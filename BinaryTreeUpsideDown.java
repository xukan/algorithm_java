package algorithm_java;

import java.util.Stack;

public class BinaryTreeUpsideDown {
	public static TreeNode upsideDownBinaryTree(TreeNode root) {
		if(root == null || root.left == null) {
	        return root;
	    }
	    
	    TreeNode newRoot = upsideDownBinaryTree(root.left);
	    root.left.left = root.right;   // node 2 left children
	    root.left.right = root;         // node 2 right children
	    root.left = null;
	    root.right = null;
	    return newRoot;
    }
	
	public static TreeNode upsideDownBinaryTree_iteration(TreeNode root) {
	    TreeNode curr = root;
	    TreeNode next = null;
	    TreeNode temp = null;
	    TreeNode prev = null;
	    
	    while(curr != null) {
	        next = curr.left;
	        
	        // swapping nodes now, need temp to keep the previous right child
	        curr.left = temp;
	        temp = curr.right;
	        curr.right = prev;
	        
	        prev = curr;
	        curr = next;
	    }
	    return prev;
	}  
	
	public static void inorder(TreeNode node){
		if(node==null)
			return;
		inorder(node.left);
		System.out.print(node.val+ " ");
		inorder(node.right);
	}
	
	public static void main(String[] args) {
		TreeNode root = new TreeNode(1);
		TreeNode node1 = new TreeNode(2);
		TreeNode node2 = new TreeNode(3);
		TreeNode node3 = new TreeNode(4);
		TreeNode node4 = new TreeNode(5);
		root.left=node1;
		root.right = node2;
		node1.left = node3;
		node1.right = node4;
		inorder(root);
		System.out.println();
		TreeNode node = upsideDownBinaryTree_iteration(root);
		inorder(node);
	}
}
