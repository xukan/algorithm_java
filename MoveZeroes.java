package algorithm_java;

//Bloomberg Facebook
//Remove Element
//http://yuanhsh.iteye.com/blog/2193772

/*
 *   对比两种方法,发现第二种解法的write会比较少,因为可以不要求顺序,所以出现在0前面的数字是不用换位置的
 * */
public class MoveZeroes {	
	//solutionI
	//// move all zeros to end of array, keep the non-zero elements order 
	public static void moveZeroes(int[] nums) {
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
