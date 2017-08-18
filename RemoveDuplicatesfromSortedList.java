package algorithm_java;

public class RemoveDuplicatesfromSortedList {
	public ListNode deleteDuplicates(ListNode head) {
        if(head == null || head.next == null)
            return head;
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode slow = dummy, fast = head;
        while(fast!= null){
            slow = slow.next;
            fast = fast.next;
            while(fast!= null && slow.val == fast.val){
                slow.next = fast.next;
                fast = slow.next;
            }
        }
        return dummy.next;
    }
	
	
	//II
	public ListNode deleteDuplicatesII(ListNode head) {
        if(head==null || head.next == null)
            return head;
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode prev = dummy, slow = head;
        ListNode fast = slow.next;
        while(fast!=null){
            while(fast!=null && fast.val == slow.val)
                fast = fast.next;
            if(slow.next!=fast){
                prev.next = fast;
                slow = fast;
            }else{
                prev = prev.next;
                slow = slow.next;
            }
            if(fast == null)
                break;
            fast = fast.next;
        }
        return dummy.next;
    }
	
}
