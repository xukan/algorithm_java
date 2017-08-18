package algorithm_java;

public class TwoSumII {
	public int[] twoSum(int[] nums, int target) {
        int[] res = new int[2];
        if(nums.length <2)
            return res;
        int l = 0, r = nums.length-1;
        while(l < r){
            int val = nums[l] + nums[r];
            if(val == target){
                res[0] = l + 1;
                res[1] = r + 1;
                return res;
            }else if(val < target)
                l++;
            else
                r--;
        }
        return res;
    }
	
	public static void main(String[] args) {
		
	}
}
