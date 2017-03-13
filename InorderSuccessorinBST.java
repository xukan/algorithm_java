package algorithm_java;

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
}
