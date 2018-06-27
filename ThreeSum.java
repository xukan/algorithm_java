package algorithm_java;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeSum {
	public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res= new ArrayList<List<Integer>>();
        if(nums.length == 0)
            return res;
        Arrays.sort(nums);
        for(int i=0;i<nums.length-2;i++){
            if(i > 0 && nums[i] == nums[i-1])
                continue;
            helper(nums, nums[i], i+1, res);
        }
        return res;
    }
    
    public void helper(int[] nums, int cur, int index, List<List<Integer>> res){
        int l = index, r = nums.length-1;
        while(l<r){
            if(cur + nums[l] + nums[r] == 0){
                res.add(Arrays.asList(cur, nums[l], nums[r]));
                l++;
                r--;
                while(l< r && nums[l] == nums[l-1])
                    l++;
                while(l< r && nums[r] == nums[r+1])
                    r--;
            }else if(cur + nums[l] + nums[r] < 0){
                l++;
            }else
                r--;
        }
    }
    
    public static void main(String[] args){
    	ThreeSum s = new ThreeSum();
		//int[] input={7,-1,14,-12,-8,7,2,-15,8,8,-8,-14,-4,-5,7,9,11,-4,-15,-6,1,-14,4,3,10,-5,2,1,6,11,2,-2,-5,-7,-6,2,-15,11,-6,8,-4,2,1,-1,4,-6,-15,1,5,-15,10,14,9,-8,-6,4,-6,11,12,-15,7,-1,-9,9,-1,0,-4,-1,-12,-2,14,-9,7,0,-3,-4,1,-2,12,14,-10,0,5,14,-1,14,3,8,10,-8,8,-5,-2,6,-11,12,13,-7,-12,8,6,-13,14,-2,-5,-11,1,3,-6};
		int[] input ={-1, 0, 1, 2, -1, -4};
		List<List<Integer>> res = s.threeSum(input);
		for(List<Integer> l : res){
			for(int i: l)
				System.out.print(i+" ");
			System.out.println();
		}
	}
}
