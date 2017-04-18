package algorithm_java;



/*
 *              5
 *           /      \
 *          4       8
 *         /       /    \
 *       11     13    4
 *      /    \             \
 *     7     2            1 
 * */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Stack;

public class Test {
	public static int lengthOfLIS(int[] nums) {
        if(nums.length==0)
            return 0;
        int len = nums.length;
        int[] tails = new int[len];
        tails[0] = nums[0];
        int i=0;
        for(int j=1;j<len;j++){
            if(nums[j]<tails[0])
                tails[0] = nums[j];
            else if(nums[j]>=tails[i])
                tails[++i] = nums[j];
            else{
                int pos = binarySearch(nums, 0, i, nums[j]);
                tails[pos] = nums[j];
            }
        }
        for(int k: tails)
        	System.out.print(k+" ");
        System.out.println();
        return i+1;
    }
    
    public static int binarySearch(int[] nums, int l, int r, int target){
        while(l<r){
            int m = l+ (r-l)/2;
            if(nums[m]<target){
                l = m + 1;
            }else
                r = m ;
        }
        return r;
    }
	
	public static void main(String[] args) {
		int[] input = {1,3,6,7,9,4,10,5,6};
		//int[] input = {11,12,13,14,15,6,7,8,101,18};
		//int[] input ={3,5,6,2,5,4,19,5,6,7,12};
		int res = lengthOfLIS(input);
		System.out.println(res);
	}
}