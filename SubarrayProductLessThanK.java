package algorithm_java;

public class SubarrayProductLessThanK {
	public static int numSubarrayProductLessThanK(int[] nums, int k) {
		if(nums.length == 0 || k<2)// input array contains only positive integers
            return 0;
        int res = 0;
        int start = 0, product = 1;
        for(int j=0;j<nums.length;j++){
            product *= nums[j];
            while(product >= k)
                product /= nums[start++];
            res += j - start + 1;
        }
        return res;
    }
	
	public static void main(String[] args) {
//		int[] nums = {10,9,10,4,3,8,3,3,6,2,10,10,9,3};
//		int k = 19;
		
		int[] nums = {10,5,2,6};
		int k = 100;
		int res = numSubarrayProductLessThanK(nums, k);
		System.out.println(res);
	}
}
