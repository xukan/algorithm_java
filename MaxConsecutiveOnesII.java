package algorithm_java;

import java.util.LinkedList;

//http://www.cnblogs.com/grandyang/p/6376115.html

//Google

public class MaxConsecutiveOnesII {
	//this is an naive solution, it is not good to solve problems when we can flip k(k>=1) zeros
	public static int findMaxConsecutiveOnes(int[] nums) {
        int res = 0, cur = 0, cnt = 0;
        for (int num : nums) {
            ++cnt;
            if (num == 0) {
                cur = cnt;
                cnt = 0;
            } 
            res = Math.max(res, cnt + cur);
        }
        return res;
    }
	
	//universal solution when k 
	public static int findMaxConsecutiveOnes(int[] nums, int k) {
		int res = 0, zero = 0, left = 0 ;
	    for (int right = 0; right < nums.length; ++right) {
	        if (nums[right] == 0) ++zero;
	        while (zero > k) {
	            if (nums[left++] == 0) --zero;
	        }
	        int size = right - left + 1;
	        res = Math.max(res, size);
	    }
	    return res;
	}
	
	//follow up, deal with data stream
	public static int findMaxConsecutiveOnesStream(int[] nums, int k) {
		int res = 0, left = 0;
	    LinkedList<Integer> q = new LinkedList();
	    for (int right = 0; right < nums.length; ++right) {
	        if (nums[right] == 0) q.offer(right);
	        if (q.size() > k) {
	            left = q.poll() + 1;
	        }
	        res = Math.max(res, right - left + 1);
	    }
	    return res;
	}
	
	public static void main(String[] args) {
		int count = 0;
		int[] nums = {0,0,1,0,1,1,0};
		count = findMaxConsecutiveOnes(nums);
		System.out.println(count);
		count = findMaxConsecutiveOnes(nums, 1);
		System.out.println(count);
		count = findMaxConsecutiveOnesStream(nums, 1);
		System.out.println(count);
	}

}
