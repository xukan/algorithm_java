package algorithm_java;

import java.util.HashMap;
import java.util.Map;

//LinkedIn Snapchat Uber Facebook
/*
 * hashmap, two pointers
 * 这道题思路是双指针,先遍历字符串t, 记录每个字符的频率
 * 遍历s,每次出现t中的字符,对应的字符频率减1,当map中的values全部为0,说明找到了t的所有字符,
 * count保持查找字符串t的长度,count==t.length(),说明已经在s中找到了t的所有字符,此时map中的value都为0
 * 这时移动左指针,根据需要并更新子串长度,minStart记录左指针位置
 * */

public class MinimumWindowSubstring {
	public static String minWindow(String s, String t) {
        if(s.length()==0|| t.length()==0 || s.length()<t.length())
            return "";
        Map<Character, Integer> map = new HashMap<>();
        for(char c: t.toCharArray()){
            map.put(c, map.getOrDefault(c, 0)-1);
        }
        int i=0, j=0;
        int minStart = 0, minLen = Integer.MAX_VALUE;
        int count = 0;
        while(j<s.length()){
            char c = s.charAt(j);
            if(map.containsKey(c)){
                map.put(c, map.get(c)+1);
                if(map.get(c)<=0)
                	//这里只有map中对应字符c的频率小于0才能说明出现的是有效字符,比如s="BBB", t= "BC",连续出现B
                	//那么字符B的频率会>0,但是并不是t中的字符
                    count++;
                while(count == t.length()){
                    if(j-i+1<minLen){
                        minStart = i;
                        minLen = j-i+1;
                    }
                    char c1 = s.charAt(i++);
                    if(map.containsKey(c1)){
                        map.put(c1, map.get(c1)-1);
                        if(map.get(c1)<0)
                            count--;
                    }
                }
            }
            j++;
        }
        if(minLen>s.length())
            return "";
        return s.substring(minStart, minStart+minLen);
    }
	
	//solutionII is very similar to solutionI
	public String minWindow_similar(String s, String t) {
        if(s.length() == 0 || t.length() == 0 || s.length() < t.length())
            return "";
        Map<Character, Integer> map = new HashMap<>();
        for(char c: t.toCharArray())
            map.put(c, map.getOrDefault(c, 0)+1);
        int minLen = Integer.MAX_VALUE;
        int count = t.length();
        int minStart = 0, i = 0;
        int j=0;
        for(;j<s.length();j++){
            char c = s.charAt(j);
            if(map.containsKey(c)){
                map.put(c, map.get(c)-1);
                if(map.get(c)>=0)
                    count--;
                while(count== 0){
                    if(j-i +1<minLen ){
                        minLen = j-i+1;
                        minStart = i;
                    }
                    char c1 = s.charAt(i);
                    if(map.containsKey(c1)){
                        map.put(c1, map.get(c1)+1);
                        if(map.get(c1)>0)
                            count++;
                    }
                    i++;
                }
            }
        }
        return minLen == Integer.MAX_VALUE?"":s.substring(minStart, minStart+minLen);
    }
	
	public static void main(String[] args) {
		String s = "a";
		String t	=	"b";
//		String s="ADOBECODEBANBC";
//		String t="ABBC";
//		String s="bba";
//		String t="ab";
//		String s = "cabwefgewcwaefgcf";
//		String t = "cae";
		String res = minWindow(s,t);
		System.out.println(res);
	}
}
