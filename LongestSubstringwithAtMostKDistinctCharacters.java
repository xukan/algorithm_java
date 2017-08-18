package algorithm_java;

import java.util.HashMap;
import java.util.LinkedHashMap;

//Google

/*
 * Given a string, find the length of the longest substring T that contains at most k distinct characters.
 * For example, Given s = “eceba” and k = 2,
 * T is "ece" which its length is 3.
 * */

public class LongestSubstringwithAtMostKDistinctCharacters {
	public static int lengthOfLongestSubstringKDistinct(String s, int k) {
        if(k<=0)
            return 0;
        HashMap<Character, Integer> map = new HashMap<Character, Integer>();
        int l = 0;
        int maxLen = 0;
        for(int r=0;r<s.length();r++){
            char c = s.charAt(r);
            map.put(c, map.getOrDefault(c, 0)+1);
            while(map.size()>k){
                char c1 = s.charAt(l++);
                map.put(c1, map.get(c1)-1);
                if(map.get(c1) == 0){
                    map.remove(c1);
                }
            }
            maxLen = Math.max(r-l+1, maxLen);
        }
        return maxLen;
    }
	
	//follow-up
	//https://discuss.leetcode.com/topic/77147/solution-to-the-follow-up
	//This solution will then solve the follow up like input string are streamed and still solve in O(n) time.
	//To clarify the possible follow up. The interviewer may say that the string is given as a steam. 
	//In this situation, we can't maintain a "left pointer" as the classical O(n) hashmap solution.
	public int lengthOfLongestSubstringKDistinct_dataStream(String s, int k) {
        if(s==null || s.length()==0 || k<=0) return 0;
        int len=s.length();
        int i=0, j=0;
        int maxLen=0;
        LinkedHashMap<Character,Integer> map=new LinkedHashMap<Character,Integer>();
        for(char x:s.toCharArray()){
            if(map.containsKey(x)){
                map.remove(x);
                map.put(x,j);
            }else{
                if(map.size()==k){
                    maxLen=Math.max(maxLen,j-i);
                    char toRemove=map.keySet().iterator().next();
                    i=map.get(toRemove)+1;
                    map.remove(toRemove);
                }
                map.put(x,j);
            }
            j++;
        }
        maxLen=Math.max(maxLen,j-i);
        return maxLen;
    }
	
	
	public static void main(String[] args) {
		String s = "eceba";
		int res = lengthOfLongestSubstringKDistinct(s, 2);
		System.out.println(res);
	}
}
