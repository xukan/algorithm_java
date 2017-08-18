package algorithm_java;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

//Google

public class EvaluateDivision {
	HashMap<String, HashSet<String>> graph = new HashMap<>();
    HashMap<String, Double> equationMap = new HashMap<>();
    public double[] calcEquation(String[][] equations, double[] values, String[][] queries){
        for(int i=0;i<equations.length;i++){
            String from = equations[i][0], to = equations[i][1];
            if(!graph.containsKey(from))
                graph.put(from, new HashSet<String>());
            graph.get(from).add(to);
            equationMap.put(from + "/" + to, values[i]);
            if(values[i]!=0.0){
                if(!graph.containsKey(to))
                    graph.put(to, new HashSet<String>());
                graph.get(to).add(from);
                equationMap.put(to + "/" + from, 1.0/values[i]);
            }
        }
        double[] res = new double[queries.length];
        for(int k=0;k<queries.length;k++){
            String from = queries[k][0], to = queries[k][1];
            if(graph.containsKey(from) && graph.containsKey(to)){
                if(from.equals(to))
                    res[k] = 1.0;
                else
                    res[k] = helper(new HashSet<String>(), from, to, 1.0);
            }else
                res[k] = -1.0;
        }
        return res;
    }
    
    public double helper(HashSet<String> visited, String from, String to, double val){
        double res = -1.0;
        visited.add(from);
        for(String neighbor: graph.get(from)){
            if(neighbor.equals(to)){
                return val*equationMap.get(from+"/"+to);
            }
            if(!visited.contains(neighbor)){
                res = helper(visited, neighbor, to, val*equationMap.get(from+"/"+neighbor));
                if(res!=-1.0)
                    break;
            }
        }
        visited.remove(from);
        return res;
    }
    
	public static void main(String[] args) {
		EvaluateDivision s = new EvaluateDivision();
		String[][] equations = {{"a", "b"}, {"b", "c"}};
		double[] values = {2.0, 3.0};
		String[][] queries = {{"a", "c"}, {"b", "a"}, {"a", "e"}, {"a", "a"}, {"x", "x"}};
		double[] res = s.calcEquation(equations, values, queries);
		for(double i: res)
			System.out.print(i + " ");
	}
}
