package algorithm_java;

import java.util.LinkedList;
import java.util.Queue;

//Facebook

public class ValidPalindromeII {
	public boolean validPalindrome(String s) {
        if(s.length() == 0)
            return false;
        int l = 0, r = s.length()-1;
        while(l<r){
            if(s.charAt(l) == s.charAt(r)){
                l++;
                r--;
            }else{
                return helper(s, l, r-1) || helper(s, l+1, r);
            }
        }
        return true;
    }
    
    public boolean helper(String s, int l, int r){
        while(l<r){
            if(s.charAt(l) == s.charAt(r)){
                l++;
                r--;
            }else
                return false;
        }
        return true;
    }
	
	
	public static void main(String[] args) {
		ValidPalindromeII s = new ValidPalindromeII();
//		String input = "aguokepatgbnvfqmgmlcupuufxoohdfpgjdmysgvhmvffcnqxjjxqncffvmhvgsymdjgpfdhooxfuupucu******lmgmqfvnbgtapekouga";
//		String input = "aguokepatgbnvfqmgmlcupuufxoohdfpgjdmysgvhmvffcnqxjjxqncffvmhvgsymdjgpfdhooxfuupuculmgmqfvnbgtapekouga";
		String input = "oebddcaacddkbe";
		boolean res = s.validPalindrome(input);
		System.out.println(res);
	}
}
