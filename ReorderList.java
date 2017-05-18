package algorithm_java;

public class ReorderList {
	public static void reorderList(ListNode head) {
        if(head == null || head.next == null || head.next.next == null)
        	return;
        ListNode fast = head;
        ListNode slow = head;
        while(fast!=null&&fast.next!=null){
            fast = fast.next.next;
            slow = slow.next;
        }
        ListNode head1 = head;
        ListNode head2 = slow.next;
       
        slow.next = null; 
        head2 = reverseList(head2);
//        while(head2!=null){
//     	   System.out.print(head2.val+"");
//     	   head2 = head2.next;
//        }
        while(head1!=null && head2!=null ){
        	ListNode node1 = head1.next;
        	ListNode node2 = head2.next;
        	head1.next= head2;
        	head2.next = node1;
        	head1= node1;
        	head2 = node2;
        }
    }
    
    public static ListNode reverseList(ListNode head){
    	ListNode dummy = new ListNode(-1);
    	dummy.next = head;
    	ListNode slow = dummy, fast = head;
    	ListNode node = fast.next;
    	while(node!=null){
    		fast.next = slow;
    		slow = fast;
    		fast = node;
    		node = node.next;
    	}
    	fast.next = slow;
    	head.next = null;
    	return fast;
    }
	
	public static void main(String[] args){
		ListNode node1 = new ListNode(1);
    	ListNode node2 = new ListNode(5);
    	ListNode node3 = new ListNode(7);
    	ListNode node4 = new ListNode(6);
    	ListNode node5 = new ListNode(4);
    	ListNode node6 = new ListNode(9);
    	ListNode node7 = new ListNode(8);
    	ListNode node8 = new ListNode(2);
    	//ListNode node6 = new ListNode(1);
    	node1.next = node2;
    	node2.next = node3;
    	node3.next = node4;
    	node4.next = node5;
    	node5.next = node6;
    	node6.next = node7;
    	node7.next = node8;
    	reorderList(node1);
    	while(node1!=null){
    		System.out.print(node1.val+" ");
    		node1 = node1.next;
    	}
	}
}
