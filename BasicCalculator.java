package algorithm_java;

import java.util.Stack;

//Google, Airbnb
//reference: 
//https://segmentfault.com/a/1190000003796804

public class BasicCalculator {	
	public int calculate(String s) {
        s= s.replace(" ", "");
		Stack<Integer> stack = new Stack<Integer>();
        stack.push(1);
        int i=0, sign =1;
        int res=0;
        while(i<s.length()){
        	char c = s.charAt(i);
        	if(c == '+'){
        		sign = 1;
        		i++;
        	}else if(c=='-'){
        		sign = -1;
        		i++;
        	}else if(c=='('){
        		stack.push(sign*stack.peek());
        		sign = 1;  // attention here; corner case : "1-(5)"
        		i++;
        	}else if(c == ')'){
        		stack.pop();
        		i++;
        	}else{
        		int num =0;
        		while(i<s.length() && Character.isDigit(s.charAt(i))){
        			num = num*10 + s.charAt(i)-'0';
        			i++;
        		}
        		res += num*sign*stack.peek();
        	}
        }
        return res;
    }
	
	public int calculateII(String s) {
        s = s.replace(" ", "");
        Stack<Long> stk = new Stack<Long>();
        String firstNum = getNum(0, s);
        stk.push(Long.parseLong(firstNum));
        int i = firstNum.length();
        while(i < s.length()){
            char c = s.charAt(i);
            // 拿出下一个数字
            String numStr = getNum(i + 1, s);
            if(c == '+'){
                stk.push(Long.parseLong(numStr));
            }
            if(c == '-'){
                stk.push(-Long.parseLong(numStr));
            }
            if(c == '*'){
                stk.push(stk.pop()*Long.parseLong(numStr));
            }
            if(c == '/'){
                stk.push(stk.pop()/Long.parseLong(numStr));
            }
            i = i+ numStr.length() + 1;
        }
        long res = 0;
        while(!stk.isEmpty()){
            res += stk.pop();
        }
        return (int)res;
    }
    
    private String getNum(int i, String s){
        StringBuilder num = new StringBuilder();
        while(i < s.length() && Character.isDigit(s.charAt(i))){
            num.append(s.charAt(i));
            i++;
        }
        return num.toString();
    }
	
	public static void main(String[] args) {
		//basic calculatorI only have +, - and  ()
		String input = "5-(1-(3-10))+2";
		//String input = "2-1+2";
		//String input = "   30";
		//String input = "1-(5)";
		BasicCalculator s = new BasicCalculator();
        int res = s.calculate(input);
        System.out.println(res);
        
        String input2 = " 30 +500 / 2 ";
        //basic calculator II only have +, -, *, /
        res = s.calculateII(input2);
        System.out.println(res);
	}
}
