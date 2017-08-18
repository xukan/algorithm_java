package algorithm_java;

//LinkedIn Google Facebook Microsoft

public class BinarySearchTreeIterator {
	TreeNode cur;
    public BinarySearchTreeIterator(TreeNode root) {
        cur = root;
    }

    /** @return whether we have a next smallest number */
    public boolean hasNext() {
        return cur != null;
    }

    /** @return the next smallest number */
    public int next() {
        int res = 0;
        while(cur!=null){
            if(cur.left==null){
                res = cur.val;
                cur = cur.right;
                break;
            }else{
                TreeNode tmp = cur.left;
                while(tmp.right!=null && tmp.right!=cur)
                    tmp = tmp.right;
                if(tmp.right == null){
                    tmp.right = cur;
                    cur = cur.left;
                }else{
                    res = cur.val;
                    tmp.right = null;
                    cur = cur.right;
                    break;
                }
            }
        }
        return res;
    }
}
