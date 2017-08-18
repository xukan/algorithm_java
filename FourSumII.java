package algorithm_java;

import java.util.HashMap;

//tc: O(n^2)

public class FourSumII {
	public static int fourSumCount(int[] A, int[] B, int[] C, int[] D) {
		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        for(int a: A){
            for(int b: B){
                int sum = a+b;
                map.put(sum, map.getOrDefault(sum,0)+1);
            }
        }
        
        int res = 0;
        for(int c : C){
            for(int d: D){
                int sum = c+d;
                res+=map.getOrDefault(-sum, 0);
            }
        }
        return res;
    }
	
	public static void main(String[] args) {
		int[] A={1, 2};
		int[] B={-2,-1}; 
		int[] C={-1,2}; 
		int[] D={0, 2};
		int res = fourSumCount(A,B,C,D);
		System.out.println(res);
	}
}
