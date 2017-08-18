package algorithm_java;

//Gilt Groupe

public class AddOneRowtoTree {
	public TreeNode addOneRow(TreeNode root, int v, int d) {
        if(root ==  null)
            return null;
        if(d == 1){
            TreeNode node = new TreeNode(v);
            node.left = root;
            return node;
        }
        TreeNode cur = root;
        helper(cur, v, d-1);
        return root;
    }
    
    public void helper(TreeNode cur, int v, int d){
    	if(cur == null)
    		return;
        if(d== 1){
            TreeNode l = new TreeNode(v);
            TreeNode r = new TreeNode(v);
            l.left = cur.left;
            cur.left = l;
            r.right = cur.right;
            cur.right = r;
            return;
        }
        helper(cur.left, v, d-1);
        helper(cur.right, v, d-1);
    }
    
    public void printTree(TreeNode root){
		if (root == null)
			return;
		printTree(root.left);
		System.out.print(root.val + " ");
		printTree(root.right);
	}
    
    public static void main(String[] args) {
    	AddOneRowtoTree s = new AddOneRowtoTree();
    	TreeNode root = new TreeNode(4);
		 TreeNode node1 = new TreeNode(2);
		 TreeNode node2 = new TreeNode(6);
		 TreeNode node3 = new TreeNode(3);
		 TreeNode node4 = new TreeNode(1);
		 TreeNode node5 = new TreeNode(5);
		 root.left = node1;
		 root.right = node2;
		 node1.left = node3;
		 node1.right = node4;
		 node2.left = node5;
		 TreeNode node = s.addOneRow(root, 1, 3);
		 s.printTree(root);
	}
}
