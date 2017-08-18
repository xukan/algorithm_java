package algorithm_java;

//http://www.geeksforgeeks.org/convert-ternary-expression-binary-tree/

// Facebook

/*
 * Input :  string expression =   a?b:c 
 * Output :       a
 *                   /  \
 *                  b   c
 * Input : expression =  a?b?c:d:e
 * Output :     a
 *                /   \
 *               b    e
 *              /  \
 *            c    d
 * 
 * */

public class ConvertTernaryExpressiontoaBinaryTree {
	public TreeNode convertExpression(String s, int i) {
		char[] expression = s.toCharArray();
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
		if (i < expression.length && expression[i] == '?')
			root.left = convertExpression(new String(expression), i + 1);

		// else we have to add it as a right child of
		// current node expression.at(0) == ':'
		else if (i < expression.length)
			root.right = convertExpression(new String(expression), i + 1);

		return root;
	}

	// function print tree
	public void printTree(TreeNode root) {
		if (root == null)
			return;

		System.out.print((char)root.val + " ");
		printTree(root.left);
		printTree(root.right);
	}

	// Driver program to test above function
	public static void main(String args[]) {
		ConvertTernaryExpressiontoaBinaryTree tree = new ConvertTernaryExpressiontoaBinaryTree();
		String exp = "a?b?c:d:e";
		TreeNode root = tree.convertExpression(exp, 0);
		tree.printTree(root);
	}
}
