package algorithm_java;

import java.util.ArrayList;
import java.util.List;
//tc: O(n)
/*
 * bottom-up solution
 * 用incr来记录当前点升序长度,decr记录当前点降序长度,递归函数的返回值是一个长度2的数组{incr, decr}
 * 当前点的{incr, decr}由左右孩子的{incr, decr}来决定
 * 当前点的最长序列公式 = incr + decr -1
 * */
public class BinaryTreeLongestConsecutiveSequenceII {	
	int maxLen = 1;
    public int longestConsecutive(TreeNode root) {
        if(root == null)
            return 0;
        helper(root);
        return maxLen;
    }
    
    public int[] helper(TreeNode node){
        if(node == null)
            return new int[]{0,0};
        int incr = 1, decr = 1;
        int[] l = helper(node.left);
        int[] r = helper(node.right);
        if(node.left != null){
            if(node.val +1 == node.left.val) incr +=l[0];
            if(node.val -1 == node.left.val) decr+=l[1];
        }
        if(node.right != null){
            if(node.val +1 == node.right.val) incr = Math.max(incr, r[0]+1);  //注意这里有比较,取最大值
            if(node.val -1 == node.right.val) decr=Math.max(decr, r[1]+1);
        }
        maxLen = Math.max(maxLen, incr+decr-1);
        return new int[]{incr, decr};
    }
	
	
	public static void main(String[] args) {
		BinaryTreeLongestConsecutiveSequenceII s = new BinaryTreeLongestConsecutiveSequenceII();
		TreeNode root = new TreeNode(3);
		 TreeNode node1 = new TreeNode(2);
		 TreeNode node2 = new TreeNode(4);
		 TreeNode node3 = new TreeNode(7);
		 TreeNode node4 = new TreeNode(1);
		 TreeNode node5 = new TreeNode(5);

		 root.left=node1;
		 root.right = node2;
		 node1.left = node3;
		 node1.right = node4;
		 node2.left = node5;
		 int res = s.longestConsecutive(root);
		 System.out.println(res);
	}
}
