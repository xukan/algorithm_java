package algorithm_java;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Permutations {
	//permutation
	//LinkedIn Microsoft

	public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        List<Integer> sol = new ArrayList();
        boolean[] visited = new boolean[nums.length];
        helper(nums, visited, sol, res);
        return res;
    }
    
    public void helper(int[] nums, boolean[] visited, List<Integer> sol, List<List<Integer>> res){
        if(sol.size() == nums.length){
            res.add(new ArrayList<Integer>(sol));
            return;
        }
        
        for(int i=0;i<nums.length;i++){
            if(!visited[i]){
                sol.add(nums[i]);
                visited[i] = true;
                helper(nums, visited, sol, res);
                sol.remove(sol.size()-1);
                visited[i] = false;
            }   
        }
    }
    
    //permutationsII 
    //LinkedIn Microsoft
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        List<Integer> sol = new ArrayList<Integer>();
        boolean[] used = new boolean[nums.length];
        Arrays.sort(nums);
        helperUnique(used, nums ,sol, res);
        return res;
    }
    
    public void helperUnique( boolean[] used, int[] nums, List<Integer> sol, List<List<Integer>> res){
        if(sol.size() == nums.length){
            res.add(new ArrayList<Integer>(sol));
            return;
        }
        for(int i=0;i<nums.length;i++){
        	if(!used[i]){
        		if(i>0 && nums[i]==nums[i-1] && !used[i-1])
	                continue;
	            sol.add(nums[i]);
	            used[i]= true;
	            helperUnique( used,nums, sol, res);
	            sol.remove(sol.size()-1);
	            used[i]= false;
        	}
        }
    }
    
    public static void main(String[] args) {
    	Permutations s = new Permutations();
//    	int[] nums = { 1,2,3 };
//    	List<List<Integer>> res = s.permute(nums);
//    	for(List<Integer> i:res){
//			for(int j:i)
//				System.out.print(j+" ");
//			System.out.println();
//    	}	
    	
    	int[] nums1 = {1,1,2};
    	List<List<Integer>> res1 = s.permuteUnique(nums1);
    	for(List<Integer> i:res1){
			for(int j:i)
				System.out.print(j+" ");
			System.out.println();
    	}
	}
}
