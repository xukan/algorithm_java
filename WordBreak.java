package algorithm_java;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
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
        for (int i = 1; i <= len; i++) {
			for (int j = 0; j < i; j++) {
				if (!pos[j])
					continue;
				String sub = s.substring(j, i);
				if (wordDict.contains(sub)) {
					pos[i] = true;
					break;//important
				}
			}
		}
        return pos[len];
    }
	
	//backtracking memorization
	//tc: tc for backtracking is O(2^n), since we use memorization, it decreases to O(n^2)
	HashMap<String,List<String>> map = new HashMap<String,List<String>>();
    public List<String> wordBreakII(String s, List<String> wordDict) {
        List<String> res = new ArrayList<String>();
        if(s.length() == 0) {
            return res;
        }
        if(map.containsKey(s)) {
            return map.get(s);
        }
        if(wordDict.contains(s)) {
            res.add(s);
        }
        for(int i = 1 ; i < s.length() ; i++) {
            String t = s.substring(0,i);
            if(wordDict.contains(t)) {
            	String str = s.substring(i);
                List<String> temp = wordBreakII( str, wordDict);
                for(String sub: temp) {
                	res.add(t+ " "+ sub );
                }
            }
        }
        map.put(s , res);
        return res;
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
