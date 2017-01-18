package algorithm_java;

public class PartitionList {
	public static ListNode partition(ListNode head, int x) {
        if(head == null )
            return null;
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode slow = dummy;
        while(slow.next!=null &&slow.next.val < x){
            slow = slow.next;
        }
        ListNode fast = slow.next;
        while(fast != null && fast.next != null){
            ListNode nextNode = fast.next;
            while(nextNode !=null && nextNode.val >= x){
                fast = fast.next;
                nextNode = fast.next;
            }
            if(fast.next !=null){
            	fast.next = nextNode.next;
            	nextNode.next = slow.next;
            	slow.next = nextNode;
            	slow = slow.next;
            }
        }
        return dummy.next;
    }
	
	public static void main(String[] args){
//		ListNode head = new ListNode(1);
//		head.next = new ListNode(4);
//		head.next.next = new ListNode(3);
//		head.next.next.next = new ListNode(2);
//		head.next.next.next.next = new ListNode(5);
//		head.next.next.next.next.next = new ListNode(2);
		
		ListNode head = new ListNode(1);
		//head.next = new ListNode(1);
		//head = reverseList(head);
		head = partition(head,0);
		while(head!=null){
			System.out.println(head.val);
			head = head.next;
		}
	}
}
