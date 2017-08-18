package algorithm_java;

public class SingleNumber {
	public int singleNumberII( int[] nums ){
		int res = 0;
		for(int i=0;i<32;i++){
			int sum =0;
			for(int j=0;j<nums.length;j++){
				if( ( ( nums[j] >>i)  & 1 ) == 1 ){
					sum++;
				}
			}
			sum %= 3;
			if( sum != 0)
				res= ( 1 << i );
		}
		return res;
	}
	
	//负数的表示是正数的补码(反码加1)
	public int[] singleNumberIII( int[] nums ){
		int xor = 0; // xor stores result of a^b, a and b are elements appearing only once in the array
		for( int i : nums)
			xor ^= i;
		int[] res =new int[2];
		//get rightmost 1 
		xor &= (-xor);
		for( int i: nums){
			//divide given array into two subarrays based on rightmost 1, in this ways, each subarray contains only 1 element appearing once.
			if( ( i & xor ) ==0 )
				res[0] ^= i;
			else
				res[1]^= i;
		}
		return res;
	}
	
	//http://www.1point3acres.com/bbs/thread-282105-1-1.html
	//Q2: 问题升级：在Q1基础上面，如果所有出现两次的数都挨着，比如3，3，2，2，4，5，5. 如何降低时间复杂度？ 用二分。.
	public int singleNonDuplicate(int[] nums) {
        int left = 0;
        int right = nums.length - 1;
        int len = right;
        if (right == 1) {
            return nums[0];
        } 
        while (left <= right) {
            int middle = (left + right) >>>1;
            // update middle.
            if (middle > 0 && nums[middle] == nums[middle - 1]) {
                
            } else if (middle < len && nums[middle] == nums[middle + 1]) {
                middle++;
            } else {
                return nums[middle];
            }
            if ((len - middle) %2 == 0) {
                right = middle-1;
            } else {
                left = middle + 1;
            }
        }
        return -1;
    }
	
	public static void main(String[] args) {
		int[] nums1 = { 3, 3, 2, 3};
		int[] nums2 = { 1, 2, 1, 3, 2, 5};
		SingleNumber solution = new SingleNumber();
		int res1= solution.singleNumberII(nums1);
		int[] res2 = solution.singleNumberIII(nums2);
		System.out.println( res1 );
		for( int i: res2 )
			System.out.print( i + " ");
	}
}
