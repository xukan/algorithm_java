package algorithm_java;

public class SortList {
	public static ListNode sortList(ListNode head) {
        if(head == null|| head.next == null)
            return head;
        ListNode slow = head, fast = head, firsthalf = head;
          
        while(fast.next!=null&&fast.next.next!=null){
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode secondhalf = slow.next;
        slow.next = null;
        
        ListNode leftlist = null, rightlist =null;
        if(firsthalf!=secondhalf){
            leftlist = sortList(firsthalf);
            rightlist = sortList(secondhalf);
        }
        return mergeTwoLists(leftlist, rightlist);
    }
    
	//这部分完全是merge two sorted lists的方法
//    public static ListNode mergeTwoLists(ListNode l1, ListNode l2){
//        ListNode dummy = new ListNode(-1);
//        dummy.next = l1;
//        ListNode pre = dummy;
//        while(l1!=null&&l2!=null){
//        	if(l1.val>l2.val){
//        		ListNode next = l2.next;
//        		l2.next = pre.next;//这里写l2.next = l1就可以
//        		pre.next = l2;
//        		l2 = next;
//        	}else
//        		l1=l1.next;
//        	pre = pre.next;
//        }
//        if(l2!=null)
//        	pre.next = l2;
//        return dummy.next;

    	
    public static ListNode mergeTwoLists(ListNode leftlist, ListNode rightlist){
        if(rightlist == null)
            return leftlist;
        if(leftlist == null)
            return rightlist;
        
        ListNode fakehead = new ListNode(-1);
        ListNode ptr = fakehead;
        while(rightlist!=null&&leftlist!=null){
            if(rightlist.val<leftlist.val){
                ptr.next = rightlist;
                ptr = ptr.next;
                rightlist = rightlist.next;
            }else{
                ptr.next = leftlist;
                ptr = ptr.next;
                leftlist = leftlist.next;
            }
        }
        
        if(rightlist!=null)
            ptr.next = rightlist;
        if(leftlist!=null)
            ptr.next = leftlist;
        
        return fakehead.next;
    }
    
    public static void main(String[] args){
    	ListNode node1 = new ListNode(5);
    	ListNode node2 = new ListNode(15);
    	ListNode node3 = new ListNode(11);
    	ListNode node4 = new ListNode(7);
    	ListNode node5 = new ListNode(25);
    	ListNode node6 = new ListNode(1);
    	node1.next = node2;
    	node2.next = node3;
    	node3.next = node4;
    	node4.next = node5;
    	node5.next = node6;
    	
    	ListNode node = sortList(node1);
    	while(node!=null){
    		System.out.println(node.val);
    		node=node.next;
    	}
    }
}
