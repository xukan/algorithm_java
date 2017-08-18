package algorithm_java;

/*
 * A full binary tree (sometimes proper binary tree or 2-tree) is a tree in which every node other than the leaves has two children
 * A complete binary tree is a binary tree in which every level, except possibly the last, is completely filled, and all nodes are as far left as possible
 * */

/*
*                           5
*                       /      \
*                     4         8
*                   /   \       /  \
*                11    10  13   4
*                /  \    /  
*              7    2 5   
* */

public class CountCompleteTreeNodes {
	public int countNodes(TreeNode root) {
	    if(root==null)
	        return 0;
	 
	    int left = getHeight(root.left)+1;   
	    int right = getHeight(root.right)+1;
	 
	    if(left==right){
	        return (2<<(left-1))-1;
	    }else{
	    	int lh = countNodes(root.left);
	    	int rh = countNodes(root.right);
	        return lh+rh+1;
	    }
	}
	 
	public int getHeight(TreeNode node){
	    if(node==null) return 0;
	    return 1 + getHeight(node.left);
	}
	
	
	public static void main(String[] args) {
		CountCompleteTreeNodes s = new CountCompleteTreeNodes();
		TreeNode root = new TreeNode(5);
		 TreeNode node1 = new TreeNode(4);
		 TreeNode node2 = new TreeNode(8);
		 TreeNode node3 = new TreeNode(11);
		 TreeNode node4 = new TreeNode(13);
		 TreeNode node5 = new TreeNode(4);
		 TreeNode node6 = new TreeNode(7);
		 TreeNode node7 = new TreeNode(2);
		 TreeNode node8 = new TreeNode(5);
		 TreeNode node10 = new TreeNode(10);
		 root.left=node1;
		 root.right = node2;
		 node1.left = node3;
		 node1.right = node10;
		 node2.left = node4;
		 node2.right = node5;
		 node3.left = node6;
		 node3.right = node7;
		 node10.left = node8;
		 int res = s.countNodes(root);
		 System.out.println(res);
	}
}
