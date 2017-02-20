package algorithm_java;

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
	
	public static void main(String[] args) {
		TargetSum s = new TargetSum();
		int[] nums = {1,1,1,1,1};
		int res = s.findTargetSumWays(nums, 3);
		System.out.println(res);
	}
}
