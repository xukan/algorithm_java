package algorithm_java;

import java.util.Stack;

/*
 * Pocket Gems Microsoft Facebook
 * Given a binary search tree and a node in it, find the in-order successor of that node in the BST.
 * Note: If the given node has no in-order successor in the tree, return null.
 * */
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
/* *                10
 *                /       \ 
 *              6        12
 *            /    \         \ 
 *          3       8       18
 *        /   \     /
 *      1    5   7
 *       
 * */

public class InorderSuccessorinBST {
	//Time is O(log(n)) and space is O(1).
//	public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
//        if(root == null || p == null)
//        	return null;
//        TreeNode cur = root;
//        TreeNode next = null;
//        while(p.val !=cur.val){
//        	if(p.val < cur.val){
//        		next = cur;
//        		cur = cur.left;
//        	}else
//        		cur = cur.right;
//        }
//        if(cur==null )
//        	return null;
//        if(cur.right == null)
//        	return next;
//        cur = cur.right;
//        while(cur.left!=null)
//        	cur = cur.left;
//        return cur;
//    }
	
	
	public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
	    TreeNode succ = null;
	    while (root != null) {
	        if (p.val < root.val) {
	            succ = root;
	            root = root.left;
	        }else
	            root = root.right;
	    }
	    return succ;
	}
	
	public TreeNode successor(TreeNode root, TreeNode p) {
		  if (root == null)
		    return null;

		  if (p.val < root.val){
			  TreeNode left = successor(root.left, p);
			  return (left != null) ? left : root;
		  }else
			  return successor(root.right, p);
	}
	
	public TreeNode predecessor(TreeNode root, TreeNode p) {
		if (root == null)
			return null;
		if (p.val<=root.val) {
			return predecessor(root.left, p);
		} else {
			TreeNode right = predecessor(root.right, p);
			return (right != null) ? right : root;
		}
	}
	
	public TreeNode inorderPredecessor(TreeNode root, TreeNode p) {
	    TreeNode prede = null;
	    while (root != null) {
	        if (p.val <= root.val) {
	            root = root.left;
	        }else{
	        	prede = root;
	        	root = root.right;
	        }
	    }
	    return prede;
	}
	
	//similar question is Binary Search Tree Iterator
	public class BSTIterator {
	    Stack<TreeNode> stack;
	    public BSTIterator(TreeNode root) {
	        stack = new Stack<TreeNode>();
	        TreeNode cur = root;
	        while(cur!=null){
	            stack.push(cur);
	            cur = cur.left;
	        }
	    }

	    /** @return whether we have a next smallest number */
	    public boolean hasNext() {
	        return !stack.isEmpty();
	    }

	    /** @return the next smallest number */
	    public int next() {
	        if(!stack.isEmpty()){
	        TreeNode node = stack.pop();
	        int res = node.val;
	        if(node.right!=null){
	            node = node.right;
	            while(node!=null){
	                stack.push(node);
	                node= node.left;
	            }
	        }
	        return res;
	        }
	        return 0;
	    }
	}
	
	public static void main(String[] args) {
		InorderSuccessorinBST s = new InorderSuccessorinBST();
		TreeNode root = new TreeNode(10);
		TreeNode node1 = new TreeNode(6);
		TreeNode node2 = new TreeNode(12);
		TreeNode node3 = new TreeNode(3);
		TreeNode node4 = new TreeNode(8);
		TreeNode node5 = new TreeNode(18);
		TreeNode node6 = new TreeNode(1);
		TreeNode node7 = new TreeNode(5);
		TreeNode node8 = new TreeNode(7);
		root.left = node1;
		root.right = node2;
		node1.left = node3;
		node1.right = node4;
		node2.right = node5;
		node3.left =node6;
		node3.right=node7;
		node4.left = node8;
		
//		TreeNode node = s.successor(root, node8);
//		TreeNode node = s.inorderSuccessor(root, node3);
		TreeNode node = s.inorderPredecessor(root, node8);
		System.out.println(node.val);
	}
}
