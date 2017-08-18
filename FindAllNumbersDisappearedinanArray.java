package algorithm_java;

import java.util.ArrayList;
import java.util.List;

//Google 

//similar question
//Find All Duplicates in an Array

//Note the input array has requirement that 1 ≤ a[i] ≤ n (n = size of array)

public class FindAllNumbersDisappearedinanArray {
	public static List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> res = new ArrayList<Integer>();
        for(int i=0;i<nums.length;i++){
            int cur = Math.abs(nums[i]);
            if(nums[cur-1]>0){
                nums[cur-1]*=-1;
            }
        }
        for(int i=0;i<nums.length;i++)
            if(nums[i]>0)
                res.add(i+1);
        return res;
    }
	
	public static void main(String[] args) {
		int[] nums = {4,3,2,7,8,2,3,1};
		List<Integer> res = findDisappearedNumbers(nums);
		res.forEach(i->System.out.print(i+" "));
	}
}
