package algorithm_java;

import java.util.ArrayList;
import java.util.List;

//Amazon Google Facebook

//http://www.geeksforgeeks.org/boundary-traversal-of-binary-tree/

/*
 * We break the problem in 3 parts:
 * 1. Print the left boundary in top-down manner.
 * 2. Print all leaf nodes from left to right, which can again be sub-divided into two sub-parts:
 * …..2.1 Print all leaf nodes of left sub-tree from left to right.
 * …..2.2 Print all leaf nodes of right subtree from left to right.
 * 3. Print the right boundary in bottom-up manner.
 * We need to take care of one thing that nodes are not printed again. e.g. The left most node is also the leaf node of the tree
 * 
 * */

/*
 *                    20
 *                  /      \
 *                8         22
 *               /  \           \
 *             4    12        5
 *                  /   \
 *                10   14     
 * */

public class BoundaryofBinaryTree {
	List<Integer> nodes = new ArrayList<>();
	public List<Integer> boundaryOfBinaryTree(TreeNode root) {
	    
	    if(root == null) return nodes;

	    nodes.add(root.val);
	    leftBoundary(root.left);
	    leaves(root.left);
	    leaves(root.right);
	    rightBoundary(root.right);
	    
	    return nodes;
	}
	public void leftBoundary(TreeNode root) {
	    if(root == null || (root.left == null && root.right == null))
	    	return;
	    nodes.add(root.val);
	    if(root.left == null) 
	    	leftBoundary(root.right);
	    else 
	    	leftBoundary(root.left);
	}
	public void rightBoundary(TreeNode root) {
	    if(root == null || (root.right == null && root.left == null))
	    	return;
	    if(root.right == null)
	    	rightBoundary(root.left);
	    else 
	    	rightBoundary(root.right);
	    nodes.add(root.val); // add after child visit(reverse)
	}
	
	public void leaves(TreeNode root) {
	    if(root == null) return;
	    if(root.left == null && root.right == null) {
	        nodes.add(root.val);
	        return;
	    }
	    leaves(root.left);
	    leaves(root.right);
	}
	
	public static void main(String[] args) {
		BoundaryofBinaryTree s = new BoundaryofBinaryTree();
		TreeNode root = new TreeNode(20);
		 TreeNode node1 = new TreeNode(8);
		 TreeNode node2 = new TreeNode(22);
		 TreeNode node3 = new TreeNode(4);
		 TreeNode node4 = new TreeNode(12);
		 TreeNode node5 = new TreeNode(25);
		 TreeNode node6 = new TreeNode(10);
		 TreeNode node7 = new TreeNode(14);
		 root.left = node1;
		 root.right = node2;
		 node1.left = node3;
		 node1.right = node4;
		 node2.right = node5;
		 node4.left = node6;
		 node4.right = node7;
		 
		 List<Integer> nodes = s.boundaryOfBinaryTree(root);
		 for(int i: nodes)
			 System.out.println(i+" ");
	}
}
