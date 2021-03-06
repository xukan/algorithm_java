package algorithm_java;

//Google

/*reference: https://discuss.leetcode.com/topic/34835/15ms-concise-java-solution/17
 * 
 * The DFS here is basically like DP with memorization. Every cell that has been computed will not be computed again, 
 * only a value look-up is performed. So this is O(mn), m and n being the width and height of the matrix.
 * To be exact, each cell can be accessed 5 times at most: 4 times from the top, bottom, left and right and one time from the outermost double for loop. 
 * 4 of these 5 visits will be look-ups except for the first one. So the running time should be lowercase o(5mn), which is of course O(mn).
 * 
 * */

public class LongestIncreasingPathinaMatrix {
//	public int longestIncreasingPath(int[][] matrix) {
//        if( matrix == null || matrix.length == 0)
//            return 0;
//        int max=0;
//        int m=matrix.length, n=matrix[0].length;
//        boolean[][] visited = new boolean[m][n];
//        for( int i=0; i< m; i++){
//            for( int j=0; j<n; j++ ){
//            	System.out.println(i+" "+j);
//                int len = dfs( matrix, i, j, 1, visited, matrix[i][j]);
//                max= Math.max(max, len);
//                System.out.println();
//            }
//        }
//        return max;
//    }
//    
//    public int dfs( int[][] matrix, int i, int j, int size, boolean[][] visited, int val){
//        if( i <0 || i >= matrix.length || j<0 || j >= matrix[0].length || visited[i][j] || ( size>1 && matrix[i][j]<=val ))
//            return size-1;
//        visited[i][j] = true;
//        int[] dx = { -1, 0, 1, 0 };
//        int[] dy = { 0, 1, 0, -1 };
//        
//        for( int k=0; k<4; k++){
//            int x= i + dx[k];
//            int y= j + dy[k];
//            size = dfs(matrix, x,y,size+1,visited, matrix[i][j]);
//        }
//        System.out.print(matrix[i][j]);
//        visited[i][j] = false;
//        return size;
//    }
	
	
	//DFS + memorization
	//
	static final int[][] dirs = {{-1, 0},{1, 0},{0,-1},{0,1}};
    public static int longestIncreasingPath(int[][] matrix) {
        if(matrix==null||matrix.length==0||matrix[0].length==0)
            return 0;
        int m=matrix.length, n=matrix[0].length;
        int longest=0;
        int[][] grid = new int[m][n];
        for(int i=0;i<m;i++){
        	for(int j=0;j<n;j++){
        		int size = dfs(matrix, i, j, grid);
        		longest = Math.max(longest, size);
        	}
        }
        return longest;
    }
    
    public static int dfs(int[][] matrix, int i, int j, int[][] grid){
    	if(grid[i][j]!=0)
    		return grid[i][j];
    	for(int[] dir : dirs){
    		int x=i+dir[0];
    		int y=j+dir[1];
    		if(x>=0 && x<matrix.length && y>=0 && y<matrix[0].length && matrix[x][y]>matrix[i][j]){
    			int size = dfs(matrix, x, y, grid);
    			grid[i][j] = Math.max(grid[i][j], size);
    		}
    	}
    	return ++grid[i][j];
    }
	
	
	public static void main(String[] args) {
		int[][] nums  = {
		                       {9,9,4},
		                       {6,6,8},
		                       {2,1,1}
		                       };
//		int[][] nums  = {
//                {3,4,5},
//                {3,2,6},
//                {2,2,1}
//                };
		
		
		LongestIncreasingPathinaMatrix solution = new LongestIncreasingPathinaMatrix();
		int res = solution.longestIncreasingPath(nums);
		System.out.println( res );
	}
}
