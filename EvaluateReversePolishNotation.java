package algorithm_java;

import java.util.Stack;

//LinkedIn

public class EvaluateReversePolishNotation {
	public static int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<Integer>();
        int res = 0;
        for(String str : tokens){
            if(str.equals("+")){
                int a2 = stack.pop();
                int a1 = stack.pop();
                int sum = a1+a2;
                stack.push(sum);
            }else if(str.equals("-")){
                int a2 = stack.pop();
                int a1 = stack.pop();
                int diff = a1-a2;
                stack.push(diff);
            }else if(str.equals("*")){
                int a2 = stack.pop();
                int a1 = stack.pop();
                int product = a1*a2;
                stack.push(product);
            }else if(str.equals("/")){
                int a2 = stack.pop();
                int a1 = stack.pop();
                int quotient = a1/a2;
                stack.push(quotient);
            }else
                stack.push(Integer.parseInt(str));
        }
        return stack.pop();
    }
	
	public static void main(String[] args) {
		String[] input = {"4", "13", "5", "/", "+"};
		int res = evalRPN(input);
		System.out.println(res);
	}
}
