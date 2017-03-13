package algorithm_java;

import java.util.ArrayList;
import java.util.List;

//Google Apple Facebook

/*
 *              5
 *           /      \
 *          4       8
 *         /       /    \
 *       11     13    4
 *      /    \             \
 *     7     2            1 
 * */

public class BinaryTreePaths {
	
	List<String> res = new ArrayList<String>();
  
	public List<String> binaryTreePaths(TreeNode root) {
		if(root != null) 
			findPaths(root,String.valueOf(root.val));
		return res;
	}
  
	private void findPaths(TreeNode n, String path){
		if(n.left == null && n.right == null) 
			res.add(path);
		if(n.left != null)
			findPaths(n.left, path+"->"+n.left.val);
		if(n.right != null)
			findPaths(n.right, path+"->"+n.right.val);
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
		TreeNode node8 = new TreeNode(1);
		root.left=node1;
		root.right = node2;
		node1.left = node3;
		node2.left = node4;
		node2.right = node5;
		node3.left = node6;
		node3.right = node7;
		node5.right = node8;
		BinaryTreePaths s = new BinaryTreePaths();
		 List<String> res = s.binaryTreePaths(root);
		 for(String str : res)
			 System.out.println(str+" ");
	}
}
