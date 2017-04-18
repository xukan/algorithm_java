package algorithm_java;

/*
 * Dynamic Program
 * 1) Optimal substructure
 * 2) Overlapping subproblems
 * 
 * 
 * I:   http://www.geeksforgeeks.org/dynamic-programming-set-4-longest-common-subsequence/
 * II:  http://www.geeksforgeeks.org/printing-longest-common-subsequence/
 * III: http://www.geeksforgeeks.org/lcs-longest-common-subsequence-three-strings/
 * 
 * Let input subsequences be, X[0...m-1], Y[0...n-1]  of lengths n and m repectively;
 * Following is the recursive definition of L(X[0...m-1], Y[0...n-1])
 * if X.charAt(m-1) == Y.charAt(n-1)
 * L = 1 + L(X[0...m-2], Y[0...n-2])
 * else:
 * L = Max(L(X[0...m-2], Y[0...n-1]), L(X[0...m-1], Y[0...n-2]) )
 *
 *This problem can be read with Longest uncommon subsequence
 * */

public class LongestCommonSubsequence {
	//tc: O(mn)
	public static int lcsI(String x, String y){
		//the aim of lcsI is to find the length of LCS
		//http://www.geeksforgeeks.org/dynamic-programming-set-4-longest-common-subsequence/
		int m = x.length();
		int n = y.length();
		int[][] dp = helper(x, y, m, n);
		return dp[m][n];
	}
	
	public static String lcsII(String x, String y){
		//Printing Longest Common Subsequence
		//http://www.geeksforgeeks.org/printing-longest-common-subsequence/
		int m = x.length();
		int n = y.length();
		int[][] dp = helper(x, y, m, n);
		int len = dp[m][n];
		StringBuilder sb = new StringBuilder();
		int i=m, j=n;
		while(i>0 && j>0){
			if(x.charAt(i-1) == y.charAt(j-1)){
				sb.insert(0,x.charAt(i-1));
				i--;
				j--;
			}else{
				if(dp[i-1][j]>dp[i][j-1])
					i--;
				else
					j--;
			}
		}
		return sb.toString();
	}
	
	public static int[][] helper(String x, String y, int m, int n){
		int[][] dp = new int[m+1][n+1];
		dp[0][0] = 0;
		for(int i=1;i<=m;i++){
			for(int j=1;j<=n;j++){
				if(x.charAt(i-1) == y.charAt(j-1))
					dp[i][j] = dp[i-1][j-1]+1;
				else
					dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
			}
		}
		System.out.println(x+m);
		System.out.println(y+n);
		for(int i=0;i<=m;i++){
			for(int j=0;j<=n;j++){
				System.out.print(dp[i][j]+" ");
			}
			System.out.println();
		}
		
		return dp;
	}
	
	
	//LCS (Longest Common Subsequence) of three strings
	/*
	 * Input : str1 = "geeks"  
	 * str2 = "geeksfor"  
	 * str3 = "geeksforgeeks"
	 * Output : 5
	 * Longest common subsequence is "geeks"
	 * 
	 * Input : str1 = "abcd1e2"  
	 * str2 = "bc12ea"  
	 * str3 = "bd1ea"
	 * Output : 3
	 * Longest common subsequence is "b1e" 
	 * */
	public static int lcsIII(String x, String y, String z){
		//http://www.geeksforgeeks.org/lcs-longest-common-subsequence-three-strings/
		int m = x.length();
		int n = y.length();
		int k = z.length();
		int[][][] dp = new int[m+1][n+1][k+1];
		dp[0][0][0] = 0;
		for(int i=1;i<=m;i++){
			for(int j=1;j<=n;j++){
				for(int t=1;t<=k;t++){
					if(x.charAt(i-1) == y.charAt(j-1) && x.charAt(i-1) == z.charAt(t-1))
						dp[i][j][t] = dp[i-1][j-1][t-1] + 1;
					else{
						dp[i][j][t] = Math.max(Math.max(dp[i-1][j][t], dp[i][j-1][t]), dp[i][j][t-1]);
					}
				}
			}
		}
		for(int i=0;i<=m;i++){
			for(int j=0;j<=n;j++){
				for(int t=0;t<=k;t++){
					System.out.print(dp[i][j][t]+" ");
				}
				System.out.println();
			}
			System.out.println();
		}
		
		return dp[m][n][k];
	}
	
	public static void main(String[] args) {
		String X = "AGGTAB";
		String Y = "GXTXAYB";
		
		//int longest = lcsI(X,Y);
		//System.out.println("Length of LCS is "+ longest);
		String lcs = lcsII(X, Y);
		System.out.println(lcs);
		
		String A = "AGGT12";
	    String B = "12TXAYB";
	    String C = "12XBA"; 
	    int len = lcsIII(A,B,C);
	    System.out.println(len);
	}
}
