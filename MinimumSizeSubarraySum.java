package algorithm_java;

//Facebook

//also do : (M) Maximum Size Subarray Sum Equals k

public class MinimumSizeSubarraySum {
	public static int minSubArrayLen(int s, int[] nums) {		
		//solution 1
		//two pointers, 
		//tc: O(n)
		//sc: O(1)
		//注意这道题与Maximum Size Subarray Sum Equals k的区别，这道题输入数组都是正数，而Maximum Size Subarray Sum Equals k的input有正有负，
		//所以这道题可以用two pointers来解
		if(nums == null || nums.length ==0)
			return 0;
		int i=0, sum=0, min=Integer.MAX_VALUE;
		for(int j=0;j<nums.length;j++){
			sum += nums[j];
			while(sum>=s){
				min = Math.min(min, j+1-i);
				sum -= nums[i++];
			}
		}
		return min==Integer.MAX_VALUE?0:min;
    }
	
	//binary search solution 
	//tc: O(nlogn)
	//sc: O(n)
	//reference:
	//
	//https://discuss.leetcode.com/topic/26814/o-n-o-nlogn-solutions-both-o-1-space/2
	//http://shaowei-su.github.io/2015/11/18/leetcode209/
	public int minSubArrayLenII(int s, int[] nums) {
        if (null == nums || nums.length == 0) {
            return 0;
        }
        int min = nums.length + 1;
        int[] sum = new int[nums.length + 1];
        for (int i = 0; i < nums.length; i++) {
            sum[i + 1] = sum[i] + nums[i];
            if (sum[i + 1] >= s) {
                int left = binarySearch(sum, sum[i + 1] - s, 0, i + 1);
                min = Math.min(min, i + 1 - left);
            }
        }
        return min == nums.length + 1 ? 0 : min;
    }

    public int binarySearch(int[] nums, int target, int start, int end) {
        while (start + 1 < end) {
            int mid = start + (end - start) / 2;
            if (nums[mid] >= target) {
                end = mid;
            } else {
                start = mid;
            }
        }
        if (nums[end] <= target) {
            return end;
        } else {
            return start;
        }
    }
	
	public static void main(String[] args) {
//		int[] input = {1,1};
		int[] input = {2,3,1,2,4,3};
		int res = minSubArrayLen(7, input);
		System.out.println(res);
		
	}
}
