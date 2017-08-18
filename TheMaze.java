package algorithm_java;

import java.util.LinkedList;

//TheMazeII, TheMazeIII

public class TheMaze {
//	public static boolean hasPath(int[][] maze, int[] start, int[] destination) {
//	    if (start[0] == destination[0] && start[1] == destination[1]) return true;
//	    LinkedList<int[]> queue = new LinkedList<int[]>();
//	    queue.offer(start);
//	    int m = maze.length;
//	    int n = maze[0].length;
//	    boolean[][] visited = new boolean[m][n];
//	    visited[start[0]][start[1]] = true;
//	    int[][] dir = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
//	    while (!queue.isEmpty()) {
//	        int[] cur = queue.poll();
//	        for (int k = 0; k < dir.length; k++) {
//	            int x = cur[0];
//	            int y = cur[1];
//	            while (x >= 0 && x < m && y >= 0 && y < n && maze[x][y] == 0) {
//	                x += dir[k][0];
//	                y += dir[k][1];
//	            }
//	            x -= dir[k][0];
//	            y -= dir[k][1];
//	            if (visited[x][y]) continue;
//	            visited[x][y] = true;
//	            if (x == destination[0] && y == destination[1]) return true;
//	            queue.offer(new int[] {x, y});
//	        }
//	    }
//	    return false;
//	}
	
	class Point {
        int x,y;
        public Point(int _x, int _y) {x=_x;y=_y;}
    }
    public boolean hasPath(int[][] maze, int[] start, int[] destination) {
        int m=maze.length, n=maze[0].length;
        if (start[0]==destination[0] && start[1]==destination[1]) return true;
        int[][] dir=new int[][] {{-1,0},{1,0},{0,-1},{0,1}};
        boolean[][] visited=new boolean[m][n];
        LinkedList<Point> list=new LinkedList<>();
        visited[start[0]][start[1]]=true;
        list.offer(new Point(start[0], start[1]));
        while (!list.isEmpty()) {
            Point p=list.poll();
            int x=p.x, y=p.y;
            for (int i=0;i<4;i++) {
                int xx=x, yy=y;
                while (xx>=0 && xx<m && yy>=0 && yy<n && maze[xx][yy]==0) {
                    xx+=dir[i][0];
                    yy+=dir[i][1];
                }
                xx-=dir[i][0];
                yy-=dir[i][1];
                if (visited[xx][yy]) continue;
                visited[xx][yy]=true;
                if (xx==destination[0] && yy==destination[1]) return true;
                list.offer(new Point(xx, yy));
            }
        }
        return false;
        
    }
	
	
	public static void main(String[] args) {
		TheMaze s = new TheMaze();
		int[][] maze = {{0, 0, 1, 0, 0},
								{0, 0, 0, 0, 0},
								{0, 0, 0, 1, 0},
								{1, 1, 0, 1, 1},
								{0, 0, 0, 0, 0}};
		int[] start= {0,4};
		int[] des = {4,4};
		boolean res = s.hasPath(maze, start, des);
		System.out.println(res);
	}
}
