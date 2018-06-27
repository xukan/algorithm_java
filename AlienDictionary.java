package algorithm_java;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

//Google Airbnb Facebook Twitter Snapchat Pocket Gems 

//similar question
//Course Schedule II

/*
 * To solve this question, we need to get topological sort from directed graph
 * To construct the graph, we need to build adjacency list
 * To get topological sort, we need to know indegree of each vertex
 * Don't forget to initialize the graph, each vertex need a adjacency list, even it is empty.
 * each vertex need a initial indegree which is 0
 * */

//tc: O(n*max(len of word in words)), n is number of word from input array
//sc: O(V), v is number of vertices in graph
public class AlienDictionary {
	public static String alienOrder(String[] words) {
        HashMap<Character, Set<Character>> map = new HashMap();
        HashMap<Character, Integer> degree = new HashMap();
        //Graph initailization
        for(String word: words)
            for(char c: word.toCharArray()){
                degree.putIfAbsent(c, 0);
                map.putIfAbsent(c, new HashSet());
            }
        for(int i=0;i+1<words.length;i++){
            String word1 = words[i];
            String word2 = words[i+1];
            int size = Math.min(word1.length(), word2.length());
            for(int j=0;j<size;j++){
                char c1 = word1.charAt(j);
                char c2 = word2.charAt(j);
                if(c1 != c2){
                    Set<Character>set = map.get(c1);
                    if(!set.contains(c2)){
                        map.get(c1).add(c2);
                        degree.put(c2, degree.get(c2)+1);
                    }
                    break;
                }
            }
        }
        //char start = '';
        LinkedList<Character> queue = new LinkedList();
        for(char c: degree.keySet()){
            if(degree.get(c)==0){
            	queue.offer(c);
            }
        }
        String res = "";
        while(!queue.isEmpty()){
            char from = queue.poll();
            degree.remove(from);
            res+=from;
            Set<Character> set = map.get(from);
            for(char to : set){
                degree.put(to, degree.get(to)-1);
                if(degree.get(to)==0)
                    queue.offer(to);
            }
        }
        if(res.length()!=map.size())
        	return "";
        return res;
    }
	
	public static String AlienOrder(String[] words) {
        if(words.length == 0)
            return "";
        Map<Character, List<Character>> graph = new HashMap<>();
        Map<Character, Integer> indegree = new HashMap<>();
        for(int i=0;i<words.length-1;i++){
            int len = Math.min(words[i].length(), words[i+1].length());
            for(int j=0;j<len;j++){
                char c1 = words[i].charAt(j);
                char c2 = words[i+1].charAt(j); 
                if(c1!=c2){
                    if(!graph.containsKey(c1))
                        graph.put(c1, new ArrayList<Character>());
                    if(!graph.containsKey(c2))
                        graph.put(c2, new ArrayList<Character>());
                    graph.get(c1).add(c2);
                    if(!indegree.containsKey(c1))
                    	indegree.put(c1, 0);
                    indegree.put(c2, indegree.getOrDefault(c2, 0)+1);
                    break;
                }
            }
        }
        Queue<Character> queue = new LinkedList<>();
        for(char key: indegree.keySet())
            if(indegree.get(key)==0)
                queue.offer(key);
        StringBuilder sb = new StringBuilder();
        while(!queue.isEmpty()){
            char c = queue.poll();
            sb.append(c);
            List<Character> tos = graph.get(c);
            for(char to: tos){
            	indegree.put(to, indegree.get(to)-1);
                if(indegree.get(to) ==0)
                    queue.offer(to);
            }
        }
        if( sb.length() != graph.size())
        	return "";
        return sb.toString();
    }
	
	
	public static void main(String[] args) {
//		String[] words = {"wrt", "wrf", "er","ett", "rftt"};
//		String[] words ={"za","zb","ca","cb"};
//		String[] words = {"wrt","wrf","er","ett","rftt","te"};
		String[] words ={"z","z"};
		String order = AlienOrder(words);
		System.out.println(order);
	}
}
