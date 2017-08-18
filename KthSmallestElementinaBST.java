package algorithm_java;

import java.util.LinkedList;

//Bloomberg Uber Google 

//https://discuss.leetcode.com/topic/17810/3-ways-implemented-in-java-binary-search-in-order-iterative-recursive/28

public class KthSmallestElementinaBST {
	public class TreeNodeWithCount {
	    int val;
	    int lCount;
	    TreeNodeWithCount left;
	    TreeNodeWithCount right;
	    TreeNodeWithCount(int x) { val = x; }
	}

	public int kthSmallest(TreeNode root, int k) {
	    if(root == null) return -1;
	    TreeNodeWithCount rootWithCount = createBSTWithCount(root);
	    return kthSmallestWithCount(rootWithCount, k);
	}

	public TreeNodeWithCount createBSTWithCount(TreeNode root) {
	    LinkedList<TreeNode> queue = new LinkedList<TreeNode>();
	    queue.add(root);
	    TreeNodeWithCount rootWithCount = null;
	    while(!queue.isEmpty()) {
	        TreeNode node = queue.remove();
	        TreeNodeWithCount nodeWithCount = new TreeNodeWithCount(node.val);
	        rootWithCount = insertBSTWithCount(rootWithCount, nodeWithCount);
	        if(node.left != null) queue.add(node.left);
	        if(node.right != null) queue.add(node.right);
	    }
	    return rootWithCount;
	}

	public TreeNodeWithCount insertBSTWithCount(TreeNodeWithCount rootWithCount, TreeNodeWithCount nodeWithCount) {
	    TreeNodeWithCount cur = rootWithCount, parent = rootWithCount;
	    while(cur != null) {
	        parent = cur;
	        if(nodeWithCount.val < cur.val) {
	            cur.lCount++;
	            cur = cur.left;
	        } else {
	            cur = cur.right;
	        }
	    }
	    if(rootWithCount == null) {
	        rootWithCount = nodeWithCount;
	    } else if(nodeWithCount.val < parent.val) {
	        parent.left = nodeWithCount;
	    } else {
	        parent.right = nodeWithCount;
	    }
	    return rootWithCount;
	}

	public int kthSmallestWithCount(TreeNodeWithCount rootWithCount, int k) {
	    while(rootWithCount != null) {
	        if(k == rootWithCount.lCount + 1) {
	            return rootWithCount.val;
	        } else if(k <= rootWithCount.lCount) {
	            rootWithCount = rootWithCount.left;
	        } else {
	            k = k - rootWithCount.lCount - 1;
	            rootWithCount = rootWithCount.right;
	        }
	    }
	    return -1;
	}
}
