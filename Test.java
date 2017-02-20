package algorithm_java;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;

class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;
	TreeNode(int x) {
		val = x;
	}
}
//class ListNode {
//	int val;
//    ListNode next;
//    ListNode(int x) { val = x; }
//}

public class Test {
	public List<List<String>> partition(String s) {
        List<List<String>> res = new ArrayList<List<String>>();
        List<String> temp = new ArrayList<String>();
        helper(s, 0, temp, res);
        return res;
    }
    
    public void helper(String s, int start, List<String> temp, List<List<String>> res){
        if(start == s.length()){
            res.add(new ArrayList<String>(temp));
            return;
        }
        for(int i=start;i<s.length();i++){
            if(isValid(s.substring(0, start))){
                temp.add(s.substring(0, start));
                helper(s.substring(start+1), i, temp, res);
                temp.remove(temp.size()-1);
            }
        }
    }
    
    public boolean isValid(String s){
        int i=0, j=s.length()-1;
        while(i<j){
            if(s.charAt(i)==s.charAt(j)){
            	i++;
            	j--;
            }else
                return false;
        }
        return true;
    }
	
    public static void main(String[] args){
    	String input = "aabaa";
    	Test s = new Test();
    	List<List<String>> res=s.partition(input);
    	for(List<String> l:res){  
    		for(String ss : l)
    			System.out.print(ss+" ");
    		System.out.println();
    	}
    }
}