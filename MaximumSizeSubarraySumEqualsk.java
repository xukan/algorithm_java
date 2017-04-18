package algorithm_java;

import java.util.HashMap;

//Palantir Facebook

//reference: https://segmentfault.com/a/1190000005771068
//we use a hashmap, key is prefix sum and value is the last index where  sum of numbers from index 0 to index val equals key.
//hashmap helps us achieve O(n) time complexity.


public class MaximumSizeSubarraySumEqualsk {
	public static int maxSubArrayLen(int[] nums, int k) {
		int sum=0;
        int max = 0;
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        map.put(0,-1);
        for(int i=0;i<nums.length;i++){
            sum += nums[i];
            int target = sum - k;
            if(map.containsKey(target)){
                max = Math.max(max, i-map.get(target));
            }
            if(!map.containsKey(sum))
                map.put(sum, i);
        }
        return max;
    }
	
	public static void main(String[] args) {
		int[] nums = {2, 1,-1,5,-2,3}; 
		//int[] nums = {-2,-1,2,1}; //1
		int res = maxSubArrayLen( nums, 3);
		System.out.println( res );
	}
}
