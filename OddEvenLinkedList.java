package algorithm_java;

public class OddEvenLinkedList {
	public static ListNode oddEvenList(ListNode head) {
        if(head == null || head.next == null)
            return head;
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode oNode = head;
        ListNode ehead = head.next, eNode = head.next;
        while(eNode.next!=null && oNode.next!=null){
            oNode.next = eNode.next;
            oNode = oNode.next;
            if(oNode.next!=null){
            eNode.next = oNode.next;
            eNode = eNode.next;
            }
        }
        oNode.next =ehead;
        eNode.next=null;
        return dummy.next;
    }
	
	public static void main(String[] args) {
		ListNode node1 = new ListNode(1);
    	ListNode node2 = new ListNode(2);
    	ListNode node3 = new ListNode(3);
    	
    	node1.next = node2;
    	node2.next = node3;
    	
    	ListNode node = oddEvenList(node1);
    	while(node!=null){
    		System.out.println(node.val);
    		node=node.next;
    	}
	}
}
