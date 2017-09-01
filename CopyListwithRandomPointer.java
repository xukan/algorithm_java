package algorithm_java;

import java.util.HashMap;

class RandomListNode {
      int label;
      RandomListNode next, random;
      RandomListNode(int x) { this.label = x; }
  };

public class CopyListwithRandomPointer {
	public RandomListNode copyRandomList(RandomListNode head) {
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
}
