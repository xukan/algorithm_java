package algorithm_java;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//backtracking
public class CombinationSum {
	public List<List<Integer>> combinationSum(int[] candidates, int target) {
		List<List<Integer>> res = new ArrayList<List<Integer>>();
        ArrayList<Integer> sol = new ArrayList<Integer>();
        Arrays.sort(candidates);
        findCombSum( candidates, 0, target, sol, res );
        return res;
    }
	
	public void findCombSum(int[] candidates, int start, int target, ArrayList<Integer> sol, List<List<Integer>> res){
		if(target < 0)
			return;
		if( target == 0){
			res.add( new ArrayList<Integer>(sol));
		}
		for( int i=start;i<candidates.length;i++){
			if(i>start&&candidates[i] == candidates[i-1])
            	continue;
            sol.add(candidates[i]);
            findCombSum(candidates, i, target-candidates[i], sol, res);
            sol.remove(sol.size()-1);
		}
	}
	
	public List<List<Integer>> combinationSum2(int[] candidates, int target) {
		List<List<Integer>> res = new ArrayList<List<Integer>>();
		List<Integer> sol = new ArrayList<Integer>();
		Arrays.sort(candidates);
		findCombSum2( candidates, 0, target, sol, res);
		return res;
    }
	
	public void findCombSum2( int[] candidates, int start, int target, List<Integer> sol, List<List<Integer>> res){
		if(target<0)
			return;
		if(target ==0)
			res.add(new ArrayList<Integer>(sol));
		for(int i=start;i<candidates.length;i++){
			if(i>start && candidates[i] == candidates[i-1])
				continue;
			sol.add(candidates[i]);
			findCombSum2(candidates, i+1, target-candidates[i], sol, res);
			sol.remove(sol.size()-1);
		}	
	}
	
	/*
	 * Find all possible combinations of k numbers that add up to a number n, given that only numbers from 1 to 9 can be used 
	 * and each combination should be a unique set of numbers.
	 * O(9 * 8 * ... (9-k+1)), which is factorial time, because we would try 9-i+1 possible numbers in ith step.
	 * */
	public List<List<Integer>> combinationSum3(int k, int n) {
		List<List<Integer>> res = new ArrayList<List<Integer>>();
		List<Integer> sol = new ArrayList<Integer>();
		findCombSum3(k, 1, n, sol, res);
		return res;
    }
	
	public void findCombSum3( int k, int start, int target, List<Integer> sol, List<List<Integer>> res){
		if(target < 0)
			return;
		if( target == 0 && sol.size() == k)
			res.add(new ArrayList<Integer>(sol));
		for(int i=start;i<=9;i++){
			sol.add(i);
			findCombSum3(k, i+1, target-i, sol, res);
			sol.remove(sol.size()-1);
		}
	}
	
	//IV, Google Snapchat Facebook
	/*
	 * http://blog.csdn.net/qq508618087/article/details/52064134
	 * 用动态规划来做, 也是一个背包问题, 求出[1, target]之间每个位置有多少种排列方式, 这样将问题分化为子问题. 
	 * 状态转移方程可以得到为: 
	 * dp[i] = sum(dp[i - nums[j]]),  (i-nums[j] > 0);
	 * So we know that target is the sum of numbers in the array. Imagine we only need one more number to reach target, 
	 * this number can be any one in the array, right? So the # of combinations of target
	 * comb[target] = sum(comb[target - nums[i]]), where 0 <= i < nums.length, and target >= nums[i].
	 * 如果允许有负数的话就必须要限制每个数能用的次数了, 不然的话就会得到无限大的排列方式, 比如1, -1, target = 1;
	 * */
	public static int combinationSum4(int[] nums, int target) {
		int[] dp= new int[target+1];
        dp[0] = 1;
        //Note in this problem, each element from the input array can be used multiple times
        for(int i = 1; i <= target;i++){
            for(int num:nums){
                if(i >= num)
                	dp[i] += dp[i - num];
            }
        }
        return dp[target];
    }
	
	public static void main(String[] args) {
		int[] candidates ={2,3,2,6,7};
		int[] candidates2 ={10, 1, 2, 7, 6, 1, 5};
		CombinationSum s = new CombinationSum();
//    	List<List<Integer>> res = s.combinationSum(candidates, 4);
//    	for(List<Integer> i:res){
//    		for(int j:i)
//    			System.out.print(j+" ");
//    		System.out.println();
//    	}	
    	
//    	List<List<Integer>> res2 = s.combinationSum2(candidates2, 8);
//    	for(List<Integer> i:res2){
//    		for(int j:i)
//    			System.out.print(j+" ");
//    		System.out.println();
//    	}
    	
    	List<List<Integer>> res3 = s.combinationSum3(3,9);
//    	for(List<Integer> i:res3){
//    		for(int j:i)
//    			System.out.print(j+" ");
//    		System.out.println();
//    	}
    	
    	int[] nums ={4,2,1};
//    	int total = combinationSum4(nums, 32);
    	int total = combinationSum4(nums, 5);
    	System.out.println(total);
	}
}
