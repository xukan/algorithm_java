package algorithm_java;

import java.util.ArrayList;
import java.util.List;

public class BinaryTreeLongestConsecutiveSequenceII {
	int maxLen=0;
	TreeNode prev = null;
	public int longestConsecutive(TreeNode root) {
        helper(root, 1);
        return maxLen;
    }
	
	public void helper(TreeNode node, int len){
		if(node == null)
			return;
		helper(node.left, len);
		if(prev!=null ){
			len  =  prev.val < node.val? len+1: 1;
			maxLen = Math.max(maxLen, len);
		}
		prev = node;
		helper(node.right, len);
	}
	
	public static void main(String[] args) {
		BinaryTreeLongestConsecutiveSequenceII s = new BinaryTreeLongestConsecutiveSequenceII();
		TreeNode root = new TreeNode(2);
		 TreeNode node1 = new TreeNode(1);
		 TreeNode node2 = new TreeNode(3);
//		 TreeNode node3 = new TreeNode(4);
//		 TreeNode node4 = new TreeNode(9);
//		 TreeNode node5 = new TreeNode(5);

		 root.left=node1;
//		 root.right = node2;
//		 node1.right = node3;
//		 node2.left = node4;
//		 node3.right = node5;
		 int res = s.longestConsecutive(root);
		 System.out.println(res);
	}
}
