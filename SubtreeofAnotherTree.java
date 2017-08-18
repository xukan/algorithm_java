package algorithm_java;

//Facebook eBay
//SameTree

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
}
