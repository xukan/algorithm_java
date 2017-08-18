package algorithm_java;

//Facebook

public class ProductofArrayExceptSelf {
	public static int[] productExceptSelf(int[] nums) {
	    int leng = nums.length;
	    int[] ret = new int[leng];
	    if(leng == 0)
	        return ret;
	    int runningprefix = 1;
	    for(int i = 0; i < leng; i++){
	        ret[i] = runningprefix;
	        runningprefix*= nums[i];
	    }
	    int runningsufix = 1;
	    for(int i = leng -1; i >= 0; i--){
	        ret[i] *= runningsufix;
	        runningsufix *= nums[i];
	    }
	    return ret;  
	}
	
	public static void main(String[] args) {
		int[] nums = {2,3,4,5};
		int[] res = productExceptSelf(nums);
		for(int i: res)
			System.out.print(i + " ");
	}
}
