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
	
	public int combinationSum4(int[] nums, int target) {
        
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
    	for(List<Integer> i:res3){
    		for(int j:i)
    			System.out.print(j+" ");
    		System.out.println();
    	}
	}
}
