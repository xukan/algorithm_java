package algorithm_java;

import java.util.HashMap;
import java.util.Map;

/*
 *         10
 *        /    \
 *      5     -3
 *     /  \       \
 *    3   2     11
 *   /  \    \
 *  3  -2   1
 *  
 * */

public class PathSumIII {
	public int pathSum(TreeNode root, int sum) {
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);  //Default sum = 0 has one count
//        return backtrack(root, root.val, sum, map); 
        return backtrack(root, 0, sum, map); 
    }
    //BackTrack one pass
    public int backtrack(TreeNode root, int sum, int target, Map<Integer, Integer> map){
//        if(root == null)
//            return 0;
    	if(root.left == null && root.right==null){
    		sum += root.val;
            if(map.getOrDefault(sum-target, 0)!=0 )
            	return 1;
            else
            	return 0;
		}
        sum += root.val;
        int res = map.getOrDefault(sum - target, 0);    //See if there is a subarray sum equals to target
        map.put(sum, map.getOrDefault(sum, 0)+1);
        //Extend to left and right child
        int l=0, r=0;
        if(root.left != null)
        	l = backtrack(root.left, sum, target, map);
        if(root.right != null)
        	r = backtrack(root.right, sum, target, map);
        res += l + r;
        map.put(sum, map.get(sum)-1);   //Remove the current node so it wont affect other path
        return res;
    }
    
    
    public int maxPathSum(TreeNode root) {
        if(root == null)
            return 0;
        return maxhelper(root);
    }
    int max = 0;
    public int maxhelper(TreeNode node){
        if(node == null)
            return 0;
        int l = maxhelper(node.left);
        int r = maxhelper(node.right);
        max = Math.max(node.val, Math.max(l, r));
        max = Math.max(max, Math.max(node.val+l, node.val+r));
        max = Math.max(max, node.val+l+r);
        return Math.max(node.val+l, node.val+r);
    }
    
    public static void main(String[] args) {
    	PathSumIII s = new PathSumIII();
    	
    	TreeNode root = new TreeNode(10);
		TreeNode node1 = new TreeNode(5);
		TreeNode node2 = new TreeNode(-3);
		TreeNode node3 = new TreeNode(3);
		TreeNode node4 = new TreeNode(2);
		TreeNode node5 = new TreeNode(11);
		TreeNode node6 = new TreeNode(3);
		TreeNode node7 = new TreeNode(-2);
		TreeNode node8 = new TreeNode(1);
		root.left=node1;
		root.right = node2;
		node1.left = node3;
		node1.right = node4;
		node2.right = node5;
		node3.left = node6;
		node3.right = node7;
		node4.right = node8;
		
		TreeNode root = new TreeNode(10);
		TreeNode node1 = new TreeNode(5);
		TreeNode node2 = new TreeNode(-3);
		
		int count = s.pathSum(root, 8);
		System.out.println(count);
	}
}
