package algorithm_java;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FourSum {
	public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        int len = nums.length;
        if (nums == null || len < 4)
			return res;
        Arrays.sort(nums);
        if(nums[0]*4>target || nums[len-1]*4<target)
            return res;
        for(int i=0;i+3<len;i++){
            int z = nums[i];
            if(i>0 && z == nums[i-1])
                continue;
            threeSum(nums, target-z, i+1, len, z, res );
        }
        return res;
    }
    
    public void threeSum(int[] nums, int target, int l, int len, int z, List<List<Integer>> res){
        if(nums[l]*3>target || nums[len-1]*3<target)
            return;
        int z1; 
        for(int i=l;i+2<len;i++){
            z1 = nums[i];
            if(i>l && nums[i-1] == z1)
                continue;
            twoSum(nums, target-z1, i+1, len-1, z, z1, res );
        }
    }
    
    public void twoSum(int[] nums, int target, int l, int len, int z, int z1, List<List<Integer>> res){
        if(nums[l]*2>target || nums[len]*2<target)
            return;
        int sum;
        int r = len;
        while(l<r){
            sum = nums[l]+nums[r];
            if(sum == target){
                res.add(Arrays.asList(z,z1,nums[l],nums[r]));
                int x = nums[l];
                while(l<r && nums[l]==x)
                    l++;
                x=nums[r];
                while(l<r && nums[r] ==x)
                    r--;
            }
            if(sum > target)
                r--;
            if(sum < target)
                l++;
        }
    }
	
	public static void main(String[] args) {
		FourSum s = new FourSum();
		int[] nums = {-1,0,-5,-2,-2,-4,0,1,-2};
		int target = -9 ;
		List<List<Integer>> res = s.fourSum(nums, target);
		for(List<Integer> list:res){
			for(int i: list){
				System.out.print(i+" ");
			}
			System.out.println();
		}
	}
}
