package algorithm_java;
//Google

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//algorightm
//http://blog.csdn.net/linhuanmars/article/details/20434115
//http://www.programcreek.com/2014/06/leetcode-next-permutation-java/
/*
 * step 1:
 * scan from right to left, find 1st element p that is less than its previous one
 * scan from p+1 to right, find first element that is smaller than p, its previous element q is the last one that is larger than p
 * swap element p and q
 * reverse elements [ p+1, nums.length-1] 
 * */

public class NextPermutation {
	public void nextPermutation(int[] nums) {
		if(nums.length <=1)
			return;
		int i=nums.length-2;
		while(i>=0 && nums[i-1]>=nums[i]){
			i--;
		}
		if(i>=0){
			int j=i+1;
			while( j+1 < nums.length && nums[j] > nums[i])
				j++;
			j--;//j--, need to find last element that is greater than nums[i]
			swap(nums, i, j);
		}
		reverse(nums, i+1);
		for(int k: nums)
			System.out.print(k+" ");
	}
	
	public void swap(int[] nums, int a, int b){
		int temp = nums[a];
		nums[a]=nums[b];
		nums[b]= temp;
	}
	
	public void reverse(int[] nums, int start){
		int end= nums.length-1;
		while(start < end){
			swap(nums, start, end);
			start++;
			end--;
		}
	}

	public static void main(String[] args) {
		int[] nums = { 1,5,1 };
		NextPermutation s = new NextPermutation();
		s.nextPermutation(nums);
	}
}
