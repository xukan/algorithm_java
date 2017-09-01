package algorithm_java;

import java.util.LinkedList;
import java.util.Queue;

public class BinaryTreetoCircularDDL {
    // Method converts a tree to a circular
    // Link List and then returns the head
    // of the Link List
	
	//BFS based
    public TreeNode bTreeToCList_BFS(TreeNode root){
        if (root == null)
            return null;
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.offer(root);
        TreeNode node = null, last = null;
        while(!queue.isEmpty()){
        	node = queue.poll();
        	if(node.left!=null)
        		queue.offer(node.left);
        	if(node.right!=null)
        		queue.offer(node.right);
        	node.left = last;
        	node.right = queue.peek();
        	last = node;
        }
        root.left = last;
        last.right = root;
        return root;
    }
 
    TreeNode prev = null;
    TreeNode head = null;
    public TreeNode bTreeToCList_inorder(TreeNode root){
    	if(root == null)
    		return root;
    	convert(root);
    	head.left = prev;
    	prev.right = head;
    	return head;
    }
    
    public void  convert(TreeNode node){
    	if(node == null)
    		return;
    	convert(node.left);
    	if(prev == null)
    		head = node;
    	else{
    		node.left = prev;
    		prev.right = node;
    	}
    	prev = node;
    	convert(node.right);
    }
    
    // Display Circular Link List
    public void display(TreeNode head){
        System.out.println("Circular Linked List is :");
        TreeNode itr = head;
        do{
            System.out.print(itr.val+ " " );
            itr = itr.right;
        }
        while (itr != head);
        System.out.println();
    }
    
    public static void main(String[] args) {
    	BinaryTreetoCircularDDL s = new BinaryTreetoCircularDDL();
    	
    	// Build the tree
    	TreeNode root = new TreeNode(10);
    	TreeNode node1 = new TreeNode(12);
    	TreeNode node2 = new TreeNode(15);
    	TreeNode node3 = new TreeNode(25);
    	TreeNode node4 = new TreeNode(30);
    	TreeNode node5 = new TreeNode(36);
    	root.left = node1;
    	root.right = node2;
    	node1.left = node3;
    	node1.right = node4;
    	node2.left = node5;
 
//    	TreeNode head1 = s.bTreeToCList_BFS(root);
//        s.display(head1);
        
        // head refers to the head of the Link List
    	TreeNode head2 = s.bTreeToCList_inorder(root);
 
        // Display the Circular LinkedList
        s.display(head2);
	}
}
