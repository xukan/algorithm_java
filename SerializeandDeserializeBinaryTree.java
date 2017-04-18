package algorithm_java;

import java.util.LinkedList;

//LinkedIn Google Uber Facebook Amazon Microsoft Yahoo Bloomberg

/*
 *               5
 *            /     \
 *           4       8
 *         /        /    \
 *       11      13    4
 *      /   \           /    \
 *    7     2        5      1
 *            
 * */

public class SerializeandDeserializeBinaryTree {
	//Solution 1 : level order
	// Encodes a tree to a single string.
	public String serialize(TreeNode root) {
	    if(root==null){
	        return "";
	    }
	 
	    StringBuilder sb = new StringBuilder();
	 
	    LinkedList<TreeNode> queue = new LinkedList<TreeNode>();
	 
	    queue.add(root);
	    while(!queue.isEmpty()){
	        TreeNode t = queue.poll();
	        if(t!=null){
	            sb.append(String.valueOf(t.val) + ",");
	            queue.add(t.left);
	            queue.add(t.right);
	        }else{
	            sb.append("#,");
	        }
	    }
	 
	    sb.deleteCharAt(sb.length()-1);
	    System.out.println(sb.toString());
	    return sb.toString();
	}
	 
	// Decodes your encoded data to tree.
	public TreeNode deserialize(String data) {
	    if(data==null || data.length()==0)
	        return null;
	 
	    String[] arr = data.split(",");
	    TreeNode root = new TreeNode(Integer.parseInt(arr[0]));
	 
	 
	    LinkedList<TreeNode> queue = new LinkedList<TreeNode>();
	    queue.add(root);
	 
	    int i=1;
	    while(!queue.isEmpty()){
	        TreeNode t = queue.poll();
	 
	        if(t==null)
	            continue;
	 
	        if(!arr[i].equals("#")){
	            t.left = new TreeNode(Integer.parseInt(arr[i]));    
	            queue.offer(t.left);
	 
	        }else{
	            t.left = null;
	            queue.offer(null);
	        }
	        i++;
	 
	        if(!arr[i].equals("#")){
	            t.right = new TreeNode(Integer.parseInt(arr[i]));    
	            queue.offer(t.right);
	 
	        }else{
	            t.right = null;
	            queue.offer(null);
	        }
	        i++;
	    }
	 
	    return root;
	}

    
    public static void main(String[] args) {
    	SerializeandDeserializeBinaryTree s = new SerializeandDeserializeBinaryTree();
    	TreeNode root = new TreeNode(5);
		 TreeNode node1 = new TreeNode(4);
		 TreeNode node2 = new TreeNode(8);
		 TreeNode node3 = new TreeNode(11);
		 TreeNode node4 = new TreeNode(13);
		 TreeNode node5 = new TreeNode(4);
		 TreeNode node6 = new TreeNode(7);
		 TreeNode node7 = new TreeNode(2);
		 TreeNode node8 = new TreeNode(5);
		 TreeNode node9 = new TreeNode(1);
		 root.left=node1;
		 root.right = node2;
		 node1.left = node3;
		 node2.left = node4;
		 node2.right = node5;
		 node3.left = node6;
		 node3.right = node7;
		 node5.left = node8;
		 node5.right = node9;
    	s.deserialize(s.serialize(root));
	}
}
