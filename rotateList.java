package algorithm_java;

public class rotateList {
	public ListNode rotateRight(ListNode head, int k) {
        if(k==0 || head == null || head.next == null)
            return head;
        ListNode check = head;
        int len = 1;
        while(check.next!=null){
            check = check.next;
            len++;
        }
        k %= len;
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode slow = dummy, fast = head;
        for(int i=1;i<k;i++){
            fast = fast.next;
        }
        while(fast.next!=null){
            slow=slow.next;
            fast = fast.next;
        }
        dummy.next = slow.next;
        slow.next = null;
        fast.next = head;
        return dummy.next;
    }
	
	public static void main(String[] args){
		ListNode node1 = new ListNode(1);
    	ListNode node2 = new ListNode(5);
    	ListNode node3 = new ListNode(7);
//     	ListNode node4 = new ListNode(6);
//    	ListNode node5 = new ListNode(4);
//    	ListNode node6 = new ListNode(9);
//    	ListNode node7 = new ListNode(8);
//    	ListNode node8 = new ListNode(2);
    	//ListNode node6 = new ListNode(1);
    	node1.next = node2;
    	node2.next = node3;
//    	node3.next = node4;
//    	node4.next = node5;
//    	node5.next = node6;
//    	node6.next = node7;
//    	node7.next = node8;
    	rotateList s = new rotateList();
    	ListNode node = s.rotateRight(node1, 0);
    	while(node!=null){
    		System.out.println(node.val);
    		node = node.next;
    	}
	}
}
