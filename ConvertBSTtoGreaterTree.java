package algorithm_java;

//similar question
//Validate BST

//Amazon 

public class ConvertBSTtoGreaterTree {
	//solution I
//	int sum = 0;
//    public TreeNode convertBST(TreeNode root) {
//        helper(root);
//        return root;
//    }
//    
//    public void helper(TreeNode node){
//        if(node == null)
//            return;
//        helper(node.right);
//        node.val += sum;
//        sum = node.val;
//        helper(node.left);
//    }
    
    TreeNode prev = null;
    public TreeNode convertBST(TreeNode root) {
        if(root == null)
            return root;
        helper(root);
        return root;
    }
    
    public void helper(TreeNode node){
        if(node == null)
            return;
        helper(node.right);
        if(prev!=null)
            node.val += prev.val;
        prev = node;
        helper(node.left);
    }
    
    
    public void inorder(TreeNode node){
    	if(node==null)
    		return;
    	inorder(node.left);
    	System.out.print(node.val+" ");
    	inorder(node.right);
    }
    
    public static void main(String[] args){
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
		
		ConvertBSTtoGreaterTree s = new ConvertBSTtoGreaterTree();
		TreeNode res = s.convertBST(node1);
		s.inorder(node1);
	}
}
