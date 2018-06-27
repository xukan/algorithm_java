package algorithm_java;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

//Google

public class TheMazeII {
	class Point{
        int x;
        int y;
        public Point(int x, int y){
            this.x = x;
            this.y = y;
        }
    }
    private static final int[][] dirs = {{-1,0},{1,0},{0,-1},{0,1}};
    
    int minLen= Integer.MAX_VALUE;
    
    public int shortestDistance(int[][] maze, int[] start, int[] destination) {
        int m = maze.length, n = maze[0].length;
        boolean[][] visited = new boolean[m][n];
        int[][] dis = new int[m][n];
        for(int i=0;i<m;i++)
            Arrays.fill(dis[i], Integer.MAX_VALUE);
        dis[start[0]][start[1]] = 0;
        Queue<Point> queue = new LinkedList<Point>();
        queue.offer(new Point(start[0], start[1]));
        visited[start[0]][start[1]] = true;
        while(!queue.isEmpty()){
            Point p = queue.poll();
            for(int[] dir : dirs){
                int d = dis[p.x][p.y];
                int x = p.x, y = p.y;
                while(x+dir[0]>=0 && x+dir[0]<m && y+dir[1]>=0 && y+dir[1]<n && maze[x+dir[0]][y + dir[1]] == 0){
                    x += dir[0];
                    y += dir[1];
                    d++;
                }
                int distance = dis[x][y];
                dis[x][y] = Math.min(dis[x][y], d);
                //注意这里加入队列有两种情况需要考虑
                //1.当前点没有访问过
                //2.当前点已经访问过但是距离更新了,说明新计算出的距离更小
                if(!visited[x][y] || dis[x][y]< distance){
                	queue.offer(new Point(x, y));
                	visited[x][y] = true;
                }
            }
        }
        return dis[destination[0]][destination[1]] == Integer.MAX_VALUE?-1:dis[destination[0]][destination[1]];
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
