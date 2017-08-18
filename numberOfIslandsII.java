package algorithm_java;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//reference: https://segmentfault.com/a/1190000004197552
/*
 * 很典型的union-find题。因为这里是动态的增加land，要能随时求出有多少个island，最简单的方法就是union-find。
 * 我们可以定义一个counter, 每增加一个land, 增加counter, 然后我们搜索那个land邻居区域，
 * 发现root不一样的话，意味着可以union, 每union一次，意味着两个island合并成一个，减小counter, 
 * 统计最终的counter值，即是增加land后的最终island的个数。
 * 为了减小时间复杂度，代码实现是QuickUnion + Path Compression, 
 * Path Compression目的是为了调整树的高度，保持很平的树，而不是越来越高，这样找root不会出现worst case.
 * 复杂度
 * time: O(Mlog(N)), space: O(N)
 * M表示增加land的数量，N表示矩阵中点的个数即m*n。
 * */

/*
 * A 2d grid map of m rows and n columns is initially filled with water. 
 * We may perform an addLand operation which turns the water at position (row, col) into a land. 
 * Given a list of positions to operate, count the number of islands after each addLand operation. 
 * An island is surrounded by water and is formed by connecting adjacent lands horizontally or vertically. 
 * You may assume all four edges of the grid are all surrounded by water.
 * Example:
 * Given m = 3, n = 3, positions = [[0,0], [0,1], [1,2], [2,1]].
 * Initially, the 2d grid grid is filled with water. (Assume 0 represents water and 1 represents land).
 * 
 * */
public class numberOfIslandsII {
	class UnionFind{
	    int[] id;
	    int[] size;
	    int count;
	    public UnionFind(int total, int c){
	        count = c;
	        id = new int[total];
	        size = new int[total];
	        for(int i=0;i<total;i++){
	            id[i] = i;
	            size[i] = 1;
	        }
	    }
	    
	    public int find(int i){
	        while(id[i] != i){
	            id[i] = id[id[i]];
	            i = id[i];
	        }
	        return i;
	    }
	    
	    public void union(int x, int y){
	        int p = find(x);
	        int q = find(y);
	        if( p == q)
	            return;
	        if(size[p]<size[q]){
	            id[p] = q;
	            size[q]+= size[p];
	        }else{
	            id[q] = p;
	            size[p]+= size[q];
	        }
	        count--;
	    }
	}
	
public List<Integer> numIslands2(int m, int n, int[][] positions) {
        
		int[][] grid = new int[m][n];
        List<Integer> res = new ArrayList<Integer>();
        UnionFind uf = new UnionFind(m*n, 0);
        int[][] dirs = {{-1,0},{1,0},{0,-1},{0,1}};
        for(int[] pos : positions){
        	grid[pos[0]][pos[1]] = 1;
        	uf.count++;
            for(int[] dir : dirs){
                int x = pos[0]+ dir[0];
                int y = pos[1]+ dir[1];
                if(x<0 || x>=m || y<0 || y>=n || grid[x][y] == 0)
                    continue;
                uf.union(pos[0]*n+pos[1], x*n+y);
                //count--;
                //break;
            }
            res.add(uf.count);
        }
        return res;
    }
	
	public static void main(String[] args) {
		int[][] positions = {{0,0}, {0,1}, {1,2}, {2,1}};
		numberOfIslandsII s = new numberOfIslandsII();
		List<Integer> res = s.numIslands2(3, 3, positions);
		for(int i:res)
			System.out.print(i+" ");
	}
}
















