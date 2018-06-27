package algorithm_java;

//Microsoft Baidu

//http://www.geeksforgeeks.org/find-maximum-path-sum-in-a-binary-tree/

/*
 * O(N), bottom-up solution
 * For each node there can be four ways that the max path goes through the node:
 * 1. Node only
 * 2. Max path through Left Child + Node
 * 3. Max path through Right Child + Node
 * 4. Max path through Left Child + Node + Max path through Right Child
 * */

public class BinaryTreeMaximumPathSum {
	int max = Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        helper(root);
        return max;
    }
    
    public int helper(TreeNode node){
        if(node == null)
            return 0;
        int l = helper(node.left);
        int r = helper(node.right);
        int left = l + node.val;
        int right = r + node.val;
        int maxSingle = Math.max(node.val, Math.max(left, right));
        int total = l + r + node.val;
        max = Math.max(max,  Math.max(total, maxSingle));
        return maxSingle;
    }

    public static void main(String[] args) {
    	BinaryTreeMaximumPathSum s = new BinaryTreeMaximumPathSum();
    	TreeNode root = new TreeNode(1);
		TreeNode node1 = new TreeNode(2);
		TreeNode node2 = new TreeNode(3);
		root.left=node1;
		root.right = node2;
		int res = s.maxPathSum(root);
		System.out.println(res);
	}
}
