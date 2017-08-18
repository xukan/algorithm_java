package algorithm_java;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

//class TreeNode {
//    int val;
//    TreeNode left;
//    TreeNode right;
//    TreeNode(int x) { val = x; }
//}

public class HouseRobber {
	//The key is to find the relation dp[i] = Math.max(dp[i-1], dp[i-2]+nums[i])
	public static int rob(int[] nums) {
		int[] dp=new int[nums.length];
		dp[0]=nums[0];
		dp[1]=Math.max(nums[0], nums[1]);
		for(int i=2;i<nums.length;i++){
			dp[i] = Math.max(dp[i-1], dp[i-2]+nums[i]);
		}
//		for(int i:dp)
//			System.out.print(i+" ");
		return dp[nums.length-1];
    }
	
	//https://segmentfault.com/a/1190000003811581
	public int robI_better(int[] nums) {
        if(nums.length <= 1){
            return nums.length == 0 ? 0 : nums[0];
        }
        int prev = nums[0];
        int cur = Math.max(nums[0], nums[1]);
        for(int i=2;i<nums.length;i++){
            int tmp = cur;
            cur = Math.max(prev+nums[i], cur);
            prev = tmp;
        }
        return cur;
    }
	
	public static int robII(int[] nums) {
		if(nums == null || nums.length==0)
            return 0;
        int len = nums.length;
        if(len==1)
            return nums[0];
        if(len==2)
            return Math.max(nums[0], nums[1]);
        int max = 0;
        int[] dp = new int[len];
        boolean first = false;
        dp[0] = nums[0];
        dp[1] = Math.max(nums[1], nums[0]);
        for(int i=2;i<len-1;i++){
            dp[i] = Math.max(dp[i-1], dp[i-2]+nums[i]);
        }
        max=dp[len-2];
        dp = new int[len];
        dp[1]=nums[1];
        dp[2]=Math.max(nums[2], nums[1]);
        for(int i=3;i<len;i++)
            dp[i] = Math.max(dp[i-1], dp[i-2]+nums[i]);
        max = Math.max(max, dp[len-1]);
        return max;
    }
	
	public int rob(TreeNode root) {
		if(root==null)
			return 0;
		int val =0;
		if(root.left!=null){
			val += rob( root.left.left ) + rob(root.left.right);
		}
		if(root.right!=null){
			val += rob(root.right.left)+rob(root.right.right);
		}
		return Math.max(root.val+val, rob(root.left)+rob(root.right));
    }
	
	//https://discuss.leetcode.com/topic/39834/step-by-step-tackling-of-the-problem/5
	//we can see that post-order traverse is bottom-up method
	public static int robIII(TreeNode root) {
	    int[] res = robSub(root);
	    return Math.max(res[0], res[1]);
	}

	//dfs all the nodes of the tree, each node return two number, int[] num
	//num[0] is max value while NOT rob this node. 
	//num[1] is the max value while rob this node,
	private static  int[] robSub(TreeNode root) {
	    if (root == null) return new int[2];
	    int[] left = robSub(root.left);
	    int[] right = robSub(root.right);
	    int[] res = new int[2];
	    //since node value is NOT robbed, res[0] is sum of max(left[0], left[1]) and max(right[0], right[1]);
	    res[0] = Math.max(left[0], left[1]) + Math.max(right[0], right[1]);
	    res[1] = root.val + left[0] + right[0];
	    return res;
	}
	
	public static void main(String[] args){
		/**********Hourse Robber I *************/
		int[] input1 = {3,7,10,5,2,6};
		//int res1 = rob(input1);
		//System.out.println(res1);
		/**********Hourse Robber I *************/
		
		/**********Hourse Robber II *************/
		//house robber II
		int[] input2 = {1,7,9,2};
		//int res2 = robII(input2);
		//System.out.println(res2);
		/**********Hourse Robber II *************/
		
		/**********Hourse Robber III *************/
		TreeNode t1 = new TreeNode(3);
		TreeNode t2 = new TreeNode(2);
		TreeNode t3 = new TreeNode(3);
		TreeNode t4 = new TreeNode(3);
		TreeNode t5 = new TreeNode(1);
		t1.left = t2;
		t1.right = t3;
		t2.right = t4;
		t3.right = t5;
		int res3 = robIII(t1);
		System.out.println(res3);
		/**********Hourse Robber III *************/
	}
}
