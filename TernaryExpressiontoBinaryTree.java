package algorithm_java;

//http://www.geeksforgeeks.org/convert-ternary-expression-binary-tree/

/*
 * Idea is that we traverse a string make first character as root and do following step recursively .
 * 1. If we see Symbol ‘?’
 * …….. then we add next character as the left child of root.
 * 2. If we see Symbol ‘:’
 * …….. then we add it as the right child of current root.
 * do this process until we traverse all element of “String”.
 * */

public class TernaryExpressiontoBinaryTree {
	public static TreeNode convertExpression(String s){
		if(s == null || s.length() == 0)
			return null;
		char[] array = s.toCharArray();
		return helper(array, 0);
	}
	
	public static TreeNode helper(char[] expression, int i){
        // Base case
        if (i >= expression.length)
            return null;
      
        // store current character of expression_string
        // [ 'a' to 'z']
        TreeNode root = new TreeNode(expression[i]);
      
        // Move ahead in str
        ++i;
      
        // if current character of ternary expression is '?'
        // then we add next character as a left child of
        // current node
        if (i < expression.length && expression[i]=='?')
            root.left = helper(expression, i+1);
      
        // else we have to add it as a right child of
        // current node expression.at(0) == ':'
        else if (i < expression.length)
            root.right = helper(expression, i+1);
      
        return root;
    }
     
    // function print tree
    public static void printTree( TreeNode root){
        if (root == null)
            return;
                 
        System.out.print((char)(root.val) +" ");
        printTree(root.left);
        printTree(root.right);
    }
	
	public static void main(String[] args) {
//		String exp = "a?b?c:d:e?f:g";
		String exp = "a?b?c:d?e:f";
        TreeNode root = convertExpression(exp);
        printTree(root) ;
	}
}
