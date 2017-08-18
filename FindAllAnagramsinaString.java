package algorithm_java;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//Amazon

public class FindAllAnagramsinaString {
	public static List<Integer> findAnagrams(String s, String p) {
	    int[] chars = new int[26];
	    List<Integer> result = new ArrayList<>();

	    if (s == null || p == null || s.length() < p.length())
	        return result;
	    for (char c : p.toCharArray())
	        chars[c-'a']++;

	    int start = 0, end = 0, count = p.length();
	    // Go over the string
	    while (end < s.length()) {
	        // If the char at start appeared in p, we increase count
	        if (end - start == p.length() && chars[s.charAt(start++)-'a']++ >= 0)
	            count++;
	        // If the char at end appeared in p (since it's not -1 after decreasing), we decrease count
	        if (--chars[s.charAt(end++)-'a'] >= 0)
	            count--;
	        if (count == 0)
	            result.add(start);
	    }
	    
	    return result;
	}
	
//	public static List<Integer> findAnagrams(String s, String p) {
//        List<Integer> res = new ArrayList<Integer>();
//        int[] dict = new int[26];
//        for(char c : p.toCharArray())
//            dict[c-'a']++;
//        int len = s.length();
//        int l=0,r=0;
//        while(len-l>=p.length()){
//            int[] temp = Arrays.copyOf(dict, dict.length);
//            r= l;
//            while(r-l+1<=p.length()){
//                temp[s.charAt(r++)-'a']--;
//            }
//            if(match(temp))
//                res.add(l);
//            l++;
//        }
//        return res;
//    }
//    
//    public static boolean match(int[] temp){
//        for(int i: temp)
//            if(i!=0)
//                return false;
//        return true;
//    }
	
	public static void main(String[] args) {
		String s= "cbacebabacd";
		String p= "abc";
		List<Integer> res = findAnagrams(s, p);
		for(int i: res)
			System.out.print(i+" ");
	}
}
