package algorithm_java;

//Facebook Amazon 

public class PalindromeLinkedList {
	public static boolean isPalindrome(ListNode head) {
        if(head == null || head.next == null)
            return true;
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode prev = dummy, slow = head, fast = head;
        while(fast!=null && fast.next != null){
            slow = slow.next;
            prev = prev.next;
            fast = fast.next.next;
        }
        if(fast!=null){
            prev = prev.next;
            slow = slow.next;
        }
        prev.next = null;
        while(slow!=null){
            ListNode next = slow.next;
            slow.next = prev;
            prev = slow;
            slow = next;
        }
        ListNode begin = head, tail = prev;
        while(begin!=null){
            if(begin.val == tail.val){
                begin = begin.next;
                tail = tail.next;
            }else
                return false;
        }
        return true;
    }
	
	
	public static boolean IsPalindrome(ListNode head) {
        if(head == null || head.next == null)
            return true;
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode slow = dummy, fast = dummy;
        while(fast!=null && fast.next!=null){
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode middle = slow;
        ListNode prev = slow;
        slow = slow.next;
        while(slow!=null){
            ListNode next = slow.next;
            slow.next = prev;
            prev = slow;
            slow = next;
        }
         middle.next = null;
        ListNode start = head, tail = prev;
        while(start!=tail){
            if(start.val == tail.val){
                start = start.next;
                tail = tail.next;
            }else
                return false;
        }
        return true;
    }
	
	public static void main(String[] args) {
		ListNode l1 = new ListNode(1);
		ListNode l2 = new ListNode(2);
		ListNode l3 = new ListNode(3);
//		ListNode l4 = new ListNode(3);
		ListNode l5 = new ListNode(2);
		ListNode l6 = new ListNode(1);
		l1.next = l2;
		l2.next = l3;
//		l3.next = l4;
//		l4.next = l5;
		l3.next = l5;
		l5.next = l6;
//		boolean res = isPalindrome(l1);
		boolean res1 = IsPalindrome(l1);
		System.out.println(res1);
	}
}
