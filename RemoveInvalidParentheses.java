package algorithm_java;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;

//facebook

import java.util.List;
import java.util.Set;

public class RemoveInvalidParentheses {
	public List<String> removeInvalidParentheses(String s) {
        List<String> res = new ArrayList<String>();
        if (s == null) return res;
        LinkedList<String> queue = new LinkedList<String>();
        Set<String> visited = new HashSet<String>();
        queue.add(s);
        boolean reached = false;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                String cur = queue.poll();
                // Valid
                if (isValid(cur)) {
                	// If answer is found, make reached true
                    // so that valid string of only that level
                    // are processed.
                    reached = true;
                    res.add(cur);
                }
                // Not Valid Then Delete 
                if (!reached) {
                    for (int j = 0; j < cur.length(); j++) {
                        if (cur.charAt(j) != '(' && cur.charAt(j) != ')') continue;  //prune
                        String s1 = cur.substring(0, j);
                        String s2 = cur.substring(j + 1);
                        String newStr =  s1+ s2;
                        if (!visited.contains(newStr)) {
                            queue.add(newStr);
                            visited.add(newStr);
                        }
                    }
                }
            }
            if (reached) break;
        }
        return res;
    }
	//  method returns true if string contains valid parenthesis
    private boolean isValid(String str) {
        char[] s = str.toCharArray();
        int left = 0;
        for (int i = 0; i < s.length; i++) {
            if (s[i] == '(') left++;
            else if (s[i] == ')') {
                if (left == 0) return false;
                left--;
            }
        }
        return left == 0;
    }
	
	public static void main(String[] args) {
		//"()())()" -> ["()()()", "(())()"]
		//"(a)())()" -> ["(a)()()", "(a())()"]
		//		")(" -> [""]
		RemoveInvalidParentheses s = new RemoveInvalidParentheses();
		String input = "()())()";
		List<String> res = s.removeInvalidParentheses(input);
		res.forEach(item -> System.out.println(item));
	}
}
