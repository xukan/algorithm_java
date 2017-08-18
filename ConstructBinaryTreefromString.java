package algorithm_java;

import java.util.Stack;

//Amazon 

public class ConstructBinaryTreefromString {
	public static TreeNode str2tree(String s) {
		if (s.length() == 0)
			return null;
		// Create root
		int i = 0, j = 0;
		while (j < s.length() && (Character.isDigit(s.charAt(j)) || s.charAt(j) == '-'))
			j++;
		TreeNode root = new TreeNode(Integer.parseInt(s.substring(i, j)));
		// Left child
		if (j < s.length()) {
			i = j;
			int count = 1;
			while (j + 1 < s.length() && count != 0) {
				j++;
				if (s.charAt(j) == ')')
					count--;
				if (s.charAt(j) == '(')
					count++;
			}
			root.left = str2tree(s.substring(i + 1, j));
		}
		j++;
		// Right child
		if (j < s.length()) {
			root.right = str2tree(s.substring(j + 1, s.length() - 1));
		}
		return root;
	}
	
	public static TreeNode str2tree_stack(String s) {
        Stack<TreeNode> stack = new Stack<>();
        for(int i = 0, j = i; i < s.length(); i++, j = i){
            char c = s.charAt(i);
            if(c == ')')    stack.pop();
            else if(c >= '0' && c <= '9' || c == '-'){
                while(i + 1 < s.length() && s.charAt(i + 1) >= '0' && s.charAt(i + 1) <= '9')
                	i++;
                TreeNode currentNode = new TreeNode(Integer.valueOf(s.substring(j, i + 1)));
                if(!stack.isEmpty()){
                    TreeNode parent = stack.peek();
                    if(parent.left != null)
                    	parent.right = currentNode;
                    else
                    	parent.left = currentNode;
                }
                stack.push(currentNode);
            }
        }
        return stack.isEmpty() ? null : stack.peek();
    }
	
	public static void inorder(TreeNode n){
		if(n == null)
			return;
		inorder(n.left);
		System.out.print(n.val+ " ");
		inorder(n.right);
	}
	
	public static void main(String[] args) {
		String input = "4(2(3)(1))(6(5))";
		TreeNode root = str2tree(input);
		inorder(root);
	}
}
