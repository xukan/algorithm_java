package algorithm_java;

import java.util.Stack;

public class AddTwoNumbersII {
	public void addNumber( Stack<Integer>stack, ListNode l1 ){
		while( l1 != null ){
			stack.push(l1.val);
			l1 = l1.next;
		}
	}
	
	public ListNode addMoreNode( Stack<Integer> stack, ListNode node, int carry ){
		while( !stack.isEmpty() ){
        	ListNode dummy = new ListNode( 0 );
        	int num = stack.pop();
        	int sum = num + carry;
        	node.val = sum % 10 ;
        	carry = sum/10;
        	dummy.next = node;
        	node = dummy;
        }
		if( carry!=0)
			node.val = carry;
		return node;
	}
	
	public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        Stack<Integer> stack1  = new Stack<Integer>();
        Stack<Integer> stack2  = new Stack<Integer>();
        addNumber( stack1, l1 );
        addNumber( stack2, l2 );
        ListNode dummy = null;
        ListNode node = new ListNode(0);
        int carry = 0;
        while( !stack1.isEmpty() && !stack2.isEmpty() ){
        	dummy = new ListNode( 0 );
        	int n1 = stack1.pop();
        	int n2 = stack2.pop();
        	int sum = n1 + n2 + carry;
        	int remainder = sum % 10;
        	carry = sum/10;
        	node.val =  remainder;
        	dummy.next = node;
        	node = dummy;
        }
        
        //test case 899 + 2 = 901, 
        if( stack1.empty() && stack2.empty() && carry!=0)
        	node.val = carry;
        
        while( !stack1.isEmpty() ){
        	node = addMoreNode( stack1, node, carry );
        }
        
        while( !stack2.isEmpty() ){
        	node = addMoreNode( stack2, node, carry );
        }
        
        if( node.val != 0){
        	return node;
        }else
        	return node.next;
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
