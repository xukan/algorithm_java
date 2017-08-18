package algorithm_java;

import java.util.Arrays;
import java.util.Random;

public class ShuffleanArray {
	int[] original;
    int[] shuffled;
    Random random;
    public ShuffleanArray(int[] nums) {
        original = nums.clone();
        shuffled = Arrays.copyOf(nums, nums.length);
        random = new Random();
    }
    
    /** Resets the array to its original configuration and return it. */
    public int[] reset() {
        shuffled = Arrays.copyOf(original, original.length);
        return shuffled;
    }
    
    /** Returns a random shuffling of the array. */
    public int[] shuffle() {
        int len = shuffled.length;
        for(int i=0;i<len;i++){
            int pos = random.nextInt(len-i);
            int tmp = shuffled[i];
            shuffled[i] = shuffled[pos+ i];
            shuffled[pos+ i] = tmp;
        }
        
        //http://www.geeksforgeeks.org/?p=25111
//        for(int i=len-1;i>=0;i--){
//            int j = random.nextInt(i+1);
//            int tmp = shuffled[j];
//            shuffled[j] = shuffled[i];
//            shuffled[i] = tmp;
//        }
        
        return shuffled;
    }
    
    public static void main(String[] args) {
    	int[] nums = {1,2,3,4,5};
    	ShuffleanArray s= new ShuffleanArray(nums);
    	int[] res = new int[nums.length];
    	res = s.shuffle();
    	for(int i: res)
    		System.out.print(i + " ");
    	System.out.println();
    	res = s.shuffle();
    	for(int i: res)
    		System.out.print(i + " ");
    	System.out.println();
    	res = s.reset();
    	for(int i: res)
    		System.out.print(i + " ");
	}
}
