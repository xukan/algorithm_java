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
//	public static int maxPathSum(TreeNode root) {
//        if(root == null)
//            return 0;
//        int[] max = new int[1];
//        max[0] = Integer.MIN_VALUE;
//        helper(root, max);
//        return max[0];
//    }
//    
//    public static int helper(TreeNode node, int[] max){
//        if(node == null)
//            return 0;
//        // recursively get sum of left and right path
//        int left = helper(node.left, max);
//        int right = helper(node.right, max);
//        int max_single = Math.max( Math.max(left, right)+ node.val, node.val);
//        //update maximum here
//        max[0] = Math.max(max[0], Math.max(left+node.val+right, max_single));
//        // return sum of largest path of current node
//        return max_single;
//    }
	
	public int maxPathSum(TreeNode root) {
        if(root == null)
            return 0;
        return helper(root);
    }
    int max = Integer.MIN_VALUE;
    public int helper(TreeNode node){
        if(node == null)
            return 0;
        int l = helper(node.left);
        int r = helper(node.right);
        int max_single = Math.max(node.val, Math.max(node.val+l, node.val+r));
        max = Math.max(max, Math.max(node.val+l+r, max_single));
        return max_single;
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
