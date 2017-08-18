package algorithm_java;

import java.util.Stack;

//Google

public class VerifyPreorderSerializationofaBinaryTree {
	//solution1 
	/*
	 * In a binary tree, if we consider null as leaves, then
	 * all non-null node provides 2 outdegree and 1 indegree (2 children and 1 parent), except root
	 * all null node provides 0 outdegree and 1 indegree (0 child and 1 parent).
	 * Suppose we try to build this tree. During building, 
	 * we record the difference between out degree and in degree diff = indegree- outdegree . 
	 * When the next node comes, we then increase diff by 1, 
	 * because the node provides an in degree. If the node is not null, we decrease diff by2,
	 * because it provides two out degrees. 
	 * If a serialization is correct, diff should never be positive and diff will be zero when finished.
	 * */
	public static boolean isValidSerialization(String preorder) {
        int diff = -1;
        String[] nodes = preorder.split(",");
        for(String str: nodes){
            diff++;
            if(diff>0)
                return false;
            if(!str.equals("#"))
                diff-=2;
        }
        return diff==0;
    }
	
	//solution2 : stack
	public static boolean isValidSerialization_stack(String preorder) {
        Stack<String> stack = new Stack();
        String[] nodes = preorder.split(",");
        for(String str: nodes){
            while(str.equals("#")&&!stack.empty() && stack.peek().equals("#")){
                stack.pop();
                if(stack.empty()||stack.peek().equals("#"))
                    return false;
                stack.pop();
            }
            stack.push(str);
        }
        return stack.size()==1 && stack.peek().equals("#");
    }
	
	public static void main(String[] args) {
		String preorder = "9,3,4,#,#,1,#,#,2,#,6,#,#";
		Boolean res = isValidSerialization(preorder);
		System.out.println(res);
	}
}
