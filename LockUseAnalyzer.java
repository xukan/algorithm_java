package algorithm_java;

import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

public class LockUseAnalyzer {
	public static int checkSequence(String[] events) {
		if (events == null || events.length < 1)
			return 0;
		Stack<String> stack = new Stack<>();
		Set<String> records = new HashSet<>();
		int len = events.length;
		for (int i=0;i<len;i++) {
			String[] array = events[i].split(" ");
			if (array[0].equals("ACQUIRE")) {
				if (records.contains(array[1]))
					return i+1;
				records.add(array[1]);
				stack.push(array[1]);
			} else if (array[0].equals("RELEASE")){
				if (stack.empty() || !stack.peek().equals(array[1])) {
					return i+1;
				}
				stack.pop();
				records.remove(array[1]);
			}
		}
		if (!stack.empty()) 
			return len + 1;
		return 0;
	}
	
	public static void main(String[] args) {
		String[] input1 = {"ACQUIRE 364",  "ACQUIRE 84", "RELEASE 84", "RELEASE 364"};
		int res1 = checkSequence(input1);
		System.out.println(res1);
		String[] input2 = {"ACQUIRE 364",  "ACQUIRE 84", "ACQUIRE 364", "RELEASE 364"};
		int res2 = checkSequence(input2);
		System.out.println(res2);
		String[] input3 = {"ACQUIRE 123",  "ACQUIRE 364", "ACQUIRE 84",  "RELEASE 84", "RELEASE 364", "ACQUIRE 789", "RELEASE 456", "RELEASE 123"};
		int res3 = checkSequence(input3);
		System.out.println(res3);
	}
}
