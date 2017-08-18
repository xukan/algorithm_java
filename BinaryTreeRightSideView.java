package algorithm_java;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

//Amazon 

//similar question
//Find Largest Value in Each Tree Row from LinkedIn

public class BinaryTreeRightSideView {
	//BFS solution
	public List<Integer> rightSideView(TreeNode root) {
        List<Integer> res = new ArrayList<Integer>();
        if(root == null)
            return res;
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.offer(root);
        while(!queue.isEmpty()){
            int size = queue.size();
            for(int i=0;i<size;i++){
                TreeNode node = queue.poll();
                if(i == size-1)
                    res.add(node.val);
                if(node.left!=null)
                    queue.offer(node.left);
                if(node.right!=null)
                    queue.offer(node.right);
            }
        }
        return res;
    }
	
	public static List<Integer> rightSideView_recursion(TreeNode root) {
        List<Integer> result = new ArrayList<Integer>();
        rightView(root, result, 0);
        return result;
    }
    
    public static  void rightView(TreeNode curr, List<Integer> result, int currDepth){
        if(curr == null){
            return;
        }
        if(currDepth == result.size()){
            result.add(curr.val);
        }
        
        rightView(curr.right, result, currDepth + 1);
        rightView(curr.left, result, currDepth + 1);
        
    }
    
    public static void main(String[] args){
		TreeNode root = new TreeNode(1);

		TreeNode firstLeft = new TreeNode(2);
		TreeNode firstRight = new TreeNode(3);
		TreeNode secondLeft = new TreeNode(5);
//		TreeNode secondRight = new TreeNode(4);
		List<TreeNode> list = new LinkedList<TreeNode>();
		root.left=firstLeft;
		root.right=firstRight;
		firstLeft.left= secondLeft;
//		firstRight.right = secondRight;
		list.add(root); 
		list.add(firstLeft);
		list.add(firstRight);
		list.add(secondLeft);
//		list.add(secondRight);
		List<Integer> rightView = new LinkedList<Integer>();
		rightView=rightSideView(root);
		Iterator<Integer> it= rightView.iterator();
		while(it.hasNext()){
			int x=it.next();
			System.out.print(x+" ");
		}
	}
}
