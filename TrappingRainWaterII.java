package algorithm_java;

//reference:  http://www.cnblogs.com/grandyang/p/5928987.html

import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.PriorityQueue;

//Google Twitter

public class TrappingRainWaterII {
	class Cell implements Comparable<Cell> {
        public int row, col, height;

        public Cell(int row, int col, int height) {
            this.row = row;
            this.col = col;
            this.height = height;
        }

        public int compareTo(Cell o) {
            return this.height - o.height;
        } 
    }
	
	public static final int[][] directions = {{-1,0},{1,0},{0,-1},{0,1}};
	
    public int trapRainWater(int[][] heightMap) {
        if (heightMap==null || heightMap.length<=2 || heightMap[0].length<=2) return 0;
        int m = heightMap.length;
        int n = heightMap[0].length;
        int res = 0;
        
        PriorityQueue<Cell> queue = new PriorityQueue<Cell>();
        
        HashSet<Integer> visited = new HashSet<Integer>();

        //这道题的解法就好像海平面在上涨,由于四周围的高度一定是要用来存水的,
        //于是首先把四个边上的点加入到队列中,队列顺序由小到大
        for(int i=0;i<m;i++){
        	for(int j=0;j<n;j++){
        		if(i==0|| i==m-1 || j==0 || j==n-1){
        			queue.offer(new Cell(i, j, heightMap[i][j]));
        			visited.add(i*n+j);
        		}
        	}
        }
        
        //PriorityQueue which is in increasing order. 
        //we can use following code to print elements stored in priority queue. We cannot use iterator since it prints heap structure which is not in order. 
//        while(!queue.isEmpty()){
//        	Cell cur= queue.poll();
//        	System.out.println( cur.row+" "+ cur.col + " " + cur.height );
//        }

        while (!queue.isEmpty()) {
            Cell cur = queue.poll();
            //System.out.println(cur.row+" "+ cur.col + " " + cur.height);
            for (int[] dir : directions) {
                int row = cur.row + dir[0];
                int col = cur.col + dir[1];
                
                //we have 2 methods here
                /*********method 1 *********/
                if(row<0 || row>=m || col<0 || col>=n || visited.contains(row*n+col))
                    continue;
                else{
	                visited.add(row*n+col);
	                //这里注意在检测过一个地之后,在加入队列的时候,高度要存最大高度,这样就有可能不是这个点自己的高度,
	                //这样就可以算出这个点四周的点的存水量了
	                int height = Math.max(cur.height, heightMap[row][col]);
	                queue.offer(new Cell(row,col, height));
	                if(heightMap[row][col] < cur.height)
	                    res += (cur.height- heightMap[row][col]);
                }
                /*
                 * ******method 2*******
                if (row>=0 && row<m && col>=0 && col<n && !visited.contains(row*n+col)) {
                    visited.add(row*n+col);
                   //sea level increases, this guarantees that we scan low column first. So every time we 
                    //come across high column, and if its neighbor is lower than it, lower column can stores water.
                    //Since all column next to the low column is higher than it.
                    res += Math.max(0, cur.height - heightMap[row][col]);
                    queue.offer(new Cell(row, col, Math.max(cur.height, heightMap[row][col])));
                }*/
            }
        }
        return res;
    }
	
	public static void main(String[] args) {
		TrappingRainWaterII s = new TrappingRainWaterII();
		int[][] input = { {1,4,3,1,3,2},
				  				{3,2,1,3,2,4},
				  				{2,3,3,2,3,1}};
		int res = s.trapRainWater(input);
		System.out.print(res);
	}
}
