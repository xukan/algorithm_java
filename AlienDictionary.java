package algorithm_java;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

public class AlienDictionary {
	public static String alienOrder(String[] words) {
        HashMap<Character, Set<Character>> map = new HashMap();
        HashMap<Character, Integer> degree = new HashMap();
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
	
	public static void main(String[] args) {
		//String[] words = {"wrt", "wrf", "er","ett", "rftt"};
		String[] words ={"za","zb","ca","cb"};
		String order = alienOrder(words);
		System.out.println(order);
	}
}
