package algorithm_java;

//http://www.geeksforgeeks.org/convert-given-binary-tree-doubly-linked-list-set-3/
//Facebook

/*
 *               5
 *            /     \
 *           4       8
 *         /        /    \
 *       11      13    4
 *            
 * */

//similar question
//BinaryTreetoCircularDDL

public class ConvertBinaryTreetoDoublyLinkedList {
	TreeNode head = null, prev = null;
	public TreeNode convert(TreeNode root) {
		if(root == null)
			return null;
		helper(root);
		//at last, prev points to the tail node
		return head;
	}
	
	public void helper(TreeNode node){
		if(node == null)
			return;
		convert(node.left);
		if(head == null){
			head = node;
		}
		if(prev != null){
			prev.right = node;
			node.left = prev;
		}
		prev = node;
		convert(node.right);
	}

	public static void main(String[] args) {
		ConvertBinaryTreetoDoublyLinkedList s = new ConvertBinaryTreetoDoublyLinkedList();
		TreeNode root = new TreeNode(5);
		TreeNode node1 = new TreeNode(4);
		TreeNode node2 = new TreeNode(8);
		TreeNode node3 = new TreeNode(11);
		TreeNode node4 = new TreeNode(13);
		TreeNode node5 = new TreeNode(4);
		root.left = node1;
		root.right = node2;
		node1.left = node3;
		node2.left = node4;
		node2.right = node5;
		
		TreeNode start = s.convert(root);
		TreeNode cur = start;
		while(cur!=null){
			System.out.print(cur.val + " ");
			cur = cur.right;
		}
	}
}
