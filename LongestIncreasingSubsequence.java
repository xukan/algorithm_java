package algorithm_java;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//Microsoft Twitter

public class LongestIncreasingSubsequence {
	// solution1: dp
	// tc: O(N^2) sc: O(N)
	public static int longestIncreasingSubsequence(int[] nums) {
		if (nums == null || nums.length == 0)
			return 0;

		if(nums.length ==0)
            return 0;
        int[] lis = new int[nums.length];
        Arrays.fill(lis,1);
        int maxLen = 1;
        for(int i=1;i<nums.length;i++){
            for(int j=0;j<i;j++){
                if(nums[i]>nums[j])
                    lis[i] = Math.max(lis[i], lis[j]+1);
                    maxLen = Math.max(lis[i], maxLen); 
            }
        }
        return maxLen;
	}

	// solution2: binary search
	//特别注意的是ends数组的值可能不是一个真实的LIS，比如若输入数组nums为{4, 2， 4， 5， 3， 7}，那么算完后的ends数组为{2， 3， 5， 7}，
	//可以发现它不是一个原数组的LIS，只是长度相等而已，千万要注意这点
	//可以参考下面链接文章中的解释,实际上是在维护多个长度不同的子序列
	//http://www.geeksforgeeks.org/longest-monotonically-increasing-subsequence-size-n-log-n/
	// tc: O(NlogN) sc: O(N)
	public static int longestIncreasingSubsequence_bs(int[] nums) {
		if (nums == null || nums.length == 0)
			return 0;
		ArrayList<Integer> list = new ArrayList<Integer>();
		for (int num : nums) {
			if (list.size() == 0 || num > list.get(list.size() - 1)) {
				list.add(num);
			} else {
				int i = 0;
				int j = list.size() - 1;
				while (i < j) {
					int mid = (i + j) / 2;
					if (list.get(mid) < num) {
						i = mid + 1;
					} else {
						j = mid;
					}
				}
				list.set(j, num);
			}
		}
		list.forEach(i->System.out.print(i+ " "));
		return list.size();
	}
	
	public static int lengthOfLIS(int[] nums) {
        List<Integer> dp = new ArrayList<Integer>();
        for (int i = 0; i < nums.length; ++i) {
            int left = 0, right = dp.size();
            while (left < right) {
                int mid = left + (right - left) / 2;
                if (dp.get(mid) < nums[i])
                	left = mid + 1;
                else
                	right = mid;
            }
            if (right >= dp.size())
            	dp.add(nums[i]);
            else
            	dp.set(right, nums[i]);
        }
        return dp.size();
    }

	public static void main(String[] args) {
		//int[] input = { 10, 9, 2, 5, 3, 7, 101, 18 };
		// int[] input = {11,12,13,14,15,6,7,8,101,18};
		// int[] input ={3,5,6,2,5,4,19,5,6,7,12};
		int[] input = {4,2,4,5,3,7};
//		int res = longestIncreasingSubsequence_bs(input);
		int res = lengthOfLIS(input);
		System.out.println(res);
	}
}
