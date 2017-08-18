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
	
	//my solution
	public TreeNode invertTree_mysolution(TreeNode root) {
        if(root == null)
            return root;
        helper(root, root.left, root.right);
        return root;
    }
    
    public void helper(TreeNode n, TreeNode n1, TreeNode n2){
        if(n1 == null && n2 == null)
            return;
        else if(n1 != null && n2 ==null){
            n.right = n1;
            n.left = null;
        }else if(n1 == null && n2 != null){
            n.left = n2;
            n.right = null;
        }else{
            n.right = n1;
            n.left = n2;
        }
        if(n1!=null)
            helper(n1, n1.left, n1.right);
        if(n2!=null)
            helper(n2, n2.left, n2.right);
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
