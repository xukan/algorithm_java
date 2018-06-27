package algorithm_java;

import java.util.HashMap;
import java.util.Map;

/*
 *         10
 *        /    \
 *      5     -3
 *     /  \       \
 *    3   2     11
 *   /  \    \
 *  3  -2   1
 *  
 * */

public class PathSumIII {
	// key : the prefix sum, value : how many ways get to this prefix sum
//	public int pathSum(TreeNode root, int sum) {
//        HashMap<Integer, Integer> preSum = new HashMap();
//        preSum.put(0,1);
//        return helper(root, 0, sum, preSum);
//    }
//    
//    public int helper(TreeNode root, int currSum, int target, HashMap<Integer, Integer> preSum) {
//        if (root == null) {
//            return 0;
//        }
//        
//        currSum += root.val;
//        int res = preSum.getOrDefault(currSum - target, 0);
//        
//        preSum.put(currSum, preSum.getOrDefault(currSum, 0) + 1);
//        
//        int l = helper(root.left, currSum, target, preSum);
//        int r = helper(root.right, currSum, target, preSum);
//        res = res + l + r;
//        preSum.put(currSum, preSum.get(currSum) - 1);
//        return res;
//    }
    
	public int pathSum(TreeNode root, int sum) {
        if(root == null)
            return 0;
        Map<Integer, Integer> preSum = new HashMap<>();
        preSum.put(0,1);
        int res = helper(root, 0, sum, preSum);
        return sum == 0?res-1: res;
    }
    
    public int helper(TreeNode node, int curSum, int target, Map<Integer, Integer> preSum){
        if(node == null)
            return 0;
        curSum += node.val;
        int res = preSum.getOrDefault(curSum - target, 0);  //this line must be put above the next line
        preSum.put(curSum, preSum.getOrDefault(curSum, 0)+1);
        int l = helper(node.left, curSum, target, preSum);
        int r = helper(node.right, curSum, target, preSum);
        preSum.put(curSum, preSum.get(curSum) - 1);
        return res + l + r;
    }
	
    public static void main(String[] args) {
    	PathSumIII s = new PathSumIII();
    	
//    	TreeNode root = new TreeNode(10);
//		TreeNode node1 = new TreeNode(5);
//		TreeNode node2 = new TreeNode(-3);
//		TreeNode node3 = new TreeNode(3);
//		TreeNode node4 = new TreeNode(2);
//		TreeNode node5 = new TreeNode(11);
//		TreeNode node6 = new TreeNode(3);
//		TreeNode node7 = new TreeNode(-2);
//		TreeNode node8 = new TreeNode(1);
//		root.left=node1;
//		root.right = node2;
//		node1.left = node3;
//		node1.right = node4;
//		node2.right = node5;
//		node3.left = node6;
//		node3.right = node7;
//		node4.right = node8;
		
    	TreeNode root = new TreeNode(1);
		TreeNode node1 = new TreeNode(2);
    	
		root.left=node1;
		int count = s.pathSum(root, 0);
		System.out.println(count);
	}
}
