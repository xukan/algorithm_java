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
 * Time complexity : O(n) One complete traversal of the tree is done.
 * Space complexity : O(n) The recursive stack can grow upto a depth of n. Further, left_boundary, right_boundary and leaves 
 * combined together can be of size n.
 * */

/*
 *                       20
 *                  /            \
 *                8               22
 *             /     \              /     
 *          4       12        16     
 *           \       /   \       /            
 *            6    10   14  15            
 * */
/*
 * Function leftBoundary() and rightBoundary() only add boundary nodes not including leaf nodes
 * rightBoundary() add nodes in reverse order
 * Function leaves() add all leaf nodes in order
 * */
public class BoundaryofBinaryTree {
//	List<Integer> nodes = new ArrayList<>();
//	public List<Integer> boundaryOfBinaryTree(TreeNode root) {
//	    
//	    if(root == null) return nodes;
//
//	    nodes.add(root.val);
//	    leftBoundary(root.left);
//	    leaves(root.left);
//	    leaves(root.right);
//	    rightBoundary(root.right);
//	    
//	    return nodes;
//	}
//	public void leftBoundary(TreeNode root) {
//	    if(root == null || (root.left == null && root.right == null))
//	    	return;
//	    nodes.add(root.val);
//	    if(root.left == null) 
//	    	leftBoundary(root.right);
//	    else 
//	    	leftBoundary(root.left);
//	}
//	public void rightBoundary(TreeNode root) {
//	    if(root == null || (root.right == null && root.left == null))
//	    	return;
//	    if(root.right == null)
//	    	rightBoundary(root.left);
//	    else 
//	    	rightBoundary(root.right);
//	    nodes.add(root.val); // add after child visit(reverse)
//	}
//	
//	public void leaves(TreeNode root) {
//	    if(root == null) return;
//	    if(root.left == null && root.right == null) {
//	        nodes.add(root.val);
//	        return;
//	    }
//	    leaves(root.left);
//	    leaves(root.right);
//	}
	
	List<Integer> res = new ArrayList<Integer>();
    public List<Integer> boundaryOfBinaryTree(TreeNode root) {
        if(root == null)
            return res;
        res.add(root.val);
        leftBoundary(root.left);
        leaves(root.left);
        leaves(root.right);
        rightBoundary(root.right);
        return res;
    }
    
    public void leftBoundary(TreeNode node){
        if(node == null || (node.left == null && node.right == null))
            return;
        res.add(node.val);
        if(node.left!=null)//注意这里要判断左子树是不是空,左边界遍历的时候尽量走左子树(遍历左边界),只有左子树为空才走右子树
        	leftBoundary(node.left);
        else
        	leftBoundary(node.right);
    }
    
    public void rightBoundary(TreeNode node){
        if(node == null || (node.left == null && node.right == null))
            return;
        if(node.right!=null)//右边界遍历,尽量走右子树,只有右子树为空才走左子树
        	rightBoundary(node.right);
        else
        	rightBoundary(node.left);
        res.add(node.val);
    }
    
    public void leaves(TreeNode node){
        if(node == null)
            return;
        if(node.left == null && node.right == null){
            res.add(node.val);
            return;
        }
        leaves(node.left);
        leaves(node.right);
    }
	
	public static void main(String[] args) {
		BoundaryofBinaryTree s = new BoundaryofBinaryTree();
		TreeNode root = new TreeNode(20);
		 TreeNode node1 = new TreeNode(8);
		 TreeNode node2 = new TreeNode(22);
		 TreeNode node3 = new TreeNode(4);
		 TreeNode node4 = new TreeNode(12);
		 TreeNode node5 = new TreeNode(16);
		 TreeNode node6 = new TreeNode(6);
		 TreeNode node7 = new TreeNode(10);
		 TreeNode node8 = new TreeNode(14);
		 TreeNode node9 = new TreeNode(15);
		 root.left = node1;
		 root.right = node2;
		 node1.left = node3;
		 node1.right = node4;
		 node2.left = node5;
		 node3.right = node6;
		 node4.left = node7;
		 node4.right = node8;
		 node5.left = node9;
		 List<Integer> nodes = s.boundaryOfBinaryTree(root);
		 for(int i: nodes)
			 System.out.print(i+" ");
	}
}
