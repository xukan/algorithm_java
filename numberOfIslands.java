package algorithm_java;

public class numberOfIslands {
	
	public int numIslands(char[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        boolean[][] visited = new boolean[m][n];
        int count = 0;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
            	if(grid[i][j]=='1' && !visited[i][j]){
                	count++;
                	dfs( grid,  visited, i, j );
            	}
            }
        }
        return count;
    }
    
    public void dfs( char[][] grid, boolean[][] visited, int x, int y ){
        int[] dx = {0, 0, -1, 1};
        int[] dy = {-1, 1, 0, 0};
        if(x <0 || x >= grid.length || y<0 || y>=grid[0].length || visited[x][y] || grid[x][y] == '0')
        	return;
        visited[x][y]=true;
        if(grid[x][y] == '1')
	        for( int i =0;i<4;i++ ){
	        	dfs( grid, visited, x+dx[i], y+dy[i] );
	        }
    }
	
	public static void main(String[] args){
		char[][] matrix ={
//				 {1, 1, 0, 0, 0},
//			     {0, 1, 0, 0, 1},
//			     {1, 0, 0, 1, 1},
//			     {0, 0, 0, 0,  0},
//			     {1, 0, 1, 0, 1}
				 {'1', '1', '0', '0', '0'},
			     {'1', '1', '0', '0', '0'},
			     {'0', '0', '1', '0', '0'},
			     {'0', '0', '0', '1', '1'},
			     {'1', '0', '0', '1', '1'}
//			     {1, 0, 1, 0, 1}
		};
		numberOfIslands s = new numberOfIslands ();
		int count = s.numIslands(matrix);
		System.out.println(count);
	}
}
