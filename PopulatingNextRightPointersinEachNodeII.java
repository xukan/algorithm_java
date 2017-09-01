package algorithm_java;

//Microsoft Bloomberg Facebook 


//Definition for binary tree with next pointer.
//class TreeLinkNode {
//	int val;
//	TreeLinkNode left, right, next;
//	TreeLinkNode(int x) { val = x; }
//}

public class PopulatingNextRightPointersinEachNodeII {
	//tc: O(n)( O(V+E))
	public static void connect(TreeLinkNode root) {
	    TreeLinkNode temp = new TreeLinkNode(0);
	    while (root != null) {
	        TreeLinkNode cur = temp;
	        while (root != null) {
	            if (root.left != null) {
	                cur.next = root.left;
	                cur = cur.next;
	            }
	            if (root.right != null) {
	                cur.next = root.right;
	                cur = cur.next;
	            }
	            root = root.next;
	        }
	        root = temp.next;
	        temp.next = null;
	    }
	}
	
	public static void main(String[] args){
		 TreeLinkNode root = new TreeLinkNode(1);
		 TreeLinkNode node1 = new TreeLinkNode(2);
		 TreeLinkNode node2 = new TreeLinkNode(3);
		 TreeLinkNode node3 = new TreeLinkNode(4);
		 TreeLinkNode node4 = new TreeLinkNode(5);
		 TreeLinkNode node6 = new TreeLinkNode(7);

		 root.left=node1;
		 root.right = node2;
		 node1.left = node3;
		 node1.right = node4;
		 node2.right = node6;

		 connect(root);
//		 for(Integer i : res)
//			 System.out.print(i+" ");
//		 System.out.println();
	} 
}
