package algorithm_java;

//Google Facebook 

//Maximum Depth of Binary Tree

/*
 *        1
          / \
        2   3
       /  \     
      4   5    
 * 
 * */

public class DiameterofBinaryTree {
	int maxLen = 0;
    public int diameterOfBinaryTree(TreeNode root) {
        if(root == null)
            return 0;
        helper(root);
        return maxLen;
    }
    
    public int helper(TreeNode root){
        if(root == null)
            return 0;
        int l = helper(root.left);
        int r = helper(root.right);
        //The difference between this question and Maximum Depth of Binary Tree is we don't consider parent node while calculating the diameter 
        //because we calculate the maxLen here, it won't take parent node into account, just get sum of left height and right height without parent node
        maxLen = Math.max(maxLen, l+r);
        return Math.max(l,r)+1;
    }
    
    public static void main(String[] args) {
    	DiameterofBinaryTree s = new DiameterofBinaryTree();
		TreeNode root = new TreeNode(1);
		TreeNode node1 = new TreeNode(2);
		TreeNode node2 = new TreeNode(3);
		TreeNode node3 = new TreeNode(4);
		TreeNode node4 = new TreeNode(5);
		root.left =node1;
		root.right = node2;
		node1.left = node3;
		node1.right = node4;
		int h = s.diameterOfBinaryTree(root);
		System.out.println(h);
	}
}
