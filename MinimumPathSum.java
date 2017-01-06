package algorithm_java;

public class MinimumPathSum {
	public static int minPathSum(int[][] grid) {
        int m=grid.length;
        int n=grid[0].length;
        int minSum=0;
        for(int i=1;i<m;i++){
        	grid[i][0]+=grid[i-1][0];
        }
        for(int j=1;j<n;j++){
        	grid[0][j]+=grid[0][j-1];
        }
        for(int i=1;i<m;i++){
            for(int j=1;j<n;j++){
                int a=grid[i][j-1];
                int b=grid[i-1][j];
                grid[i][j] += Math.min(a, b);
                //minSum=grid[i][j];
            }
        }
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
            	System.out.print(grid[i][j]+ " ");
            }
            System.out.println();
            }
        
        return grid[m-1][n-1];
    }
	
	public static void main(String[] args) {
		//[[1,3,1],[1,5,1],[4,2,1]]
		int input[][] = {{1,3,1},{1,5,1},{4,2,1}};
		int res = minPathSum(input);
		System.out.println(res);
	}
}
