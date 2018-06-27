package algorithm_java;

import java.util.HashMap;

//Microsoft Amazon Bloomberg Uber 

class RandomListNode {
      int label;
      RandomListNode next, random;
      RandomListNode(int x) { this.label = x; }
  };

public class CopyListwithRandomPointer {
	//solution I, tc: O(n), sc: O(n)
	public RandomListNode copyRandomList_solI(RandomListNode head) {
        if(head == null)
            return null;
        HashMap<RandomListNode, RandomListNode> map = new HashMap();
        RandomListNode newHead = new RandomListNode(head.label); 
        RandomListNode p = head;
        RandomListNode q = newHead;
        map.put(head, newHead);
        p = p.next;
        while(p!=null){
            RandomListNode copy = new RandomListNode(p.label);
            map.put(p, copy);
            q.next = copy;
            p = p.next;
            q = q.next;
        }
        p = head;
        q = newHead;
        while(p!=null){
        	if(p.random!=null && map.containsKey(p.random)){
                q.random = map.get(p.random);
            }else
                q.random = null;    
            p = p.next;
            q = q.next;
        }
        return newHead;
    }
	
	//solution2, tc: O(n), sc: O(1)
	//思路就是三次循环
	//1.复制,并把新复制的点放在原来点的后面
	//2.给random指针赋值
	//3.解锁链表,
	public RandomListNode copyRandomList(RandomListNode head) {
        if(head == null)
            return null;
        RandomListNode cur = head;
        while(cur!=null){
        	RandomListNode copy = new RandomListNode(cur.label);
            copy.next = cur.next;
            cur.next = copy;
            cur = cur.next.next;
        }
        cur = head;
        while(cur != null){
            if(cur.random!=null)
                cur.next.random = cur.random.next;
            cur = cur.next.next;
        }
        RandomListNode dummy = new RandomListNode(0);       
        RandomListNode copy = dummy;
        cur = head;
        while(cur!=null){
            RandomListNode tmp = cur.next;
            cur.next = tmp.next;
            copy.next = tmp; //第一次的时候dummy.next也指向了复制后的首节点
            cur = cur.next;
            copy = copy.next;
        }
        return dummy.next;
    }
}
