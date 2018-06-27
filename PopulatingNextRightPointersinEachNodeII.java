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
        TreeLinkNode dummy = new TreeLinkNode(0);
        TreeLinkNode prev = dummy;
        while(root!=null){
            if(root.left != null){
                prev.next = root.left;
                prev = prev.next;
            }
            if(root.right!=null){
                prev.next = root.right;
                prev = prev.next;
            }
//            root = root.next;
//            if(root == null){
//                prev = dummy;
//                root = dummy.next;
//                dummy.next = null;
//            }
            if(root.next==null){
                prev = dummy;
                root = dummy.next;
                dummy.next = null;
            }else
                root = root.next;
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
