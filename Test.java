package algorithm_java;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;

class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;
	TreeNode(int x) {
		val = x;
	}
}
//class ListNode {
//	int val;
//    ListNode next;
//    ListNode(int x) { val = x; }
//}

public class Test {
	public ListNode reverseBetween(ListNode head, int m, int n) {
        if(head ==null || head.next ==null )
            return head;
        ListNode dummy=new ListNode(-1);
        dummy.next = head;
        ListNode node = head;
        ListNode slow = dummy, fast = dummy;
        for(int i=1;i<m;i++)
            slow = slow.next;
        for(int i=0;i<n;i++) 
            fast = fast.next;
        /*             1      2      3     4     5
         * dumy ->1 ->  2 -> 3 -> 4 -> 5
         *             s      tail           f
         * */
        ListNode tail = slow.next;
        slow.next = fast;
        slow = tail;
        tail = tail.next;
        slow.next= fast.next;
        for(int i=m;i<n;i++){
            ListNode next = tail.next;
            tail.next = slow;
            slow =tail;
            tail = next;
        }
        return dummy.next;
    }
	
	public static void main(String[] args){
		ListNode head = new ListNode(1);
		head.next = new ListNode(2);
		head.next.next = new ListNode(3);
		head.next.next.next = new ListNode(4);
		head.next.next.next.next = new ListNode(5);
		//head = reverseList(head);
		Test s = new Test();
		head = s.reverseBetween(head, 2,4);
		while(head!=null){
			System.out.println(head.val);
			head = head.next;
		}
	}
}