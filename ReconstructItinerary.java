package algorithm_java;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Stack;

//google

public class ReconstructItinerary {
	HashMap<String, PriorityQueue<String>> map = new HashMap<String, PriorityQueue<String>>();
	LinkedList<String> result = new LinkedList<String>();
 
	public List<String> findItinerary(String[][] tickets) {
		for (String[] ticket : tickets) {
			String from = ticket[0], to = ticket[1];
            map.putIfAbsent(from, new PriorityQueue<String>());
            map.get(from).offer(to);
		}
 
		dfs("JFK");
		return result;
	}
 
	public void dfs(String s) {
		PriorityQueue<String> q = map.get(s);
 
		while (q != null && !q.isEmpty()) {
			dfs(q.poll());
		}
 
		result.addFirst(s);
	}
	
	public List<String> findItinerary_iteration(String[][] tickets) {
		for (String[] ticket : tickets) {
			String from = ticket[0], to = ticket[1];
            map.putIfAbsent(from, new PriorityQueue<String>());
            map.get(from).offer(to);
		}
		String curr = "JFK";
        Stack<String> drawBack = new Stack<String>();
        for(int i = 0; i < tickets.length; i++) {
            while(!map.containsKey(curr) || map.get(curr).isEmpty()) {
                drawBack.push(curr);
                curr = result.remove(result.size()-1);
            }
            result.add(curr);
            curr = map.get(curr).poll();
        }
        result.add(curr);
        while(!drawBack.isEmpty()) result.add(drawBack.pop());
        return result;
    }
	
	public static void main(String[] args) {
		ReconstructItinerary s = new ReconstructItinerary();
		//String[][] tickets = {{"JFK","SFO"},{"JFK","ATL"},{"SFO","ATL"},{"ATL","JFK"},{"ATL","SFO"}, {"JFK", "SHA"}};
		String[][] tickets ={{"JFK","KUL"},{"JFK","NRT"},{"NRT","JFK"}};
		List<String> res = s.findItinerary_iteration(tickets);
		for(String str: res)
			System.out.print( str + " ");
	}
}
