package algorithm_java;

import java.util.HashMap;

//reference: https://discuss.leetcode.com/topic/80793/java-o-n-time-o-k-space/38

/*
 * The solution is based on reminder theorem
 * (x + k*n)%n == x%n
 * (a+(n*x))%x is same as (a%x)
 * For e.g. in case of the array [23,2,6,4,7] the running sum is [23,25,31,35,42] and the reminders are [5,1,1,5,0]. 
 * We got reminder 5 at index 0 and at index 3. That means, in between these two indexes we must have added a number 
 * which is multiple of the k. Hope this clarifies your doubt :)
 * */

public class ContinuousSubarraySum {
	public static boolean checkSubarraySum(int[] nums, int k) {
		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
		//map.put(0,-1);
	    int runningSum = 0;
	    for (int i=0;i<nums.length;i++) {
	        runningSum += nums[i];
	        if (k != 0) runningSum %= k; 
	        Integer prev = map.get(runningSum);
	        if (prev != null) {
	            if (i - prev > 1) return true;
	        }else
	        	map.put(runningSum, i);
	    }
	    return false;
    }
	
	public static void main(String[] args) {
		//int[] nums = {23, 2, 4, 6, 7};
		int[] nums= {0,1,0}; // k=0, to test sentence:  map.put(0,-1);
		boolean res = checkSubarraySum(nums, 0);
		System.out.println(res);
	}
}
