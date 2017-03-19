package algorithm_java;

/*      1
	  /     \
	 2       3
	/  \     / 
   4   5  6
	   / \
	  7  8     */


//similar problem : Balanced Binary Tree

public class MinimumDepthofBinaryTree {
	public static int minDepth(TreeNode root) {
        if(root == null)
            return 0;
        int l = minDepth(root.left);
        int r = minDepth(root.right);
        //corner case is 
        /*    1
         *   /
         *  2 
         * */
        //TreeNode 1 only has left child and no right child
        //in this case, program reaches if(root == null) return 0; so right height is 0, left height is 1
        //if return Math.min(l, r)+1; result would be 1 which is wrong, since the correct answer is 2
        if(l==0 || r == 0)
            return l >=r ? l+1: r+1;
            
        return Math.min(l, r)+1;
    }
	
	public static void main(String[] args) {
		TreeNode node1 = new TreeNode(1);
		TreeNode node2 = new TreeNode(2);
		TreeNode node3 = new TreeNode(3);
		TreeNode node4 = new TreeNode(4);
		TreeNode node5 = new TreeNode(5);
		TreeNode node6 = new TreeNode(6);
		TreeNode node7 = new TreeNode(7);
		TreeNode node8 = new TreeNode(8);
		node1.left =node2;
		node1.right = node3;
		node2.left = node4;
		node2.right = node5;
		node3.left = node6;
		node5.left = node7;
		node5.right = node8;
		
		int res = minDepth(node1);
		System.out.println(res);
	}
}
