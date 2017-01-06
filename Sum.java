package algorithm_java;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Sum {
	//two sum
	//LinkedIn Uber Airbnb Facebook Amazon Microsoft Apple Yahoo Dropbox Bloomberg Yelp Adobe
	
	//Two Sum II - Input array is sorted
	//Amazon
	public int[] twoSum(int[] numbers, int target) {
		if (numbers == null || numbers.length == 0)
			return null;
	 
		int i = 0;
		int j = numbers.length - 1;
	 
		while (i < j) {
			int x = numbers[i] + numbers[j];
			if (x < target) {
				++i;
			} else if (x > target) {
				j--;
			} else {
				return new int[] { i + 1, j + 1 };
			}
		}
		return null;
	}
	
	
	//Two Sum III - Data structure design
	//LinkedIn
	
	 /**********************3Sum***********************/
	//3Sum
	//Amazon Microsoft Bloomberg Facebook Adobe Works Applications
	//O(nlgn), we use two pointers to solve this problem. 
	//two ignore duplicate elements, we first need to sort the input array.
	//Then we use similar idea as in Two Sum II - Input array is sorted. To narrow the scope of input array,
	//one candidate is nums[i], left bar is the one after we iterate, which is i+1, right bar is end of the array, this is similar to 2Sum. 
	//The difference is that we may have multiple answer for each nums[i]. So we need a temporary 2d list curRes.
	//After each search, we add all lists in curRes to res
	public static List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        if(nums==null || nums.length<=2)
            return res;
        Arrays.sort(nums);
        int len = nums.length;
        for(int i=0;i<len-2;i++){
            if(i>0 && nums[i] == nums[i-1])
                continue;
            List<List<Integer>> curRes = new ArrayList<List<Integer>>();
            twoSum(nums, i+1, nums[i], curRes);
            res.addAll(curRes);
        }
        return res;
    }
    
    public static void twoSum(int[] nums, int l, int target, List<List<Integer>> cur){
        int r= nums.length-1;
        while(l<r){
        	List<Integer> sol = new ArrayList<Integer>();
        	int x = nums[l]+nums[r]+target;
        	if( x == 0){
            	sol.add(target);
                sol.add(nums[l]);
                sol.add(nums[r]);
                if(!cur.contains(sol))
                	cur.add(new ArrayList<Integer>(sol));
                l++;
                r--;
	            while(l<r && nums[l]== nums[l-1])
	                l++;
	            while(l<r && nums[r] == nums[r+1])
	                r--;
        	}
        	else if(x<0)
                l++;
            else
                r--;
        }
    }
    /***************3 Sum***********************/
	
    /***********************3Sum Closest***********************************/
	//3Sum Closest
	//Bloomberg
    public static int threeSumClosest(int[] nums, int target) {
        int closest=Integer.MAX_VALUE, res=0;
        Arrays.sort(nums);
        for(int i=0;i<nums.length-2;i++){
            if(i>0 && nums[i] == nums[i-1])
                continue;
            int gap = helper(nums, i+1, target-nums[i]);
            if( Math.abs(gap)<Math.abs(closest))
            	closest = gap;
        }
        res = target - closest;
        return res;
    }
    
    public static int helper(int[] nums, int l, int target){
        
        int closest=Integer.MAX_VALUE;
        int r = nums.length-1;
        while(l<r){
        	int x = target - nums[l] - nums[r];
        	//closest = Math.min(closest, Math.abs(x));
        	if(Math.abs(x)<Math.abs(closest))
                closest = x;
        	if(x ==0){
        		return 0;
        	}else if(x>0){
        		l++;
        	}else
        		r--;
        }
        return closest;
    }
    /***********************3Sum Closest***********************************/
    
    
	
	// 3Sum Smaller
	
	//4Sum
	
	//4Sum II
	

    public static void main(String[] args){
    	/***************3 Sum***********************/
		//int[] input={7,-1,14,-12,-8,7,2,-15,8,8,-8,-14,-4,-5,7,9,11,-4,-15,-6,1,-14,4,3,10,-5,2,1,6,11,2,-2,-5,-7,-6,2,-15,11,-6,8,-4,2,1,-1,4,-6,-15,1,5,-15,10,14,9,-8,-6,4,-6,11,12,-15,7,-1,-9,9,-1,0,-4,-1,-12,-2,14,-9,7,0,-3,-4,1,-2,12,14,-10,0,5,14,-1,14,3,8,10,-8,8,-5,-2,6,-11,12,13,-7,-12,8,6,-13,14,-2,-5,-11,1,3,-6};
		//int[] input ={-1,0,1,2,-1,-4};
//    	int[] input3Sum ={-2,0,1,1,2};
//		List<List<Integer>> res = threeSum(input3Sum);
//		for(List<Integer> l : res){
//			for(int i: l)
//				System.out.print(i+" ");
//			System.out.println();
//		}
		/***************3 Sum***********************/
		
		int[] input3SumClosest = {0,1,2};
		int target=0;
		int res1 = threeSumClosest(input3SumClosest, target);
		System.out.println(res1);
	}
	
}
