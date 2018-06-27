package algorithm_java;

import java.util.Arrays;

//Google

public class RedundantConnection {
	
	//II
	//We define two variables (first and second) to store the 2 edges that point to the same node if there is any
	public static int[] findRedundantDirectedConnection(int[][] edges) {
        int n = edges.length;
        int[] parent = new int[n+1], ds = new int[n+1];
        Arrays.fill(parent, -1);
        int first = -1, second = -1, last = -1;
        for(int i = 0; i < n; i++) {
            int p = edges[i][0], c = edges[i][1];
            if (parent[c] != -1) {
                first = parent[c];
                second = i;
                continue;
            }
            parent[c] = i;
            
            int p1 = find(ds, p);
            if (p1 == c) 
            	last = i;
            else 
            	ds[c] = p1;
        }
        if (last == -1) 
        	return edges[second]; // no cycle found by removing second
        if (second == -1) 
        	return edges[last]; // no edge removed
        return edges[first];
    }
    
    private static int find(int[] ds, int i) {
        return ds[i] == 0 ? i : (ds[i] = find(ds, ds[i]));
    }
    
    public static void main(String[] args) {
//    	int[][] edges ={{1,2},{2,3},{3,1},{1,4}};
//    	int[][] edges ={{1,2},{2,3},{3,1},{4,1}};
    	int[][] edges = {{1,2}, {2,3}, {3,4}, {4,1}, {1,5}};
    	int[] res = findRedundantDirectedConnection(edges);
    	System.out.println(res[0] + " " + res[1]);
	}
}
