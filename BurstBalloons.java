package algorithm_java;

//http://bookshadow.com/weblog/2015/11/30/leetcode-burst-balloons/

/*
 * 动态规划（Dynamic Programming）
 * 时间复杂度O(n ^ 3)
 * 参考peisi的答案：https://leetcode.com/discuss/72216/share-some-analysis-and-explanations
 * 以最后被爆破的气球m为界限，把数组分为左右两个子区域
 * 状态转移方程：(transition function)
 * dp[l][r] = max(dp[l][r], nums[l] * nums[m] * nums[r] + dp[l][m] + dp[m][r])
 * dp[l][r]表示扎破(l, r)范围内所有气球获得的最大硬币数，不含边界；
 * l与r的跨度k从2开始逐渐增大；
 * 三重循环依次枚举范围跨度k，左边界l，中点m；右边界r = l + k；
 * 状态转移方程在形式上有点类似于Floyd最短路算法。
 * */

public class BurstBalloons {
	public static int maxCoins(int[] iNums) {
        int[] nums = new int[iNums.length + 2];
        int n = 1;
        for (int x : iNums) if (x > 0) nums[n++] = x;
        nums[0] = nums[n++] = 1;

        int[][] dp = new int[n][n];
        for (int k = 2; k < n; ++k)
            for (int l = 0; l < n - k; ++l) {
                int r = l + k;
                for (int m = l + 1; m < r; ++m)
                    dp[l][r] = Math.max(dp[l][r], 
                        nums[l] * nums[m] * nums[r] + dp[l][m] + dp[m][r]);
            }
    
        for(int i=0;i<n;i++){
        	 for(int j=0;j<n;j++){
        		 System.out.print(dp[i][j]+" ");
             }
        	 System.out.println();
        }
        return dp[0][n - 1];
    }
	
	public static void main(String[] args) {
		int[] input ={3,1,5,8};
		int res = maxCoins(input);
		System.out.println(res);
	}
}
