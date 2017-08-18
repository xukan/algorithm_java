package algorithm_java;

//Microsoft Facebook

public class ReverseNodesinkGroup {
	//my solution
	public static ListNode reverseKGroup(ListNode head, int k) {
		if(head == null)
            return head;
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        int len = 0;
        ListNode walk = head;
        while(walk!=null){
            len++;
            walk = walk.next;
        }
        if(k>len)
            return dummy.next;
        ListNode prev = dummy, slow = head;
        while(len>= k){
            ListNode begin = prev, tail = slow;
            for(int i=0;i<k;i++){
                ListNode next = slow.next;
                slow.next = prev;
                prev = slow;
                slow = next;
            }
            begin.next = prev;
            tail.next = slow;
            prev = tail;
            len-=k;
        }
        return dummy.next;
    }
	
	public static void main(String[] args) {
		ListNode head = new ListNode(5);
		head.next = new ListNode(4);
		head.next.next = new ListNode(3);
		head.next.next.next = new ListNode(2);
		head.next.next.next.next = new ListNode(1);
		head = reverseKGroup(head, 2);
		while(head!=null){
			System.out.println(head.val);
			head = head.next;
		}
	}
}
