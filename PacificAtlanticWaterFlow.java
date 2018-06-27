package algorithm_java;

import java.util.LinkedList;
import java.util.List;

//Google

//http://www.cnblogs.com/grandyang/p/5962508.html

public class PacificAtlanticWaterFlow {
	//Since we keep a visited list for each ocean, we only visit a cell if it is not visited before. 
	//For each ocean, the worst case is MN thus totally O(MN)
	static final int[][]dir = new int[][]{{-1, 0},{1,0},{0,-1},{0,1}};
	public List<int[]> pacificAtlantic(int[][] matrix) {
        List<int[]> res = new LinkedList<>();
        if(matrix == null || matrix.length == 0 || matrix[0].length == 0){
            return res;
        }
        int m = matrix.length, n = matrix[0].length;
        boolean[][]pacific = new boolean[m][n];
        boolean[][]atlantic = new boolean[m][n];
        for(int i=0; i<m; i++){
            dfs(matrix, pacific, i, 0);
            dfs(matrix, atlantic, i, n-1);
        }
        for(int j=0; j<n; j++){
            dfs(matrix, pacific, 0, j);
            dfs(matrix, atlantic, m-1, j);
        }
        for (int i = 0; i < m; i++) 
            for (int j = 0; j < n; j++) 
                if (pacific[i][j] && atlantic[i][j]) 
                    res.add(new int[] {i, j});
        return res;
    }
    
    public void dfs(int[][]matrix, boolean[][]visited, int i, int j){
        int n = matrix.length, m = matrix[0].length;
        visited[i][j] = true;
        for(int[]d:dir){
        	int x = i+d[0];
        	int y = j+d[1];
        	if(x<0 || x>=n || y<0 || y>=m || visited[x][y] || matrix[x][y] < matrix[i][j])
                continue;
            dfs(matrix, visited,x, y );
        }
    }
    
    public static void main(String[] args) {
    	int[][] matrix = {{1,2,2,3,5},
    							 {3,2,3,4,4},
    							 {2,4,5,3,1},
    							 {6,7,1,4,5},
    							 {5,1,1,2,4}};
    	PacificAtlanticWaterFlow s = new PacificAtlanticWaterFlow();
    	List<int[]> res = s.pacificAtlantic(matrix);
    	res.forEach(k -> System.out.println(k[0] + " " + k[1]));
	}
}
