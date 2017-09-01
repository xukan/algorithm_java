package algorithm_java;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

public class TaskScheduler {
	//solutionI, sort
	public static int leastInterval(char[] tasks, int n) {
		int[] map = new int[26];
        for (char c: tasks)
            map[c - 'A']++;
        Arrays.sort(map);
        int time = 0;
        while (map[25] > 0) {
            int i = 0;
            while (i <= n) {
                if (map[25] == 0)
                    break;
                if (i < 26 && map[25 - i] > 0)
                    map[25 - i]--;
                time++;
                i++;
            }
            Arrays.sort(map);
        }
        return time;
    }
	//solutionII
	public static int leastInterval_sII(char[] tasks, int n){
		Map<Character, Integer> map = new HashMap<>();
	    for (int i = 0; i < tasks.length; i++) {
	        map.put(tasks[i], map.getOrDefault(tasks[i], 0) + 1); // map key is TaskName, and value is number of times to be executed.
	    }
	    PriorityQueue<Map.Entry<Character, Integer>> q = new PriorityQueue<>( //frequency sort
	            (a,b) -> a.getValue() != b.getValue() ? b.getValue() - a.getValue() : a.getKey() - b.getKey());
	    q.addAll(map.entrySet());
	    int count = 0;
	    while (!q.isEmpty()) {
	    	int k = n + 1;
	        List<Map.Entry> tempList = new ArrayList<>();
	        while (k > 0 && !q.isEmpty()) {
	            Map.Entry<Character, Integer> top = q.poll(); // most frequency task
	            top.setValue(top.getValue() - 1); // decrease frequency, meaning it got executed
	            tempList.add(top); // collect task to add back to queue
	            k--;
	            count++; //successfully executed task
	        }

	        for (Map.Entry<Character, Integer> e : tempList) {
	            if (e.getValue() > 0) q.add(e); // add valid tasks 
	        }

	        if (q.isEmpty()) break;
	        count = count + k; // if k > 0, then it means we need to be idle
	    }
	    return count;
	}
	
	public static void main(String[] args) {
//		String s  ="AAADBBCC";
		String s = "AAABBB";
		int res = leastInterval_sII(s.toCharArray(), 50);
		System.out.println(res);
	}
}
