package algorithm_java;

import java.util.HashMap;
import java.util.Map;

//Palantir Facebook

//reference: https://segmentfault.com/a/1190000005771068
//we use a hashmap, key is prefix sum and value is the last index where  sum of numbers from index 0 to index val equals key.
//hashmap helps us achieve O(n) time complexity.

//similar question
//SubarraySumEqualsK
//Continuous Subarray Sum

public class MaximumSizeSubarraySumEqualsk {
	public static int maxSubArrayLen(int[] nums, int k) {
		Map<Integer, Integer> preSum = new HashMap<Integer, Integer>();
        preSum.put(0,-1);
        int sum = 0;
        int maxLen =0;
        for(int i=0;i<nums.length;i++){
            sum += nums[i];
            //prev + k =sum
            int prev =  sum-k;
            if(preSum.containsKey(prev)){
            	//如果当前坐标是j, prevSum的坐标是k, 那么现在的和sum-prev的范围是k+1~j,所以这里不用再加1
                maxLen = Math.max(maxLen, i-preSum.get(prev));
            }
            if(!preSum.containsKey(sum)){
                preSum.put(sum,i);
            }
        }
        return maxLen;
    }
	
	public static void main(String[] args) {
		int[] nums = {2, 1,-1,5,-2,3}; 
		//int[] nums = {-2,-1,2,1}; //1
		int res = maxSubArrayLen( nums, 3);
		System.out.println( res );
	}
}
