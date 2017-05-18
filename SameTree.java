package algorithm_java;

//Bloomberg
//similar to Symmetric Tree
//similar to 

public class SameTree {
	public boolean isSameTree(TreeNode p, TreeNode q) {
        if(p==null && q==null)
            return true;
        else if(p==null || q==null)
            return false;
        if(p.val == q.val){
            return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
        }else
            return false;
        
//        if(p.val != q.val)
//        	return false;
//        return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }
}
