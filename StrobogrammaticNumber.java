package algorithm_java;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//Google

public class StrobogrammaticNumber {
	//I
	public boolean isStrobogrammatic(String num) {
        Map<Character, Character> map = new HashMap<>();
        map.put('9','6');
        map.put('6','9');
        map.put('0','0');
        map.put('1','1');
        map.put('8','8');
        int l = 0, r = num.length()-1;
        while(l<=r){
            char c1 = num.charAt(l);
            char c2 = num.charAt(r);
            if(!map.containsKey(c1))
                return false;
            if(map.get(c1) == c2){
                l++;
                r--;
            }else
                return false;
        }
        return true;
    }
	
	//II
	public static List<String> findStrobogrammatic_iterative(int n) {
        List<String> cur, ans;
        ans = new ArrayList<String>((n & 1) == 0 ? Arrays.asList("") : Arrays.asList("0", "1", "8"));
        if (n < 2)
        	return ans;
        for (;n > 1; n -= 2) {
            cur = ans;
            ans = new ArrayList<String>();
            for (String i : cur) {
                if (n > 3) ans.add('0' + i + '0');
                ans.add('1' + i + '1');
                ans.add('8' + i + '8');
                ans.add('6' + i + '9');
                ans.add('9' + i + '6');
            }
        }
        return ans;
    }
	
	//II recursion
	public List<String> findStrobogrammatic_recursion(int n) {
	    return helper(n, n);
	}

	List<String> helper(int n, int m) {
	    if (n == 0) return new ArrayList<String>(Arrays.asList(""));
	    if (n == 1) return new ArrayList<String>(Arrays.asList("0", "1", "8"));
	    
	    List<String> list = helper(n - 2, m);
	    
	    List<String> res = new ArrayList<String>();
	    
	    for (int i = 0; i < list.size(); i++) {
	        String s = list.get(i);
	        
	        if (n != m) res.add("0" + s + "0");
	        
	        res.add("1" + s + "1");
	        res.add("6" + s + "9");
	        res.add("8" + s + "8");
	        res.add("9" + s + "6");
	    }
	    
	    return res;
	}
	
	
	public static void main(String[] args) {
		List<String> res = findStrobogrammatic_iterative(4);
		for(String str: res)
			System.out.print(str + " ");
	}
}
