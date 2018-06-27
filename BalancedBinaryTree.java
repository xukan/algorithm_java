package algorithm_java;

/*
 *            1
 *          /   \
 *         2     2
 *        /  \     \
 *       3   5     3
 *      /             \
 *     4              4
 *   In this example£¬for tree node 2 whose height of left subtree is 2£¬and height of right subtree is 0£¬
 *   difference between them is 2>1. Thus the result should be false
 *   In the program, return value for left of treenode 1 is -1, same for right, return value is also -1
 *   so we need to add a judge : if(left ==-1 || right == -1)
 *   	                         	return -1;
 *   similar problem is: Maximum Depth of Binary Tree, Minimum Depth of Binary Tree
 * */

//Bloomberg 

public class BalancedBinaryTree {
	public static boolean isBalanced(TreeNode root) {
		if(root == null)
            return true;
        if(depth(root) == -1)
            return false;
        return true;
	}
	
	public static int depth(TreeNode node){
        if(node == null)
            return 0;
        int left = depth(node.left);
        int right = depth(node.right);
        if (left == -1 || right == -1)
			return -1;
        if(Math.abs(left-right)>1)
            return -1;
        return Math.max(left, right)+1;
    }
    
    public static void main(String[] args) {
    	 TreeNode root = new TreeNode(1);
		 TreeNode node1 = new TreeNode(2);
		 TreeNode node2 = new TreeNode(2);
		 TreeNode node3 = new TreeNode(3);
		 TreeNode node4 = new TreeNode(5);
		 TreeNode node5 = new TreeNode(3);
		 TreeNode node6 = new TreeNode(4);
		 TreeNode node7 = new TreeNode(4);
		 root.left = node1;
		 root.right = node2;
		 node1.left = node3;
		 node1.right = node4;
		 node2.right = node5;
		 node3.left = node6;
		 node5.right = node7;
		 boolean res = isBalanced(root);
		 System.out.println(res);
	}
}
