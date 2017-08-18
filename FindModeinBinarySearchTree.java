package algorithm_java;

import java.util.ArrayList;
import java.util.List;

//amazon

//similar question
//validateBST
public class FindModeinBinarySearchTree {
	TreeNode prev = null;
    int count = 0;
    int max = 0;
    public int[] findMode(TreeNode root) {
        if(root == null)
            return new int[0];
        List<Integer> list = new ArrayList<Integer>();
        //list.add(root.val);
        prev = root;
        helper(root, list);
        return list.stream().mapToInt(i->i).toArray();
    }
    
    public void helper(TreeNode node, List<Integer> list){
        if(node == null)
            return;
        helper(node.left, list);  
        count = prev.val == node.val? count+1: 1;
        if(count > max){
            max = count;
            list.clear();
            list.add(node.val);
        }else if (count == max)
            list.add(node.val);
        prev = node;   // need to use inorder traversal, so prev represents previous node 
        
        helper(node.right, list);
    }

    public static void main(String[] args) {
    	FindModeinBinarySearchTree  s= new FindModeinBinarySearchTree ();
    	TreeNode node1 = new TreeNode(2);
		TreeNode node2 = new TreeNode(2);
		TreeNode node3 = new TreeNode(9);
		TreeNode node4 = new TreeNode(2);
		TreeNode node5 = new TreeNode(3);
		TreeNode node6 = new TreeNode(8);
		TreeNode node7 = new TreeNode(9);
		TreeNode node8 = new TreeNode(9);
		node1.left = node2;
		node1.right = node3;
		node2.left = node4;
		node2.right = node5;
		node3.left = node6;
		node3.right = node7;
		node7.right = node8;
		//boolean res = isValidBST(node1);
		int[] res = s.findMode(node1);
		for(int i: res)
			System.out.print(i+" ");
	}
}
