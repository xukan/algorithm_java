package algorithm_java;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

//Leetcode

public class TheMazeIII {
	class Point{
        int x;
        int y;
        String route;
        int d;
        public Point(int x, int y, int d){
        	this.x = x;
        	this.y = y;
        	this.route = "";
        	this.d = d;
        }
		public void setRoute(String r) {
			route += r;
		}
    }
    private static final int[][] dirs = {{-1,0},{1,0},{0,-1},{0,1}};
    private static final char[] direc = {'u', 'd', 'l', 'r'};
    int minLen= Integer.MAX_VALUE;
    
    public String findShortestWay(int[][] maze, int[] ball, int[] hole) {
        int m = maze.length, n = maze[0].length;
        boolean[][] visited = new boolean[m][n];
        int[][] dis = new int[m][n];
        for(int i=0;i<m;i++)
            Arrays.fill(dis[i], Integer.MAX_VALUE);
        dis[ball[0]][ball[1]] = 0;
        Queue<Point> queue = new LinkedList<Point>();
        queue.offer(new Point(ball[0], ball[1], 0));
        visited[ball[0]][ball[1]] = true;
        List<String> res = new ArrayList<String>(); 
        while(!queue.isEmpty()){
            Point p = queue.poll();
            for(int i=0;i<4;i++){
                int d = p.d;
                int x = p.x, y = p.y;
                String r = p.route;
                while(x+dirs[i][0]>=0 && x+dirs[i][0]<m && y+dirs[i][1]>=0 && y+dirs[i][1]<n&&maze[x+dirs[i][0]][y + dirs[i][1]] == 0 && !( x == hole[0] && y== hole[1])){
                    x += dirs[i][0];
                    y += dirs[i][1];
                    d++;
                }
                int distance = dis[x][y];
                dis[x][y] = Math.min(dis[x][y], d);
                r+=direc[i];
                if((!visited[x][y] || dis[x][y]<distance) && !( x == hole[0] && y== hole[1])){
                	Point cell = new Point(x, y, d);
                	cell.setRoute(r);
                	queue.offer(cell);
                	visited[x][y] = true;
                }else if(x == hole[0] && y == hole[1]){
                	if(d > distance)
                    	continue;
                    if(d< distance)
                        res.clear();
                    res.add(r);    
                }
            }
        }
        Collections.sort(res);
        res.forEach(i->System.out.print(i+" "));
        System.out.println();
        System.out.println(dis[hole[0]][hole[1]]);
        return dis[hole[0]][hole[1]] == Integer.MAX_VALUE?"impossible":res.get(0);
    }
    
    public static void main(String[] args) {
		TheMazeIII s = new TheMazeIII();
//		int[][] maze = {{0,0,0,0,0},{1,1,0,0,1},{0,0,0,0,0},{0,1,0,0,1},{0,1,0,0,0}};
//		int[] ball= {4,3};
//		int[] hole = {0,1};
//		int[][] maze = {{0,0,0,0,0,0,0},
//							   {0,0,1,0,0,1,0},
//							   {0,0,0,0,1,0,0},
//							   {0,0,0,0,0,0,1}};
//		int[] ball= {0,4};
//		int[] hole ={2,0};
//		int[][] maze = {{0, 1, 0, 0, 1, 0, 0, 0, 0, 0, 1, 0, 0, 1, 0, 0, 1, 0, 0, 1, 0, 0, 1, 0, 0, 1, 0, 0, 1, 0},
//				{0, 0, 0, 0, 0, 1, 0, 0, 1, 0, 0, 1, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 1},
//				{0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 1, 0, 0, 1, 0, 0, 1, 0, 0, 1, 0, 0, 0, 0, 0, 1, 0, 0},
//				{1, 0, 0, 1, 0, 0, 1, 0, 0, 1, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 1, 0, 0, 1, 0, 0},
//				{0, 1, 0, 0, 1, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0},
//				{0, 0, 1, 0, 0, 1, 0, 0, 1, 0, 0, 1, 0, 0, 0, 0, 0, 1, 0, 0, 1, 0, 0, 1, 0, 0, 0, 0, 0, 0},
//				{0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 1, 0, 0, 1, 0, 0, 1, 0, 0},
//				{1, 0, 0, 1, 0, 0, 1, 0, 0, 1, 0, 0, 0, 0, 0, 1, 0, 0, 1, 0, 0, 0, 0, 0, 1, 0, 0, 1, 0, 0},
//				{0, 1, 0, 0, 0, 0, 0, 1, 0, 0, 1, 0, 0, 1, 0, 0, 1, 0, 0, 1, 0, 0, 0, 0, 0, 1, 0, 0, 1, 0},
//				{0, 0, 1, 0, 0, 1, 0, 0, 1, 0, 0, 1, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 1, 0, 0, 1, 0, 0, 1},
//				{0, 0, 0, 1, 0, 0, 1, 0, 0, 1, 0, 0, 0, 0, 0, 1, 0, 0, 1, 0, 0, 0, 0, 0, 1, 0, 0, 1, 0, 0},
//				{1, 0, 0, 1, 0, 0, 1, 0, 0, 1, 0, 0, 1, 0, 0, 1, 0, 0, 1, 0, 0, 0, 0, 0, 1, 0, 0, 1, 0, 0},
//				{0, 1, 0, 0, 1, 0, 0, 0, 0, 0, 1, 0, 0, 1, 0, 0, 1, 0, 0, 1, 0, 0, 1, 0, 0, 1, 0, 0, 1, 0},
//				{0, 0, 1, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 1, 0, 0, 0, 0, 0, 1, 0, 0, 1, 0, 0, 1},
//				{0, 0, 0, 1, 0, 0, 1, 0, 0, 1, 0, 0, 1, 0, 0, 1, 0, 0, 1, 0, 0, 1, 0, 0, 1, 0, 0, 0, 0, 0},
//				{1, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 1, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0},
//				{0, 0, 0, 0, 1, 0, 0, 1, 0, 0, 1, 0, 0, 1, 0, 0, 0, 0, 0, 1, 0, 0, 1, 0, 0, 1, 0, 0, 1, 0},
//				{0, 0, 1, 0, 0, 1, 0, 0, 1, 0, 0, 1, 0, 0, 0, 0, 0, 1, 0, 0, 1, 0, 0, 1, 0, 0, 1, 0, 0, 1},
//				{0, 0, 0, 1, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 1, 0, 0},
//				{1, 0, 0, 1, 0, 0, 1, 0, 0, 1, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0},
//				{0, 1, 0, 0, 1, 0, 0, 1, 0, 0, 0, 0, 0, 1, 0, 0, 1, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0},
//				{0, 0, 1, 0, 0, 1, 0, 0, 1, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 1, 0, 0, 1, 0, 0, 0, 0, 0, 1},
//				{0, 0, 0, 1, 0, 0, 1, 0, 0, 1, 0, 0, 1, 0, 0, 1, 0, 0, 1, 0, 0, 1, 0, 0, 1, 0, 0, 0, 0, 0},
//				{1, 0, 0, 1, 0, 0, 1, 0, 0, 1, 0, 0, 1, 0, 0, 1, 0, 0, 1, 0, 0, 1, 0, 0, 1, 0, 0, 1, 0, 0},
//				{0, 1, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 1, 0, 0, 0, 0, 0, 1, 0, 0, 1, 0, 0, 0, 0},
//				{0, 0, 1, 0, 0, 1, 0, 0, 1, 0, 0, 1, 0, 0, 1, 0, 0, 1, 0, 0, 1, 0, 0, 1, 0, 0, 1, 0, 0, 1},
//				{0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 1, 0, 0, 1, 0, 0, 1, 0, 0},
//				{1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0},
//				{0, 1, 0, 0, 1, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 1, 0, 0, 1, 0, 0, 1, 0},
//				{0, 0, 1, 0, 0, 1, 0, 0, 1, 0, 0, 1, 0, 0, 1, 0, 0, 1, 0, 0, 0, 0, 0, 1, 0, 0, 1, 0, 0, 1}};
//		int[] ball= {29,18};
//		int[] hole ={14,22};
		int[][] maze = {{0,1,0,0,1,0,0,1,0,0},
				               {0,0,1,0,0,1,0,0,1,0},
							   {0,0,0,0,0,0,1,0,0,1},
							   {0,0,0,0,0,0,1,0,0,1},
							   {0,1,0,0,1,0,0,1,0,0},
							   {0,0,1,0,0,1,0,0,0,0},
							   {0,0,0,0,0,0,1,0,0,0},
							   {1,0,0,1,0,0,0,0,0,1},
							   {0,1,0,0,1,0,0,1,0,0},
							   {0,0,0,0,0,1,0,0,1,0}};
		int[] ball= {2,4};
		int[] hole = {7,6};
		String res = s.findShortestWay(maze, ball, hole);
		System.out.println(res);		
	}
}
