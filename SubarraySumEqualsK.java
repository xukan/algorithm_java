package algorithm_java;

import java.util.HashMap;

/*
 * we know the key to solve this problem is SUM[i, j]. So if we know SUM[0, i - 1] and SUM[0, j], then we can easily get SUM[i, j]. 
 * To achieve this, we just need to go through the array, calculate the current sum and save number of all seen PreSum to a HashMap. 
 * Time complexity O(n), Space complexity O(n).
 * */

//Google

//similar question
//Maximum Size Subarray Sum Equals k

public class SubarraySumEqualsK {
	public static int subarraySum(int[] nums, int k) {
		HashMap<Integer, Integer> map = new HashMap<>();
		int count = 0;
		int sum = 0;
		for(int num: nums){
			map.put(sum, map.getOrDefault(sum, 0) + 1);
            sum += num;
            count += map.getOrDefault(sum-k, 0);
		}
		return count;
	}
	
	public static void main(String[] args) {
		//int[] nums = {28,54,7,-70,22,65,-6};//k=100
		int[] nums = {1,2,1,3};
		int res = subarraySum(nums, 4);
		System.out.println(res);
	}
}
