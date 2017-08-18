package algorithm_java;

//Apple Airbnb Facebook

//dp  tc: O(MN) sc: O(MN)
//https://segmentfault.com/a/1190000003709497

/*当我们判断以某个点P为正方形右下角能构成最大的正方形D时，那么点P的左上角,正上方,左方的三个点也一定是正方形的右下角
 * 否则以点P为右下角的最大的正方形就是点P自己了
 * 动态规划,初始化第一行和第一列,如果matrix[0][j]=='1', dp[0][j] =1或者 matrix[i][0] == '1',那么dp[i][0] ==1否则就是0,
 * 可以认为只要输入矩阵第一行或者第一列的一个格子为1,那么就能形成长度为1的正方形
 * 接下来找递推公式
 * 对于dp[i][j],可以认为是以坐标(i,j)为右下角的正方形D,那么正方形A的边长由dp[i-1][j-1]为右下角的正方形A，
 * dp[i-1][j]为右下角的正方形B,dp[i][j-1]为右下角的正方形C决定,
 * 即dp[i][j] = min(dp[i-1][j-1],dp[i-1][j],dp[i][j-1])+1
 * D的边长为A,B,C正方形最小的边长数加1
 * */

public class MaximalSquare {
	public static int maximalSquare(char[][] matrix) {
        if(matrix.length==0) return 0;
        int m = matrix.length;
        int n = matrix[0].length;
        int[][] dp = new int[m][n];
        int max = 0;
        for(int i=0;i<m;i++){
            dp[i][0] = matrix[i][0] == '1'? 1:0;
            max = Math.max(max, dp[i][0]);
        }
        for(int j=0;j<n;j++){
            dp[0][j] = matrix[0][j] == '1'? 1:0;
            max = Math.max(max, dp[0][j]);
        }
        for(int i=1;i<m;i++){
            for(int j=1;j<n;j++){
                if(matrix[i][j]=='1'){
                    dp[i][j] = Math.min(Math.min(dp[i-1][j], dp[i][j-1]), dp[i-1][j-1])+1;
                }else
                    dp[i][j] = 0;
                max = Math.max(max, dp[i][j]);
            }
        }
        return max*max;
    }
	
	public static void main(String[] args) {
		char[][] matrix={{'1', '0', '1', '0', '0'},
				  {'1', '0', '1', '1', '1'},
				  {'1', '1', '1', '1', '1'},
				  {'1', '0', '0', '1', '0'}};
		int area = maximalSquare(matrix);
		System.out.println(area);
	}
}
