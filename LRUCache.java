package algorithm_java;

import java.util.HashMap;
import java.util.Map;

//Google Uber Facebook Twitter Zenefits Amazon Microsoft Snapchat Yahoo Bloomberg Palantir

/*
 * The LRU cache is a hash table of keys and double linked nodes. 
 * The hash table makes the time of get() to be O(1). 
 * The list of double linked nodes make the nodes adding/removal operations O(1).
 * */

public class LRUCache {
	class Node{
        int key;
        int val;
        Node prev;
        Node next;
        public Node(int k, int v){
            key = k;
            val = v;
            prev = null;
            next = null;
        }
    }
    Node head;
    Node tail;
    int size;
    Map<Integer, Node> map;
    public LRUCache(int capacity) {
        size = capacity;
        map = new HashMap<Integer, Node>();
        head = null;
        tail = null;
    }
    
    public void setHead(Node node){
        node.next = head;
        node.prev = null;
        if(head!=null)
            head.prev = node;
        head = node;
        if(tail == null)
            tail = head;
    }
    
    public int get(int key) {
        if(map.containsKey(key)){
            Node node = map.get(key);
            remove(node);
            setHead(node);
            return node.val;
        }
        return -1;
    }
    
    public void put(int key, int value) {
        Node node = new Node(key, value);
        if(!map.containsKey(key)){
            if(map.size()>=size){
                map.remove(tail.key);
                remove(tail);
            }  
        }else{
            remove(map.get(key));
        }
        setHead(node);
        map.put(key, node);
    }
    
    public void remove(Node node){
        if(node.prev!=null)
            node.prev.next = node.next;
        else
            head = node.next;
        if(node.next!=null)
            node.next.prev = node.prev;
        else
            tail = node.prev;
    }
	
	
    public static void main(String[] args) {
//    	LRUCache cache= new LRUCache(2);
//    	cache.put(1, 1);
//    	cache.put(2, 2);
//    	System.out.println(cache.get(1));       // returns 1
//    	cache.put(3, 3);    // evicts key 2
//    	System.out.println(cache.get(2));       // returns -1 (not found)
//    	cache.put(4, 4);    // evicts key 1
//    	System.out.println(cache.get(1));       // returns -1 (not found)
//    	System.out.println(cache.get(3));       // returns 3
//    	System.out.println(cache.get(4));       // returns 4
    	LRUCache cache= new LRUCache(10);
    	cache.put(10,13);
    	cache.put(3,17);
    	cache.put(6,11);
    	cache.put(10, 5);
    	cache.put(9, 10);
	}
}
