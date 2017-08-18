package algorithm_java;

//Amazon Microsoft Bloomberg Airbnb Adobe 

//similar question
//Add Two Numbers II
public class AddTwoNumbers {	
	public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode n= new ListNode(0);
        ListNode newHead = n;
        int carry = 0;
        while(l1!=null || l2 != null){
            if(l1!=null){
                carry += l1.val;
                l1 = l1.next;
            }
            if(l2!=null){
                carry += l2.val;
                l2 = l2.next;
            }
            ListNode node = new ListNode(carry % 10);
            n.next = node;
            n = n.next;
        }
        if(carry!=0){
            ListNode node = new ListNode(carry);
            n.next = node;
        }
        return newHead.next;
    }
	
	
	public static void main(String[] args) {
		ListNode node1 = new ListNode( 9 );
//		ListNode node2 = new ListNode( 4 );
//		ListNode node3 = new ListNode( 3 );
		ListNode node4 = new ListNode( 1 );
		ListNode node5 = new ListNode( 9 );
		ListNode node6 = new ListNode( 9 );
		ListNode node7 = new ListNode( 9 );
		ListNode node8 = new ListNode( 9 );
		ListNode node9 = new ListNode( 9 );
		ListNode node10 = new ListNode( 9 );
		ListNode node11 = new ListNode( 9 );
		ListNode node12 = new ListNode( 9 );
		ListNode node13 = new ListNode( 9 );
//		node1.next = node2;
//		node2.next = node3;
		node4.next = node5;
		node5.next = node6;
		node6.next = node7;
		node7.next = node8;
		node8.next = node9;
		node9.next = node10;
		node10.next = node11;
		node11.next = node12;
		node12.next = node13;
		AddTwoNumbers solution = new AddTwoNumbers();
		ListNode result =  solution.addTwoNumbers( node1, node4 );
		while( result != null ){
			System.out.print( result.val + " " );
			result = result.next;
		}
	}
	
}
