package algorithm_java;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Stack;

public class LongestValidParentheses {
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
	
	public static void main(String[] args){
		String input = "())((())";
		int res = longestValidParentheses(input);
		System.out.println(res);
	}
}
