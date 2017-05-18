package algorithm_java;

public class SumRoottoLeafNumbers {
//	public static int sumNumbers(TreeNode root) {
//        if(root == null)
//            return 0;
//        return helper(root, 0);
//    }
//    
//    public static int helper(TreeNode node, int levelBase){
//        if(node==null)
//            return 0;
//        if(node.left == null && node.right == null){
//            int num = levelBase + node.val;
//        	 return num;
//        }
//        int nextLevelBase = (levelBase + node.val)*10;
//        int lsum = helper(node.left, nextLevelBase);
//        int rsum = helper(node.right, nextLevelBase);
//        return lsum + rsum;
//    }
    
	int sum = 0;
    public int sumNumbers(TreeNode root) {
        if(root==null)
            return 0;
        helper(root, 0);
        return sum;
    }
    
    public void helper(TreeNode node, int v){
        if(node.left==null &&node.right == null){
            sum = sum + v+node.val;
            return;
        }
        v+=node.val;
        if(node.left!=null){
            helper(node.left, 10*v);
        }
        if(node.right!=null){
            helper(node.right, 10*v);
        }
    }
	
    public static void main(String[] args) {
    	TreeNode root = new TreeNode(1);
		 TreeNode node1 = new TreeNode(2);
		 TreeNode node2 = new TreeNode(2);
		 TreeNode node3 = new TreeNode(3);
		 TreeNode node4 = new TreeNode(3);
		 TreeNode node5 = new TreeNode(4);
		 TreeNode node6 = new TreeNode(4);
		 root.left = node1;
		 root.right = node2;
		 node1.left = node3;
		 node2.right = node4;
		 node3.left = node5;
		 node4.right = node6;
		 SumRoottoLeafNumbers s = new SumRoottoLeafNumbers();
		 int res = s.sumNumbers(root);
		 System.out.println(res);
	}
}
