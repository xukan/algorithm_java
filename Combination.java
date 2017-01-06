package algorithm_java;

import java.util.ArrayList;
import java.util.List;

public class Combination {
	public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        List<Integer> sol = new ArrayList<Integer>();
        helper(1, n,k,sol, res);
        return res;
    }
    
    public void helper(int start, int n, int k, List<Integer> sol, List<List<Integer>> res){
        if(sol.size() == k){
            res.add(new ArrayList<Integer>(sol));
            return;
        }
        for(int i=start;i<=n;i++){
            sol.add(i);
            helper(i+1, n, k, sol, res);
            sol.remove(sol.size()-1);
        }
    }
    
    public static void main(String[] args) {
    	Combination s = new Combination();
    	List<List<Integer>> res = s.combine(3, 3);
    	for(List<Integer> i:res){
		for(int j:i)
			System.out.print(j+" ");
		System.out.println();
	}	
	}
}
