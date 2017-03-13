package algorithm_java;

import java.util.HashMap;

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
        HashMap<Character, Integer> map = new HashMap<Character, Integer>();
        int l=0, minStart=0, minLen=Integer.MAX_VALUE, count=0;
        int len = t.length();
        for(int i=0;i<len;i++){
            char c = t.charAt(i);
            map.put(c, map.getOrDefault(c, 0)+1);
        }
        for(int r=0;r<s.length();r++){
            char c = s.charAt(r);
            if(map.containsKey(c)){
                map.put(c, map.get(c)-1);
                if(map.get(c)>=0)//注意如果map.get(c)<0说明s中对应的key的频率超过了t中的key,比如s="aa", t="a", map=[a, -1],这时count++是不对的,只有在map.get(c)>=0时,count++
                    count++;
            }
            while(count==len){
                if(r-l+1<minLen){//minStart只有在r-l+1<minLen时才更新
                    minStart = l;
                    minLen = r-l+1;
                }
                char c1 = s.charAt(l);
                if(map.containsKey(c1)){
                    map.put(c1, map.get(c1)+1);
                    if(map.get(c1)>0)
                        count--;
                }
                l++;
            }
        }
        if(minLen>s.length())
            return "";
        return s.substring(minStart, minStart+minLen);
    }
	
	public static void main(String[] args) {
//		String s="ADOBECODEBANBC";
//		String t="ABBC";
//		String s="bba";
//		String t="ab";
		String s = "cabwefgewcwaefgcf";
		String t = "cae";
		String res = minWindow(s,t);
		System.out.println(res);
	}
}
