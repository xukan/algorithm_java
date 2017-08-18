package algorithm_java;

//Microsoft Bloomberg Facebook

//two pointers, like move zeros
//follow up: remove duplicates
public class RemoveDuplicatesfromSortedArray {
	public int removeDuplicatesI(int[] nums) {
        if( nums.length <=1)
            return nums.length;
        int cur=1,pre =0;
        while( cur < nums.length){
            if( nums[ pre ] == nums[cur])
                cur++;
            else{
            	pre++;
                nums[pre] = nums[cur];
                cur++;
            }
        }
        for( int k : nums )
        	System.out.println( k + " " );
        return pre+1;
    }
	
	/*Facebook
	 * Follow up for "Remove Duplicates": 
	 * What if duplicates are allowed at most twice?
	 * */
	public int removeDuplicatesII(int[] A) {
        if (A.length <= 2)
            return A.length;
 
        int prev = 1; // point to previous
        int curr = 2; // point to current
 
        while (curr < A.length) {
            if (A[curr] == A[prev] && A[curr] == A[prev - 1]) {
                curr++;
            } else {
                prev++;
                A[prev] = A[curr];
                curr++;
            }
        }
      for( int k: A )
    	System.out.println( k +" ");
        return prev + 1;
    }
	
	
	public static void main(String[] args) {
		RemoveDuplicatesfromSortedArray solution = new RemoveDuplicatesfromSortedArray();
		//int[] input = { 1, 1, 1, 2, 4, 4, 5, 7};
		int[] input = { 1,1,1,2,2,5,7 };
		//int len = solution.removeDuplicatesI(input);
		//int[] input = { 1, 2, 2};
		int len = solution.removeDuplicatesII(input);
		System.out.println( len );
	}
}
