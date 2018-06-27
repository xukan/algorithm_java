package algorithm_java;

import java.util.ArrayList;
import java.util.List;

public class Combination {
//	public List<List<Integer>> combine(int n, int k) {
//        List<List<Integer>> res = new ArrayList<List<Integer>>();
//        List<Integer> sol = new ArrayList<Integer>();
//        helper(1, n,k,sol, res);
//        return res;
//    }
//    
//    public void helper(int start, int n, int k, List<Integer> sol, List<List<Integer>> res){
//        if(sol.size() == k){
//            res.add(new ArrayList<Integer>(sol));
//            return;
//        }
//        for(int i=start;i<=n;i++){
//            sol.add(i);
//            helper(i+1, n, k, sol, res);
//            sol.remove(sol.size()-1);
//        }
//    }
    
	//better solution
	public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        if(k==0)
            return res;
        List<Integer> sol = new ArrayList<Integer>();
        helper(n, 1, k, sol, res);
        return res;
    }
    
    public void helper(int n, int index, int k, List<Integer> sol, List<List<Integer>> res){
        if(0 == k){
            res.add(new ArrayList<Integer>(sol));
            return;
        }
        //当剩余的数字不够组成k个数字的组合时,停止查找,注意这里k是变化的
        /*Change the ending condition of for-loop to i <= n - k + 1 and the performance of this implementation will beat over 96% of the results! 
         *Take combine(4, 2) as an example, the program does not need to try the combination starting with 4, 
         *because it has been covered by those starting with 1, 2 and 3. The same applies for each sub-problem in the recursions.
         * */
        if (n-index+1<k)
            return;
        for(int i=index;i<=n;i++){
            sol.add(i);
            helper(n, i+1, k-1, sol, res);
            sol.remove(sol.size()-1);
        }
    }
	
    //similar solution as above one, it is easier to understand
    public List<List<Integer>> combine_sameAsAboveOne(int n, int k) {
        List<List<Integer>> results = new ArrayList<>();
        dfs(1, n, k, new ArrayList<Integer>(), results);
        return results;
    }

    private void dfs(int crt, int n, int level, List<Integer> comb, List<List<Integer>> results) {
        if (level == 0) {
            List<Integer> newComb = new ArrayList<>(comb);
            results.add(newComb);
            return;
        }
        int size = comb.size();
        for (int i = crt, max = n - level + 1; i <= max; i++) { 
        //end search when its not possible to have any combination
            comb.add(i);
            dfs(i + 1, n, level - 1, comb, results);
            comb.remove(size);
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
