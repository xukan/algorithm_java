package algorithm_java;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

//无向图检测环的方法
//http://www.cnblogs.com/tenosdoit/p/3644225.html
//认为这种方法是一个BFS
//http://www.programcreek.com/2014/05/leetcode-course-schedule-java/
//

public class CourseSchedule {
	public boolean canFinish(int numCourses, int[][] prerequisites) {
        if(prerequisites.length ==0)
            return true;
        HashMap<Integer, Integer> degree = new HashMap();
        HashMap<Integer, Set<Integer>> al = new HashMap();
        for(int[] link: prerequisites){
            if(!al.containsKey(link[1]))
                al.put(link[1], new HashSet<Integer>());
            if(!degree.containsKey(link[0]))
                degree.put(link[0],0);
            if(!degree.containsKey(link[1]))
                degree.put(link[1], 0);
            if(al.get(link[1]).add(link[0]))  // input prerequisite may contain duplicate elements, so we need to guarantee indegree add once for each edge
                degree.put(link[0],degree.get(link[0])+1);
        }
        LinkedList<Integer> queue = new LinkedList();
        for(int course: degree.keySet())
            if(degree.get(course)==0)
                queue.offer(course);
        List<Integer> courses = new ArrayList(); 
        while(!queue.isEmpty()){
            int from = queue.poll();
            courses.add(from);
            if(al.get(from)==null)
            	continue;
            for(int to: al.get(from)){
                degree.put(to, degree.get(to)-1);
                if(degree.get(to) == 0)
                    queue.offer(to);
            }
        }
        for(Map.Entry<Integer, Integer> entry: degree.entrySet()){
        	if(entry.getValue()!=0)
        		return false;
        }
        return true;
    }
	
	//II
	public int[] findOrder(int numCourses, int[][] pre) {
		//adjacency matrix
//        int[] res = new int[numCourses];
//        int k=0;
//        int[][] matrix = new int[numCourses][numCourses];
//        LinkedList<Integer> queue = new LinkedList<Integer>();
//        int[] indegree = new int[numCourses];
//        for(int i=0;i<pre.length;i++){
//        	matrix[pre[i][1]][pre[i][0]] = 1;
//        	indegree[pre[i][0]]++;
//        }
//        for(int i=0;i<numCourses;i++){
//        	if(indegree[i] == 0)
//        		queue.offer(i);
//        }
//        while(!queue.isEmpty()){
//        	int from = queue.poll();
//        	res[k++] = from;
//        	for(int i=0;i<matrix[from].length;i++){
//        		if(matrix[from][i] == 1){
//        			matrix[from][i] =0;
//        			indegree[i]--;
//        			if(indegree[i] ==0)
//        				queue.offer(i);
//        		}
//        	}
//        }
//        if(k==numCourses)
//        	return res;
//        else
//        	return new int[0];
		int[] res = new int[numCourses];
        int k=0;
        //adjacency matrix
        //int[][] matrix = new int[numCourses][numCourses];
        //adjacency list
        List<Set<Integer>> posts= new ArrayList();
        for(int i=0;i<numCourses;i++)
        	posts.add(new HashSet<Integer>());
        LinkedList<Integer> queue = new LinkedList<Integer>();
        int[] indegree = new int[numCourses];
        for(int i=0;i<pre.length;i++){
            if(!posts.get(pre[i][1]).contains(pre[i][0])){
	        	posts.get(pre[i][1]).add(pre[i][0]);
	        	indegree[pre[i][0]]++;
            }
        }
        for(int i=0;i<numCourses;i++){
        	if(indegree[i] == 0)
        		queue.offer(i);
        }
        while(!queue.isEmpty()){
        	int from = queue.poll();
        	res[k++] = from;
        	for(int to:posts.get(from)){
        			indegree[to]--;
        			if(indegree[to] ==0)
        				queue.offer(to);
        	}
        }
        for(int d: indegree){
            if(d!=0)
                return new int[0];
        }
        return res;
    }
	
	
	public int[] findOrder_new(int numCourses, int[][] prerequisites) {
        int[] indegree = new int[numCourses];
        HashMap<Integer, HashSet<Integer>> graph = new HashMap<>();
        for(int[] link: prerequisites){
            if(!graph.containsKey(link[1]))
                graph.put(link[1], new HashSet<Integer>());
            if(!graph.containsKey(link[0]))
                graph.put(link[0], new HashSet<Integer>());
            graph.get(link[1]).add(link[0]);
            indegree[link[0]]++;
        }
        LinkedList<Integer> queue = new LinkedList<>();
        for(int i=0;i<numCourses;i++)
            if(indegree[i] == 0)
                queue.offer(i);
        List<Integer> path = new ArrayList<>();
        while(!queue.isEmpty()){
            int from = queue.poll();
            path.add(from);
            for(int to: graph.get(from)){
            	indegree[to]--;
                if(indegree[to] == 0)
                    queue.offer(to);
            }
        }
        return path.stream().mapToInt(i->i).toArray();
    }
	
	public static void main(String[] args){
		int num=4;
//  	10, [[5,8],[3,5],[1,9],[4,5],[0,2],[1,9],[7,8],[4,9]]
//  	int[][] prerequisites = {{0,1},{3,1},{1,3},{3,2}};
//		int[][] prerequisites = {{5,8},{3,5},{1,9},{4,5},{0,2},{1,9},{7,8},{4,9}};
		int[][] prerequisites = {{1,0},{2,0},{3,1},{3,2}};
		CourseSchedule cs = new CourseSchedule();
		//boolean good = cs.canFinish(num, prerequisites);
		int[] res = cs.findOrder_new(num, prerequisites);
//		int[] res = cs.findOrder(num, prerequisites);
		for(int i:res )
			System.out.print(i+" ");
		
  	}
}
