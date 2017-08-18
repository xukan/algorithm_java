package algorithm_java;

import java.util.LinkedList;
import java.util.Queue;

//Google Zenefits

public class ShortestDistancefromAllBuildings {
	int[][] dirs = {{-1,0},{1,0},{0,-1},{0,1}};
	int minDist = -1;

//	public int shortestDistance(int[][] grid) {
//	    if (grid == null || grid.length == 0 || 
//	        grid[0].length == 0) return minDist;
//	    int m = grid.length, n = grid[0].length;
//	    int[][] dist = new int[m][n];
//	    int walk = 1;
//	    for (int i = 0; i < m; i++) {
//	        for (int j = 0; j < n; j++) {
//	            if (grid[i][j] == 1)
//	            	bfs(i, j, --walk, grid, dist);
//	        }
//	    }
//	    return minDist;
//	}
//
//	private void bfs(int i, int j, int walk, int[][] grid, int[][] dist) {
//	    minDist = -1;
//	    Queue<int[]> q = new LinkedList<>();
//	    q.offer(new int[]{i, j});
//	    int depth = 0;
//	    while (!q.isEmpty()) {
//	        depth++;
//	        int len = q.size();
//	        for (int k = 0; k < len; k++) {
//	            int[] pos = q.poll();
//	            for (int[] dir: dirs) {
//	                int r = pos[0] + dir[0];
//	                int c = pos[1] + dir[1];
//	                if (r >= 0 && r < grid.length && c >= 0 && c < grid[0].length
//	                    && grid[r][c] == walk) {
//	                    grid[r][c] = walk - 1;
//	                    dist[r][c] += depth;
//	                    if (minDist < 0 || minDist > dist[r][c]){
//	                        minDist = dist[r][c];
//	                    }
//	                    q.offer(new int[]{r, c});
//	                }
//	            }
//	        }
//	    }
//	}
	
	public int shortestDistance(int[][] grid) {
	    if (grid == null || grid.length == 0 || grid[0].length == 0)
	    	return minDist;
	    int m = grid.length, n = grid[0].length;
	    int[][] dist = new int[m][n];
	    for (int i = 0; i < m; i++) {
	        for (int j = 0; j < n; j++) {
	            if (grid[i][j] == 1)
	            	bfs(i, j, grid, dist, new boolean[m][n]);
	        }
	    }
	    for (int i = 0; i < m; i++) {
	        for (int j = 0; j < n; j++) {
	            System.out.print(dist[i][j] + " ");
	        }
	        System.out.println();
	    }
	    return minDist;
	}

	private void bfs(int i, int j, int[][] grid, int[][] dist, boolean[][] visited) {
	    minDist = -1;
	    visited[i][j] = true;
	    Queue<int[]> q = new LinkedList<>();
	    q.offer(new int[]{i, j});
	    int depth = 0;
	    while (!q.isEmpty()) {
	        depth++;
	        int len = q.size();
	        for (int k = 0; k < len; k++) {
	            int[] pos = q.poll();
	            for (int[] dir: dirs) {
	                int r = pos[0] + dir[0];
	                int c = pos[1] + dir[1];
	                if (r >= 0 && r < grid.length && c >= 0 && c < grid[0].length
	                    && !visited[r][c] && grid[i][j]!=1 && grid[r][c]!=2) {
	                    visited[r][c] = true;
	                    dist[r][c] += depth;
//	                    if ((minDist < 0 || minDist > dist[r][c]) && grid[r][c]!=2){
	                    if (minDist < 0 || minDist > dist[r][c]){
	                        minDist = dist[r][c];
	                    }
	                    q.offer(new int[]{r, c});
	                }
	            }
	        }
	    }
	}
	
	public static void main(String[] args) {
		ShortestDistancefromAllBuildings s = new ShortestDistancefromAllBuildings();
		int[][] grid = {
				//{1,0,2,0,1},{0,0,0,0,0},{0,0,1,0,0}
				{0,2,1},{1,0,2},{0,1,0}
		};
		int res =s.shortestDistance(grid);
		System.out.println(res);
	}
}
