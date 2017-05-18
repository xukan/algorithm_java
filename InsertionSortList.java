package algorithm_java;

public class InsertionSortList {
	public static ListNode insertionSortList(ListNode head) {  
        if(head == null||head.next == null)  
            return head;  
        ListNode sortedlisthead = new ListNode(0);  
        ListNode cur = head;
        while(cur!=null){  
            ListNode next = cur.next;  
            ListNode pre = sortedlisthead;  
            while(pre.next!=null && pre.next.val<cur.val)  
                pre = pre.next;  
            cur.next = pre.next;  
            pre.next = cur;  
            cur = next;  
        }  
        return sortedlisthead.next;  
    }
	
	public static void main(String[] args){
		ListNode node1 = new ListNode(4);
		ListNode node2 = new ListNode(3);
		ListNode node3 = new ListNode(2);
		
		ListNode node4 = new ListNode(5);
		ListNode node5 = new ListNode(1);
		ListNode node6 = new ListNode(7);
		node1.next = node2;
		node2.next = node3;
		node3.next = node4;
		node4.next = node5;
		node5.next = node6;
		node1 = insertionSortList(node1);
		while(node1!=null){
			System.out.print(node1.val+" ");
			node1=node1.next;
		}  
	}
}
