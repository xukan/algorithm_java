package algorithm_java;


/*      1
	  /     \
	2       3
   /  \     / 
  4   5  6
      / \
     7  8     */
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Stack;

public class Test {
	HashMap<Integer, Node> map;
    Node head;
    Node end;
    int size;
    
    class Node{
        int key;
        int val;
        Node pre;
        Node next;
        Node(int k, int v){
            this.key= k;
            this.val = v;
        }
    }
    
    public Test(int capacity) {
        this.map = new HashMap<Integer, Node>();
        this.size = capacity;
        head = null;
        end = null;
    }
    
    public int get(int key) {
        if(map.containsKey(key)){
            Node n = map.get(key);
            if(map.size()>1){
	            remove(n);
	            setHead(n);
            }
            return n.val;
        }
        return -1;
    }
    
    public void setHead(Node node){
        node.next = head;
        node.pre = null;
        if(head!=null)
            head.pre = node;
        head = node;
        if(end == null)
            end = head;
    }
    
    public void remove(Node node){
        if(node.pre!=null)
            node.pre.next = node.next;
        else
            head = node.next;
        if(node.next != null)
            node.next.pre = node.pre;
        else
            end = node.pre;
    }
    
    public void put(int key, int value) {
        Node node = new Node(key, value);
        if(!map.containsKey(key)){
            if(map.size()>=size){
                map.remove(end.key);
                remove(end);
            }
            setHead(node);
        }else{
            Node old = map.get(key);
            remove(old);
            setHead(node);
        }
        map.put(key, node);
//        Node h = head;
//        System.out.println( "dnode: ");
//        while(h!=null){
//        	System.out.print(h.val+" ");
//        	h = h.next;
//        }
//        System.out.println();
    }
    
    public static void main(String[] args) {
    	Test cache= new Test(2);
    	cache.put(2, 1);
    	cache.put(2, 2);
    	System.out.println(cache.get(2));       // returns 1
    	cache.put(1, 1);    // evicts key 2
    	
    	cache.put(4, 1);    // evicts key 1
    	System.out.println(cache.get(2));       // returns -1 (not found)


	}
}