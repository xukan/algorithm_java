package algorithm_java;

import java.util.Comparator;
import java.util.PriorityQueue;

//Google Twitter 

public class KthSmallestElementinaSortedMatrix {
	class Pair{
        int x;
        int y;
        int val;
        public Pair(int x, int y, int val){
            this.x = x;
            this.y = y;
            this.val = val;
        }
    }
    public int kthSmallest(int[][] matrix, int k) {
        int m = matrix.length, n = matrix[0].length;
         PriorityQueue<Pair> queue = new PriorityQueue<Pair>(new Comparator<Pair>(){
            public int compare(Pair p1, Pair p2){
                return Integer.compare(p1.val, p2.val);
            }
        });
        for(int j=0;j<n;j++)
            queue.offer(new Pair(0, j, matrix[0][j]));
        int res = -1;
        for(int i=0;i<m*n;i++){
            if(i==k-1){
                res = queue.poll().val;
                break;
            }
            Pair p = queue.poll();
            if(p.x==m-1)
                continue;
            queue.offer(new Pair(p.x+1, p.y, matrix[p.x+1][p.y]));
        }
        return res;
    }
	
	public static void main(String[] args) {
		KthSmallestElementinaSortedMatrix s = new KthSmallestElementinaSortedMatrix();
		int[][] matrix = {
				{1,  5,  9},
			    {10, 11, 13},
			    {12, 13, 15}
		};
		int res = s.kthSmallest(matrix, 8);
		System.out.println(res);
	}
}
