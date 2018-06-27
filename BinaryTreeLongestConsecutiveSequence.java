package algorithm_java;

//Google 

public class BinaryTreeLongestConsecutiveSequence {
	//top-down solution, tc: O(n)
	int maxLen = 1;
    public int longestConsecutive(TreeNode root) {
        if(root == null)
            return 0;
        helper(root, null, 0);
        return maxLen;
    }
    
    public void helper(TreeNode node, TreeNode parent, int len){
        if(node == null)
            return;
        if(parent != null && parent.val + 1 == node.val){
            len +=1;
            maxLen = Math.max(maxLen, len);
        }else
            len = 1;
        helper(node.left, node, len);
        helper(node.right, node, len);
    }
	
    //bottom up solution
    int maxLength = 0;
	public int longestConsecutive_bottomup(TreeNode root) {
	    helper(root);
	    return maxLength;
	}

	private int helper(TreeNode p) {
	    if (p == null) return 0;
	    int L = helper(p.left) + 1;
	    int R = helper(p.right) + 1;
	    if (p.left != null && p.val + 1 != p.left.val) {
	        L = 1;
	    }
	    if (p.right != null && p.val + 1 != p.right.val) {
	        R = 1;
	    }
	    int length = Math.max(L, R);
	    maxLength = Math.max(maxLength, length);
	    return length;
	}

	public static void main(String[] args) {
		BinaryTreeLongestConsecutiveSequence s = new BinaryTreeLongestConsecutiveSequence();
		TreeNode root = new TreeNode(1);
		 TreeNode node1 = new TreeNode(3);
		 TreeNode node2 = new TreeNode(8);
		 TreeNode node3 = new TreeNode(4);
		 TreeNode node4 = new TreeNode(9);
		 TreeNode node5 = new TreeNode(5);

		 root.right=node1;
		 node1.left = node2;
		 node1.right = node3;
		 node2.left = node4;
		 node3.right = node5;
		 int res = s.longestConsecutive_bottomup(root);
		 System.out.println(res);
	}
}	
