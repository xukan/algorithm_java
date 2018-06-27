package algorithm_java;

import java.util.LinkedList;
import java.util.Queue;

//TheMazeII, TheMazeIII

public class TheMaze {
	class Point{
        int x;
        int y;
        public Point(int x, int y){
            this.x = x;
            this.y = y;
        }
    }
	
    private static final int[][] dirs = {{-1,0},{1,0},{0,-1},{0,1}};
    
    public boolean hasPath(int[][] maze, int[] start, int[] destination) {
        int m = maze.length, n = maze[0].length;
        boolean[][] visited = new boolean[m][n];
        Queue<Point> queue = new LinkedList<Point>();
        Point begin = new Point(start[0], start[1]);
        queue.offer(begin);
        visited[begin.x][begin.y] = true;
        while(!queue.isEmpty()){
            Point p = queue.poll();
            for(int[] dir: dirs){
            	 int x = p.x;
                 int y = p.y;
                while(x + dir[0] >=0 && x + dir[0] < m && y + dir[1] >=0 && y + dir[1] <n && maze[x + dir[0]][y + dir[1]] == 0){
                    x += dir[0];
                    y += dir[1];
                }
                if(visited[x][y])
                    continue;
                if(x == destination[0] && y == destination[1])
                    return true;
                visited[x][y] = true;
                queue.offer(new Point(x, y));
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
