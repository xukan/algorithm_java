package algorithm_java;

//Google Facebook 

public class MaximumSumofThreeNonOverlappingSubarrays {
	//solution I, mid interval
	public static int[] maxSumOfThreeSubarrays_midinter(int[] nums, int k) {
		int n = nums.length, maxsum = 0;
        int[] sum = new int[n+1];
        int[] posLeft = new int[n];
        int[] posRight = new int[n];
        int[] ans = new int[3];
        for (int i = 0; i < n; i++)
        	sum[i+1] = sum[i]+nums[i];
        // DP for starting index of the left max sum interval
        for (int i = k, tot = sum[k]-sum[0]; i < n; i++) {
            if (sum[i+1]-sum[i+1-k] > tot) {
                posLeft[i] = i+1-k;
                tot = sum[i+1]-sum[i+1-k];
            }else
                posLeft[i] = posLeft[i-1];
        }
        // DP for starting index of the right max sum interval
       // caution: the condition is ">= tot" for right interval, and "> tot" for left interval
        posRight[n-k] = n-k;
        for (int i = n-k-1, tot = sum[n]-sum[n-k]; i >= 0; i--) {
            if (sum[i+k]-sum[i] >= tot) {
                posRight[i] = i;
                tot = sum[i+k]-sum[i];
            }else
                posRight[i] = posRight[i+1];
        }
        // test all possible middle interval
        //length of right interval is k, plus middle interval with length k, so upper bound is n - 2*k
        for (int i = k; i <= n-2*k; i++) {
            int l = posLeft[i-1], r = posRight[i+k];
            int tot = (sum[i+k]-sum[i]) + (sum[l+k]-sum[l]) + (sum[r+k]-sum[r]);
            if (tot > maxsum) {
                maxsum = tot;
                ans[0] = l; ans[1] = i; ans[2] = r;
            }
        }
        return ans;
    }
	
	public static int[] maxSumOfThreeSubarrays(int[] nums, int k) {
        int[][] dp = new int[4][nums.length + 1];
        int sum = 0;
        int[] accu = new int[nums.length + 1];
        for(int i = 0; i < nums.length; i++) {
            sum += nums[i];
            accu[i] = sum;
        }
        int[][] id = new int[4][nums.length + 1];
        int max = 0, inId = 0;
        for(int i = 1; i < 4; i++) {
            for(int j = k-1 ; j < nums.length; j++) {
//                int tmpmax = j - k < 0 ? accu[j] : accu[j] - accu[j-k] + dp[i-1][j-k];
                int tmpmax = 0;
                if(j-k<0)
                	 tmpmax =accu[j];
                else
                	tmpmax = accu[j] - accu[j-k] + dp[i-1][j-k];
                if(j - k >= 0) {
                    dp[i][j] = dp[i][j-1];
                    id[i][j] = id[i][j-1];
                }
                if(j > 0 && tmpmax > dp[i][j-1]) {
                    dp[i][j] = tmpmax;
                    id[i][j] = j-k+1;
                }
            }
        }
        int[] res = new int[3];
        res[2] = id[3][nums.length-1];
        res[1] = id[2][res[2] - 1];
        res[0] = id[1][res[1] - 1];        
        return res;
    }
	
	public static void main(String[] args) {
		int[] nums = {1,2,1,2,6,7,5,1};
		int k = 2;
		int[] res = maxSumOfThreeSubarrays_midinter(nums, k);
//		int[] res = maxSumOfThreeSubarrays(nums, k);
		for(int i: res)
			System.out.print(i+" ");
	}
}
