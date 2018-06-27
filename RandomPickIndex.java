package algorithm_java;

import java.util.Random;

//Facebook

public class RandomPickIndex {
	int[] arr;
    Random rand;
    public RandomPickIndex(int[] nums) {
        rand = new Random();
        arr = nums;
    }
    
    public int pick(int target) {
        int count = 0;
        int res = -1;
        for(int i=0;i<arr.length;i++){
            if(arr[i] == target)
            	//reservoir sampling
            	//when first time meet target number, res will be updated to be current index, since rand.nextInt(1) = 0;
            	//the rest of target values will have equal chance to be picked up
                if(rand.nextInt(++count) == 0)
                    res = i;
        }
        return res;
    }
    
    public static void main(String[] args) {
    	int[] nums = {1,2,3,3,3};
    	RandomPickIndex s = new RandomPickIndex(nums);
    	int res = s.pick(3);
    	System.out.println(res);
	}
}
