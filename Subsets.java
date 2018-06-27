package algorithm_java;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

//Amazon Uber Facebook

//Increasing Subsequences

public class Subsets {
	//time complexity O(2^n)
	public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        res.add(new ArrayList<Integer>());
        List<Integer> array = new ArrayList<Integer>();
        helper( 0, nums, array, res );
        return res;
    }
	
	public void helper(int start, int[] nums, List<Integer> array, List<List<Integer>> res ){
		for(int i=start;i<nums.length;i++){
			array.add(nums[i]);
			res.add(new ArrayList<Integer>(array));
			helper( i+1, nums, array, res );
			array.remove(array.size()-1);
		}
	}
	
	//given String s = "abc", find all subsets
	//use bit manipulation
	public List<String> strsubsets(String s) {
		List<String> res = new ArrayList<String>();
		if(s.length() == 0)
			return res;
		int len = s.length();
		int bitset = 0;
		for(int i=0;i<Math.pow(2, len);i++){
			if(i == 0){
				res.add("empty");
			}else{
				String str = "";
				int n= i;
				int sum = -1;
				while(n>0){
					sum += 1;
					if(n%2!=0)	
						str += (char)(sum + 'a');
					n/=2;
				}
				res.add(str);
			}
		}
		return res;
	}
	
//	public List<List<Integer>> subsets(int[] nums) {
//        List<List<Integer>> res = new ArrayList<List<Integer>>();
//        res.add(new ArrayList<Integer>());
//        for( int i=0;i<nums.length;i++){
//            List<Integer> array = new ArrayList<Integer>();
//            helper( i+1, 0, nums, array, res );
//        }
//        return res;
//    }
//	
//	public void helper( int len, int start, int[] nums, List<Integer> array, List<List<Integer>> res ){
//		if(array.size() == len){
//			List<Integer> temp = new ArrayList<Integer>(array);
//			Collections.sort(temp);
//			if( !res.contains(temp))
//				res.add(temp);
//			return;
//		}
//		for(int i=start;i<nums.length;i++){
//			if(!array.contains(nums[i])){
//				array.add(nums[i]);
//				helper( len, i, nums, array, res );
//				array.remove(array.size()-1);
//			}
//		}
//	}
	
	//subsets II
	//Facebook
    /*
     *  Given a collection of integers that might contain duplicates, nums, return all possible subsets.
     *  Note: The solution set must not contain duplicate subsets.
     * */
	public List<List<Integer>> subsetsWithDup(int[] nums) {
		List<List<Integer>> res = new ArrayList<List<Integer>>();
        res.add(new ArrayList<Integer>());
        Arrays.sort(nums);
        List<Integer> array = new ArrayList<Integer>();
        helperWithDup( 0, nums, array, res );
        return res;
    }
	
	public void helperWithDup(int start, int[] nums, List<Integer> array, List<List<Integer>> res){
		for(int i=start;i<nums.length;i++){
				if(i>start && nums[i] == nums[i-1])
					continue;
				array.add(nums[i]);
				res.add(new ArrayList<Integer>(array));
				helperWithDup(i+1,  nums, array, res);
				array.remove(array.size()-1);
			//}
		}
	}
	
	public static void main(String[] args) {
		//subsets
		int[] nums = {1,2,3};
		Subsets s = new Subsets();
		List<List<Integer>> res1 = s.subsets(nums);
    	for(List<Integer> i:res1){
			for(int j:i)
				System.out.print(j+" ");
			System.out.println();
    	}
    	
		//subsetsII, with duplicated data
    	int[] nums1 = {1,2,2};
    	List<List<Integer>> res2 = s.subsetsWithDup(nums1);
    	for(List<Integer> i:res2){
			for(int j:i)
				System.out.print(j+" ");
			System.out.println();
    	}
    	
    	String input = "abc";
    	List<String> res3 = s.strsubsets(input);
    	res3.forEach(ss->System.out.print(ss+" "));
	}
}
