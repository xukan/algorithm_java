package algorithm_java;

import java.util.HashMap;

//Google

public class LongestSubstringwithAtMostTwoDistinctCharacters {
	public static int lengthOfLongestSubstringTwoDistinct(String s) {
        HashMap<Character, Integer> map = new HashMap<Character, Integer>();
        int l = 0;
        int len = 0;
        for(int r=0;r<s.length();r++){
            char c = s.charAt(r);
            if(!map.containsKey(c) && map.size()>=2){
                while(map.size()>=2 && l <s.length()){
                    char c1 = s.charAt(l++);
                    map.put(c1, map.get(c1)-1);
                    if(map.get(c1) == 0){
                        map.remove(c1);
                    }
                }
            }
            if(!map.containsKey(c) && map.size()<2){
                map.put(c, 1);
                len = Math.max(r-l+1, len);
            }else if(map.containsKey(c)){
                map.put(c, map.get(c)+1);
                len = Math.max(r-l+1, len);
            }
        }
        return len;
    }
	
	public static void main(String[] args) {
		String s = "abcabcabc";
		String s1 = "eceeba";
		int res = lengthOfLongestSubstringTwoDistinct(s1);
		System.out.println(res);
	}
}
