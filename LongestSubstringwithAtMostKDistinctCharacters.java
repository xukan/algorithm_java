package algorithm_java;

import java.util.HashMap;

//Google

/*
 * Given a string, find the length of the longest substring T that contains at most k distinct characters.
 * For example, Given s = “eceba” and k = 2,
 * T is "ece" which its length is 3.
 * */

public class LongestSubstringwithAtMostKDistinctCharacters {
	public static int lengthOfLongestSubstringKDistinct(String s, int k) {
//        s = s.toLowerCase();
        int len = s.length();
        HashMap<Character,Integer> map = new HashMap();
        int start = 0;
        int maxLen =0;
        int u = 0;
        for(int end=0;end<len;end++){
            char c1 = s.charAt(end);
            if(!map.containsKey(c1)){
                u++;
            }
            map.put(c1, map.getOrDefault(c1, 0)+1);
            while(u>k){
                char c2= s.charAt(start);
                map.put(c2, map.get(c2)-1);
                if(map.get(c2)==0){
                    u--;
                    map.remove(c2);
                }
                start++;
            }
            maxLen = Math.max(maxLen, end-start+1);
        }
        return maxLen;
    }
	
	public static void main(String[] args) {
		String s = "eceba";
		int res = lengthOfLongestSubstringKDistinct(s, 2);
		System.out.println(res);
	}
}
