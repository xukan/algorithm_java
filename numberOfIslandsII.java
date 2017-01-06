package algorithm_java;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
 * Union and find
 *  public int find(int p, int q){
        while( id[p] != p ){
            id[p] = id[id[p]]; //path compression
            p = id[p];
        }
        return p;
    }
    
    public void union(int p, int q){
        int pRoot = find(p);
        int qRoot = find(q);
        if( pRoot == qRoot )
            return;
        if( size[pRoot] < size[qRoot ] ){
            id[pRoot] = qRoot;
            size[qRoot] += size[pRoot];
        }else{
            id[qRoot] = pRoot;
            size[pRoot] += size[qRoot];
        }
        count--;
    }
 * 
 * */

//reference: https://segmentfault.com/a/1190000004197552

public class numberOfIslandsII {
	public List<Integer> numIslands2(int m, int n, int[][] positions) {
		List<Integer> res = new ArrayList<Integer>();
		int[] id = new int[m*n]; //serialization
		Arrays.fill(id, -1);
		int count =0;
		int[][] dirs = {{-1,0},{1,0},{0,-1},{0,1}}; // neighbors
		for(int i=0;i<positions.length;i++){
			count++;
			int index = positions[i][0]*n+positions[i][1];
			id[index]=index;  //initialization
			
			for(int j=0;j<dirs.length;j++){
				int x = positions[i][0]+dirs[j][0];
				int y = positions[i][1]+dirs[j][1];
				if(x>=0&&x<m && y>=0&&y<n&&id[x*n+y]!=-1){
					int root = getRoot(id, x*n+y);
					if(root!=index){
						id[root] = index;
						count--;
					}
				}
			}
			res.add(count);
		}
		return res;
	}
	
	public int getRoot(int[] id, int pos){
		while(id[pos]!=pos){
			id[pos]= id[id[pos]]; //path compression
			pos=id[pos];
		}
		return pos;
	}
	
	public static void main(String[] args) {
		int[][] positions = {{0,0}, {0,1}, {1,2}, {2,1}};
		numberOfIslandsII s = new numberOfIslandsII();
		List<Integer> res = s.numIslands2(3, 3, positions);
		for(int i:res)
			System.out.print(i+" ");
	}
}
















