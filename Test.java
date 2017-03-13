package algorithm_java;


/*      1
	  /     \
	2       3
   /  \     / 
  4   5  6
      / \
     7  8     */
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Stack;

public class Test {
	public static String minWindow(String s, String t) {
		if(s.length()==0|| t.length()==0 || s.length()<t.length())
            return "";
        HashMap<Character, Integer> map = new HashMap<Character, Integer>();
        int l=0, minStart=0, count=0, len = t.length();
        int minLen = Integer.MAX_VALUE;
        for(int i=0;i<t.length();i++){
            char c = t.charAt(i);
            map.put(c, map.getOrDefault(c, 0)+1);
        }
        for(int r=0;r<s.length();r++){
            char c = s.charAt(r);
            if(map.containsKey(c)){
                map.put(c, map.get(c)-1);
                if(map.get(c)>=0)
                	 count++;
            }
            while(count == len){
            	if(r-l+1<minLen){
	                minStart = l;
	                minLen =  r-l+1;
                }
                char c1 = s.charAt(l);
                if(map.containsKey(c1)){
                    map.put(c1, map.get(c1)+1);
                    if(map.get(c1)>0){
                        count--;
                    }
                }
                l++;
            }
        }
        String res = s.substring(minStart, minStart+minLen);
        return res;
    }
	
	public static void main(String[] args) {
		
		//String s="ADOBECODEBANBC";
		//String t="ABBC";
//		String s="bba";
//		String t="ab";
		String s = "cabwefgewcwaefgcf";
		String t="cae";
		String res = minWindow(s,t);
		System.out.println(res);
	}
}