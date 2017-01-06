package algorithm_java;

public class CreateMaximumNumber {
//	public int[] maxNumber(int[] nums1, int[] nums2, int k) {
//        int[] ans = new int[k];
//        for (int i = Math.max(k - nums2.length, 0); i <= Math.min(nums1.length, k); i++) {
//            int[] res1 = get_max_sub_array(nums1, i);
//            int[] res2 = get_max_sub_array(nums2, k - i);
//            int[] res = new int[k];
//            int pos1 = 0, pos2 = 0, tpos = 0;
// 
//            while (pos1 < res1.length || pos2 < res2.length) {
//                res[tpos++] = greater(res1, pos1, res2, pos2) ? res1[pos1++] : res2[pos2++];
//            }
// 
//            if (!greater(ans, 0, res, 0))
//                ans = res;
//        }
//        return ans;
//    }
// 
//    public boolean greater(int[] nums1, int start1, int[] nums2, int start2) {
//        for (; start1 < nums1.length && start2 < nums2.length; start1++, start2++) {
//            if (nums1[start1] > nums2[start2]) return true;
//            if (nums1[start1] < nums2[start2]) return false;
//        }
//        return start1 != nums1.length;
//    }
// 
//    public int[] get_max_sub_array(int[] nums, int k) {
//        int[] res = new int[k];
//        int len = 0;
//        for (int i = 0; i < nums.length; i++) {
//            while (len > 0 && len + nums.length - i > k && res[len - 1] < nums[i]) {
//                len--;
//            }
//            if (len < k)
//                res[len++] = nums[i];
//        }
//        return res;
//    }
	public int[] maxNumber(int[] nums1, int[] nums2, int k) {
        int[] ans = new int[k];
        //for (int i = Math.max(k - nums2.length, 0); i <= Math.min(nums1.length, k); i++) {
        for (int i = 0; i <= Math.min(nums1.length, k); i++) {
            int[] res1 = maxSubArray(nums1, i);
            int[] res2 = maxSubArray(nums2, k - i);
            int[] res = new int[k];
            int pos1 = 0, pos2 = 0, tpos = 0;
 
            while (pos1 < res1.length || pos2 < res2.length) {
                res[tpos++] = greater(res1, pos1, res2, pos2) ? res1[pos1++] : res2[pos2++];
            }
 
//            if (!greater(ans, 0, res, 0))
//                ans = res;
        }
        return ans;
    }
	
	public boolean greater( int[] nums1, int pos1, int[] nums2, int pos2){
		for( ; pos1<nums1.length && pos2<nums2.length; pos1++, pos2++ ){
			if( nums1[pos1] > nums2[pos2])
				return true;
			if( nums1[pos1] < nums2[pos2])
				return false;
		}
		return start1!=
	}
	
	public int[] maxSubArray(int[]nums, int k){
		/*
		 * Easy version is: Given one array of length n, create the maximum number of length k.
		 * Here, We can use a stack to get maximum subarray of a given array.
		 * Initialize a stack
		 * Loop through input array nums
		 *  pop the top of stack if it is smaller than nums[i] until:
		 *  	1. stack is empty
		 *  	2. the digits left is not enough to fill the size k
		 *  if stack size < k push nums[i]
		 * */
		int len = nums.length;
		//we use a stack to get maximum sub-array of a given array
		int[] stack = new int[k];
		//j is the cursor to scan stack 
		int j = 0;
		for( int i=0; i<len; i++){
			while( j > 0 && stack[j-1]<nums[i] && len-i+j >k ){
				j--;
			}
			if( j < k )
				stack[ j++ ] = nums[i];
		}
		return stack;
	}
	
    public static void main(String[] args) {
    	int[] nums1 = {3, 4, 6, 5};
    	int[] nums2 = {9, 1, 2, 5, 8, 3};
    	int k = 5;
    	CreateMaximumNumber solution = new CreateMaximumNumber();
    	int[] result = solution.maxNumber(nums1, nums2, k);
    	for( int i: result){
    		System.out.print( i + " " );
    	}
    	
	}
}
