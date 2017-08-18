package algorithm_java;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.PriorityQueue;

public class TheMazeII {
	class Point{
        int x;
        int y;
        int l;
        public Point(int x, int y, int l){
            this.x = x;
            this.y = y;
            this.l = l;
        }
    }
    
    public static final int[][] dirs = {{-1, 0},{1,0},{0,-1},{0,1}};
    public int shortestDistance(int[][] maze, int[] start, int[] destination) {
        int m = maze.length, n = maze[0].length;
        int[][] dis = new int[m][n];
        boolean[][] visited = new boolean[m][n];
        for(int i=0;i<m;i++)
            Arrays.fill(dis[i], Integer.MAX_VALUE);
        LinkedList<Point> queue = new LinkedList<Point>();
        Point source = new Point(start[0], start[1], 0);
        queue.offer(source);
        dis[start[0]][start[1]] = 0;
        while(!queue.isEmpty()){
            Point p = queue.poll();
            if(visited[p.x][p.y])
                continue;
            for(int[] dir : dirs){
                int xx = p.x, yy = p.y, len = p.l;
                while(xx+dir[0]>=0 && xx+dir[0] < m && yy + dir[1] >=0 && yy + dir[1] < n && maze[xx+dir[0]][yy + dir[1]] == 0){
                    xx += dir[0];
                    yy += dir[1];
                    len++;
                }
                if(visited[xx][yy])
                    continue;
                if( len < dis[xx][yy]){
                    dis[xx][yy] = len;
                    queue.offer(new Point(xx, yy, len));
                }
            }
        }
        return dis[destination[0]][destination[1]] == Integer.MAX_VALUE?-1: dis[destination[0]][destination[1]];
    }
	
	
    public static void main(String[] args) {
		TheMazeII s = new TheMazeII();
		int[][] maze = {{0, 0, 1, 0, 0},
								{0, 0, 0, 0, 0},
								{0, 0, 0, 1, 0},
								{1, 1, 0, 1, 1},
								{0, 0, 0, 0, 0}};
		int[] start= {0,4};
		int[] des = {4,4};
		int res = s.shortestDistance(maze, start, des);
		System.out.println(res);
	}
}
