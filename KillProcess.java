package algorithm_java;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class KillProcess {
	public static List<Integer> killProcess(List<Integer> pid, List<Integer> ppid, int kill) {
		Map<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < pid.size(); ++i) {
            map.putIfAbsent(ppid.get(i), new ArrayList<>());
            map.get(ppid.get(i)).add(pid.get(i));
        }
        List<Integer> ans = new ArrayList<>();
        LinkedList<Integer> q = new LinkedList<>();
        q.add(kill);
        while (!q.isEmpty()) {
            int n = q.poll();
            ans.add(n);
            if (map.containsKey(n)) {
                q.addAll(map.get(n));
            }
        }
        return ans;
    }
	
	public static void main(String[] args) {
		int[] a = {1,3,10,5};
		List<Integer> pid=new ArrayList();
		for(int i: a)
			pid.add(i);
		int[] b = {3,0,5,3};
		List<Integer> ppid = new ArrayList();;
		for(int i: b)
			ppid.add(i);
		int kill =5;
		List<Integer> res = killProcess(pid, ppid, kill);
		for(int killedpid: res)
			System.out.print(killedpid+" ");
	}
}
