package algorithm_java;

import java.util.ArrayList;
import java.util.List;

//similar questions
//permutations, permutationII

public class BeautifulArrangement {
//	int count = 0;
//	public int countArrangement(int N) {
//        dfs(N, N, new boolean[N + 1]);
//        return count;
//    }
//    
//    void dfs(int N, int k, boolean[] visited) {
//        if (k == 0) {
//            count++;
//            return;
//        }
//        for (int i = 1; i <= N; i++) {
//            if (visited[i] || k % i != 0 && i % k != 0) {
//                continue;
//            }
//            visited[i] = true;
//            dfs(N, k - 1, visited);
//            visited[i] = false;
//        }
//    }
    
	public int countArrangement(int N) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        List<Integer> sol = new ArrayList<Integer>();
        boolean[] visited = new boolean[N];
        helper(N, visited, sol, res);
        return res.size();
    }
    
    public void helper(int N, boolean[] visited, List<Integer> sol, List<List<Integer>> res){
        if(sol.size() == N){
            res.add(new ArrayList<Integer>(sol));
            return;
        }
        
        for(int i=0;i<N;i++){
            if(!visited[i]){
                if((i+1)%(sol.size()+1)==0 || (sol.size()+1)%(i+1)==0){
                    sol.add(i+1);
                    visited[i] = true;
                    helper(N, visited, sol, res);
                    sol.remove(sol.size()-1);
                    visited[i] = false;
                }
            }
        }
    }
	
    public static void main(String[] args) {
    	BeautifulArrangement s = new BeautifulArrangement();
    	int res = s.countArrangement(4);
    	System.out.println(res);
	}
}
