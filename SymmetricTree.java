package algorithm_java;

//similar to same tree

//LinkedIn Bloomberg Microsoft

public class SymmetricTree {
	public boolean isSymmetric(TreeNode root) {
        if(root==null)
            return true;
        return helper(root.left, root.right);
    }
    
    public boolean helper(TreeNode l, TreeNode r){
        if(l == null && r == null)
            return true;
        else if(l == null || r ==null)
            return false;
        
        if (l.val != r.val)
		    return false;
 
        return helper(l.left, r.right) && helper(l.right, r.left);
//        The last line can be expaned as following:
//	    if (!isSymmetric(l.left, r.right))
//	    	return false;
//        if (!isSymmetric(l.right, r.left))
//        	return false;
//	    return true;
    }
    
	public static void main(String[] args){
		TreeNode node1 = new TreeNode(1);
		TreeNode node2 = new TreeNode(2);
		TreeNode node3 = new TreeNode(2);
		TreeNode node4 = new TreeNode(3);
		TreeNode node5 = new TreeNode(3);
		TreeNode node6 = new TreeNode(4);
		TreeNode node7 = new TreeNode(4);
		node1.left =node2;
		node1.right = node3;
		node2.left = node4;
		node3.right = node5;
		node2.right = node6;
		node3.left = node7;

//		TreeNode node2 = new TreeNode(2);
//		TreeNode node3 = new TreeNode(2);
//		TreeNode node4 = new TreeNode(3);
//		TreeNode node5 = new TreeNode(3);
//		TreeNode node6 = new TreeNode(4);
//		TreeNode node7 = new TreeNode(4);
//		node1.left =node2;
//		node1.right = node3;
//		node2.left = node4;
//		node3.right = node5;
//		node2.right = node6;
//		node3.left = node7;

		SymmetricTree s = new SymmetricTree();
		boolean res = s.isSymmetric(node1);
		System.out.println(res);
	}
}
