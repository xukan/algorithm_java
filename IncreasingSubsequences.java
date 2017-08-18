package algorithm_java;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

//subsets

//http://programtalk.com/java/increasing-subsequences-leetcode/
public class IncreasingSubsequences {
	public static List<List<Integer>> findSubsequences(int[] nums) {
        Set<List<Integer>> res = new HashSet<List<Integer>>();
        List<Integer> sol = new ArrayList<Integer>();
        helper(nums, 0, sol, res);
        List result = new ArrayList(res);
        return result;
    }
    
    public static void helper(int[] nums, int start, List<Integer> sol, Set<List<Integer>> res){
        for(int i=start;i<nums.length;i++){
            if(sol.size()==0 || nums[i]>=sol.get(sol.size()-1)){
                sol.add(nums[i]);
                if(sol.size()>=2)
                    res.add(new ArrayList<Integer>(sol));
                helper(nums, i+1, sol, res);
                sol.remove(sol.size()-1);
            }
        }
    }
    
    public static void main(String[] args) {
		int[] nums  = {4, 6, 7, 7};
		List<List<Integer>> res = findSubsequences(nums);
		for(List<Integer> i:res){
			for(int j:i)
				System.out.print(j+" ");
			System.out.println();
    	}
	}
}
