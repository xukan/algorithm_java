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
public class InorderSuccessorinBST {
	
	//Time is O(log(n)) and space is O(1).
	public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        if(root == null || p == null)
        	return null;
        TreeNode cur = root;
        TreeNode next = null;
        while(p.val !=cur.val){
        	if(p.val < cur.val){
        		next = cur;
        		cur = cur.left;
        	}else
        		cur = cur.right;
        }
        if(cur==null )
        	return null;
        if(cur.right == null)
        	return next;
        cur = cur.right;
        while(cur.left!=null)
        	cur = cur.left;
        return cur;
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
}
