package algorithm_java;

public class MinimumSizeSubarraySum {
	public static int minSubArrayLen(int s, int[] nums) {
		//my solution
//		if(nums == null || nums.length ==0)
//            return 0;
//        int slow=0, fast=1;
//        int sum=nums[0], count=1, min=nums.length;
//        boolean find = false;
//        while(slow<nums.length){
//            if(sum < s ){
//            	if(fast >=nums.length)
//            		break;
//                sum+=nums[fast];
//                fast++;
//                count++;
//            }else{
//            	find = true;
//                min = Math.min(min, count);
//                slow++;
//                fast = slow+1;
//                if(fast>nums.length-1)
//                	break;
//                sum = nums[slow];
//                count=1;
//            }
//        }
//        if(find)
//        	return min;
//        else
//        	return 0;
		
		
		//better solution
		if(nums == null || nums.length ==0)
			return 0;
		int j=0, sum=0, min=Integer.MAX_VALUE;
		for(int i=0;i<nums.length;i++){
			while(j<nums.length && sum < s){
				sum += nums[j];
				j++;
			}
			if(sum>=s){
				min = Math.min(min, j-i);
			}
			sum -= nums[i];	
		}
		return min==Integer.MAX_VALUE?0:min;
    }
	
	public static void main(String[] args) {
//		int[] input = {1,1};
		int[] input = {2,3,1,2,4,3};
		int res = minSubArrayLen(7, input);
		System.out.println(res);
		
	}
}
