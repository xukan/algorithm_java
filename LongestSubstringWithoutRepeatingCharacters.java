package algorithm_java;

import java.util.HashSet;
import java.util.Set;

//Amazon Adobe Bloomberg Yelp

//two pointers, tc: O(n)
public class LongestSubstringWithoutRepeatingCharacters {
	public static int lengthOfLongestSubstring(String s) {
        int i=0, j=0, max = 0;
        HashSet<Character> set = new HashSet();
        while(j<s.length()){
            char c = s.charAt(j);
            if(set.add(c)){
                j++;
                max = Math.max(max, set.size());
            }else
                set.remove(s.charAt(i++));
        }
        return max;
    }
	
	public static void main(String[] args) {
		//String input = "pwwkew";
		String input = "au";
		int len = lengthOfLongestSubstring( input );
		System.out.println( len );
	}
}
