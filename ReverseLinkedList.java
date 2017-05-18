package algorithm_java;

public class ReverseLinkedList {
	//in-place iterative solution
	public static ListNode reverseList(ListNode head) {
        if(head==null)
            return null;
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode slow = dummy;
        ListNode fast = head;
        ListNode nextNode = fast.next;
        while(nextNode!=null){
            fast.next=slow;
            slow=fast;
            fast = nextNode;
            nextNode=nextNode.next;
        }
        fast.next = slow;
        head.next = null;
        return fast;
    }
	
	//recursion
//	public static ListNode reverseList(ListNode head){
//        if(head ==null || head.next == null)
//            return head;
//        return reverse(head, head.next);
//    }
//    
//    public static ListNode reverse(ListNode first, ListNode node){
//        if(node == null)
//            return first;
//        ListNode newHead = reverse(node, node.next);
//        node.next = first;
//        first.next = null;
//        return newHead;
//    }
	
	public static void main(String[] args){
		ListNode head = new ListNode(5);
		head.next = new ListNode(4);
		head.next.next = new ListNode(3);
		head.next.next.next = new ListNode(2);
		head.next.next.next.next = new ListNode(1);

		head = reverseList(head);

		//head = recursiveReverse(head);

		while(head!=null){
			System.out.println(head.val);
			head = head.next;
		}
	}
}
