package algorithm_java;

public class IntersectionofTwoLinkedLists {
	public static ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if(headA==null || headB==null)
            return null;
        int sizeA = 0, sizeB=0;
        ListNode a=headA, b=headB;
        while(a!=null){
            a=a.next;
            sizeA++;
        }
        while(b!=null){
            b=b.next;
            sizeB++;
        }
        int max= Math.max(sizeA, sizeB);
        int diff = Math.abs(sizeA-sizeB);
        int i=0;
        if(sizeA>sizeB){
            for(;i<diff;i++){
                headA=headA.next;
            }
        }else{
            for(;i<diff;i++)
                headB=headB.next;
        }
        
        while(headA!=null && headB!=null){
            if(headA.val==headB.val)
                return headA;
            headA=headA.next;
            headB=headB.next;
        }
        return null;
    }
    
    public static void main(String[] args) {
    	//Intersected at '30': [1,3,5,7,9,11,13,15,17,19,21,23,25,27,29,30,31,32]
    	//[30,31,32]
		
    	ListNode a1 = new ListNode(1);
		ListNode a2 = new ListNode(3);
		ListNode a3 = new ListNode(5);
		ListNode a4 = new ListNode(7);
		ListNode a5 = new ListNode(9);
		ListNode a6 = new ListNode(11);
		ListNode a7 = new ListNode(13);
		ListNode a8 = new ListNode(15);
		ListNode a9 = new ListNode(17);
		ListNode a10 = new ListNode(19);
		ListNode a11 = new ListNode(21);
		ListNode a12 = new ListNode(23);
		ListNode a13 = new ListNode(25);
		ListNode a14 = new ListNode(27);
		ListNode a15 = new ListNode(29);
		ListNode a16 = new ListNode(30);
		ListNode a17 = new ListNode(31);
		ListNode a18 = new ListNode(32);
		
		a1.next=a2;
		a2.next=a3;
		a3.next=a4;
		a4.next=a5;
		a5.next=a6;
		a6.next=a7;
		a7.next=a8;
		a8.next=a9;
		a9.next=a10;
		a10.next=a11;
		a11.next=a12;
		a12.next=a13;
		a13.next=a14;
		a14.next=a15;
		a15.next=a16;
		a16.next=a17;
		a17.next=a18;
		
		ListNode commonNode = getIntersectionNode(a1, a16);
		System.out.println(commonNode.val);
	}
}
