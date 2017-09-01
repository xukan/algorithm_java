package algorithm_java;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;
/*
 * we can convert the two input arrays to a matrix
 *          2   4   6
 *         - - - - - - -  
 *     1 | 3   5   7      
 *     7 | 9  11  13
 *   11 |13  15  17
 * */

//Google Uber 

//similar question
//Kth Smallest Element in a Sorted Matrix

//tc: mkO(logk), m = num1.length

public class FindKPairswithSmallestSums {
	class Pair{
        int x;
        int y;
        int val;
        public Pair(int a, int b, int v){
            this.x = a;
            this.y = b;
            this.val = v;
        }
    }
    
    public List<int[]> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        List<int[]> res = new ArrayList<int[]>();
        if(nums1 == null || nums2 == null || nums1.length == 0 || nums2.length == 0 || k<=0)
            return res;
        PriorityQueue<Pair> queue = new PriorityQueue<Pair>(k, new Comparator<Pair>(){
            public int compare(Pair p1, Pair p2){
                return Integer.compare(p1.val, p2.val);
            }
        });
        int m = nums1.length, n=nums2.length;
        for(int j=0;j<n;j++){
            queue.offer(new Pair(0, j, nums1[0]+nums2[j]));
        }
        for(int i=0;i<k&&i<m*n;i++){
            Pair p = queue.poll();
            res.add(new int[]{nums1[p.x], nums2[p.y]});
            if(p.x<m-1)
                queue.offer(new Pair(p.x+1, p.y, nums1[p.x+1]+nums2[p.y]));
        }
        return res;
    }
	
	public static void main(String[] args) {
		FindKPairswithSmallestSums s = new FindKPairswithSmallestSums();
		int[] nums1 = {1,7,11};
		int[] nums2 =  {2,4,6};
		int k = 3;
		List<int[]> list = s.kSmallestPairs(nums1, nums2, k);
		for(int[] array: list){
			System.out.println(array[0] + " "+ array[1]);
		}
	}
}
