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

//similar questions: PathSumI, II, III, 

public class BinaryTreePaths {
	
	public List<String> binaryTreePaths(TreeNode root) {
        List<String> res = new ArrayList<String>();
        if(root == null)
            return res;
        bthelper(root, root.val+"", res);
        return res;
    }
    
    public void bthelper(TreeNode node, String str, List<String> res){
        if(node.left == null && node.right == null){
            res.add(str);
        }
        if(node.left!=null){
            bthelper(node.left, str+"->"+node.left.val, res);
        }
        if(node.right!=null){
            bthelper(node.right, str+"->"+node.right.val, res);
        }  
    }
    
    //solutionII
//    public List<String> binaryTreePaths(TreeNode root) {
//        List<String> res = new ArrayList<String>();
//        if(root == null)
//            return res;
//        helper(root, "", res);
//        return res;
//    }
//    
//    public void helper(TreeNode node, String path, List<String> res){
//        if(node == null)
//            return;
//        if(node.left == null && node.right == null){
//            res.add(path + node.val);
//            return;
//        }
//        helper(node.left, path + node.val + "->", res);
//        helper(node.right, path + node.val + "->", res);
//    }
    
	
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
