package algorithm_java;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

/*
 * This question 
 * */

public class FindAllDuplicatesinanArray {
	public List<Integer> findDuplicates(int[] nums) {
		List<Integer> res = new ArrayList<>();
        for (int i = 0; i < nums.length; ++i) {
            int index = Math.abs(nums[i])-1;
            if (nums[index] < 0)
                res.add( index+1 );
            nums[index] = -nums[index];
        }
        return res;
        }

	//Find All Numbers Disappeared in an Array
	public List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> res = new ArrayList();
        //boolean[] visit = new boolean[nums.length];
        for(int i=0;i<nums.length;i++){
            int index = Math.abs(nums[i])-1;
            if( nums[index] < 0)
                continue;
            nums[index] = -nums[index];
        }
        for(int i=0;i<nums.length;i++)
        	if(nums[i]>0)
        		res.add(i+1);
        return res;
    }
	
	public void swap(int[] array, int x, int y){
		int temp = array[x];
		array[x] = array[y];
		array[y] = temp;
	}
	
	public static void main(String[] args) {
		int[] input2 = {4,3,2,7,8,2,3,1};
		//int[] input = {5,4,6,7,9,3,10,9,5,6};
		int[] input= {3,11,8,16,4,15,4,17,14,14,6,6,2,8,3,12,15,20,20,5};
		int[] input1 = {3,11,8,16,4,15,4,17,14,14,6,6,2,8,3,20,20,20,20,5};
//		Arrays.sort(input1);
//		for( int i: input1 )
//			System.out.print( i + " " );
//		System.out.println();
//		for( int i: input )
//			System.out.print( i + " " );
//		System.out.println();
		FindAllDuplicatesinanArray solution = new FindAllDuplicatesinanArray();
//		List<Integer> res = solution.findDuplicates(input);
		
		List<Integer> res = solution.findDisappearedNumbers(input2);
		for( int i: res )
			System.out.print( i + " " );
	}
}
