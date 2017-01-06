package algorithm_java;
//这道题必须声明p1和p2, p1=l1, p2=l2, 否则会超时的
public class AddTwoNumbers {	
	public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
		int carry =0;
		 
        ListNode newHead = new ListNode(0);
        ListNode p1 = l1, p2 = l2, p3=newHead;
 
        while(p1 != null || p2 != null){
            if(p1 != null){
                carry += p1.val;
                p1 = p1.next;
            }
 
            if(p2 != null){
                carry += p2.val;
                p2 = p2.next;
            }
 
            p3.next = new ListNode(carry%10);
            p3 = p3.next;
            carry /= 10;
        }
 
        if(carry==1) 
            p3.next=new ListNode(1);
 
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
