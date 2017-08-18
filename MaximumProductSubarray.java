package algorithm_java;

//LinkedIn, Yelp

public class MaximumProductSubarray {
	public static int maxProduct(int[] nums) {
        int max=nums[0], min = nums[0], local = nums[0];
        for(int i=1;i<nums.length;i++){
            local = Math.max(nums[i], local*nums[i]);
            int prevMax = max;
            max = Math.max(max, Math.max(local, min*nums[i]));
            min = Math.min(min, Math.min(local, prevMax*nums[i]));
        }
        return max;
    }
	
	public static void main(String[] args) {
		//int[] nums ={-4,-3,-2};
		//int[] nums  = {0,2};
		int[] nums ={-2,0,-1};
		int res = maxProduct(nums);
		System.out.println(res);
	}
}
