package algorithm_java;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class GroupAnagrams {
	public List<List<String>> groupAnagrams(String[] strs) {
		List<List<String>> result = new ArrayList<List<String>>();
		HashMap<String,Integer> map = new HashMap<String, Integer>();
		for(int i=0;i<strs.length;i++){
			char[] str = strs[i].toCharArray();
			Arrays.sort(str);
			String s = new String(str);
			if(map.containsKey(s)){
				result.get(map.get(s)).add(strs[i]);
			}else{
				List<String> list = new ArrayList<String>();
				list.add(strs[i]);
				result.add(list);
				map.put(s, result.size()-1);
			}
		}
		return result;
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
