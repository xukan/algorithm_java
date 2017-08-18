package algorithm_java;

//Google

public class PlusOneLinkedList {
	public ListNode plusOne(ListNode head) {
        ListNode newHead = reverse(head);
        ListNode l = newHead;
        int carry = 1;
        while(l !=null){
        	int v = l.val + carry;
            carry = v/10;
            l.val = v%10;
            l = l.next;
        }
        if(carry!=0){
            ListNode n = new ListNode(carry);
            head.next = n;
            head = head.next;
        }
        return reverse(newHead);
    }
    
    public ListNode reverse(ListNode l1){
        ListNode dummy = new ListNode(-1);
        dummy.next = l1;
        ListNode prev = dummy, walk = l1;
        while(walk!=null){
            ListNode next = walk.next;
            walk.next = prev;
            prev = walk;
            walk = next;
        }
        l1.next = null;
        return prev;
    }
    
    public static void main(String[] args) {
    	PlusOneLinkedList s = new PlusOneLinkedList();
    	ListNode l1 = new ListNode(1);
    	ListNode l2 = new ListNode(2);
    	l1.next = l2;
    	ListNode res = s.plusOne(l1);
    	while(res!=null){
    		System.out.print(res.val + " ");
    		res = res.next;
    	}
	}
}
