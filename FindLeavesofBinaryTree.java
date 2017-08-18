package algorithm_java;

import java.util.ArrayList;
import java.util.List;

//LinkedIn
//The key to solve this problem is converting the problem to be finding the index of the element in the result list. 
//Then this is a typical DFS problem on trees.
public class FindLeavesofBinaryTree {
	//solutionI
	public List<List<Integer>> findLeavesI(TreeNode root) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        List<Integer> sol = new ArrayList<Integer>();
        while(root!=null){
            root = printLeaves(root, sol);
            res.add(new ArrayList<Integer>(sol));
            sol.clear();
        }
        return res;
    }
    
    public TreeNode printLeaves(TreeNode node,List<Integer> sol){
        if(node ==null)
        	return null;
    	if(node.left == null && node.right == null){
            sol.add(node.val);
            return null;
        }
    	node.left = printLeaves(node.left, sol);
    	node.right = printLeaves(node.right, sol);
        return node;
    }
	
    //solutionII
	public List<List<Integer>> findLeaves(TreeNode root) {
	    List<List<Integer>> result = new ArrayList<List<Integer>>();
	    helper(result, root);
	    return result;
	}
	 
	// traverse the tree bottom-up recursively
	private int helper(List<List<Integer>> list, TreeNode root){
	    if(root==null)
	        return -1;
	 
	    int left = helper(list, root.left);
	    int right = helper(list, root.right);
	    int curr = Math.max(left, right)+1;
	 
	    // the first time this code is reached is when curr==0,
	    //since the tree is bottom-up processed.
	    if(list.size()<=curr){
	        list.add(new ArrayList<Integer>());
	    }
	 
	    list.get(curr).add(root.val);
	 
	    return curr;
	}
	
	public static void main(String[] args) {
		FindLeavesofBinaryTree s = new FindLeavesofBinaryTree();
		TreeNode root = new TreeNode(1);
		TreeNode node1 = new TreeNode(2);
		TreeNode node2 = new TreeNode(3);
		TreeNode node3 = new TreeNode(4);
		TreeNode node4 = new TreeNode(5);
		root.left = node1;
		root.right = node2;
		node1.left = node3;
		node1.right = node4;
		List<List<Integer>> res = s.findLeavesI(root);
		for(List<Integer> list: res){
			for(int i: list){
				System.out.print(i+ " ");
			}
			System.out.println();
		}
	}
}
