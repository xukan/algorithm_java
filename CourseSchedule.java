package algorithm_java;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public class CourseSchedule {
	public boolean canFinish(int n, int[][] pre) {
        int[] indegree = new int[n];
        List<Set<Integer>> al = new ArrayList();
        for(int i=0;i<n;i++)
            al.add(new HashSet<Integer>());
        LinkedList<Integer> queue = new LinkedList();
        for(int i=0;i<pre.length;i++){
            if(al.get(pre[i][1]).add(pre[i][0]))  // input prerequisite may contain duplicate elements, so we need to guarantee indegree add once for each edge
                indegree[pre[i][0]]++;
        }
        for(int i=0;i<n;i++)
            if(indegree[i] == 0)
                queue.offer(i);
        while(!queue.isEmpty()){
            int from = queue.poll();
            for(int to: al.get(from)){
                indegree[to]--;
                if(indegree[to] == 0)
                    queue.offer(to);
            }
        }
        for(int i=0;i<n;i++){
            if(indegree[i]!=0)
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
        if(k==numCourses)
        	return res;
        else
        	return new int[0];
    }
	
	
	public static void main(String[] args){
		int num=10;
//  	10, [[5,8],[3,5],[1,9],[4,5],[0,2],[1,9],[7,8],[4,9]]
//  	int[][] prerequisites = {{0,1},{3,1},{1,3},{3,2}};
//		int[][] prerequisites = {{5,8},{3,5},{1,9},{4,5},{0,2},{1,9},{7,8},{4,9}};
		int[][] prerequisites = {{0,1}};
		CourseSchedule cs = new CourseSchedule();
		//boolean good = cs.canFinish(num, prerequisites);
		int[] res = cs.findOrder(num, prerequisites);
		for(int i:res )
			System.out.print(i+" ");
		
  	}
}
