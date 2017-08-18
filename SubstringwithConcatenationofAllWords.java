package algorithm_java;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
//https://leetcode.com/problems/find-all-anagrams-in-a-string/#/solutions

//similar questions
//https://leetcode.com/problems/minimum-window-substring/
//https://leetcode.com/problems/longest-substring-without-repeating-characters/
//https://leetcode.com/problems/substring-with-concatenation-of-all-words/
//https://leetcode.com/problems/longest-substring-with-at-most-two-distinct-characters/
//https://leetcode.com/problems/find-all-anagrams-in-a-string/

public class SubstringwithConcatenationofAllWords {
	public static List<Integer> findSubstring(String S, String[] L) {
	    List<Integer> res = new ArrayList<Integer>();
        if (S == null || L == null || L.length == 0) return res;
        int len = L[0].length(); // length of each word
        
        Map<String, Integer> map = new HashMap<String, Integer>(); // map for L
        for (String w : L)
            map.put(w, map.getOrDefault(w, 0)+ 1);
        
        for (int i = 0; i <= S.length() - len * L.length; i++) {
            Map<String, Integer> copy = new HashMap<String, Integer>(map);
            for (int j = 0; j < L.length; j++) { // checkc if match
                String str = S.substring(i + j*len, i + j*len + len); // next word
                if (copy.containsKey(str)) { // is in remaining words
                    int count = copy.get(str);
                    if (count == 1) copy.remove(str);
                    else copy.put(str, count - 1);
                    if (copy.isEmpty()) { // matches
                        res.add(i);
                        break;
                    }
                } else break; // not in L
            }
        }
        return res;
   	}
	
	//solution2, faster
	public static List<Integer> findSubstring_faster(String s, String[] words) {
        List<Integer> res = new ArrayList<Integer>();
        if(s == null || s.length() == 0 || words == null)
            return res;
        int wordlen = words[0].length();
        int len = words.length;
        HashMap<String, Integer> map = new HashMap<String, Integer>();
        for(String word: words)
            map.put(word, map.getOrDefault(word, 0)+1);
               
        for(int i=0;i<wordlen;i++){
        	//最外层的循环很重要，是一种错位检查，
//    		String s="abarfoobarthefoobarman";
//    		String[] t={"foo", "bar"};
//        	这个例子就是从第二个字符开始出现t中的字符串连接的
        	HashMap<String,Integer> curMap = new HashMap<String,Integer>();  
            int count = 0;  
            int left = i;  
            for(int j=i;j<=s.length()-wordlen;j+=wordlen)  {  
                String str = s.substring(j,j+wordlen);  
                if(map.containsKey(str)){  
                    if(curMap.containsKey(str))  
                        curMap.put(str,curMap.get(str)+1);  
                    else  
                        curMap.put(str,1);  
                    if(curMap.get(str)<=map.get(str))  
                        count++;  
                    else{  
//                		String s="abababab";  //这个例子用于测试while这部分代码
//                		String[] t={"a","b","a"};
                        while(curMap.get(str)>map.get(str))  
                      //当出现bab这种情况时，b的次数为2>1,因此需要把left继续左移
                        {  
                            String temp = s.substring(left,left+wordlen);  
                            if(curMap.containsKey(temp)){  
                                curMap.put(temp,curMap.get(temp)-1); 
//                        		String s ="aaabbbc";
//                        		String[] t ={"a","a","b","b","c"};
//                                这个例子用来测试接下来的两行代码
                                if(curMap.get(temp)<map.get(temp))  
                                    count--;  
                            }  
                            left += wordlen;  
                        }  
                    }  
                    if(count == words.length){  
                        res.add(left);  
                        String temp = s.substring(left,left+wordlen);  
                        if(curMap.containsKey(temp))  
                            curMap.put(temp,curMap.get(temp)-1);  
                        count--;  
                        left += wordlen;  
                    }  
                }else{  
                    curMap.clear();  
                    count = 0;  
                    left = j+wordlen;  
                }  
            }  
        }
        return res;
    }
	
	public static void main(String[] args){
		String s="abarfoobarthefoobarman";
		String[] t={"foo", "bar"};
//		String s="abababab";  //这个例子
//		String[] t={"a","b","a"};
//		String s ="aaabbbc";
//		String[] t ={"a","a","b","b","c"};
//		String s = "wordgoodgoodgoodbestword";
//		String[] t=	{"word","good","best","good"};
		List<Integer> res = findSubstring(s,t);
		for(int i : res)
			System.out.print(i+" ");
	}
}
