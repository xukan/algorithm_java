package algorithm_java;

//Google

public class MinimumAbsoluteDifferenceinBST {
	public int getMinimumDifference(TreeNode root) {
        int min = Integer.MAX_VALUE;
        TreeNode cur = root;
        TreeNode prev = null;
        while(cur!=null){
            if(cur.left == null){
                if(prev!=null)
                    min = Math.min(cur.val - prev.val, min);
                prev = cur;
                cur = cur.right;
            }else{
                TreeNode temp = cur.left;
                while(temp.right!=null && temp.right!=cur)
                    temp = temp.right;
                if(temp.right == null){
                    temp.right = cur;
                    cur = cur.left;
                }else{
                    temp.right = null;
                    if(prev!=null)
                        min = Math.min(cur.val - prev.val, min);
                    prev = cur;
                    cur = cur.right;
                }
            }
        }
        return min;
    }
}
