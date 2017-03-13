package algorithm_java;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

//LinkedIn Facebook Amazon Microsoft Apple Bloomberg

public class BinaryTreeLevelOrderTraversal {
	public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        if(root == null)
            return res;
        LinkedList<TreeNode> queue = new LinkedList<TreeNode>();
        queue.offer(root);
        int count =0;
        while(!queue.isEmpty()){
            count = queue.size();
            List<Integer> sol = new ArrayList<Integer>();
            for(int i=0;i<count;i++){
                TreeNode node = queue.poll();
                sol.add(node.val);
                if(node.left!=null)
                    queue.offer(node.left);
                if(node.right!=null)
                    queue.offer(node.right);
            }
            res.add(new ArrayList<Integer>(sol));
        }
        return res;
    }
}
