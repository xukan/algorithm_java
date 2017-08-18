package algorithm_java;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GroupShiftedStrings {
	public static List<List<String>> groupStrings(String[] strs) {
		HashMap<String, ArrayList<String>> map = new HashMap<String, ArrayList<String>>();
	    Arrays.sort(strs);    	
		for (String s : strs) {
			String key = "";
			for (int i = 1; i < s.length(); i++) 
				key += String.format("%2d", (s.charAt(i) - s.charAt(i-1) + 26) % 26);//Difference from the previous char.
			if (!map.containsKey(key)) map.put(key, new ArrayList<String>());
			map.get(key).add(s);    		
		} 
		return new ArrayList<List<String>>(map.values());
	}
	
//	public static List<List<String>> groupStrings(String[] strings) {
//		List<List<String>> res = new ArrayList<List<String>>();
//        HashMap<Integer, List<String>> map = new HashMap();
//        for(String str: strings){
//            int len = str.length();
//            map.putIfAbsent(len, new ArrayList<String>());
//            map.get(len).add(str);
//        }
//        HashMap<String, List<String>> map1 = new HashMap();
//        for(Map.Entry<Integer, List<String>> entry: map.entrySet()){
//            for(String s: entry.getValue()){
//                String key = "";
//                for(int i=1;i<s.length();i++){
//                    key += ( s.charAt(i) - s.charAt(i-1) + 26)%26;
//                }
//                map1.putIfAbsent(key, new ArrayList<String>());
//                map1.get(key).add(s);
//            }
//        }
//        res.addAll(map1.values());
//        return res;
//    }
	
	public static void main(String[] args) {
		String[] strs = {"abc", "bcd", "acef", "xyz", "az", "ba", "a", "z"};
		//String[] strs = {"aa","bb","b"};
		List<List<String>> res = groupStrings(strs);
		for(List<String> list: res){
			for(String str: list){
				System.out.print(str+" ");
			}
			System.out.println();
		}
	}
}
