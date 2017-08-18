package algorithm_java;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class PermutationinString {
//	public static boolean checkInclusion(String s1, String s2) {
//        int[] count = new int[128];
//        for(int i = 0; i < s1.length(); i++)
//        	count[s1.charAt(i)]--;
//        for(int l = 0, r = 0; r < s2.length(); r++) {
//            if (++count[s2.charAt(r)] > 0)
//                while(--count[s2.charAt(l++)] != 0) { /* do nothing */}
//            else if ((r - l + 1) == s1.length())
//            	return true;
//        }
//        return s1.length() == 0;
//    }
    
	public static boolean checkInclusion(String s1, String s2) {
		int[] count = new int[26];
		for(char c: s1.toCharArray())
			count[c-'a']--;
		for(int l=0, r=0;r<s2.length();r++){
			if(++count[s2.charAt(r)-'a']>0){
//				while(--count[s2.charAt(l)-'a']!=0){
//				}
				while(l <= r){
	                if(--count[s2.charAt(l)-'a'] == 0){
	                    l++;
	                    break;
	                }
	                l++;
	            }      
			}else if( r-l+1 == s1.length())
				return true;
		}
		return s1.length()==0;
	}
	
    public static void main(String[] args) {
//    	String s1 = "hello";
//    	String s2 = "ooolleoooleh";
    	
    	String s1 = "ab";
    	String s2 = "eidbaooo";
    	boolean res = checkInclusion(s1, s2);
    	System.out.println(res);
	}
    
}
