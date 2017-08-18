package algorithm_java;

//Intuit 

public class MaximumProductofThreeNumbers {
	public static int maximumProduct(int[] nums) {
        int min1 = Integer.MAX_VALUE, min2 = Integer.MAX_VALUE;
        int max1 = Integer.MIN_VALUE, max2 = Integer.MIN_VALUE, max3 = Integer.MIN_VALUE;
        for(int i: nums){
            if(i<min1){
                min2 = min1;
                min1 = i;
            }else if(i < min2){
                min2 = i;
            }
            if(i>max1){
                max3= max2;
                max2 = max1;
                max1 = i;
            }else if(i>max2){
                max3 = max2;
                max2 = i;
            }else if(i>max3)
                max3 = i;
        }
        return Math.max(min1*min2*max1, max1*max2*max3);
    }
	
	public static void main(String[] args) {
		int[] nums = {-5,-7,1,2,3,4,5};
		int res = maximumProduct(nums);
		System.out.println(res);
	}
}
