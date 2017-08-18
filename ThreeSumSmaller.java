package algorithm_java;

import java.util.Arrays;

//Google 

public class ThreeSumSmaller {
	//tc: O(n^2)
	public static int threeSumSmaller(int[] nums, int target) {
        if(nums.length<=2)
            return 0;
        Arrays.sort(nums);
        int count = 0;
        int len = nums.length;
        for(int i=0;i<len-2;i++){
            int l = i+1, r= len-1;
            while(l<r){
                if(nums[i] + nums[l] + nums[r]<target){
                    count += r-l;
                    l++;
                }else
                    r--;
            }
        }
        return count;
    }
	
	public static void main(String[] args) {
		int[] nums = {-2,0,1,3};
		int res = threeSumSmaller(nums, 2);
		System.out.println(res);
	}
}
