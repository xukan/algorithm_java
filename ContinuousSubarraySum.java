package algorithm_java;

import java.util.HashMap;

//reference: https://discuss.leetcode.com/topic/80793/java-o-n-time-o-k-space/38

/*
 * The solution is based on reminder theorem
 * (x + k*n)%n == x%n
 * (a+(n*x))%x is same as (a%x)
 * For e.g. in case of the array [23,2,6,4,7] k=6,the running sum is [23,25,31,35,42] and the reminders are [5,1,1,5,0]. 
 * We got reminder 5 at index 0 and at index 3. That means, in between these two indexes we must have added a number 
 * which is multiple of the k. Hope this clarifies your doubt :)
 * */

//similar question
//Maximum Size Subarray Sum Equals k

//Time complexity : O(n). Only one traversal of the array nums is done.
//Space complexity : O(min(n,k)). The HashMap can contain upto min(n,k) different pairings.

public class ContinuousSubarraySum {
	public static boolean checkSubarraySum(int[] nums, int k) {
		int sum = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);
        for (int i = 0; i < nums.length; i++){
            sum += nums[i];
            if (k != 0)
                sum = sum % k;
            if (map.containsKey(sum)) {
                if (i - map.get(sum) > 1)
                    return true;
            }else
                map.put(sum, i);
        }
        return false;
    }
	
	public static void main(String[] args) {
//		int[] nums = {23, 2, 4, 6, 7};
//		int[] nums= {0,1, 0}; // k=0, to test sentence:  map.put(0,-1);
		int[] nums= {0, 0};
		boolean res = checkSubarraySum(nums, 0);
		System.out.println(res);
	}
}
