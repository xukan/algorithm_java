package algorithm_java;

import java.util.ArrayList;
import java.util.List;

public class MajorityElementII {
	public List<Integer> majorityElement(int[] nums) {
        List<Integer> res = new ArrayList<Integer>();
        if(nums==null || nums.length==0)
            return res;
        int max_can1=0;
        int max_can2=0;
        int count1=1;
        int count2=0;
        for(int i=1;i<nums.length;i++){
        	if(count1==0 && nums[i]!= nums[max_can2]){
                max_can1=i;
            }else if( count2==0){
                max_can2 =i;
            }
            if(nums[i] ==  nums[max_can1])
                count1++;
            else if(nums[i] == nums[max_can2])
                count2++;
            else{
                count1--;
                count2--;
            }
        }
        find(nums, nums[max_can1], nums[max_can2], res);

        return res;
    }
    
    public void find(int[] nums, int candidate1, int candidate2, List<Integer> res){
        int count1=0, count2=0;
        for(int i=0;i<nums.length;i++){
            if(nums[i] == candidate1){
                count1++;
            }else if(nums[i] == candidate2 ){
                count2++;
            }
        }
        if(count1>nums.length/3)
            res.add(candidate1);
        if(count2>nums.length/3 && candidate2 != candidate1){
            res.add(candidate2);
        }
    }
    
    public static void main(String[] args) {
		//int[] nums = {0,3,4,0};
		int[] nums= {1,2,2,3,2,1,1,3};
		MajorityElementII s = new MajorityElementII();
		List<Integer> res = s.majorityElement(nums);
		for(int i: res)
			System.out.print( i + " " );
	}
}
