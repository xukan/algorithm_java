package algorithm_java;

import java.util.HashSet;
import java.util.Set;

//Alibaba 

public class SplitArraywithEqualSum {
	public static boolean splitArray(int[] nums) {
        if (nums.length < 7)
            return false;
        int[] sum = new int[nums.length];
        sum[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            sum[i] = sum[i - 1] + nums[i];
        }
        for (int j = 3; j < nums.length - 3; j++) {
            Set < Integer > set = new HashSet <Integer> ();
            for (int i = 1; i < j - 1; i++) {
                if (sum[i - 1] == sum[j - 1] - sum[i])
                    set.add(sum[i - 1]);
            }
            for (int k = j + 2; k < nums.length - 1; k++) {
                if (sum[nums.length - 1] - sum[k] == sum[k - 1] - sum[j] && set.contains(sum[k - 1] - sum[j]))
                    return true;
            }
        }
        return false;
    }
	
	public static void main(String[] args) {
		int[] nums = {3,2,3,5,2,-3,8,7,4,1};
		boolean res = splitArray(nums);
		System.out.println(res);
	}
}
