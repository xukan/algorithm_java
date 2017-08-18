package algorithm_java;

import java.util.Stack;

//Microsoft Bloomberg 

public class AddTwoNumbersII {
	public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode ln1 = reverse(l1);
        ListNode ln2 = reverse(l2);
        int carry = 0;
        ListNode node = new ListNode(0);
        ListNode head = node;
        while(ln1!=null || ln2 != null){
            if(ln1!=null){
                carry += ln1.val;
                ln1 = ln1.next;
            }
            if(ln2!=null){
                carry += ln2.val;
                ln2 = ln2.next;
            }
            ListNode n = new ListNode(carry%10);
            carry /= 10;
            node.next = n;
            node = node.next;
        }
        if(carry!=0){
            ListNode n = new ListNode(carry);
            node.next = n;
        }
        ListNode newHead = reverse(head.next);
        return newHead;
    }
    
    public ListNode reverse(ListNode ln){
        ListNode dummy = new ListNode(-1);
        dummy.next = ln;
        ListNode prev = dummy, temp = ln;
        while(temp!=null){
            ListNode next = temp.next;
            temp.next = prev;
            prev = temp;
            temp = next;
        }
        ln.next = null;
        return prev;
    }
	
	public static void main(String[] args) {
		//NODE1
		ListNode node1 = new ListNode( 7 );
		ListNode node2 = new ListNode( 2 );
		ListNode node3 = new ListNode( 4 );
		ListNode node4 = new ListNode( 3 );
		node1.next = node2;
		node2.next = node3;
		node3.next = node4;
		//NODE2
		ListNode node11 = new ListNode( 5 );
		ListNode node12 = new ListNode( 6 );
		ListNode node13 = new ListNode( 4 );
		node11.next = node12;
		node12.next = node13;
		
		AddTwoNumbersII solution = new AddTwoNumbersII();
		ListNode res = solution.addTwoNumbers(node1, node11);
		while( res != null ){
				System.out.println( res.val  + "" );
				res = res.next;
		}
	}
}
