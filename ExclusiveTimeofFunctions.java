package algorithm_java;

import java.util.Arrays;
import java.util.List;
import java.util.Stack;

//Facebook

//tc: O(n), sc: The stackstack can grow upto a depth of atmost n/2n/2. Here, nn refers to the number of elements in the given logslogs list.
public class ExclusiveTimeofFunctions {
	public static int[] exclusiveTime(int n, List < String > logs) {
        Stack < Integer > stack = new Stack < > ();
        int[] res = new int[n];
        String[] s = logs.get(0).split(":");
        stack.push(Integer.parseInt(s[0]));
        int i = 1, prev = Integer.parseInt(s[2]);
        while (i < logs.size()) {
            s = logs.get(i).split(":");
            if (s[1].equals("start")) {
                if (!stack.isEmpty()) 
                    res[stack.peek()] += Integer.parseInt(s[2]) - prev;
                stack.push(Integer.parseInt(s[0]));
                prev = Integer.parseInt(s[2]);
            } else {
                res[stack.peek()] += Integer.parseInt(s[2]) - prev + 1;
                stack.pop();
                prev = Integer.parseInt(s[2]) + 1;
            }
            i++;
        }
        return res;
    }
	
	//my solution
	public static int[] exclusiveTimeI(int n, List<String> logs) {
        int[] res = new int[n];
        Stack<Integer> stack = new Stack<Integer>();
        String[] tokens = logs.get(0).split(":");
        stack.push(Integer.parseInt(tokens[0]));
        int prev = Integer.parseInt(tokens[2]);
        String tag = tokens[1];
        for(int i=1;i<logs.size();i++){
            String[] log = logs.get(i).split(":");
            int time =  Integer.parseInt(log[2]);
            if(log[1].equals("start")){
            	if(!stack.empty())
            		res[stack.peek()] +=  time- prev + (tag.equals("end")?-1:0);
                stack.push(Integer.parseInt(log[0]));
            }else{ 
                res[stack.peek()] += time - prev + (tag.equals("start")?1:0);
                stack.pop();
            }
            prev = time;
            tag = log[1];
        }
        return res;
    }
	
	public static void main(String[] args) {
//		List < String > logs = Arrays.asList(
//				 "0:start:0",
//				 "1:start:2",
//				 "2:start:5",
//				 "2:end:6",
//				 "1:end:7",
//				 "0:end:9");
		
//		List < String > logs = Arrays.asList(
//				 "0:start:0",
//				 "1:start:2",
//				 "1:end:4",
//				 "2:start:5",
//				 "2:end:8",
//				 "0:end:9");
		
		List < String > logs = Arrays.asList("0:start:0","0:end:0","1:start:1","1:end:1","2:start:2","2:end:2","2:start:3","2:end:3");
		int[] res = exclusiveTimeI(3, logs);
		for(int i: res)
			System.out.print(i + " ");
	}
}
