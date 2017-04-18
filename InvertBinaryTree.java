package algorithm_java;

public class InvertBinaryTree {
	//recursion
	public TreeNode invertTree(TreeNode root) {
        if(root == null)
        	return null;
        TreeNode l = root.left;
        TreeNode r = root.right;
        root.left = invertTree(r);
        root.right = invertTree(l);
        return root;
    }
	
	
	
	public void inorder(TreeNode node){
		if(node == null)
				return;
		inorder(node.left);
		System.out.println(node.val);
		inorder(node.right);
	}
	
	public static void main(String[] args){
		TreeNode node1 = new TreeNode(1);
		TreeNode node2 = new TreeNode(2);
		TreeNode node3 = new TreeNode(3);
		TreeNode node4 = new TreeNode(4);
		TreeNode node5 = new TreeNode(5);
		TreeNode node6 = new TreeNode(6);
		TreeNode node7 = new TreeNode(7);
		node1.left =node2;
		node1.right = node3;
		node2.left = node4;
		node2.right = node5;
		node3.left = node6;
		
		InvertBinaryTree s = new InvertBinaryTree();
		s.inorder(node1);
		
		//TreeNode res = s.invertTree(node1);
		//System.out.println(res);
	}
}
