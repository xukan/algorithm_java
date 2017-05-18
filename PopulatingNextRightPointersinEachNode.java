package algorithm_java;

/*                  1
 *                /     \
 *              2        3
 *             /   \     /  \   
 *           4    5   6    7
 * */
/*
 *                1
                 /   \
                2    3
              /   \    \
             4   5    7
 * */
/*
 *      1 -> NULL
       /    \
      2  -> 3 -> NULL
    /    \     \
   4-> 5 -> 7 -> NULL
 * 
 * 
 * */

//Definition for binary tree with next pointer.
class TreeLinkNode {
	int val;
	TreeLinkNode left, right, next;
	TreeLinkNode(int x) { val = x; }
}


public class PopulatingNextRightPointersinEachNode {
	public static void connect(TreeLinkNode root) {
		if(root == null)
            return;
        if(root.right!=null){
        	if(root.next == null)	
                root.right.next = null;
        	else
                root.right.next = root.next.left;
        }
        if(root.left!=null)
            root.left.next = root.right;
        connect(root.left);
        connect(root.right);
    }
	
	//This question can be solved by level order traversal, but it requires constant extra space
	//http://www.cnblogs.com/yuzhangcmu/p/4041345.html
	//sp: O(1)
	//tc: O(n)
	public static void connect1(TreeLinkNode root) {
        if (root == null) {
            return;
        }
        
        TreeLinkNode leftEnd = root;
        
        // Bug 1: don't need " && leftEnd.left != null"
        while (leftEnd != null) {
            TreeLinkNode cur = leftEnd;
            
            TreeLinkNode dummy = new TreeLinkNode(0);
            TreeLinkNode pre = dummy;
            while (cur != null) {
                if (cur.left != null) {
                    pre.next = cur.left;
                    pre = cur.left;
                }
                
                if (cur.right != null) {
                    pre.next = cur.right;
                    pre = cur.right;
                }
                
                cur = cur.next;
            }
            leftEnd = dummy.next;
        }
    }
	
	public static void main(String[] args){
		 TreeLinkNode root = new TreeLinkNode(1);
		 TreeLinkNode node1 = new TreeLinkNode(2);
		 TreeLinkNode node2 = new TreeLinkNode(3);
		 TreeLinkNode node3 = new TreeLinkNode(4);
		 TreeLinkNode node4 = new TreeLinkNode(5);
		 TreeLinkNode node5 = new TreeLinkNode(6);
		 TreeLinkNode node6 = new TreeLinkNode(7);

		 root.left=node1;
		 root.right = node2;
		 node1.left = node3;
		 node1.right = node4;
		 //node2.left = node5;
		 node2.right = node6;

		 connect1(root);
//		 for(Integer i : res)
//			 System.out.print(i+" ");
//		 System.out.println();
	} 
}
