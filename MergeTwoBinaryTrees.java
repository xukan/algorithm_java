package algorithm_java;

public class MergeTwoBinaryTrees {
	public TreeNode mergeTrees(TreeNode t1, TreeNode t2) {
        if(t1 == null && t2 == null)
            return null;
        if(t1!=null && t2!=null){
            t1.val += t2.val;
        }
        if(t1 != null && t2==null){
            return t1;
        }
        if(t1 == null && t2!=null){
            return t2;
        }
        TreeNode l = mergeTrees(t1.left, t2.left);
        TreeNode r = mergeTrees(t1.right, t2.right);
        t1.left = l;
        t1.right = r;
        return t1;
    }
}
