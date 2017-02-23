package algorithm_java;

import java.util.Arrays;

//eBay

public class PartitionEqualSubsetSum {
	
	//Time Complexity: O(sum*n)
	//Auxiliary Space: O(sum*n)
	//Please note that this solution will not be feasible for arrays with big sum.
	//http://www.geeksforgeeks.org/dynamic-programming-set-18-partition-problem/
	public boolean canPartition(int[] nums) {
		int sum = 0;
	    
	    for (int num : nums) {
	        sum += num;
	    }
	    
	    if (sum %2 != 0) {
	        return false;
	    }
	    sum /= 2;

	    int n = nums.length;
	    boolean[][] dp = new boolean[n+1][sum/2+1];
	    
	    dp[0][0] = true;
	    
	    for (int i = 1; i <= n; i++) {
	        dp[i][0] = true;
	    }
	    for (int j = 1; j <= sum/2; j++) {
	        dp[0][j] = false;
	    }
	    
	    for (int i = 1; i < n+1; i++) {
	        for (int j = 1; j <= sum/2; j++) {
	            dp[i][j] = dp[i-1][j];
	            if (j >= nums[i-1]) {
	                dp[i][j] = (dp[i][j] || dp[i-1][j-nums[i-1]]);
	            }
	        }
	    }
	    
	    for(int i=0;i<=n;i++){
	    	for(int j = 1; j <= sum/2; j++){
	    		System.out.print(dp[i][j]+" ");
	    	}
	    	System.out.println();
	    }
	   
	    return dp[n][sum/2];
    }

	//optimization
	//https://discuss.leetcode.com/topic/67539/0-1-knapsack-detailed-explanation/2
//	public boolean canPartition(int[] nums) {
//	    int sum = 0;
//	    
//	    for (int num : nums) {
//	        sum += num;
//	    }
//	    
//	    if ((sum & 1) == 1) {
//	        return false;
//	    }
//	    sum /= 2;
//	    
//	    int n = nums.length;
//	    boolean[] dp = new boolean[sum+1];
//	    Arrays.fill(dp, false);
//	    dp[0] = true;
//	    
//	    for (int num : nums) {
//	        for (int i = sum; i > 0; i--) {
//	            if (i >= num) {
//	                dp[i] = dp[i] || dp[i-num];
//	            }
//	        }
//	    }
//	    
//	    return dp[sum];
//	}
	
	public static void main(String[] args) {
		PartitionEqualSubsetSum s = new PartitionEqualSubsetSum();
		int[] nums = {3, 1, 1, 2, 2,1};
		boolean res = s.canPartition(nums);
		System.out.println(res);
	}
}
