package algorithm_java;

//Google
//http://www.programcreek.com/2014/05/leetcode-pain-fence-java/

//recursive formula
//f(n) = (n-1)*(f(n-1)+f(n-2))
//f(0) = k, f(1) = k*k

public class PaintFence {
	public int numWays(int n, int k) {
        int[] dp = {0, k, k*k, 0};
        if(n<=2)
            return dp[n];
        for(int i=2;i<n;i++){
            dp[3] = (k-1)*(dp[1]+dp[2]);
            dp[1] = dp[2];
            dp[2] = dp[3];
        }
        return dp[3];
    }
}
