package algorithm_java;

import java.util.List;

public class BigCountries {
	public static void moveZeroes(int[] nums) {
		List<Integer> list = 
        int count = 0;
        for(int i=0;i<nums.length;i++){
            if(nums[i] == 0)
                count++;
            else{
                if(count > 0){
                    nums[i-count] = nums[i];
                    nums[i] = 0;
                }
            }
        }
    }
	
	// move all zeros to end of array, does not keep the non-zero elements order  
	public static void moveZeroRight(int[] A) {  
	    for(int i=0, j=A.length-1; i<j; i++) {  
	        if(A[i] == 0) {  
	            while(i<j && A[j] == 0) 
	            	j--;  
	            swap(A, i, j);  
	        }
	    }
	    for(int n: A)
	    	System.out.print(n + " ");
	}  
	  
	private static void swap(int[] A, int i, int j) {  
	    int tmp = A[i];  
	    A[i] = A[j];  
	    A[j] = tmp;  
	}  
	
	public static void main(String[] args) {
		int[] nums = {0,1,0,3,12,0};
		moveZeroRight(nums);
	}
}
