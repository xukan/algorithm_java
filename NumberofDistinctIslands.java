package algorithm_java;

import java.util.HashSet;
import java.util.Set;

//Amazon

public class NumberofDistinctIslands {
	int[][] dirs = new int[][] { { -1, 0 },{ 1, 0 }, { 0, -1 }, { 0, 1 } };
	public int numDistinctIslands(int[][] grid) {
		Set<String> set = new HashSet<>();
		int res = 0;

		for (int i = 0; i < grid.length; i++) {
			for (int j = 0; j < grid[0].length; j++) {
				if (grid[i][j] == 1) {
					StringBuilder sb = new StringBuilder();
					helper(grid, i, j, 0, 0, sb);
					String s = sb.toString();
					if (!set.contains(s)) {
						res++;
						set.add(s);
					}
				}
			}
		}
		return res;
	}

	public void helper(int[][] grid, int i, int j, int xpos, int ypos, StringBuilder sb) {
		grid[i][j] = 0;
		sb.append(xpos + "" + ypos);
		for (int[] dir : dirs) {
			int x = i + dir[0];
			int y = j + dir[1];
			if (x < 0 || y < 0 || x >= grid.length || y >= grid[0].length || grid[x][y] == 0)
				continue;
			helper(grid, x, y, xpos + dir[0], ypos + dir[1], sb);  //note here we use xpos + dir[0], ypos + dir[1]
		}
	}
	
	public static void main(String[] args) {
		NumberofDistinctIslands s = new NumberofDistinctIslands();
//		int[][] grid = {{1,1,0,1,1},
//							  {1,0,0,0,0},
//							  {0,0,0,0,1},
//							  {1,1,0,1,1}};
		int[][] grid = {{1,1,0},
							  {0,1,1},
							  {0,0,0},
							  {1,1,1},
							  {0,1,0}};  //in this example, if we just memorize directions, two islands have same direction string: 00011001
		
		int res = s.numDistinctIslands(grid);
		System.out.println(res);
	}
}
