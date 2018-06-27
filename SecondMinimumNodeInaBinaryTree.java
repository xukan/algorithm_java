package algorithm_java;

//LinkedIn 

//This solution is based on preorder traversal. Time complexity should be O(n), where n is the total number of nodes in the binary tree.
public class SecondMinimumNodeInaBinaryTree {
	int first;
    int second;
    public int findSecondMinimumValue(TreeNode root) {
        if(root == null)
            return -1;
        first = root.val;
        second = root.val;
        update(root);
        return second == first?-1:second;
    }
    
    public void update(TreeNode node){
        if(node == null)
            return;
        if(node.left!=null && node.right != null)
            node.val = Math.min(node.left.val, node.right.val);
        if(node.val <= first)
            first = node.val;
        else if(node.val <= second || second == first)
            second = node.val;
        update(node.left);
        update(node.right);
    }
    
    public static void main(String[] args) {
    	SecondMinimumNodeInaBinaryTree s = new SecondMinimumNodeInaBinaryTree();
    	 TreeNode root = new TreeNode(2);
		 TreeNode node1 = new TreeNode(2);
		 TreeNode node2 = new TreeNode(5);
		 TreeNode node3 = new TreeNode(5);
		 TreeNode node4 = new TreeNode(7);
		 root.left = node1;
		 root.right = node2;
		 node2.left = node3;
		 node2.right = node4;
		 int res = s.findSecondMinimumValue(root);
		 System.out.println(res);
	}
}
