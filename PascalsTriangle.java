package algorithm_java;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//Apple Twitter

// II Amazon

public class PascalsTriangle {
	public static List<List<Integer>> generate(int numRows) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        List<Integer> sol = new ArrayList<Integer>();
        sol.add(1);
        res.add(new ArrayList<Integer>(sol));
        sol.clear();
        sol.add(1);
        sol.add(1);
        res.add(new ArrayList<Integer>(sol));
        if(numRows>2){
        	
	        for(int i=2;i<numRows;i++){
	        	sol.clear();
	        	sol.add(1);
	        	List<Integer> temp = res.get(res.size()-1);
	        	for(int j=0;j<temp.size()-1;j++){
	        		sol.add(temp.get(j)+temp.get(j+1));
	        	}
	        	sol.add(1);
		        res.add(new ArrayList<Integer>(sol));
	        }
        }
        return res;
    }
	
	public List<Integer> getRow(int rowIndex) {
        List<Integer> sol = new ArrayList<Integer>();
        if(rowIndex<0)
            return sol;
        sol.add(1);
        if(rowIndex==0)
            return sol;
        sol.clear();
        sol.add(1);
        sol.add(1);
        if(rowIndex ==1)
            return sol;
        if(rowIndex>1){
	        for(int i=2;i<=rowIndex;i++){
	            List<Integer> pre = new ArrayList<Integer>(sol);
	        	sol.clear();
	        	sol.add(1);
	        	for(int j=0;j<pre.size()-1;j++){
	        		sol.add(pre.get(j)+pre.get(j+1));
	        	}
	        	sol.add(1);
	        }
        }
        return sol;
    }
	
	public static void main(String[] args) {
		List<List<Integer>> res = generate(5);
//		Arrays.stream(res)
//	    .map(a -> String.join(" ", a))
//	        .forEach(System.out::println);
		
		res.forEach(list->{
						list.forEach(i->System.out.print(i+" "));
						System.out.println();});
	}
}
