package algorithm_java;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GroupAnagrams {
//	solutionI, sorting
//	public List<List<String>> groupAnagrams(String[] strs) {
//        List<List<String>> res = new ArrayList<List<String>>();
//        if(strs.length == 0)
//            return res;
//        Map<String, List<String>> map = new HashMap<>();
//        for(String str: strs){
//            char[] arr = str.toCharArray();
//            Arrays.sort(arr);
//            String key = new String(arr);
//            if(!map.containsKey(key))
//                map.put(key, new ArrayList<String>());
//            map.get(key).add(str);
//        }
//        res.addAll(map.values());
//        return res;
//    }
	
	public int getID(String s){
        int[] counter   =   new int[26];
        for(char ch : s.toCharArray()){
            counter[ch - 'a']++;
        }
        return Arrays.hashCode(counter);    //use the counter array's hash code as this anagram's ID
    }
    
    //solution takes 18ms
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> groups   =   new ArrayList<>();
        Map<Integer, List<String>> anagramMap   =   new HashMap<>();
        
        for(String word : strs){
            int id   =   getID(word);   //unique for each anagram
            List<String> group  =   anagramMap.get(id);
            
            if(null == group){
                group  =   new ArrayList();
                anagramMap.put(id, group);
           
            }
            
            group.add(word);
        }
        
        groups.addAll(anagramMap.values());
        
        return groups;
    }
	
	public static void main(String[] args) {
		String[] input = {"eat", "tea", "tan", "ate", "nat", "bat"};
		GroupAnagrams s = new GroupAnagrams();
		List<List<String>> res = s.groupAnagrams(input);
		for(List<String> l: res){
			for(String str : l){
				System.out.print(str + " ");
			}
			System.out.println();
		}
	}
}
