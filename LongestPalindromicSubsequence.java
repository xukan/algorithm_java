package algorithm_java;

//Amazon Uber, Linkedin, PayPal, Rivigo

//reference:
//http://www.geeksforgeeks.org/dynamic-programming-set-12-longest-palindromic-subsequence/

/*
 * 1) Optimal Substructure: 
 * Let X[0..n-1] be the input sequence of length n and L(0, n-1) be the length of the longest palindromic subsequence of X[0..n-1].
 * If last and first characters of X are same, then L(0, n-1) = L(1, n-2) + 2.
 * Else L(0, n-1) = MAX (L(1, n-1), L(0, n-2)).
 * Following is a general recursive solution with all cases handled.
 * Everay single character is a palindrom of length 1
 * L(i, i) = 1 for all indexes i in given sequence
 * IF first and last characters are not same
 * If (X[i] != X[j])  L(i, j) =  max{L(i + 1, j),L(i, j - 1)} 
 * If there are only 2 characters and both are same
 * Else if (j == i + 1) L(i, j) = 2  
 * If there are more than two characters, and first and last 
 * characters are same
 * Else L(i, j) =  L(i + 1, j - 1) + 2 
 * */

public class LongestPalindromicSubsequence {
	//recursive implementation of the LPS problem
	public static int longestPalindromeSubseq_recursion(String s) {
        int res = helper(s, 0,s.length()-1);
        return res;
    }
	
	public static int helper(String s, int i, int j){
		if(i==j)
			return 1;
		if(s.charAt(i)==s.charAt(j) && j==i+1)
			return 2;
		if(s.charAt(i) == s.charAt(j))
			return helper(s, i+1, j-1)+2;
		return Math.max(helper(s, i+1, j),helper( s, i, j-1));	
	}
	
	//dynamic programming
	//1) Overlapping Subproblems
	//2) Optimal Substructure
	//recomputations of same subproblems can be avoided by constructing a temporary array L[][] in bottom up manner.
	//tc: O(n^2)
	public static int longestPalindromeSubseq(String s){
		int len = s.length();
		int[][] dp = new int[len][len];
		for(int i=0;i<len;i++)
			dp[i][i]=1;
		/*
		 * // Build the table. Note that the lower diagonal values of table are
		 * useless and not filled in the process. The values are filled in a
		 * manner similar to Matrix Chain Multiplication DP solution (See
		 * http://www.geeksforgeeks.org/archives/15553). k is length ofsubstring
		 * */
		for(int k=2;k<=len;k++){
			for(int i=0;i<len-k+1;i++){
				int j=i+k-1;
				if(s.charAt(i) == s.charAt(j) && k==2){
					dp[i][j] = 2;
				}else if(s.charAt(i) == s.charAt(j)){
					dp[i][j] = dp[i+1][j-1]+2;
				}else
					dp[i][j] =Math.max(dp[i+1][j], dp[i][j-1]);
			}
		}
		for(int i=0;i<len;i++){
			for(int j=0;j<len;j++){
				System.out.print(dp[i][j]+" ");
			}
			System.out.println();
		}
		return dp[0][len-1];
	}
	
	public static void main(String[] args) {
		String s = "bbbab";
		int res  = longestPalindromeSubseq(s);
		System.out.println(res);
	}
}
