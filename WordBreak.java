package algorithm_java;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//Google Uber Facebook Amazon Yahoo Bloomberg Pocket Gems

//II
//Dropbox Google Uber Snapchat Twitter

public class WordBreak {
	/*
	 * 用一个boolean数组表示到字符串第j个位置子串[i, j]是否在dict中,从第i个位置开始查找，
	 * 比如"leetcode",
	 * pos[4]=true表示"leet"在dict中,从下一个字符开始查找，最后看pos[len]是否是true
	 * tc: O(n^2)
	 * sc: O(n)
	 * */
	public boolean wordBreak(String s, List<String> wordDict) {
		int len = s.length();
        boolean[] pos = new boolean[len+1];
        pos[0] = true;
        for(int i=0;i<len;i++){
            if(pos[i]){
                for(int j=i+1;j<=len;j++){
                    String sub = s.substring(i, j);
                    if(wordDict.contains(sub))
                        pos[j]=true;
                }
            }
        }
        return pos[len];
    }
	
	public static List<String> wordBreakII(String s, List<String> wordDict) {
	    ArrayList<String> [] pos = new ArrayList[s.length()+1];
	    pos[0]=new ArrayList<String>();
	 
	    for(int i=0; i<s.length(); i++){
	        if(pos[i]!=null){
	            for(int j=i+1; j<=s.length(); j++){
	                String sub = s.substring(i,j);
	                if(wordDict.contains(sub)){
	                    if(pos[j]==null){
	                        ArrayList<String> list = new ArrayList<String>();
	                        list.add(sub);
	                        pos[j]=list;
	                    }else{
	                        pos[j].add(sub);
	                    }
	                }
	            }
	        }
	    }
	 
	    if(pos[s.length()]==null){
	        return new ArrayList<String>();
	    }else{
	        ArrayList<String> result = new ArrayList<String>();
	        dfs(pos, result, "", s.length());
	        return result;
	    }
	}
	 
	public static void dfs(ArrayList<String> [] pos, ArrayList<String> result, String curr, int i){
	    if(i==0){
	        result.add(curr.trim());
	        return;
	    }
	 
	    for(String s: pos[i]){
	        String combined = s + " "+ curr;
	        dfs(pos, result, combined, i-s.length());
	    }
	}
	
	
	public static void main(String[] args) {
		//word break I
		String str1 = "leetcode";
		List<String> dict1 = new ArrayList<String>();
		dict1.add("leet");
		dict1.add("code");
		WordBreak s = new WordBreak();
		boolean flag = s.wordBreak(str1, dict1);
		System.out.println(flag);
		
		//word break II
		String str2 = "catsanddog";
		List<String> dict2 = new ArrayList<String>();
		String[] arr = {"cat", "cats", "and", "sand", "dog"};
		for(String ss: arr)
			dict2.add(ss);
		List<String> res = s.wordBreakII(str2, dict2);
		for(String str: res)
			System.out.println(str+ " ");
	}
}
