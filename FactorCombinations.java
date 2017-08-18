package algorithm_java;

import java.util.ArrayList;
import java.util.List;

//LinkedIn Uber

public class FactorCombinations {
	public List<List<Integer>> getFactors(int n) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        List<Integer> sol = new ArrayList<Integer>();
        helper(2, n, sol, res);
        return res;
    }
    
    public void helper(int start, int n, List<Integer> sol, List<List<Integer>> res){        
        if (n == 1) {
            if (sol.size() > 1) {//this if block is used to avoid add n itself to sol
                res.add(new ArrayList<Integer> (sol));
            }
            return;
        }
        for(int i=start;i<=n;i++){
            if(n%i==0){
                sol.add(i);
                helper(i, n/i, sol, res);
                sol.remove(sol.size()-1);
            }
        }
    }
    
    public static void main(String[] args) {
    	FactorCombinations s = new FactorCombinations();
    	List<List<Integer>> res = s.getFactors(12);
    	for(List<Integer> i:res){
			for(int j:i)
				System.out.print(j+" ");
			System.out.println();
		}
	}
}
