package algorithm_java;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class BinaryTreeZigzagLevelOrderTraversal {
	public static List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        LinkedList<TreeNode> queue1 = new LinkedList<TreeNode>();
        LinkedList<TreeNode> queue2 = new LinkedList<TreeNode>();
        queue1.offer(root);
        while(!queue1.isEmpty() || !queue2.isEmpty()){
            List<Integer> sol = new ArrayList();
            while(!queue1.isEmpty()){
                TreeNode node = queue1.poll();
                sol.add(node.val);
                if(node.left!=null)
                	queue2.offer(node.left);
                if(node.right!=null)
                	queue2.offer(node.right);
            }
            res.add(new ArrayList<Integer>(sol));
            sol.clear();
            if(queue2.size()>0){
                for(int i=queue2.size()-1;i>=0;i--){
                    TreeNode node = queue2.get(i);
                    sol.add(node.val);
                }
            }
            res.add(new ArrayList<Integer>(sol));
            sol.clear();
            while(!queue2.isEmpty()){
                TreeNode node = queue2.poll();
                if(node.left!=null)
                	queue1.offer(node.left);
                if(node.right!=null)
                	queue1.offer(node.right);
            }
        }
        return res;
    }
	
	public static void main(String[] args){
		//Tree for traversal
		 TreeNode traversalRoot = new TreeNode(5);
		 TreeNode traversalNode1 = new TreeNode(4);
		 TreeNode traversalNode2 = new TreeNode(8);
		 TreeNode traversalNode3 = new TreeNode(11);
		 TreeNode traversalNode4 = new TreeNode(13);
		 TreeNode traversalNode5 = new TreeNode(4);
		 TreeNode traversalNode6 = new TreeNode(7);
		 TreeNode traversalNode7 = new TreeNode(2);
		 TreeNode traversalNode8 = new TreeNode(5);
		 TreeNode traversalNode9 = new TreeNode(1);
		 traversalRoot.left=traversalNode1;
		 traversalRoot.right = traversalNode2;
		 traversalNode1.left = traversalNode3;
		 traversalNode2.left = traversalNode4;
		 traversalNode2.right = traversalNode5;
		 traversalNode3.left = traversalNode6;
		 traversalNode3.right = traversalNode7;
		 traversalNode5.left = traversalNode8;
		 traversalNode5.right = traversalNode9;
		 
		 System.out.println("ZigzagLevelorder traversal of the tree is: ");
			List<List<Integer>> levelorderTraversal = zigzagLevelOrder(traversalRoot);
			for(List<Integer> l:levelorderTraversal){
				for(int i: l)
					System.out.print(i+" ");
				System.out.println();
			}
	}
	
}
