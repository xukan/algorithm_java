package algorithm_java;

//tc : O(1) time per query, O(mn) time pre-computation. The pre-computation in the constructor takes O(mn) time. Each sumRegion query takes O(1) time.
//sc : O(mn). The algorithm uses O(mn) space to store the cumulative region sum.
public class RangeSumQueryTwoDImmutable {
	private int[][] dp;

    public RangeSumQueryTwoDImmutable(int[][] matrix) {
        if(matrix.length == 0)
            return;
        int m = matrix.length, n = matrix[0].length;
        dp = new int[m+1][n+1];
        for(int i=1;i<=m;i++){
            for(int j=1;j<=n;j++){
                dp[i][j] = dp[i][j-1] + dp[i-1][j] + matrix[i-1][j-1] - dp[i-1][j-1];
            }
        }
    }
    
    public int sumRegion(int row1, int col1, int row2, int col2) {
        return dp[row2+1][col2+1] - dp[row2+1][col1] - dp[row1][col2+1] + dp[row1][col1];
    }
	
	public static void main(String[] args) {
		int[][] matrix = {
				{3, 0, 1, 4, 2},
				{5, 6, 3, 2, 1},
				{1, 2, 0, 1, 5},
				{4, 1, 0, 1, 7},
				{1, 0, 3, 0, 5}};
		RangeSumQueryTwoDImmutable numMatrix = new RangeSumQueryTwoDImmutable(matrix);
		int row1 = 2, col1 = 1;
		int row2 = 4, col2 = 3;
		int sum =  numMatrix.sumRegion(row1, col1, row2, col2);
		System.out.println(sum);
	}
}
