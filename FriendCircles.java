package algorithm_java;

import java.util.Arrays;

//similar
//UnionFind, MST

//Two Sigma

/*
 *  friend circle is a group of students who are direct or indirect friends.
 *  we can use union and find to find friend circles.
 *  
 * */

public class FriendCircles {
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
        
        //path compression helps decrease depth of tree
        public int find(int i){
            while(id[i]!=i){
                id[i] = id[id[i]];
                i = id[i];
            }
            return i;
        }
        
        //weighted quick-union helps avoid tall trees by linking smaller tree below large one.
        public void union(int a, int b){
            int p = find(a);
            int q = find(b);
            if(p == q)
                return;
            if(size[p] < size[q]){
                id[p] = q;
                size[q] += size[p];
            }else{
                id[q] = p;
                size[p] += size[q]; 
            }
            count--;
        }
    }
	
	public int findCircleNum(int[][] M) {
        int n = M.length;
        UnionFind uf = new UnionFind(n);
        for(int i=1;i<n;i++){
            for(int j=0;j<i;j++){
                if(M[i][j] == 1){
                    uf.union(i, j);
                }
            }
        }
        return uf.count;
    }
    
    public static void main(String[] args) {
    	FriendCircles f = new FriendCircles();
		//int[][] M = {{1,1,0},{1,1,0},{0,0,1}};
		int[][] M = {{1,0,0,1},{0,1,1,0},{0,1,1,1},{1,0,1,1}};
		int res = f.findCircleNum(M);
		
		int n = M.length;
//		for (int i = 0; i <  n- 1; i++) {
//            for (int j = i + 1; j < n; j++) {
//                System.out.print(M[i][j]+" ");
//            }
//            System.out.println();
//        }
		System.out.println(res);
	}
}
