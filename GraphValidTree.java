package algorithm_java;

//Google Facebook Zenefits

/*
 * Given n nodes labeled from 0 to n - 1 and a list of undirected edges (each edge is a pair of nodes), 
 * write a function to check whether these edges make up a valid tree.
 * For example:
 * Given n = 5 and edges = [[0, 1], [0, 2], [0, 3], [1, 4]], return true.
 * Given n = 5 and edges = [[0, 1], [1, 2], [2, 3], [1, 3], [1, 4]], return false.
 * Hint:
 * Given n = 5 and edges = [[0, 1], [1, 2], [3, 4]], what should your return? Is this case a valid tree?
 * According to the definition of tree on Wikipedia: “a tree is an undirected graph in which any two vertices are connected by exactly one path.
 *  In other words, any connected graph without simple cycles is a tree.”
 * Note: you can assume that no duplicate edges will appear in edges. 
 * Since all edges are undirected, [0, 1] is the same as [1, 0] and thus will not appear together in edges.
 * 
 * */

//similar question
//
public class GraphValidTree {
	class UnionFind{
        int[] id;
        int[] size;
        int count;
        public UnionFind(int n){
            count = n;
            id = new int[n];
            size = new int[n];
            for(int i=0;i<n;i++){
                id[i] = i;
                size[i] = 1;
            }
        }
        
        public int find(int i){
            while(id[i]!=i){
                id[i] = id[id[i]];
                i = id[i];
            }
            return i;
        }
        
        public boolean union(int i, int j){
            int p = find(i);
            int q = find(j);
            if(p==q)
                return false;
            if(size[p]<size[q]){
                id[p] = q;
                size[q]+=size[p];
            }else{
                id[q] = p;
                size[p]+=size[q];
            }
            count--;
            return true;
        }
    }
	
	public boolean validTree(int n, int[][] edges) {
        UnionFind uf = new UnionFind(n);
        for(int[] edge: edges){
            if(!uf.union(edge[0], edge[1]))
                return false;
        }
        return uf.count == 1;
    }
    
    public static void main(String[] args) {
    	GraphValidTree  gt = new GraphValidTree ();
    	int[][] edges = {{0,1},{0,2},{1,2},{2,3},{2,4}};
    	boolean res = gt.validTree(5, edges);
    	System.out.println(res);
	}
}
