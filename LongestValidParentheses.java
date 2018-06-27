package algorithm_java;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Stack;

public class LongestValidParentheses {
	//solution I, tc:O(n), sc: O(n)
	public static int longestValidParentheses(String s) {
		if(s==null || s.length()==0)
	        return 0;
        // Stack<Integer> stack = new Stack<Integer>();
        Deque<Integer> stack = new ArrayDeque<>(s.length());
        int start = 0;
        int maxLen = 0;
        for(int i=0;i<s.length();i++){
            char c = s.charAt(i);
            if(c == '(')
                stack.push(i);
            else{
                if(stack.isEmpty())
                    start = i+1;
                else{
                    stack.pop();
                    if(stack.isEmpty())
                        maxLen = Math.max(maxLen, i-start+1);
                    else
                        maxLen = Math.max(maxLen, i-stack.peek());
                }
            }
        }
        return maxLen;
	}
	
	//solution II, tc:O(n), sc: O(1)
	//forward pass help us discard the situation where right parentheses are more than leftt parentheses
	//backward pass help us discard the situation where left parentheses are more than right parentheses
	//so the longest valid parentheses satisfies both two situations
	public static int longestValidParentheses_better(String s) {
        if(s.length()  == 0)
            return 0;
        int l = 0, r = 0;
        int maxLen = 0;
        int len = s.length();
        for(int i=0;i<len;i++){
            if(s.charAt(i) == '(')
                l++;
            else
                r++;
            if(l == r)
                maxLen = Math.max(maxLen, 2*l);
            else if(l<r){
                l=0;
                r=0;
            }
        }
        l=0;
        r=0;
        for(int i=len-1;i>=0;i--){
            if(s.charAt(i) == '(')
                l++;
            else
                r++;
            if(l == r)
                maxLen = Math.max(maxLen, 2*r);
            else if(l>r){
                l=0;
                r=0;
            }
        }
        return maxLen;
    }
	
	public static void main(String[] args){
		String input = "())((())";
		int res = longestValidParentheses_better(input);
		System.out.println(res);
	}
}
