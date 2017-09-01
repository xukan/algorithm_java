package algorithm_java;

import java.util.Stack;

//http://www.cnblogs.com/hapjin/p/4740801.html

public class Calulator {
	/*
     * @Task: 将中缀表达式转换为后缀表达式
     * @param: infix 合法的中缀表达式字符串
     * @return: 与infix等价的后缀表达式字符串
     */
	public int solution(String s) {
        if(s.length() == 0)
            return 0;
        s = s.replace(" ", "");
        String postfix = convertToPostfix(s);
        int res = evaluate(postfix);
        return res;
    }
    
    public String convertToPostfix(String s){
        Stack<Character> stack = new Stack<Character>();
        StringBuilder sb = new StringBuilder(); //初始化一个字符串缓冲区存放转换过程中生成的后缀表达式
        for(int i=0;i<s.length();i++){
            char c = s.charAt(i);
            if(Character.isDigit(c)){
                int num = 0;
                while(i<s.length() && Character.isDigit(s.charAt(i))){
                    num = 10*num + s.charAt(i++) - '0';
                }
                i--;
                sb.append(num).append("#");
            }else{
                switch(c){
                    case '(': case '^':
                        stack.push(c);
                        break;
                    case '+': case '-': case '*': case '/':
                        while(!stack.empty()){
                            if(getPrecedence(c) <= getPrecedence(stack.peek())){
                                sb.append(stack.pop()).append("#");
                            }else
                                break;//当栈顶元素逐渐pop后,nextCharacter的优先级大于 栈顶的优先级
                        }
                        stack.push(c);//当nextCharacter的优先级大于 栈顶的优先级,再把cpush 入栈
                        break;
                    case ')':
                        char topOpe = stack.pop();
                        while(topOpe!= '('){
                            sb.append(topOpe).append("#");
                            topOpe = stack.pop();
                        }
                        break;
                }
            }
        }
        while(!stack.empty())
        	sb.append(stack.pop()).append("#");
        sb.deleteCharAt(sb.length()-1);
        return sb.toString();
    }
    
    private  int getPrecedence(char operator){
        switch(operator){
	        case '(': case ')': return 0;//实际只有 + - * / 才需要调用该函数比较优先级
	        case '+': case '-': return 1;// + - 优先级为1
	        case '*': case '/': return 2;// * / 优先级为2
	        case '^':             return 3;
        }
        return -1;
    }
    
    public int evaluate(String postfix){
        Stack<Integer> stack = new Stack<Integer>();
        String[] tokens = postfix.split("#");
        for(String token : tokens){
            if(isOperator(token) && !stack.empty()){
                int second = stack.pop();
                int first = stack.pop();
                int res = calculate(first, second, token.charAt(0));
                stack.push(res);
            }else
                stack.push(Integer.parseInt(token));
        }
        return stack.pop();
    }
    
    public boolean isOperator(String ope){
        if(ope.equals("+") || ope.equals("-") || ope.equals("*") || ope.equals("/") || ope.equals("^") )
            return true;
        return false;
    }
    
    public int calculate(int a, int b, char ope){
        int res = 0;
        switch(ope){
            case '+':
                res = a+ b;
                break;
            case '-':
                res = a - b;
                break;
            case '*':
                res = a * b;
                break;
            case '/':
                res = a / b;
                break;
            case '^':
                res = (int)Math.pow(a, b);
                break;
        }
        return res;
    }
	
    //for test purpose
    public static void main(String[] args) {
    	Calulator c = new Calulator();
//        String postfix = convert2Postfix("a/b*(c - (d-e)^g)");
//    	String postfix = c.convertToPostfix("9/3*(15 - (6-3)^2)");  //93/1563-2^-*
    	//["9","/","3","*","(","15","-", "(", "6", "-", "3", ")", "^", "2", ")"]
//        System.out.println(postfix);
//        int res = c.evaluate(postfix);
    	String expression = "9/3*(15 - (6-3)^2)";
    	int res = c.solution(expression);
        System.out.println(res);
    }
}
