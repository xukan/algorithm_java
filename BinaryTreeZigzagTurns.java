package algorithm_java;

public class BinaryTreeZigzagTurns {
	int max = 0;
	public int zigzagturn(TreeNode root){
		if(root == null)
			return 0;
		helper(root, 0, true, true);
		return max;
	}
	
	public void helper(TreeNode node, int turn, boolean isLeft, boolean isRight){
		if(node.left == null && node.right == null){
			max = Math.max(max, turn);
		}
		if(node.left != null){
			int l = turn + (isLeft?0:1);
			helper(node.left, l, true, false);
		}
		if(node.right != null){
			int r = turn + (isRight?0:1);
			helper(node.right, r, false, true);
		}
	}
	
	public static void main(String[] args) {
		BinaryTreeZigzagTurns s = new BinaryTreeZigzagTurns();
		
		TreeNode root = new TreeNode(5);
		 TreeNode node1 = new TreeNode(3);
		 TreeNode node2 = new TreeNode(10);
		 TreeNode node3 = new TreeNode(20);
		 TreeNode node4 = new TreeNode(1);
		 TreeNode node5 = new TreeNode(15);
		 TreeNode node6 = new TreeNode(6);
		 TreeNode node7 = new TreeNode(30);
		 TreeNode node8 = new TreeNode(8);
		 TreeNode node9 = new TreeNode(9);
		 TreeNode node10 = new TreeNode(11);
		 TreeNode node11 = new TreeNode(19);
		 TreeNode node12 = new TreeNode(29);
		 TreeNode node13 = new TreeNode(31);
		 TreeNode node14 = new TreeNode(32);
		 root.left = node1;
		 root.right = node2;
		 node1.left = node3;
		 node2.left = node4;
		 node2.right = node5;
		 node3.left = node6;
		 node5.left = node7;
		 node5.right = node8;
		 node7.right = node9;
		 node9.left = node13;
		 node13.right = node14;
		 node3.right = node10;
		 node10.left = node11;
		 node11.right = node12;
		 int res =s.zigzagturn(root);
		 System.out.println(res);
	}
}	
