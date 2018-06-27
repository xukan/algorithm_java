package algorithm_java;

//Facebook 

/*
 *           3
 *         /    \
 *        9    20
 *      /    \
 *     15   7
 * */

public class SumofLeftLeaves {
	int sum = 0;
    public int sumOfLeftLeaves(TreeNode root) {
        if(root == null)
            return sum;
        helper(root, false);
        return sum;
    }
    
    public void helper(TreeNode node, boolean isLeft){
        if(node == null)
            return;
        if(node.left == null && node.right == null ){
            if(isLeft)
                sum += node.val;
            return;
        }
        helper(node.left, true);
        helper(node.right, false);
    }
    
    public static void main(String[] args) {
    	SumofLeftLeaves s = new SumofLeftLeaves();
    	TreeNode root = new TreeNode(3);
    	TreeNode node1 = new TreeNode(9);
    	TreeNode node2 = new TreeNode(20);
    	TreeNode node3 = new TreeNode(15);
    	TreeNode node4 = new TreeNode(7);
    	root.left = node1;
    	root.right = node2;
    	node1.left = node3;
    	node2.right = node4;
    	int res = s.sumOfLeftLeaves(root);
    	System.out.println(res);
	}
}
