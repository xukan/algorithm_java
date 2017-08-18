package algorithm_java;

//http://www.geeksforgeeks.org/flood-fill-algorithm-implement-fill-paint/

public class Floodfill {
	public void floodFill(int[][] screen, int x, int y, int newC){
		int m = screen.length;
		int n = screen[0].length;
		boolean[][] visited = new boolean[m][n];
		helper(screen, screen[x][y], x, y, newC, visited);
		screen[x][y] = newC;
	}
	
	public void helper(int[][] screen, int target, int x, int y, int newC, boolean[][] visited){
		int m = screen.length;
		int n = screen[0].length;
		int[][] dirs = {{-1,0},{1,0},{0,-1},{0,1}};
		visited[x][y]=true;
		for(int[] dir: dirs){
			int i = x+dir[0];
			int j = y+dir[1];
			if(i<0 || i>=m || j<0 || j>=n || visited[i][j] || screen[i][j]!=target)
				continue;
			screen[i][j] = newC;
			helper(screen, target, i, j, newC, visited);
		}
		visited[x][y] = false;
	}
	
	
	public static void main(String[] args) {
		Floodfill s =new Floodfill();
		int screen[][] = {{1, 1, 1, 1, 1, 1, 1, 1},
                				{1, 1, 1, 1, 1, 1, 0, 0},
                				{1, 0, 0, 1, 1, 0, 1, 1},
                				{1, 2, 2, 2, 2, 0, 1, 0},
                				{1, 1, 1, 2, 2, 0, 1, 0},
                				{1, 1, 1, 2, 2, 2, 2, 0},
                				{1, 1, 1, 1, 1, 2, 1, 1},
                				{1, 1, 1, 1, 1, 2, 2, 1}
               				};
		int x = 4, y = 4, newC = 3;
		s.floodFill(screen, x, y, newC);
		for(int i=0;i<screen.length;i++){
			for(int j=0;j<screen[0].length;j++){
				System.out.print(screen[i][j]+" ");
			}
			System.out.println();
		}
	}
}
