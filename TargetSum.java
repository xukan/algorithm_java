package algorithm_java;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//Google Facebook

//variation of 0-1 knapsack problem
/*
 * 状态转移方程：dp[i + 1][k + nums[i] * sgn] += dp[i][k]上式中，sgn取值±1，k为dp[i]中保存的所有状态；
 * 初始令dp[0][0] = 1, 利用滚动数组，可以将空间复杂度优化到O(n)，n为可能的运算结果的个数
 * 
 * */

//similar question
//Partition Equal Subset Sum
//coin change II
public class TargetSum {
//Using subset sum solver.
//	public static void main(String[] args) {
//        System.out.println(new TargetSumProblem().findTargetSumWays(new int[] { 1, 1, 1, 1, 1 }, 3));
//    }
// 
//    public int findTargetSumWays(int[] nums, int s) {
//        int sum = 0;
//        for (int i = 0; i < nums.length; i++) {
//            sum += nums[i];
//            nums[i] += nums[i];
//        }
//        if (sum < s) {
//            return 0;
//        }
//        return subsetSum(nums, s + sum);
//    }
// 
//    public int subsetSum(int[] numbers, int s) {
//        int n = numbers.length, nw[][] = new int[s + 1][n + 1];
//        nw[0][0] = 1;
//        for (int i = 0; i <= s; i++) {
//            for (int j = 1; j <= n; j++) {
//                nw[i][j] = nw[i][j - 1];
//                if (i - numbers[j - 1] >= 0) {
//                    nw[i][j] += nw[i - numbers[j - 1]][j - 1];
//                }
//            }
//        }
//        return nw[s][n];
//    }
	
	//solution I, based on Expression Add Operators
	//Optimization: The idea is If the sum of all elements left is smaller than absolute value of target, 
	//there will be no answer following the current path. Thus we can return.
	int result = 0;
    public int findTargetSumWays(int[] nums, int S) {
        if(nums == null || nums.length == 0) return result;
        int n = nums.length;
        int[] sums = new int[n];
        sums[n - 1] = nums[n - 1];
        for (int i = n - 2; i >= 0; i--)
            sums[i] = sums[i + 1] + nums[i];
        
        helper(nums, sums, S, 0);
        return result;
    }
    public void helper(int[] nums, int[] sums, int target, int pos){
        if(pos == nums.length){
            if(target == 0) result++;
            return;
        }
        
        if (sums[pos] < Math.abs(target)) return;
        
        helper(nums, sums, target + nums[pos], pos + 1);
        helper(nums, sums, target - nums[pos], pos + 1);
    }
    
    //solution II, subset sum
    //https://discuss.leetcode.com/topic/76243/java-15-ms-c-3-ms-o-ns-iterative-dp-solution-using-subset-sum-with-explanation/3
    /*
     * we can compare this question with coin change II
     * https://discuss.leetcode.com/topic/76243/java-15-ms-c-3-ms-o-ns-iterative-dp-solution-using-subset-sum-with-explanation/43?page=3
     * Great observation, the difference is that if you update dp while:
     * increasing i then the previous partial result dp[i - coin] is the result that has considered coin already
     * decreasing i then the previous partial result dp[i - coin] is the result that has not considered coin yet
     * * @return number of ways to make sum s using repeated coins
		public static int coinrep(int[] coins, int s) {
		    int[] dp = new int[s + 1]; 
		    dp[0] = 1;          
		    for (int coin : coins)      
		        for (int i = coin; i <= s; i++)         
		            dp[i] += dp[i - coin];                                  
		    return dp[s];
		}                                       
		 * @return number of ways to make sum s using non-repeated coins
		
		public static int coinnonrep(int[] coins, int s) {
		    int[] dp = new int[s + 1];
		    dp[0] = 1;  
		    for (int coin : coins)
		        for (int i = s; i >= coin; i--)
		            dp[i] += dp[i - coin];              
		    return dp[s];                                                   
		} 
     * */
    public int findTargetSumWays_subsetsum(int[] nums, int S) {
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
        }
        if(S > sum || (sum + S) % 2 == 1)   
        	return 0;
        return subsetSum(nums, (sum + S) / 2);
    }

    //http://algorithms.tutorialhorizon.com/dynamic-programming-subset-sum-problem/
    //above link use 2d array dp solution to solve subset sum question
    private int subsetSum(int[] nums, int s){
    	int[] dp = new int[s + 1]; 
        dp[0] = 1;
        for (int n : nums)
            for (int i = s; i >= n; i--)
                dp[i] += dp[i - n]; 
        return dp[s];
    }
    
    
    public int FindTargetSumWays(int[] nums, int S) {
        if(nums == null || nums.length == 0)
            return 0;
        int sum = 0;
        for(int num: nums)
            sum += num;
        if((sum+S)/2!=0 || sum < S || -sum> S)
            return 0;
        return helper(nums, (sum+S)/2);
    }
    
    public int helper(int[] nums, int target){
        int[] dp = new int[target+1];
        dp[0] = 1;
        for(int n: nums)
            for(int i=target;i>=n;i--)
                dp[i] += dp[i-n];
        return dp[target];
    }
    
	public static void main(String[] args) {
		TargetSum s = new TargetSum();
//		int[] nums = {1,0,0,0};
//		int[] nums = {1,0,0,0,1};
		int[] nums = {1,1,1,1,1};
//		int[] nums = {1,2,7,9,981}; target = 1000000000
		int res = s.findTargetSumWays(nums, 3);
//		int res = s.findTargetSumWays_subsetsum(nums, 3);
		int res1 = s.FindTargetSumWays(nums, 3);
		System.out.println(res);
	}
}
