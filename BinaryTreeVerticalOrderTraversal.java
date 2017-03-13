package algorithm_java;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

//Google Snapchat Facebook

/*
 *               _3_(0)
 *          /                \
 *        9(-1)            8(1)
 *      /     \             /   \
 *   4(-2)   0(0)    1(0)  7(2)
 *                \
 *                10(1)
 * */
//reference: http://www.cnblogs.com/yrbbest/p/5065457.html
//总的来说就是假定一个node的column是 i，那么它的左子树column就是i - 1，右子树column就是i + 1。
//相同的column输出在同一组
//例子中的树垂直遍历的结果为
/*
 * [4] 
 * [9] 
 * [3 0 1] 
 * [8 10] 
 * [7] 
 * */
public class BinaryTreeVerticalOrderTraversal {
	public static List<List<Integer>> verticalOrder(TreeNode root) {
	    List<List<Integer>> result = new ArrayList<List<Integer>>();
	    if(root==null)
	        return result;
	 
	    // level and list    
	    HashMap<Integer, ArrayList<Integer>> map = new HashMap<Integer, ArrayList<Integer>>();
	 
	    LinkedList<TreeNode> queue = new LinkedList<TreeNode>();
	    LinkedList<Integer> level = new LinkedList<Integer>();
	 
	    queue.offer(root);
	    level.offer(0);
	 
	    int minLevel=0;
	    int maxLevel=0;
	 
	    while(!queue.isEmpty()){
	        TreeNode p = queue.poll();
	        int l = level.poll();
	 
	        //track min and max levels
	        minLevel=Math.min(minLevel, l);
	        maxLevel=Math.max(maxLevel, l);
	 
	        if(map.containsKey(l)){
	            map.get(l).add(p.val);
	        }else{
	            ArrayList<Integer> list = new ArrayList<Integer>();
	            list.add(p.val);
	            map.put(l, list);
	        }
	 
	        if(p.left!=null){
	            queue.offer(p.left);
	            level.offer(l-1);
	        }
	 
	        if(p.right!=null){
	            queue.offer(p.right);
	            level.offer(l+1);
	        }
	    }
	 
	    for(int i=minLevel; i<=maxLevel; i++){
	        if(map.containsKey(i)){
	            result.add(map.get(i));
	        }
	    }
	 
	    return result;
	}
	
	public static void main(String[] args) {
		TreeNode t1 = new TreeNode(3);
		TreeNode t2 = new TreeNode(9);
		TreeNode t3 = new TreeNode(8);
		TreeNode t4 = new TreeNode(4);
		TreeNode t5 = new TreeNode(0);
		TreeNode t6 = new TreeNode(1);
		TreeNode t7 = new TreeNode(7);
		TreeNode t8 = new TreeNode(10);
		t1.left = t2;
		t1.right = t3;
		t2.left = t4;
		t2.right = t5;
		t3.left = t6;
		t3.right = t7;
		t5.right = t8;
		List<List<Integer>> res =  verticalOrder(t1);
		for(List<Integer> list : res){
			for(int i: list){
				System.out.print(i+ " ");
			}
			System.out.println();
		}
		//print(levelOrder(t1));
	}
}
