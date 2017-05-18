package algorithm_java;

import java.util.Arrays;

public class WiggleSort {
	public static void wiggleSort(int[] nums) {
        
		//II
		Arrays.sort(nums);
        int len = nums.length;
        int[] temp = new int[len];
        int s = len%2==0?len/2-1:len/2;
        int t=len-1;
        for(int i=0;i<len;i++){
            temp[i] = (i&1)==0?nums[s--]:nums[t--];
        }
        // int s = (nums.length + 1) >> 1, t = nums.length;

        // for (int i = 0; i < nums.length; i++) {
        //     temp[i] = (i & 1) == 0 ?  nums[--s] : nums[--t] ;
        // }
//        for (int i = 0; i < nums.length; i++)
//            nums[i] = temp[i];
         nums = Arrays.copyOf(temp, len);
    }
	
	public static void main(String[] args) {
		int[] nums = {1,5,1,1,6,4};
		wiggleSort(nums);
		for (int i = 0; i < nums.length; i++)
			System.out.print(nums[i]+" ");
	}
	
}
