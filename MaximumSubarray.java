package algorithm_java;

//https://www.youtube.com/watch?v=yCQN096CwWM

//LinkedIn Bloomberg Microsoft 

public class MaximumSubarray {
	//Kadane's algorithm
	public static int maxSubArray(int[] nums) {
        int maxLocal = nums[0];
        int global = nums[0];
        for(int i=1;i<nums.length;i++){
            maxLocal = Math.max(nums[i], nums[i]+maxLocal);
            global = Math.max(global, maxLocal);
        }
        return global;
    }
	
	public static void main(String[] args) {
		int[] nums= {-2,1,-3,4,-1,2,1,-5,4};
		int res = maxSubArray(nums);
		System.out.println(res);
	}
}
