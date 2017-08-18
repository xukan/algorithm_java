package algorithm_java;

import java.util.Stack;

//Google

public class DecodeString {
	public static String decodeString(String s) {
		Stack<Integer> count = new Stack<>();
        Stack<String> result = new Stack<>();
       
        //result.push("");
        for(int i=0;i < s.length();i++) {
            char ch = s.charAt(i);
            if (ch >= '0' && ch <= '9') {
                int start = i;
                while (s.charAt(i + 1) >= '0' && s.charAt(i + 1) <= '9')
                	i++;
                count.push(Integer.parseInt(s.substring(start, i + 1)));
            } else if (ch == '[') {
                result.push("");
            } else if (ch == ']') {
                String str = result.pop();
                StringBuilder sb = new StringBuilder();
                int times = count.pop();
                for (int j = 0; j < times; j += 1) {
                    sb.append(str);
                }
                result.push(result.pop() + sb.toString());
            } else {
                result.push(result.pop() + ch);
            }
        }
        return result.pop();
    }
	
	public static void main(String[] args) {
		String input = "3[a2[c]]";
//		String input = "2[abc]3[cd]";
		String res = decodeString(input);
		System.out.println(res);
	}
}
