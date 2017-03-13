package algorithm_java;

import java.util.ArrayList;

//Microsoft Google Snapchat

//similar to Minimum Absolute Difference in BST
public class ClosestBinarySearchTreeValue {
    public int closestValue(TreeNode root, double target) {
        if(root == null)
            return 0;
        ArrayList<Integer> list = new ArrayList<Integer>();
        TreeNode cur = root, prev = null;
        while(cur!=null){
            if(cur.left == null){
                list.add(cur.val);
                cur = cur.right;
            }else{
                prev = cur.left;
                while(prev.right !=null && prev.right !=cur){
                    prev = prev.right;
                }
                if(prev.right!=cur){
                    prev.right = cur;
                    cur = cur.left;
                }else{
                    prev.right = null;
                    list.add(cur.val);
                    cur = cur.right;
                }
            }
        }
        double diff = Double.MAX_VALUE;
        int res = -1;
        for(int i=0;i<list.size();i++){
            if(Math.abs((double)list.get(i)-target) < diff){
                diff = Math.abs((double)list.get(i)-target);
                res = list.get(i);
            }
        }
        return res;
    }
    
    //II, Google
    /*
     * Given a non-empty binary search tree and a target value, find k values in the BST that are closest to the target.
     * Note:
     * Given target value is a floating point.
     * You may assume k is always valid, that is: k ≤ total nodes.
     * You are guaranteed to have only one unique set of k values in the BST that are closest to the target.
     * Follow up:
     * Assume that the BST is balanced, could you solve it in less than O(n) runtime (where n = total nodes)?
     * Hint:
     * Consider implement these two helper functions:
     * getPredecessor(N), which returns the next smaller node to N.
     * getSuccessor(N), which returns the next larger node to N.
     * Try to assume that each node has a parent pointer, it makes the problem much easier.
     * Without parent pointer we just need to keep track of the path from the root to the current node using a stack.
     * You would need two stacks to track the path in finding predecessor and successor node separately.
     * */
}
