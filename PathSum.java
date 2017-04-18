package algorithm_java;

import java.util.ArrayList;
import java.util.List;

/*
 *              5
 *           /      \
 *          4       8
 *         /       /    \
 *       11     13    4
 *      /    \          /   \
 *     7     2       5    1 
 * */

//these three questions are based on method used in Binary Tree Paths
//I Microsoft
//II Bloomberg
//III

public class PathSum {
	public boolean hasPathSum(TreeNode root, int sum) {
        if(root == null)
            return false;
        return helper(root, sum - root.val);
    }
    
    public boolean helper(TreeNode root, int sum){
        if(root.left == null && root.right == null){
            return sum == 0?true: false;
        }
        boolean l = false, r=false;
        if(root.left!=null)
            l = helper(root.left, sum-root.left.val);
        if(root.right != null )
            r = helper(root.right, sum - root.right.val);
        return l || r;
    }
    
    //path sum II 
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        if(root == null)
            return res;
        List<Integer> sol = new ArrayList<Integer>();
        sol.add(root.val);
        helperII(root, sum-root.val, sol, res);
        return res;
    }
    
    public void helperII(TreeNode node, int sum, List<Integer> sol, List<List<Integer>> res){
        if(node.left == null && node.right == null){
            if(sum ==0){
                res.add(new ArrayList<Integer>(sol));
                return;
            }
        }
        if(node.left != null){
            sol.add(node.left.val);
            helperII(node.left, sum-node.left.val, sol, res);
            sol.remove(sol.size()-1);
        }
        if(node.right != null){
            sol.add(node.right.val);
            helperII(node.right, sum-node.right.val, sol, res);
            sol.remove(sol.size()-1);
        }
        
        //III
        //https://discuss.leetcode.com/topic/64526/17-ms-o-n-java-prefix-sum-method/12
    }
    
    public static void main(String[] args) {
		TreeNode root = new TreeNode(5);
		TreeNode node1 = new TreeNode(4);
		TreeNode node2 = new TreeNode(8);
		TreeNode node3 = new TreeNode(11);
		TreeNode node4 = new TreeNode(13);
		TreeNode node5 = new TreeNode(4);
		TreeNode node6 = new TreeNode(7);
		TreeNode node7 = new TreeNode(2);
		TreeNode node8 = new TreeNode(5);
		TreeNode node9 = new TreeNode(1);
		root.left=node1;
		root.right = node2;
		node1.left = node3;
		node2.left = node4;
		node2.right = node5;
		node3.left = node6;
		node3.right = node7;
		node5.left = node8;
		node5.right = node9;
		PathSum s = new PathSum();
		
		//Path Sum I
		boolean resI = s.hasPathSum(root, 22);
		System.out.println(resI);
		
		 List<List<Integer>> resII = s.pathSum(root, 22);
		 for(List<Integer> l : resII){
			 for(int i: l)
				 System.out.print(i+  " ");
			 System.out.println();
		 }
	}
}
