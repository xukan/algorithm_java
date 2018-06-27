package algorithm_java;

//Amazon

//this question requires removing exactly one edge, so we can just bottom up method to solve it.
public class EqualTreePartition {
	boolean equal = false;
    public boolean checkEqualTree(TreeNode root) {
        if(root == null)
            return false;
        int total = getTotal(root);
        check(root, root, total);
        return equal;
    }
    
    public int getTotal(TreeNode node){
        if(node == null)
            return 0;
        int l = getTotal(node.left);
        int r = getTotal(node.right);
        return l + node.val + r;
    }
    
    public int check(TreeNode root, TreeNode node, int sum){
        if(node == null)
            return 0;
        int l = check(root, node.left, sum);
        int r = check(root, node.right, sum);
        int cur = l + node.val + r;
        if( node!= root && sum == 2 * cur ){  // corner case:     tree:   -1 <- 0 -> 1 should return false
            equal = true;
        }
        return cur;
    }
      
    public static void main(String[] args) {
    	EqualTreePartition s = new EqualTreePartition();
    	TreeNode root = new TreeNode(0);
		TreeNode node1 = new TreeNode(0);
//		TreeNode node2 = new TreeNode(1);
//		TreeNode node3 = new TreeNode(11);
//		TreeNode node4 = new TreeNode(13);
//		TreeNode node5 = new TreeNode(4);
//		TreeNode node6 = new TreeNode(7);
//		TreeNode node7 = new TreeNode(2);
//		TreeNode node8 = new TreeNode(1);
		root.left=node1;
//		root.right = node2;
//		node1.left = node3;
//		node2.left = node4;
//		node2.right = node5;
//		node3.left = node6;
//		node3.right = node7;
//		node5.right = node8;
		boolean res = s.checkEqualTree(root);
		System.out.println(res);
	}
}
