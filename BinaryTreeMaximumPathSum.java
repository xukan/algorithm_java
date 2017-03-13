package algorithm_java;

//Microsoft Baidu

//http://www.geeksforgeeks.org/find-maximum-path-sum-in-a-binary-tree/

/*
 * For each node there can be four ways that the max path goes through the node:
 * 1. Node only
 * 2. Max path through Left Child + Node
 * 3. Max path through Right Child + Node
 * 4. Max path through Left Child + Node + Max path through Right Child
 * */

public class BinaryTreeMaximumPathSum {
	public static int maxPathSum(TreeNode root) {
        if(root == null)
            return 0;
        int[] max = new int[1];
        max[0] = Integer.MIN_VALUE;
        helper(root, max);
        return max[0];
    }
    
    public static int helper(TreeNode node, int[] max){
        if(node == null)
            return 0;
        // recursively get sum of left and right path
        int left = helper(node.left, max);
        int right = helper(node.right, max);
        int max_single = Math.max( Math.max(left, right)+ node.val, node.val);
        //update maximum here
        max[0] = Math.max(max[0], Math.max(left+node.val+right, max_single));
        // return sum of largest path of current node
        return max_single;
    }
}
