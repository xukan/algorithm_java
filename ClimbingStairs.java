package algorithm_java;

//Apple Adobe 

//similar question
//Decode ways

public class ClimbingStairs {
	//solutionI,  tc : O(n), sc: O(n)
	public int climbStairs(int n) {
         int[] dp = new int[n+1];
         dp[0] = 1;
         dp[1] = 1;
         for(int i=2;i<=n;i++){
             dp[i] = dp[i-1]+ dp[i-2];
         }
         return dp[n];
    }
	
	//solutionI,  tc : O(n), sc: O(1)
	public int climbStairs_better(int n) {
		int prev  = 1;
        int cur  = 1;
        for(int i=2;i<=n;i++){
            int tmp = cur;
            cur = cur + prev;
            prev = tmp;
        }
        return cur;
	}
	
	public static void main(String[] args) {
		ClimbingStairs s = new ClimbingStairs();
		int res = s.climbStairs_better(5);
		System.out.println(res);
	}
}
