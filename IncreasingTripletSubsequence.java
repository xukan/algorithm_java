package algorithm_java;

//Facebook

public class IncreasingTripletSubsequence {
	public static boolean increasingTriplet(int[] nums) {
        int x = Integer.MAX_VALUE;
        int y = Integer.MAX_VALUE;
        for(int i: nums){
            int z = i;
            if(x>=z){
                x=z;
            }else if(y>=z){
                y=z;
            }else
                return true;
        }

        return false;
    }
	
	public static void main(String[] args) {
		int[] nums= {2,1,7,5,10};
		boolean res = increasingTriplet(nums);
		System.out.println(res);
	}
}
