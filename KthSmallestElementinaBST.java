package algorithm_java;

import java.util.LinkedList;

//Bloomberg Uber Google 

//https://discuss.leetcode.com/topic/17810/3-ways-implemented-in-java-binary-search-in-order-iterative-recursive/28

//简单的版本就是Morris中序遍历,用count来记录当前遍历到第几个点,等于K的时候返回结果

//Follow up思路： 在查询多和更改多的情况下，我们可以为BST的每个节点增加一个int count，然后进行二分查找。
//这题的难点其实在于Follow Up：如果我们频繁的操作该树，并且频繁的调用kth函数，有什么优化方法使时间复杂度降低至O(h)？
//h是树的高度。根据提示，我们可以在TreeNode中加入一个rank成员，这个变量记录的是该节点的左子树中节点的个数，
//其实就是有多少个节点比该节点小。这样我们就可以用二叉树搜索的方法来解决这个问题了。
//这个添加rank的操作可以在建树的时候一起完成。
//https://discuss.leetcode.com/topic/32792/java-divide-and-conquer-solution-considering-augmenting-tree-structure-for-the-follow-up

/*
 *              5
 *           /      \
 *          2       13
 *        /    \    /    \
 *       1     3 7     15 
 * */

public class KthSmallestElementinaBST {
	// one solution for follow up
	public int kthSmallest(TreeNode root, int k) {
        int left = nodeCount(root.left);  // this value can be saved in the root node
        if(left + 1 == k) {
            return root.val;
        } else if (left + 1 < k) {
            return kthSmallest(root.right, k - left - 1);
        } else {
            return kthSmallest(root.left, k);
        }
    }
    
    private int nodeCount(TreeNode root) {
        if(root == null) {
            return 0;
        }
        return 1 + nodeCount(root.left) + nodeCount(root.right);
    }
    
    public static void main(String[] args) {
    	TreeNode node1 = new TreeNode(5);
		TreeNode node2 = new TreeNode(2);
		TreeNode node3 = new TreeNode(13);
		TreeNode node4 = new TreeNode(1);
		TreeNode node5 = new TreeNode(3);
		TreeNode node6 = new TreeNode(7);
		TreeNode node7 = new TreeNode(15);
		node1.left =node2;
		node1.right = node3;
		node2.left = node4;
		node2.right = node5;
		node3.left = node6;
		node3.right = node7;
	}
}
