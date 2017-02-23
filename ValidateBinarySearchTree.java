package algorithm_java;

import java.util.ArrayList;
import java.util.List;

//Amazon Microsoft Bloomberg Facebook

//class TreeNode {
//	int val;
//	TreeNode left;
//	TreeNode right;
//	TreeNode(int x) {
//		val = x;
//	}
//}
//Morris Traversal Algorithm
//Time complexity: O(n+m), n is total # of nodes, m is total # of edges, since m = n-1
//O(n+m) = O(n+n-1) -> O(n)
//Space complexity: O(1)
public class ValidateBinarySearchTree {
	public static boolean isValidBST(TreeNode root) {
		List<Integer> inorder = new ArrayList<Integer>();
		TreeNode cur = root;
		while (cur != null) {
			if (cur.left == null) {
				if (inorder.size() > 0 && inorder.get(inorder.size() - 1) >= cur.val)
					return false;
				inorder.add(cur.val);
				cur = cur.right;
			} else {
				TreeNode prev = cur.left;
				while (prev.right != null && prev.right != cur)
					prev = prev.right;
				if (prev.right != cur) {
					prev.right = cur;
					cur = cur.left;
				} else {
					if (inorder.size() > 0 && inorder.get(inorder.size() - 1) >= cur.val)
						return false;
					inorder.add(cur.val);
					prev.right = null;
					cur = cur.right;
				}
			}
		}
		for (int i : inorder)
			System.out.print(i + " ");
		return true;
	}

	// solution 2:
	// Use inorder traverse to check a binary search tree, awesome!
	public boolean IsValidBST(TreeNode root) {
		ArrayList<Integer> pre = new ArrayList<Integer>();
		pre.add(null);
		return helper(root, pre);
	}

	public boolean helper(TreeNode root, ArrayList<Integer> pre) {
		if (root == null)
			return true;
		boolean left = helper(root.left, pre);
		if (pre.get(0) != null && root.val <= pre.get(0))
			return false;
		pre.set(0, root.val);
		return left && helper(root.right, pre);
	}

	public static void main(String[] args) {
		TreeNode node1 = new TreeNode(5);
		TreeNode node2 = new TreeNode(2);
		TreeNode node3 = new TreeNode(7);
		TreeNode node4 = new TreeNode(1);
		TreeNode node5 = new TreeNode(3);
		TreeNode node6 = new TreeNode(6);
		TreeNode node7 = new TreeNode(10);
		node1.left = node2;
		node1.right = node3;
		node2.left = node4;
		node2.right = node5;
		node3.left = node6;
		node3.right = node7;
		boolean res = isValidBST(node1);
		System.out.println(res);
	}
}
