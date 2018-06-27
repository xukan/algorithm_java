package algorithm_java;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/*
*                         5
*                       /    \
*                     4       8
*                   /         /  \
*                 11      13   4
*                /    \          /  \
*              7      2       5    1
* */

public class BinaryTreePostOrderTraversal {
	//solutionI, it change tree structure
	public static List<Integer> postorderTraversal(TreeNode root) {
	    List<Integer> res = new ArrayList<Integer>();
	    if(root==null)
	        return res;
	    Stack<TreeNode> stack = new Stack<TreeNode>();
	    stack.push(root);
	 
	    while(!stack.isEmpty()) {
	        TreeNode temp = stack.peek();
	        if(temp.left==null && temp.right==null) {
	            TreeNode pop = stack.pop();
	            res.add(pop.val);
	        }else {
	            if(temp.right!=null) {
	                stack.push(temp.right);
	                temp.right = null;
	            }
	            if(temp.left!=null) {
	                stack.push(temp.left);
	                temp.left = null;
	            }
	        }
	    }
	    return res;
	}
	
	//solution II
	public static List<Integer> postOrderTraverse(TreeNode node){
		List<Integer> list = new ArrayList<Integer>();
		Stack<TreeNode> stack = new Stack<TreeNode>();
        // Check for empty tree
        if (node == null)
            return list;
        stack.push(node);
        TreeNode prev = null;
        while (!stack.empty()){
            TreeNode current = stack.peek();
            /* go down the tree in search of a leaf an if so process it 
            and pop stack otherwise move down */
            if (prev == null || prev.left == current || prev.right == current){
                if (current.left != null)
                    stack.push(current.left);
                else if (current.right != null)
                    stack.push(current.right);
                else{
                    stack.pop();
                    list.add(current.val);
                }
                /* go up the tree from left node, if the child is right 
                   push it onto stack otherwise process parent and pop 
                   stack */
            }else if (current.left == prev) {
                if (current.right != null)
                    stack.push(current.right);
                else{
                    stack.pop();
                    list.add(current.val);
                }
                /* go up the tree from right node and after coming back
                 from right node process parent and pop stack */
            }else if (current.right == prev) {
                stack.pop();
                list.add(current.val);
            }
            prev = current;
        }
  
        return list;
	}
	
	public static void main(String[] args){
		 TreeNode root = new TreeNode(5);
		 TreeNode node1 = new TreeNode(4);
		 TreeNode node2 = new TreeNode(8);
		 TreeNode node3 = new TreeNode(11);
		 TreeNode node4 = new TreeNode(13);
		 TreeNode node5 = new TreeNode(4);
		 TreeNode node6 = new TreeNode(7);
		 TreeNode node7 = new TreeNode(2);
		 TreeNode node8 = new TreeNode(5);
		 TreeNode node9 = new TreeNode(1);
		 root.left=node1;
		 root.right = node2;
		 node1.left = node3;
		 node2.left = node4;
		 node2.right = node5;
		 node3.left = node6;
		 node3.right = node7;
		 node5.left = node8;
		 node5.right = node9;
		 List<Integer> res = postorderTraversal(root);
//		 List<Integer> res = postOrderTraverse(root);
		 for(Integer i : res)
			 System.out.print(i+" ");
		 System.out.println();
	} 
}
