package algorithm_java;

public class PatchingArray {
	public static int minPatches(int[] nums, int n) {
	    long miss = 1;
	    int count = 0;
	    int i = 0;
	 
	    while(miss <= n){
	        if(i<nums.length && nums[i] <= miss){
	            miss = miss + nums[i];
	            //add miss
	            System.out.println("miss: "+miss);
	            i++;
	        }else{
	            miss += miss;
	            count++;
	        }
	    }
	 
	    return count;
	}
	
	public static void main(String[] args) {
		int[] nums = {1,4,10};
		int n = 50;
		int res = minPatches(nums, n);
		System.out.println(res);
	}
}
