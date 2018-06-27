package algorithm_java;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class ValidParentheses {
	//my solution with stack
	public boolean isValid(String s) {
		if(s.length() == 0)
            return true;
        Stack<Character> stack = new Stack<>();
        for(char c: s.toCharArray()){
            if(c == '(' || c == '[' || c == '{')
                stack.push(c);
            else{
                if(stack.empty())
                    return false;
                if(c == ')' && stack.peek() == '(' || c == ']' && stack.peek() == '[' || c == '}' && stack.peek() == '{'){
                    stack.pop();
                }else
                    return false;
            }
        }
        //finally, we need to check if stack is empty for input like "((["
        return stack.empty();
    }
	
	public static void main(String[] args) {
		String input= "()[]{}";
		ValidParentheses solution = new ValidParentheses();
		boolean res = solution.isValid(input);
		System.out.println( res );
	}
}
