package algorithm_java;

import java.util.ArrayList;
import java.util.List;

//Zenefits

//Boyer-Moore Majority Vote Algorithm

public class MajorityElementII {
	//Linear Time Majority Vote Algorithm
	//http://www.programcreek.com/2014/02/leetcode-majority-element-java/
	public int majorityElementI(int[] nums) {
	    int result = 0, count = 0;
	 
	    for(int i = 0; i<nums.length; i++ ) {
	        if(count == 0){
	            result = nums[ i ];
	            count = 1;
	        }else if(result == nums[i]){
	           count++;
	        }else{
	           count--;
	        }
	    }
	 
	    return result;
	}

	public List<Integer> majorityElement(int[] nums) {
        List<Integer> res = new ArrayList<Integer>();
        if(nums.length==0)
            return res;
        int cnt1=1, cnt2=0;
        int num1 = nums[0], num2 = nums[0];
        int len = nums.length;
        for(int i=1;i<len;i++){
        	if(nums[i] == num1)
                cnt1++;
            else if(nums[i] == num2)
                cnt2++;
            else  if(cnt1 == 0){
                num1 = nums[i];
                cnt1 = 1;
            }else if(cnt2==0){
                num2 = nums[i];
                cnt2 = 1;
            }else{
            	//When there are n votes and two majorities in it. Cancel everybody’s vote 1 by 1 is a good way. 
            	//Because two majorities has the confidence to have remaining votes while others die out.
                cnt1--;
                cnt2--;
            }
        }
        cnt1=0;
        cnt2=0;
        for(int i: nums){
            if(i==num1)
                cnt1++;
            if(i==num2)
                cnt2++;
        }
        if(cnt1>len/3)
            res.add(num1);
        if(num2 != num1 && cnt2>len/3)
            res.add(num2);
        return res;
    }
    
    public static void main(String[] args) {
		//int[] nums = {0,3,4,0};
		int[] nums= {8,8,7,7,7};
		MajorityElementII s = new MajorityElementII();
		List<Integer> res = s.majorityElement(nums);
		for(int i: res)
			System.out.print( i + " " );
	}
}
