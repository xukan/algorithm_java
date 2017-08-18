package algorithm_java;

//Google Facebook 

public class WallsandGates {
	static final int[][] dirs = {{-1,0},{1,0},{0,-1},{0,1}};
    public void wallsAndGates(int[][] rooms) {
        if(rooms.length == 0)
            return;
        int m = rooms.length;
        int n = rooms[0].length;
        boolean[][] visited = new boolean[m][n];
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(rooms[i][j] == 0)
                    helper(rooms, i, j, 0, visited);
            }
        }
    }
    
    public void helper(int[][] rooms, int i, int j, int dis, boolean[][] visited){
        int m = rooms.length;
        int n = rooms[0].length;
        for(int[] dir: dirs){
            int x = i + dir[0];
            int y = j + dir[1];
            if(x<0 || x>=m || y<0 || y>=n || rooms[x][y] == -1 || rooms[x][y] == 0 || visited[x][y])
                continue;
            rooms[x][y] = Math.min(rooms[x][y], dis+1);
            visited[x][y] = true;
            helper(rooms,x, y, rooms[x][y], visited);
            visited[x][y] = false;
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
