package algorithm_java;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
class myComparator implements Comparator{
	@Override
	public int compare( Object o1, Object o2){
		Map.Entry e1 = (Map.Entry)o1;
		Map.Entry e2 = (Map.Entry)o2;
		return (int)e2.getValue() - (int)e1.getValue();
	}
}

public class SortCharactersByFrequency {
	public String frequencySort(String s) {
        Map<Character, Integer> map = new HashMap<Character, Integer>();
        for( int i=0;i<s.length();i++){
        	char c = s.charAt(i);
        	if( map.containsKey(c)){
        		map.put(c, map.get(c)+1);
        	}else
        		map.put(c, 1);
        }
        List<Map.Entry<Character, Integer>> list = new ArrayList< Map.Entry<Character, Integer> >(map.entrySet());
        Collections.sort(list, new myComparator() );
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<list.size();i++){
        	Map.Entry<Character, Integer> o1 = list.get(i);
        	for( int j=0;j<o1.getValue();j++)
        		sb.append(o1.getKey());
        }
        return sb.toString();
    }
	
	public static void main(String[] args) {
		String input = "Aabb";
		SortCharactersByFrequency solution = new SortCharactersByFrequency();
		String res = solution.frequencySort(input);
		System.out.println( res);
	}
}
