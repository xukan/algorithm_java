package algorithm_java;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class ValidParentheses {
	//my solution with stack
	public boolean isValid(String s) {
		if( s.length() <=1 )
            return false;
        Stack<Character> stack = new Stack<Character>();
        for( int i=0;i<s.length(); i++){
        	char c = s.charAt(i);
        	if( c =='(' || c=='{' || c=='[' ){
        		stack.push( c );
        	}else if( c == ')'){
        		if( !stack.isEmpty() && stack.peek() == '('){
        			stack.pop();
        		}else
        		    return false;
        	}else if( c == ']'){
        		if( !stack.isEmpty() && stack.peek() == '['){
        			stack.pop();
        		}else
        		    return false;
        	}else if( c == '}'){
        		if( !stack.isEmpty() && stack.peek() == '{'){
        			stack.pop();
        		}else
        		    return false;
        	}else
        		return false;
        }
        return stack.isEmpty();
    }
	
	public static void main(String[] args) {
		String input= "()[]{}";
		ValidParentheses solution = new ValidParentheses();
		boolean res = solution.isValid(input);
		System.out.println( res );
	}
}
