package algorithm_java;

import java.util.Stack;

//http://www.cnblogs.com/hapjin/p/4740801.html

public class Calulator {
	/*
     * @Task: 将中缀表达式转换为后缀表达式
     * @param: infix 合法的中缀表达式字符串
     * @return: 与infix等价的后缀表达式字符串
     */
    public  String convert2Postfix(String infix){
        StringBuilder postfix = new StringBuilder();//初始化一个字符串缓冲区存放转换过程中生成的后缀表达式
        Stack<Character> operatorStack = new Stack<Character>();
        int len = infix.length();
        char topCharactor;
        
        for(int index = 0; index < len; index++){
            //boolean done = false;
            char c= infix.charAt(index);
            if(Character.isDigit( c)){
            	int num = 0;
	            while(index<infix.length() && Character.isDigit(infix.charAt(index)))
	    			num = num*10 + infix.charAt(index++)-'0';
	            index--;
	            postfix.append(num).append("#");
    		}else{
                switch( c){
	                case '^':case '(':
	                    operatorStack.push( c);
	                    break;
	                case '+': case '-': case '*': case '/':
	                    while(!operatorStack.empty()){
	                        topCharactor = operatorStack.peek();
	                        if(getPrecedence( c) <= getPrecedence(topCharactor)){
	                            postfix = postfix.append(topCharactor).append("#");
	                            operatorStack.pop();
	                        }else
	                            break;//当栈顶元素逐渐pop后,nextCharacter的优先级大于 栈顶的优先级
	                    }//end while
	                    operatorStack.push( c);//当nextCharacter的优先级大于 栈顶的优先级,再把cpush 入栈
	                    break;
	                case ')':
	                    topCharactor = operatorStack.pop();
	                    while(topCharactor != '('){
	                        postfix.append(topCharactor).append("#");
	                        topCharactor = operatorStack.pop();
	                    }
	                    break;
	                default:break;
	                }//end switch
            }
        }//end for
        
        while(!operatorStack.empty()){
            topCharactor = operatorStack.pop();
            postfix = postfix.append(topCharactor).append("#");
        }
        postfix.deleteCharAt(postfix.length()-1);
        return postfix.toString();
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
    
    public boolean isOperator(String token){
        if( token.equals("+") || token.equals("-") || token.equals("*") || token.equals("/") || token.equals("^") )
            return true;
        return false;
    }
    
    public int evaluate(String s){
        Stack<Integer> stack = new Stack<Integer>();
        String[] parts = s.split("#");
        for(int i=0;i<parts.length;i++){
            if(isOperator(parts[i])){
                int b = stack.pop();
                int a = stack.pop();
                int c = calculate(a, b, parts[i].charAt(0));
                stack.push(c);
            }else
                stack.push(Integer.parseInt(parts[i]));
        }
        return stack.pop();
    }
    
    public int calculate(int a, int b, char ope){
        int num = 0;
        switch(ope){
            case '+':
                num = a + b;
                break;
            case '-':
                num = a - b;
                break;
            case '*':
                num = a * b;
                break;
            case '/':
                num = a / b;
                break;
            case '^':
                num = (int)Math.pow(a, b);
                break;
        }
        return num;
    }
    //for test purpose
    public static void main(String[] args) {
    	Calulator c = new Calulator();
//        String postfix = convert2Postfix("a/b*(c - (d-e)^g)");
    	String postfix = c.convert2Postfix("9/3*(15 - (6-3)^2)");  //93/1563-2^-*
    	//["9","/","3","*","(","15","-", "(", "6", "-", "3", ")", "^", "2", ")"]
        System.out.println(postfix);
        int res = c.evaluate(postfix);
        System.out.println(res);
    }
}
