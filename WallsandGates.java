package algorithm_java;

import java.util.LinkedList;
import java.util.Queue;

//Google Facebook 

public class WallsandGates {
	private static final int[][] dirs = {{-1,0},{1,0},{0,-1},{0,1}};
    public void wallsAndGates(int[][] rooms) {
        if(rooms.length == 0)
            return;
        int m = rooms.length, n = rooms[0].length;
        Queue<int[]> queue = new LinkedList<int[]>();
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(rooms[i][j] == 0)
                    helper(rooms, i, j);
            }
        }
    }
    
    public void helper(int[][] rooms, int i, int j){
        int m = rooms.length, n = rooms[0].length;
        for(int[] dir: dirs){
            int x = i + dir[0];
            int y = j + dir[1];
            if(x<0 || x>=m || y< 0 || y>=n || rooms[x][y] == -1 || rooms[i][j] + 1 > rooms[x][y])
                continue;
            rooms[x][y] = rooms[i][j] + 1;
            helper(rooms, x, y);
        }
    }
    
    public static void main(String[] args) {
    	WallsandGates wg = new WallsandGates();
    	int INF = Integer.MAX_VALUE;
		int[][] rooms = {
				{INF, -1,  0,  INF},{INF, INF, INF,  -1},{INF,  -1, INF,  -1},{ 0,  -1, INF, INF}
		};
		wg.wallsAndGates(rooms);
		for(int i=0;i<rooms.length;i++){
			for(int j=0;j<rooms[0].length;j++){
				System.out.print(rooms[i][j] + " ");
			}
			System.out.println();
		}
	}
}
