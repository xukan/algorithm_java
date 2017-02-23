package algorithm_java;

public class EditDistance {
	public static int minDistance(String word1, String word2) {
        int m = word1.length();
        int n = word2.length();
        int[][] dp = new int[m+1][n+1];
        dp[0][0]=0;
        //如果第二个字符串为空，就相当于做m个删除操作
        for(int i=1;i<m+1;i++){
            dp[i][0]=i;
        }
        //如果第一个字符串为空，就相当于做n个插入操作
        for(int j=1;j<n+1;j++)
            dp[0][j]=j;
        for(int i=1;i<m+1;i++){
            for(int j=1;j<n+1;j++){
                if(word1.charAt(i-1) == word2.charAt(j-1))
                    dp[i][j] = dp[i-1][j-1];
                else{
                    int deletion = dp[i][j-1]+1;
                    int insertion = dp[i-1][j]+1;
                    int tmp = Math.min(deletion, insertion);
                    int replace = dp[i-1][j-1]+1;
                    dp[i][j] = Math.min(replace, tmp);
                }
            }
        }
        return dp[m][n];
    }
	
	public static void main(String[] args){
		String word1 = "zeil", word2 = "trials";
		int count = minDistance(word1, word2);
		System.out.println(count);
	}
}
