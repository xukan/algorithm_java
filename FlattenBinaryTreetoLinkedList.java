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
*/

public class FlattenBinaryTreetoLinkedList {
	//solution I, stack
	public static void flatten(TreeNode root) {
		TreeNode cur = root;
        Stack<TreeNode> stack = new Stack<TreeNode>();
        while(cur !=null){
            if(cur.right!=null){
                stack.push(cur.right);
            }
            if(cur.left!=null){
                cur.right = cur.left;
                cur.left = null;
            }else if(!stack.empty()){
                cur.right = stack.pop();
            }
            cur = cur.right;
        }
    }
	
	//solution II
	TreeNode prev = null;
    public void flatten_postOrder(TreeNode root) {
        if(root == null)
            return;
        flatten(root.right);
        flatten(root.left);
        if(prev!=null){
            root.right = prev;
            root.left = null;
        }
        prev = root;
    }
	
	public static void main(String[] args) {
//		TreeNode root = new TreeNode(5);
//		TreeNode node1 = new TreeNode(4);
//		TreeNode node2 = new TreeNode(8);
//		TreeNode node3 = new TreeNode(11);
//		TreeNode node4 = new TreeNode(13);
//		TreeNode node5 = new TreeNode(4);
//		
//		root.left=node1;
//		root.right = node2;
//		node1.left = node3;
//		node2.left = node4;
//		node2.right = node5;
		
		TreeNode root = new TreeNode(5);
		TreeNode node1 = new TreeNode(4);
		TreeNode node2 = new TreeNode(8);
		root.right = node1;
		root.left = node2;
		
		flatten(root);
		List<Integer> list = new ArrayList<Integer>();
		while(root!=null){
			list.add(root.val);
			root = root.right;
		}
		list.forEach(i->System.out.print(i + " "));
	}
}
