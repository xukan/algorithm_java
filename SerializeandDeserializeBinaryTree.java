package algorithm_java;

import java.util.LinkedList;
import java.util.Queue;

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
	//solutonI: level order
	// Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if(root == null)
            return "";
        StringBuilder sb = new StringBuilder();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while(!queue.isEmpty()){
            TreeNode node = queue.poll();
            sb.append((node==null?"#":node.val) + ",");
            if(node!=null){
                queue.offer(node.left);
                queue.offer(node.right);
            }
        }
        sb.deleteCharAt(sb.length()-1);
        System.out.print(sb.toString());
        return sb.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if(data.length() == 0)
            return null;
        String[] tokens = data.split(",");
        TreeNode root = new TreeNode(Integer.parseInt(tokens[0]));
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int i=1;
        while(!queue.isEmpty()){
            int size = queue.size();
            for(int j=0;j<size;j++){
                TreeNode node = queue.poll();
                if(tokens[i].equals("#"))
                    node.left = null;
                else{
                    TreeNode l = new TreeNode(Integer.parseInt(tokens[i]));
                    node.left = l;
                    queue.offer(l);
                }
                i++;
                if(tokens[i].equals("#"))
                    node.right = null;
                else{
                    TreeNode r = new TreeNode(Integer.parseInt(tokens[i]));
                    node.right = r;
                    queue.offer(r);
                }
                i++;
            }
        }
        return root;
    }

    //solutionII, preorder based
    //pos[],可以替换为一个全局变量index
 // Encodes a tree to a single string.
    public String serialize_preorder(TreeNode root) {
        if (root == null) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        buildString(sb, root);
        sb.deleteCharAt(sb.length() - 1);
        return sb.toString();
    }

    public void buildString(StringBuilder sb, TreeNode node) {
        if (node == null) {
            sb.append("#,");
        } else {
            sb.append(node.val + ",");
            buildString(sb, node.left);
            buildString(sb, node.right);
        }
    }
    // Decodes your encoded data to tree.
    public TreeNode deserialize_preorder(String data) {
        if (data.equals("")) {
            return null;
        }
        int[] pos = new int[1];
        return buildTree(data.split(","), pos);
    }
    
    public TreeNode buildTree(String[] nodes, int[] pos) {
        if (nodes[pos[0]].equals("#")) {
            pos[0]++;
            return null;
        } else {
            TreeNode node = new TreeNode(Integer.valueOf(nodes[pos[0]]));
            pos[0]++;
            node.left = buildTree(nodes, pos);
            //注意这里就不需要pos[0]++,右孩子的指针会由左孩子的最右边的空节点移动过来的,在判断是空的时候pos[0]++
            node.right = buildTree(nodes, pos);
            return node;
        }
    }
    
    public static void main(String[] args) {
    	SerializeandDeserializeBinaryTree s = new SerializeandDeserializeBinaryTree();
		TreeNode root = new TreeNode(5);
		TreeNode node1 = new TreeNode(4);
		TreeNode node2 = new TreeNode(8);
		TreeNode node3 = new TreeNode(11);
		TreeNode node4 = new TreeNode(13);
		TreeNode node5 = new TreeNode(4);
//		 TreeNode node6 = new TreeNode(7);
//		 TreeNode node7 = new TreeNode(2);
//		 TreeNode node8 = new TreeNode(5);
//		 TreeNode node9 = new TreeNode(1);
		 root.left=node1;
		 root.right = node2;
		 node1.left = node3;
		 node2.left = node4;
		 node2.right = node5;
//		 node3.left = node6;
//		 node3.right = node7;
//		 node5.left = node8;
//		 node5.right = node9;
//    	s.deserialize(s.serialize(root));
		 String encode = s.serialize_preorder(root);
		 System.out.println(encode);
		 s.deserialize_preorder(encode); 
	}
}
