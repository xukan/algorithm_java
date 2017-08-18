package algorithm_java;

import java.util.HashMap;

//LinkedIn, Yelp

public class IsomorphicStrings {
	public boolean isIsomorphic(String s, String t) {
		if(s.length()!=t.length())
			return false;
		HashMap<Character, Character> map = new HashMap();
		for(int i=0;i<s.length();i++){
			char c1 = s.charAt(i), c2 = t.charAt(i);
			if(!map.containsKey(c1)){
				if(!map.containsValue(c2))
					map.put(c2, c2);
				else	
					return false;
			}else{
				if(map.get(c1)!=c2)
					return false;
			}
		}
		return true;
	}
}
