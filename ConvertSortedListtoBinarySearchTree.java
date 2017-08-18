package algorithm_java;

//Zenefits

public class ConvertSortedListtoBinarySearchTree {
	
	//solution I, tc: O(nlogn) sc: O(1)
	public TreeNode sortedListToBST(ListNode head) {
	    if(head==null) return null;
	    return toBST(head,null);
	}
	public TreeNode toBST(ListNode head, ListNode tail){
	    ListNode slow = head;
	    ListNode fast = head;
	    if(head==tail) return null;
	    
	    while(fast!=tail&&fast.next!=tail){
	        fast = fast.next.next;
	        slow = slow.next;
	    }
	    TreeNode thead = new TreeNode(slow.val);
	    thead.left = toBST(head,slow);
	    thead.right = toBST(slow.next,tail);
	    return thead;
	}
	
	public void inorder(TreeNode n){
		if(n==null)
			return;
		System.out.print(n.val+" ");
		inorder(n.left);
		inorder(n.right);
	}
	
	//solutionII, bottom up construction 
	//tc: O(nlogn) sc: O(1)
	private ListNode node;

	public TreeNode sortedListToBST_inorder(ListNode head) {
		if(head == null){
			return null;
		}
		
		int size = 0;
		ListNode runner = head;
		node = head;
		
		while(runner != null){
			runner = runner.next;
			size ++;
		}
		
		return inorderHelper(0, size - 1);
	}

	public TreeNode inorderHelper(int start, int end){
		if(start > end){
			return null;
		}
		
		int mid = start + (end - start) / 2;
		TreeNode left = inorderHelper(start, mid - 1);
		
		TreeNode treenode = new TreeNode(node.val);
		treenode.left = left;
		node = node.next;

		TreeNode right = inorderHelper(mid + 1, end);
		treenode.right = right;
		
		return treenode;
	}
	
	public static void main(String[] args) {
		ConvertSortedListtoBinarySearchTree s = new ConvertSortedListtoBinarySearchTree();
		ListNode n1 = new ListNode(1);
		ListNode n2 = new ListNode(5);
		ListNode n3 = new ListNode(8);
		ListNode n4 = new ListNode(9);
		ListNode n5 = new ListNode(15);
		ListNode n6 = new ListNode(19);
		ListNode n7 = new ListNode(21);
		n1.next = n2;
		n2.next = n3;
		n3.next = n4;
		n4.next = n5;
		n5.next = n6;
		n6.next = n7;
//		TreeNode root = s.sortedListToBST(n1);
		TreeNode root = s.sortedListToBST_inorder(n1);
		s.inorder(root);
		//[9,5,19,1,8,15,21]
	}
}
