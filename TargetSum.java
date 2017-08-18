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

public class TargetSum {
//Using subset sum solver.
//reference:  http://126kr.com/article/496zmjbcw9x
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
	
	//https://discuss.leetcode.com/topic/76243/java-15-ms-c-3-ms-o-ns-iterative-dp-solution-using-subset-sum-with-explanation/3
//	 public int findTargetSumWays(int[] nums, int S) {
//	        int sum = 0;
//	        for (int i = 0; i < nums.length; i++) {
//	            sum += nums[i];
//	        }
//	        if(S > sum || (sum + S) % 2 == 1)   return 0;
//	        return subsetSum(nums, (sum + S) / 2);
//	    }
//
//	    private int subsetSum(int[] nums, int S){
//	        int[] dp = new int[S + 1];
//	        dp[0] = 1;
//	        for (int i = 0; i < nums.length; i++) {
//	            for (int j = S; j >= nums[i]; j--) {
//	                dp[j] += dp[j - nums[i]];
//	            }
//	        }
//	        return dp[S];
//	    }
	
	public int findTargetSumWays(int[] nums, int s) {
		//reference: 
		//https://discuss.leetcode.com/topic/76264/short-java-dp-solution-with-explanation/10
		/*
		 * this is a classic knapsack problem in knapsack, we decide whether we choose this element or not
		 * in this question, we decide whether we add this element or minus it
		 * So start with a two dimensional array dp[i][j] which means the number of ways for first i-th element to reach a sum j
		 * we can easily observe that dp[i][j] = dp[i-1][j+nums[i]] + dp[i-1][j-nums[i],
		 * further observation is that each row is only effected by the last row, we can reduce a two dimensional array to two single arrays
		 * dp[i] means the number of ways to reach a sum i
		 * Another part which is quite confusing is return value, here we return dp[sum+S], why is that?
		 * because dp's range starts from -sum-->0-->sum
		 * so we need to add sum first, then the total starts from 0, then we add S
		 * Actually most of Sum problems can be treated as knapsack problem, hope it helps
		 * */
        int sum = 0; 
        for(int i: nums) sum+=i;
        if(s>sum || s<-sum) return 0;
        int[] dp = new int[2*sum+1];
        dp[sum] = 1;
        for(int i = 0; i<nums.length; i++){
            int[] next = new int[2*sum+1];
            for(int k = 0; k<2*sum+1; k++){
                if(dp[k]!=0){
                    next[k + nums[i]] += dp[k];
                    next[k - nums[i]] += dp[k];
                }
            }
            dp = next;
        }
        for(int i: dp)
        	System.out.print(i+" ");
        System.out.println();
        return dp[sum+s];
    }
	
	public int findTargetSumWays_recursion(int[] nums, int S) {
		StringBuilder sb = new StringBuilder();
		List<String> res = new ArrayList<String>();
        for(int i: nums)
        	sb.append(i).append("#");
        String num = sb.toString();
        helper(num,  "", 0, S, res);
        //res.forEach(str->System.out.println(str));
        return res.size();
    }
    
    public void helper(String num, String cur, long curVal, int target, List<String> res){
        if(num.length() == 0){
            if(curVal == target)
                res.add(cur);
            return;
        }
        int index = num.indexOf("#");
        if(index == -1)
            index = num.length();
        long v1 = Long.valueOf("+"+num.substring(0, index));
        long v2 = Long.valueOf("-"+num.substring(0, index));
        helper(num.substring(index+1), cur+ "+" + v1, curVal + v1, target, res);
        helper(num.substring(index+1), cur+ "-" + v1, curVal + v2, target, res);
    }
	
    public int findTargetSumWays_mem(int[] nums, int S) {
        if (nums == null || nums.length == 0){
            return 0;
        }
        return helper_mem(nums, 0, 0, S, new HashMap<>());
    }
    private int helper_mem(int[] nums, int index, int sum, int S, Map<String, Integer> map){
        String encodeString = index + "->" + sum;
        if (map.containsKey(encodeString)){
            return map.get(encodeString);
        }
        if (index == nums.length){
            if (sum == S){
                return 1;
            }else {
                return 0;
            }
        }
        int curNum = nums[index];
        int minus = helper_mem(nums, index + 1, sum - curNum, S, map);
        int add = helper_mem(nums, index + 1, sum + curNum, S, map);
        map.put(encodeString, add + minus);
        return add + minus;
    }
    
	public static void main(String[] args) {
		TargetSum s = new TargetSum();
//		int[] nums = {1,0,0,0};
		int[] nums = {1,0,0,0,1};
		int res = s.findTargetSumWays_mem(nums, 2);
//		int res = s.findTargetSumWays(nums, 3);
		System.out.println(res);
	}
}
