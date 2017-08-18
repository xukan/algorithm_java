package algorithm_java;

import java.util.Arrays;

/*
 * Say we have (a1, b1), (a2, b2), ... , (an, bn)
 * ai = min(ai, bi)
 * Sa = a1 + a2 + ...+ an;
 * Sd = (b1-a1) + (b2 - a2) + ... + (bn - an);
 * S = 2Sa + Sd
 * Sa = (S-Sd)/2;
 * since S is constant for the given input array, to get minimal Sa, we need to minimize Sd,
 * So this problem becomes finding pairs in an array that makes sum of di (distance between ai and bi) as small as possible. 
 * Apparently, sum of these distances of adjacent elements is the smallest. 
 * */


public class ArrayPartitionI {
	public static int arrayPairSum(int[] nums) {
        int res = 0;
        Arrays.sort(nums);
        for(int i=0;i<nums.length;i+=2)
            res+=nums[i];
        return res;
    }
	
	public static void main(String[] args) {
		int[] nums = {1,4,3,2};
		int res = arrayPairSum(nums);
		System.out.println(res);
	}
}
