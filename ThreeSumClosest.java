package algorithm_java;

import java.util.Arrays;

public class ThreeSumClosest {
	int min = Integer.MAX_VALUE;
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        for(int i=0;i<nums.length;i++){
            if( i> 0 && nums[i] == nums[i-1])
                continue;
            int diff = helper(nums, i, target);
            if(Math.abs(diff)<Math.abs(min))
                min = diff;
        }
        return target-min;
    }
    
    public int helper(int[] nums, int i, int target){
        int closest = Integer.MAX_VALUE;
        int l = i+1, r = nums.length-1;
        while(l<r){
            int sum = nums[l] + nums[r] + nums[i];
            int gap = target-sum;
            if(Math.abs(gap)<Math.abs(closest))
                closest = gap;
            if(gap == 0)
                return 0;
            else if(gap>0)
                l++;
            else
                r--;
        }
        return closest;
    }
}
