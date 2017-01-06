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
