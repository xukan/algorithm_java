package algorithm_java;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;

//LinkedIn

public class RepeatedDNASequences {
	//solution1, sliding window
	public List<String> findRepeatedDnaSequences_set(String s) {
        HashSet<String> seen = new HashSet();
        HashSet<String> repeated = new HashSet();
        for(int i=0;i+9<s.length();i++){
            String str = s.substring(i, i+10);
            if(!seen.add(str))
                repeated.add(str);
        }
        return new ArrayList<String>(repeated);
    }
	
	public List<String> findRepeatedDnaSequences_map(String s) {
        List<String> res = new ArrayList<String>();
        if(s.length()<=10)
            return res;
        Map<String, Integer> map = new HashMap<String, Integer>();
        for(int i=0;i<=s.length()-10;i++){
            String sub = s.substring(i, i+10);
            if(map.getOrDefault(sub, 0)>=1 && !res.contains(sub))
                res.add(sub);
            map.put(sub, map.getOrDefault(sub, 0)+1);
        }
        return res;
    }
	
	//solution2, bit 
	
}
