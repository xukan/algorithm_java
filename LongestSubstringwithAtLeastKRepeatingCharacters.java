package algorithm_java;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

//Baidu

//divide and conquer
//reference:
//http://www.guoting.org/leetcode/leetcode-395-longest-substring-with-at-least-k-repeating-characters/

public class LongestSubstringwithAtLeastKRepeatingCharacters {
	public static int longestSubstring(String s, int k) {
		int n=s.length();
        int[] count=new int[26];
        int max=0;
        for(int i=0;i<n;i++){
            count[s.charAt(i)-'a']++;
        }
        List<Integer> pos=new ArrayList<>();
        for(int i=0;i<n;i++){
            if(count[s.charAt(i)-'a']<k) pos.add(i);
        }
        if(pos.size()==0) return n;
        pos.add(0,-1);
        pos.add(n);
        for(int i=1;i<pos.size();i++){
            int start=pos.get(i-1)+1;
            int end=pos.get(i);
            max=Math.max(max,longestSubstring(s.substring(start,end),k));
        }
        return max;
    }
	
	public static void main(String[] args){
		//String s = "ababbc";
		String s = "ababacb";
		int res = longestSubstring(s, 2);
		System.out.println(res);
	}
}
