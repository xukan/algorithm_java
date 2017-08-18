package algorithm_java;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

//Google

public class LongestWordinDictionarythroughDeleting {
	public static String findLongestWord(String s, List<String> d) {
        if(d==null || d.size()==0)
            return "";
        PriorityQueue<String> queue = new PriorityQueue<String>(new Comparator<String>(){
            public int compare(String s1, String s2){
                if(s1.length() == s2.length()){
                    return s1.compareTo(s2);
                }else
                    return Integer.compare(s2.length(), s1.length());
            }
        });
        for(String str: d){
            if(isSubsequence(s, str)){
                queue.offer(str);
            }
        }
        if(queue.isEmpty())
            return "";
        return queue.poll();
    }
    
    public static boolean isSubsequence(String s, String str){
        int lastIdx = -1;
        for(char c: str.toCharArray()){
            lastIdx = s.indexOf(c, lastIdx+1);
            if(lastIdx<0)
                return false;
        }
        return true;
    }
    
    public static void main(String[] args) {
    	String s = "abpcplea";
    	String[] array = {"ale","apple","monkey","plea"};
    	List<String> d = Arrays.asList(array);
		String res = findLongestWord(s, d);
		System.out.println(res);
	}
}
