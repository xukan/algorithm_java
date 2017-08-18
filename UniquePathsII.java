package algorithm_java;

public class UniquePathsII {
	public static int uniquePathsWithObstacles(int[][] obstacleGrid) {
        if(obstacleGrid[0][0] == 1)
            return 0;
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        int[][] dp = new int[m][n];
        dp[0][0] = 1;
        for(int i=1;i<m;i++){
            if(obstacleGrid[i][0] == 1){
                break;
            }
            dp[i][0] = 1;
        }
        for(int j=1;j<n;j++){
            if(obstacleGrid[0][j] == 1){
                break;
            }
            dp[0][j] = 1;
        }
        for(int i=1;i<m;i++){
            for(int j=1;j<n;j++){
                if(obstacleGrid[i][j]==1)
                    continue;
                else{
                    dp[i][j] += dp[i-1][j];
                    dp[i][j] += dp[i][j-1];
                }
            }
        }
        return dp[m-1][n-1];
    }
	
	public static void main(String[] args) {
		int[][] grid = {{0,0,0},
				  			  {0,1,0},
				              {0,0,0}};
		int res = uniquePathsWithObstacles(grid);
		System.out.println(res);
	}
}
