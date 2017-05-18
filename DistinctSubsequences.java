package algorithm_java;

public class DistinctSubsequences {
	public static int numDistinct(String s, String t) {
        if(s == null || t == null)
            return 0;
        int len1 = t.length();
        int len2 = s.length();
        int[][] dp = new int[len1+1][len2+1];
        dp[0][0] = 1;
        for(int i=1;i<=len1;i++)//如果s为空，那么就不存在字串
            dp[i][0] = 0;
        for(int j=1;j<=len2;j++)//如果t为空，那么只有全部删除s中的所有字符一种方法得到t(空串是任意非空字符串的子串)
            dp[0][j] = 1;
        
        for(int i=1;i<=len1;i++){
            for(int j=1;j<=len2;j++){
                dp[i][j] = dp[i][j-1];
                if(t.charAt(i-1) == s.charAt(j-1))
                	//注意，这里的s的位置i-1的字符就是s中的第i个字符
                	//       t的位置j-1的字符就是t中的第j个字符
                    dp[i][j] += dp[i-1][j-1];
            }
        }
       
        for(int i=0;i<=len1;i++){
        	for(int j=0;j<=len2;j++){
        		System.out.print(dp[i][j]+" ");
        	}
        	System.out.println();
        }
        return dp[len1][len2];
	 
    }
	
	public static void main(String[] args){
		//String word1 = "ccc", word2 = "c";
		String word1 = "rabbbit", word2 = "rabbit";
		int count = numDistinct(word1, word2);
		System.out.println(count);
	}
}
