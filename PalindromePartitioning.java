package algorithm_java;

import java.util.ArrayList;
import java.util.List;

public class PalindromePartitioning {
	public List<List<String>> partition(String s) {
        List<List<String>> res = new ArrayList<List<String>>();
        List<String> temp = new ArrayList<String>();
        dfs(s, 0, temp, res);
        return res;
    }
    
	public void dfs(String s, int start, List<String> temp, List<List<String>> res){
		if(start == s.length()){
			res.add(new ArrayList<String>(temp));
			return;
		}
		for(int i=start;i<s.length();i++){
			String str = s.substring(start, i+1);
			if(isValidPalindrome(str)){
				temp.add(str);
				dfs(s, i+1, temp, res);
				temp.remove(temp.size()-1);
			}
		}
	}
    
    
    public boolean isValidPalindrome(String str){
    	int low =0;
    	int high = str.length()-1;
    	while(low<high){
    		if(str.charAt(low)==str.charAt(high)){
    			low++;
    			high--;
    		}
    		else{
    			return false;
    		}
    	}
    	return true;
    }
    
    public static void main(String[] args){
    	//String input = "aabaa";
    	String input = "aaaba";
    	PalindromePartitioning s = new PalindromePartitioning();
    	List<List<String>> res=s.partition(input);
    	for(List<String> l:res){  
    		for(String ss : l)
    			System.out.print(ss+" ");
    		System.out.println();
    	}
    }
}
