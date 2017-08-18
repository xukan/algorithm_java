package algorithm_java;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//Amazon Google

//bucket sort
//tc: O(n)

//similar question
//Top K Frequent Elements

public class SortCharactersByFrequency {
	public String frequencySort(String s) {
        Map<Character, Integer> map = new HashMap<>();
        int len = 0;
        for(char c: s.toCharArray()){
            int f = map.getOrDefault(c, 0)+1;
            map.put(c, f);
            len = Math.max(len, f);
        }
        List<Character>[] bucket = new List[len+1];
        for(char key: map.keySet()){
            int f = map.get(key);
            if(bucket[f] == null)
                bucket[f] = new ArrayList<Character>();
            bucket[f].add(key);
        }
        StringBuilder sb = new StringBuilder();
        for(int i=bucket.length-1;i>=0;i--){
            if(bucket[i]!=null){
                for(char c: bucket[i]){
                    for(int k=0;k<i;k++)
                        sb.append(c);
                }
            }
        }
        return sb.toString();
    }
}
