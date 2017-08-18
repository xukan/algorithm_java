package algorithm_java;

import java.util.HashMap;
import java.util.HashSet;

//similar question
//isomophic strings

//Dropbox Uber

public class WordPattern {
	public static boolean wordPattern(String pattern, String str) {
        char[] array = pattern.toCharArray();
        String[] words = str.trim().split(" ");
        if(array.length!=words.length)
            return false;
        HashMap<Character, String> map = new HashMap();
        for(int i=0;i<array.length;i++){
            if(!map.containsKey(array[i])){
                if(!map.containsValue(words[i]))
                    map.put(array[i], words[i]);
                else
                    return false;
            }else{
                if(!map.get(array[i]).equals( words[i]))
                    return false;
            }
        }
        return true;
    }
	
	//II 
	public static boolean wordPatternMatch(String pattern, String str) {
	    if(pattern.length()==0 && str.length()==0)
	        return true;
	    if(pattern.length()==0)
	        return false;
	 
	    HashMap<Character, String> map = new HashMap<Character, String>();
	    HashSet<String> set = new HashSet<String>();
	    return helper(pattern, str, 0, 0, map, set);
	}
	 
	public static boolean helper(String pattern, String str, int i, int j, HashMap<Character, String> map, HashSet<String> set){
	    if(i==pattern.length() && j==str.length()){
	        return true;
	    }
	 
	    if(i>=pattern.length() || j>=str.length())
	        return false;
	 
	    char c = pattern.charAt(i);
	    for(int k=j+1; k<=str.length(); k++){
	        String sub = str.substring(j, k);
	        if(!map.containsKey(c) && !set.contains(sub)){
	            map.put(c, sub);
	            set.add(sub);
	            if(helper(pattern, str, i+1, k, map, set))
	                return true;
	            map.remove(c);
	            set.remove(sub);
	        }else if(map.containsKey(c) && map.get(c).equals(sub)){
	            if(helper(pattern, str, i+1, k, map, set))
	                return true;
	        }
	    }    
	    return false;
	}

	public static void main(String[] args) {
		String pattern = "abba";
		String str = "dog cat cat dog";
		boolean res = wordPattern(pattern, str);
		System.out.println(res);
		
		String pat= "abab", str1 = "redblueredblue";
		boolean res1 = wordPatternMatch(pat, str1);
		System.out.println(res1);
		
	}
}
