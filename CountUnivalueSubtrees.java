package algorithm_java;

public class CountUnivalueSubtrees {

	int count = 0;
    public int countUnivalSubtrees(TreeNode root) {
        if(root == null)
            return 0;
        helper(root);
        return count;
    }
    
    public boolean helper(TreeNode root){
        if(root == null){
            return true;
        }
        boolean	 l =helper(root.left);
        boolean	 r= helper(root.right);
        if(l && r){
        	if(root.left != null && root.val != root.left.val)
        		return false;
        	if(root.right != null && root.val != root.right.val)
        		return false;
        	count++;
        	return true;
        }
        return false;
    }
	
    public static void main(String[] args) {
    	TreeNode root = new TreeNode(5);
    	TreeNode node1 = new TreeNode(1);
		TreeNode node2 = new TreeNode(5);
		TreeNode node3 = new TreeNode(5);
		TreeNode node4 = new TreeNode(5);
		TreeNode node5 = new TreeNode(5);
		root.left = node1;
		root.right = node2;
		node1.left = node3;
		node1.right = node4;
		node2.right = node5;
		
		CountUnivalueSubtrees s = new CountUnivalueSubtrees();
		int res = s.countUnivalSubtrees(root);
		System.out.println(res);
	}
}
