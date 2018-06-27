package algorithm_java;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

//无向图检测环的方法
//http://www.cnblogs.com/tenosdoit/p/3644225.html
//认为这种方法是一个BFS
//http://www.programcreek.com/2014/05/leetcode-course-schedule-java/
//

public class CourseSchedule {
	public boolean canFinish(int numCourses, int[][] prerequisites) {
		Map<Integer, Set<Integer>> graph = new HashMap<>();
		int[] indegree = new int[numCourses];
		for (int[] courses : prerequisites) {
			int from = courses[1], to = courses[0];
			if (!graph.containsKey(from))
				graph.put(from, new HashSet<Integer>());
			if (graph.get(from).add(to)) // input prerequisite may contain duplicate elements, so we need to guarantee indegree add once for each edge
				indegree[to]++;
		}
		List<Integer> sequence = new ArrayList<Integer>();
		Queue<Integer> queue = new LinkedList<Integer>();
		for (int i = 0; i < numCourses; i++) {
			if (indegree[i] == 0) {
				queue.offer(i);
			}
		}
		while (!queue.isEmpty()) {
			int from = queue.poll();
			sequence.add(from);
			if (!graph.containsKey(from))
				continue;
			 Iterator<Integer> iter = graph.get(from).iterator();
			 while(iter.hasNext()){
				 int to = iter.next();
				 indegree[to]--;
				 if(indegree[to] == 0)
				 queue.offer(to);
			 }
//			for (int to : graph.get(from)) {
//				indegree[to]--;
//				if (indegree[to] == 0)
//					queue.offer(to);
//			}
		}
		return sequence.size() == numCourses;
	}

	/**********************/
	public boolean CanFinish(int numCourses, int[][] prerequisites) {
		Map<Integer, Set<Integer>> graph = new HashMap<>();
		int[] indegree = new int[numCourses];
		for (int[] courses : prerequisites) {
			int from = courses[1], to = courses[0];
			if (!graph.containsKey(from))
				graph.put(from, new HashSet<Integer>());
			if (graph.get(from).add(to))
				indegree[to]++;
		}
		List<Integer> sequence = new ArrayList<Integer>();
		Queue<Integer> queue = new LinkedList<Integer>();
		for (int i = 0; i < numCourses; i++) {
			if (indegree[i] == 0) {
				queue.offer(i);
			}
		}
		while (!queue.isEmpty()) {
			int from = queue.poll();
			sequence.add(from);
			if (!graph.containsKey(from))
				continue;
			Iterator<Integer> iter = graph.get(from).iterator();
			while (iter.hasNext()) {
				int to = iter.next();
				indegree[to]--;
				if (indegree[to] == 0)
					queue.offer(to);
			}
			// for(int to: graph.get(from)){
			// indegree[to]--;
			// if(indegree[to] == 0)
			// queue.offer(to);
			// }
		}
		return sequence.size() == numCourses;
	}

	/**********************/
	// II
	public int[] findOrder(int numCourses, int[][] pre) {
		// adjacency matrix
		// int[] res = new int[numCourses];
		// int k=0;
		// int[][] matrix = new int[numCourses][numCourses];
		// LinkedList<Integer> queue = new LinkedList<Integer>();
		// int[] indegree = new int[numCourses];
		// for(int i=0;i<pre.length;i++){
		// matrix[pre[i][1]][pre[i][0]] = 1;
		// indegree[pre[i][0]]++;
		// }
		// for(int i=0;i<numCourses;i++){
		// if(indegree[i] == 0)
		// queue.offer(i);
		// }
		// while(!queue.isEmpty()){
		// int from = queue.poll();
		// res[k++] = from;
		// for(int i=0;i<matrix[from].length;i++){
		// if(matrix[from][i] == 1){
		// matrix[from][i] =0;
		// indegree[i]--;
		// if(indegree[i] ==0)
		// queue.offer(i);
		// }
		// }
		// }
		// if(k==numCourses)
		// return res;
		// else
		// return new int[0];
		int[] res = new int[numCourses];
		int k = 0;
		// adjacency matrix
		// int[][] matrix = new int[numCourses][numCourses];
		// adjacency list
		List<Set<Integer>> posts = new ArrayList();
		for (int i = 0; i < numCourses; i++)
			posts.add(new HashSet<Integer>());
		LinkedList<Integer> queue = new LinkedList<Integer>();
		int[] indegree = new int[numCourses];
		for (int i = 0; i < pre.length; i++) {
			if (!posts.get(pre[i][1]).contains(pre[i][0])) {
				posts.get(pre[i][1]).add(pre[i][0]);
				indegree[pre[i][0]]++;
			}
		}
		for (int i = 0; i < numCourses; i++) {
			if (indegree[i] == 0)
				queue.offer(i);
		}
		while (!queue.isEmpty()) {
			int from = queue.poll();
			res[k++] = from;
			for (int to : posts.get(from)) {
				indegree[to]--;
				if (indegree[to] == 0)
					queue.offer(to);
			}
		}
		for (int d : indegree) {
			if (d != 0)
				return new int[0];
		}
		return res;
	}

	public int[] findOrder_new(int numCourses, int[][] prerequisites) {
		int[] res = new int[numCourses];
        Map<Integer, Set<Integer>> graph = new HashMap<>();
        int[] indegree = new int[numCourses];
        for(int[] course: prerequisites){
            int from = course[1];
            int to = course[0];
            if(!graph.containsKey(from))
                graph.put(from, new HashSet<Integer>());
            if(graph.get(from).add(to)) //here, we filter duplicate edges
                indegree[to]++;
        }
        Queue<Integer> queue = new LinkedList<>();
        for(int i = 0;i<numCourses; i++){
            if(indegree[i] == 0){
                queue.offer(i);
            }
        }
        int k = 0;
        while(!queue.isEmpty()){
            int node = queue.poll();
            res[k++] = node;
            if(!graph.containsKey(node))  //if this node does not have neighbors, continue
                continue;
            Set<Integer> neighbors = graph.get(node);
            for(int neighbor: neighbors){
                indegree[neighbor]--;
                if(indegree[neighbor] == 0){
                    queue.offer(neighbor);
                }
            }
        }
        if(k!=numCourses)
            return new int[0];
        return res;
	}

	public static void main(String[] args) {
//		int num = 4;
		// 10, [[5,8],[3,5],[1,9],[4,5],[0,2],[1,9],[7,8],[4,9]]
		// int[][] prerequisites = {{0,1},{3,1},{1,3},{3,2}};
//		int num = 10;
//		 int[][] prerequisites =
//		 {{5,8},{3,5},{1,9},{4,5},{0,2},{1,9},{7,8},{4,9}};
//		int[][] prerequisites = { { 1, 0 }, { 2, 0 }, { 3, 1 }, { 3, 2 } };
		int num = 2;
		int[][] prerequisites = {{1,0}};
		CourseSchedule cs = new CourseSchedule();
//		boolean good = cs.CanFinish(num, prerequisites);
//		System.out.println(good);
//		 int[] res = cs.findOrder_new(num, prerequisites);
		 int[] res = cs.myfindOrder(num, prerequisites);
		 for(int i:res )
			 System.out.print(i+" ");

	}
}
