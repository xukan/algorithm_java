package algorithm_java;

//Google 

public class BinaryTreeLongestConsecutiveSequence {
	private int maxLength = 0;
	public int longestConsecutive_topdown(TreeNode root) {
	    dfs(root, null, 0);
	    return maxLength;
	}

	public void dfs(TreeNode p, TreeNode parent, int length) {
	    if (p == null) return;
	    length = (parent != null && p.val == parent.val + 1) ? length + 1 : 1;
	    maxLength = Math.max(maxLength, length);
	    dfs(p.left, p, length);
	    dfs(p.right, p, length);
	}
	
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
