package algorithm_java;

import java.util.Arrays;

//Bloomberg 

public class ThreeSumClosest {
	int min = Integer.MAX_VALUE;
    public int threeSumClosest(int[] nums, int target) {
        if(nums.length <= 2)
            return 0;
        Arrays.sort(nums);
        for(int i=0;i<nums.length-2;i++)
            helper(nums, i+1, nums[i], target);
        return target-min;
    }
    
    public void helper(int[] nums, int index, int cur, int target){
        int l = index, r = nums.length-1;
        int sum = 0;
        while(l<r){
            sum = cur + nums[l] + nums[r];
            int diff = target - sum;
            if(Math.abs(diff) < Math.abs(min))
                min = diff;
            if(sum < target)
                l++;
            else
                r--;
        }
    }
    
    public static void main(String[] args) {
    	ThreeSumClosest s = new ThreeSumClosest();
		int[] nums = {-1, 2, 1, -4};
		int target = 1;
		int res = s.threeSumClosest(nums, target);
		System.out.println(res);
	}
}
