package algorithm_java;

import java.util.ArrayList;
import java.util.List;

//yelp interview question

public class PermutateStringWithUpperLowerCase {
	public static void dfs(List<String> res, String s, int pos) {   
	    res.add(s);        
	    char[] arr = s.toCharArray();  
	    for (int i = pos; i < arr.length; i++) {
	        if (arr[i] <= 'z' && arr[i] >= 'a') {                
	            arr[i] = Character.toUpperCase(arr[i]);
	            dfs(res, new String(arr), i + 1);
	            arr[i] = Character.toLowerCase(arr[i]);        
	        }
	    }
	}

	public static void main(String[] args) {        
	    List<String> res = new ArrayList();
	    //String s = "hr3a";
	    String s = "a2c";
	    StringBuilder sb = new StringBuilder();
	    
	    dfs(res, s, 0);
	    for (String str : res) System.out.println(str);
	}
}	
