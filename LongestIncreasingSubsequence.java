package algorithm_java;

import java.util.ArrayList;
import java.util.Arrays;

//Microsoft

public class LongestIncreasingSubsequence {
	// solution1: dp
	// tc: O(N^2) sc: O(N)
	public static int longestIncreasingSubsequence(int[] nums) {
		if (nums == null || nums.length == 0)
			return 0;

		int[] max = new int[nums.length];
		Arrays.fill(max, 1);
		int result = 1;
		for (int i = 0; i < nums.length; i++) {
			for (int j = 0; j < i; j++) {
				if (nums[i] > nums[j]) {
					max[i] = Math.max(max[i], max[j] + 1);
				}
			}
			result = Math.max(max[i], result);
		}
		return result;
	}

	// solution2: binary search
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
		return list.size();
	}

	public static void main(String[] args) {
		int[] input = { 10, 9, 2, 5, 3, 7, 101, 18 };
		// int[] input = {11,12,13,14,15,6,7,8,101,18};
		// int[] input ={3,5,6,2,5,4,19,5,6,7,12};
		int res = longestIncreasingSubsequence(input);
		System.out.println(res);
	}
}
