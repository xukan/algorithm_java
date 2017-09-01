package algorithm_java;

//Facebook eBay
//SameTree

//tc: O(n), where n is total number of nodes in tree with root node s.

public class SubtreeofAnotherTree {
	public boolean isSubtree(TreeNode s, TreeNode t) {
        if(s == null)
            return false;
        if(isSameTree(s, t))
            return true; 
        boolean l = isSubtree(s.left, t);
        boolean r = isSubtree(s.right, t);
        return l || r;
    }
    
    public boolean isSameTree(TreeNode s, TreeNode t){
        if(s == null && t == null)
            return true;
        if(s == null || t == null)
            return false;
        if(s.val != t.val)
            return false;
        return isSameTree(s.left, t.left) && isSameTree(s.right, t.right);
    }
    
    public static void main(String[] args) {
    	SubtreeofAnotherTree s = new SubtreeofAnotherTree();
    	TreeNode root1 = new TreeNode(1);
    	TreeNode node1 = new TreeNode(1);
    	root1.left = node1;
    	TreeNode root2 = new TreeNode(1);
    	boolean res = s.isSubtree(root1, root2);
    	System.out.println(res);
	}
}
