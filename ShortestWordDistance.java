package algorithm_java;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

//LinkedIn

public class ShortestWordDistance {
	/*
	 * We can greatly improve on the brute-force approach by keeping two indices i1 and i2 where we store the most recent locations of word1 and word2. 
	 * Each time we find a new occurrence of one of the words, we do not need to search the entire array for the other word, 
	 * since we already have the index of its most recent occurrence.
	 * */
	public int shortestDistanceI(String[] words, String word1, String word2) {
        int min = words.length;
        int p1 = -1, p2 = -1;
        for(int i=0;i<words.length;i++){
            if(words[i].equals(word1))
                p1 = i;
            if(words[i].equals(word2))
                p2 = i;
            if(p1!=-1 && p2!=-1)
                min = Math.min(Math.abs(p1-p2), min);
        }
        return min;
    }
	
	//Shortest Word Distance II
	/*
	 * 注意这一问和第一问的区别,这一问是说shortest函数会被调用多次,那么就不能没调用一次再像第一问中那样扫面一遍整个输入数组
	 * 一个比较好的方法是用HashMap把每个字符串的位置都存下来,这样比较的时候就不用先扫描数组了
	 * */
	HashMap<String, List<Integer>> map;
    public ShortestWordDistance(String[] words) {
        map = new HashMap<String, List<Integer>>();
        for(int i=0;i<words.length;i++){
            String word = words[i];
            if(!map.containsKey(word))
                map.put(word, new ArrayList<Integer>());
            map.get(word).add(i);
        }
    }
    
    public int shortest(String word1, String word2) {
        List<Integer> l1 = map.get(word1);
        List<Integer> l2 = map.get(word2);
        int i=0, j=0;
        int min = Integer.MAX_VALUE;
        while(i<l1.size() && j<l2.size()){
            min = Math.min(min, Math.abs(l1.get(i)-l2.get(j)));
            if(l1.get(i)<l2.get(j))
                i++;
            else
                j++;
        }
        return min;
    }
    
    //The only difference is now word1 could be the same as word2.
    public int shortestWordDistanceIII(String[] words, String word1, String word2) {
        int p1=-1, p2=-1;
        int min = Integer.MAX_VALUE;
        for(int i=0;i<words.length;i++){
            if(words[i].equals(word1)){
                if(word1.equals(word2) && p1!=-1){
                    p2 = p1;
                }
                p1 = i;
            }
            if(words[i].equals(word2)){
                if(!word1.equals(word2))
                    p2 = i;
            }
            if(p1!=-1 && p2!=-1){
                min = Math.min(min, Math.abs(p1-p2));
            }
        }
        return min;
    }
}
