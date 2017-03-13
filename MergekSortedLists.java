package algorithm_java;

public class MergekSortedLists {
	public ListNode mergeKLists(ListNode[] lists) {
        //int[] pos = new int[lists.length];
        ListNode head = mergeSort(0, lists.length-1, lists);
        return head;
    }
    
    public ListNode mergeSort(int l, int h, ListNode[] lists){
        if(l<h){
            int m=l+ (h-l)/2;
            ListNode node1=mergeSort(l, m, lists);  // here, we cannot use (l, m-1), since m-1 might equal -1, list[-1] is unreasonable.
            ListNode node2=mergeSort(m+1, h, lists);  
            return merge(node1, node2);
        }
        return lists[l];
    }
    
    public ListNode merge(ListNode l1, ListNode l2){
    	ListNode dummy = new ListNode(-1);
    	ListNode pre = dummy;
        while( l1!=null && l2!=null){
            if( l1.val < l2.val ){
                pre.next = l1;
                l1=l1.next;
                
            }else{
                pre.next=l2;
                l2=l2.next;
            }
            pre = pre.next;
        }
        if(l1!=null){
            pre.next=l1;
        }
        if(l2!=null)
        	pre.next=l2;
        return dummy.next;
    }
    
    
    public static void main(String[] args){
		ListNode node1 = new ListNode(5);
    	ListNode node2 = new ListNode(15);
    	ListNode node3 = new ListNode(25);
    	ListNode node4 = new ListNode(27);
    	ListNode node5 = new ListNode(35);
    	ListNode node6 = new ListNode(51);
    	node1.next = node2;
    	node2.next = node3;
    	node3.next = node4;
    	node4.next = node5;
    	node5.next = node6; 
    	ListNode node10 = new ListNode(2);
    	ListNode node11 = new ListNode(7);
    	ListNode node22 = new ListNode(8);
    	node10.next = node11;
    	node11.next = node22;
    	ListNode node33 = new ListNode(1);
    	ListNode node44 = new ListNode(6);
    	ListNode node55 = new ListNode(25);
    	ListNode node66 = new ListNode(37);
//    	node22.next = node33;
    	node33.next = node44;
    	node44.next = node55;
    	node55.next = node66; 
    	ListNode[] lists={node1, node10, node33};
    	MergekSortedLists s = new MergekSortedLists();
    	ListNode head = s.mergeKLists(lists);
    	while(head!=null){
			System.out.println(head.val);
			head = head.next;
		}    	
	}
}
