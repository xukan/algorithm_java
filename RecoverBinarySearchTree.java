package algorithm_java;

public class RecoverBinarySearchTree {
	public static void recoverTree(TreeNode root) {
		TreeNode cur = root;
		TreeNode prev = null;
		TreeNode first = null, second = null;
		while(cur != null){
			if(cur.left == null){
				if(prev!=null && prev.val > cur.val){
					if(first == null){
						first = prev;
						second = cur;
					}else
						second = cur;
				}
				prev = cur;
				cur = cur.right;
			}else{
				TreeNode temp = cur.left;
				while(temp.right!=null && temp.right != cur){
					temp = temp.right;
				}
				if(temp.right == null){
					temp.right = cur;
					cur = cur.left;
				}else{
					if(prev != null && prev.val>cur.val){
						if(first == null){
							first = prev;
							second = cur;
						}else
							second = cur;
					}
					prev = cur;
					temp.right = null;
					cur = cur.right;
				}
			}
		}
		int k = first.val;
		first.val = second.val;
		second.val = k;
	}
	
	public static void main(String[] args) {
		TreeNode root = new TreeNode(2);
		TreeNode node1 = new TreeNode(3);
		TreeNode node2 = new TreeNode(1);
		root.left=node1;
		root.right = node2;
		recoverTree(root);
	}
}
