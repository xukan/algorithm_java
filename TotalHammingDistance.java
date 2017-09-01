package algorithm_java;

//Facebook 

//https://discuss.leetcode.com/topic/72092/java-o-n-time-o-1-space
//tc: O(n)

//since we need to compare any pairs selected from the input array,
//bitCount(number of ones) * (n - bitCount) will give us the number of bits differences for current bit

public class TotalHammingDistance {
	public static int totalHammingDistance(int[] nums) {
	    int total = 0, n = nums.length;
	    for (int j=0;j<32;j++) {
	        int bitCount = 0;
	        for (int i=0;i<n;i++) 
	            bitCount += (nums[i] >> j) & 1;
	        total += bitCount*(n - bitCount);
	    }
	    return total;
	}
	
	public static void main(String[] args) {
		int[] nums = {4, 14, 2};
		int res = totalHammingDistance(nums);
		System.out.println(res);
	}
}
