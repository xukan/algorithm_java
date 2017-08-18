package algorithm_java;

import java.util.ArrayList;
import java.util.List;

//IXL 

public class FindtheDerangementofAnArray {
	//recursion solution got TLE
	public int findDerangement_recursion(int n) {
        int[] nums = new int[n];
        boolean[] visited = new boolean[n];
        List<List<Integer>> list = new ArrayList<List<Integer>>();
        List<Integer> sol = new ArrayList<>();
        helper(n, visited, sol, list);
        return list.size();
    }
    
    public void helper(int n,  boolean[] visited, List<Integer> sol, List<List<Integer>> list){
        if(sol.size() == n){
            list.add(new ArrayList<Integer>(sol));
            return;
        }
        for(int i=1;i<=n;i++){
        	if(!visited[i-1]){
	        	if(sol.size()+1 == i)
	        		continue;
	            sol.add(i);
	            visited[i-1] = true;
	            helper(n, visited, sol, list);
	            sol.remove(sol.size()-1);    
	            visited[i-1] = false;
        	}
        }
    }
    
    //dp, formula: dp[n] = (n-1)*(dp[n-1]+ dp[n-2]);
    public static int findDerangement(int n) {
    	if(n<=1)
            return 0;
        long[] dp=new long[n+1];
    	long mod = 1000000007;
        dp[1] = 0;
    	dp[2] = 1;
        
    	for(int i=3;i<=n;i++)
    		dp[i] = (i-1)*(dp[i-1]+dp[i-2])%mod;
    	return (int)dp[n];
    }
    
    
    public static void main(String[] args) {
    	FindtheDerangementofAnArray s = new FindtheDerangementofAnArray();
    	int res = s.findDerangement(10);
    	System.out.println(res);
	}
}
