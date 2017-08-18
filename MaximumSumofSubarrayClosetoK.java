package algorithm_java;

import java.util.TreeSet;

//similar question
//Maximum Subarray

//http://www.programcreek.com/2016/08/maximum-sum-of-subarray-close-to-k/

//lintcode : Subarray Sum Closest 

public class MaximumSumofSubarrayClosetoK {
	public static int getLargestSumCloseToK(int[] arr, int k){
	    int sum=0;
	    TreeSet<Integer> set = new TreeSet<Integer>();
	    int result=Integer.MIN_VALUE;
	    set.add(0);
	 
	    for(int i=0; i<arr.length; i++){
	        sum=sum+arr[i];
	 
	        Integer ceiling = set.ceiling(sum-k);
	        if(ceiling!=null){
	            result = Math.max(result, sum-ceiling);  
	            System.out.print(result + " ");
	        }
	 
	        set.add(sum);
	    }
	    System.out.println();
	 
	    return result;
	}
	
	public static void main(String[] args) {
		int[] nums= {-3, 0, 1, -4, 7, 1};
		int res = getLargestSumCloseToK(nums, 2);
		System.out.println(res);
	}
}
