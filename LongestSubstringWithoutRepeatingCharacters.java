package algorithm_java;

import java.util.HashSet;
import java.util.Set;

//Amazon Adobe Bloomberg Yelp

public class LongestSubstringWithoutRepeatingCharacters {
	public int lengthOfLongestSubstring(String s) {
		int slow=0, fast =0, maxLen = 0;
        HashSet<Character> hashset = new HashSet<Character>();
        while( fast < s.length() ){
            char c = s.charAt( fast );
            if( hashset.contains( c ) ){
                maxLen = Math.max( maxLen, fast-slow );
                while( s.charAt(slow) != c ){
                    hashset.remove( s.charAt(slow) );
                    slow++;
                }
                slow++;
                fast++;
            }else{
                fast++;
                hashset.add(c);
            }
        }
        return Math.max( maxLen, fast-slow );
    }
	
	public static void main(String[] args) {
		//String input = "pwwkew";
		String input = "au";
		LongestSubstringWithoutRepeatingCharacters solution = new 
				LongestSubstringWithoutRepeatingCharacters();
		int len = solution.lengthOfLongestSubstring( input );
		System.out.println( len );
	}
}
