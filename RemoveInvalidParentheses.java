package algorithm_java;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;

//facebook

import java.util.List;
import java.util.Set;

//Facebook

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
        int left = 0;
        for(char c: str.toCharArray()){
        	if(c == '(')
        		left++;
        	if(c== ')' && left-- == 0)
        		return false;
        }
        return left == 0;
    }
	
    
    //solutionII, dfs
    //If there are k unique answers then this algorithm runs in roughly O(nk), where n is the length of the string.
    //I have question. How this solution guarantees that minimal number of parenthesis is removed? 
    //Is that because of the variable "stack"? As far as I understand, only when stack is greater than 0, when one parenthesis is more than the other, the removal is conducted.
    //why we need last_i
    //after we remove an invalid parentheses, string before last_i(prefix) is valid, so we just need to continue checking starting at last_i
    //why we need last_j
    //we may have a consecutive of invalid parentheses, last_j marks last removal position,
    // If we do not have this position, we will generate duplicate results by removing two ‘)’ in two steps only with a different order.
//    public List<String> removeInvalidParentheses_better(String s) {
//        List<String> ans = new ArrayList<>();
//        remove(s, ans, 0, 0, new char[]{'(', ')'});
//        return ans;
//    }
//
//    public void remove(String s, List<String> ans, int last_i, int last_j,  char[] par) {
//        for (int stack = 0, i = last_i; i < s.length(); ++i) {
//            if (s.charAt(i) == par[0])
//            	stack++;
//            if (s.charAt(i) == par[1])
//            	stack--;
//            if (stack >= 0)
//            	continue;
//            for (int j = last_j; j <= i; ++j)
//                if (s.charAt(j) == par[1] && (j == last_j || s.charAt(j - 1) != par[1]))
//                    remove(s.substring(0, j) + s.substring(j + 1), ans, i, j, par);
//            return;
//        }
//        String reversed = new StringBuilder(s).reverse().toString();
//        if (par[0] == '(') // finished left to right
//            remove(reversed, ans, 0, 0, new char[]{')', '('});
//        else // finished right to left
//            ans.add(reversed);
//    }
    
    public List<String> RemoveInvalidParentheses(String s) {
        List<String> res = new ArrayList<String>();
        if(s.length() == 0)
            return res;
        helper(s, 0, 0, new char[]{'(', ')'}, res);
        return res;
    }
    
    public void helper(String s, int last_i, int last_j, char[] par, List<String> res){
        int count = 0;
        for(int i=last_i;i<s.length();i++){
            if(s.charAt(i) == par[0])
                count++;
            if(s.charAt(i) == par[1])
                count--;
            if(count>=0)
                continue;
            for(int j=last_j;j<=i;j++){
                if(s.charAt(j) == par[1] && (j == last_j || s.charAt(j-1)!=par[1])){
                    String left = s.substring(0, j);
                    String right = s.substring(j+1);
                    helper(left+right, i, j, par, res);
                }
            }
            return;
        }
        String reverse = new StringBuilder().reverse().toString();
        if(par[0] == '(')
            helper(reverse, 0, 0, new char[]{')','('}, res);
        else
            res.add(reverse);
    }
    
    
	public static void main(String[] args) {
		//"()())()" -> ["()()()", "(())()"]
		//"(a)())()" -> ["(a)()()", "(a())()"]
		//		")(" -> [""]
		RemoveInvalidParentheses s = new RemoveInvalidParentheses();
		String input = "(a)()))()";
//		String input = "(";
		List<String> res = s.RemoveInvalidParentheses(input);
		res.forEach(item -> System.out.println(item));
	}
}
