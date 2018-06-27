package algorithm_java;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//O(n^3) tc, O(1) extra sc

public class FourSum {
	public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        if(nums.length <= 3)
            return res;
        Arrays.sort(nums);
        if(4*nums[0]>target || 4*nums[nums.length-1]<target)
            return res;
        for(int i=0;i+3<nums.length;i++){
            if(i>0 && nums[i] == nums[i-1])
                continue;
            threeSum(nums, i+1, target-nums[i], nums[i], res);
        }
        return res;
    }
    
    public void threeSum(int[] nums, int start, int target, int a, List<List<Integer>> res){
        if(3*nums[start]>target || 3*nums[nums.length-1]<target)
            return;
        for(int i=start;i+2<nums.length;i++){
            if(i>start && nums[i] == nums[i-1])
                continue;
            twoSum(nums, i+1, target - nums[i], a, nums[i], res);
        }
    }
    
    public void twoSum(int[] nums, int start, int target, int a, int b, List<List<Integer>> res){
        if(2*nums[0]>target || 2*nums[nums.length-1] < target)
            return;
        int l = start, r = nums.length-1;
        List<Integer> list = new ArrayList<Integer>();
        while(l<r){
            if(nums[l] + nums[r] == target){
                list.clear();
                list.add(a);
                list.add(b);
                list.add(nums[l]);
                list.add(nums[r]);
                res.add(new ArrayList<Integer>(list));
                l++;
                r--;
                while(l<r && nums[l] == nums[l-1])
                    l++;
                while(l<r && nums[r] == nums[r+1])
                    r--;
            }else if(nums[l] + nums[r] < target)
                l++;
            else
                r--;
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
