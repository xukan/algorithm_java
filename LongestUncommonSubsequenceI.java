package algorithm_java;

import java.util.Arrays;

//I and II both from Google

public class LongestUncommonSubsequenceI {
	
	//I
	public static  int findLUSlength(String a, String b) {
        if(a.equals(b))
            return -1;
        return Math.max(a.length(), b.length());
    }
	
	//II
	public static int findLUSlength(String[] strs) {
        Arrays.sort(strs, (String s1, String s2)->(s2.length() - s1.length()));
        for(String s: strs)
        	System.out.println(s);
        int len = strs.length;
        boolean bar = false;
        for(int i=0;i<len;i++){
            int count = len-1;
            for(int j=0;j<len;j++){
            	if( strs[i].equals(strs[j])){
            		continue;
            	}
                if(!isSubsequence(strs[i], strs[j])){
                    count--;
                }
            }
            if(count ==0)
                return strs[i].length();
        }
        return -1;
    }
    
    public static boolean isSubsequence(String s1, String s2){
        int l1=0;
        for(char c : s2.toCharArray()){
            if(l1<s1.length() && c == s1.charAt(l1))
                l1++;
        }
        return l1 == s1.length();
    }
	
	public static void main(String[] args) {
		String[] strs = { "aba", "cdce", "eaeda", "eacca" };
		String[] strs1 = {"aabbcc", "aabbcc","cb","abc","mmnnqq"};
		String[] strs2 = {"aaa","aaa","aa"};
		String[] strs3 = {"aabbcc", "aabbcc","c","e","aabbcd"};
		int res = findLUSlength(strs3);
		System.out.println(res);
	}
}
