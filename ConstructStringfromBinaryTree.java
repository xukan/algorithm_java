package algorithm_java;

/*
 *              1
 *            /    \
 *           2     3
 *             \  
 *              4 
 * */

public class ConstructStringfromBinaryTree {
	//my solution
	public String tree2str(TreeNode t) {
        String res = "";
        if(t == null)
            return res;
        return helper(res+t.val, t);
    }
    
    public String helper(String res, TreeNode node){
        if(node.left == null && node.right == null)
            return res;
        if(node.left != null){
            res += "(" + node.left.val;
            res = helper(res, node.left);
            res += ")";
        }else{
        	res += "()";
        }
        if(node.right != null){
            res += "(" + node.right.val;
            res = helper(res, node.right);
            res += ")";
        }
        return res;
    }
    
    //concise solution
    public String tree2strI(TreeNode t) {
         if(t == null)
             return "";
         if(t.left == null && t.right == null)
             return String.valueOf(t.val);
         String l = tree2strI(t.left);
         String r = tree2strI(t.right);
         String s = t.val + "(" + l + ")";
         s = t.right == null ? s : s + "(" + r + ")";
         return s;
     }
    
    public static void main(String[] args) {
    	ConstructStringfromBinaryTree s = new ConstructStringfromBinaryTree();
    	TreeNode root = new TreeNode(1);
		TreeNode node1 = new TreeNode(2);
		TreeNode node2 = new TreeNode(3);
		TreeNode node3 = new TreeNode(4);
		root.left=node1;
		root.right = node2;
		node1.right = node3;
		String res = s.tree2strI(root);
		System.out.println(res);
	}
}
