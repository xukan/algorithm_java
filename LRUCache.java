package algorithm_java;

import java.util.HashMap;

//Google Uber Facebook Twitter Zenefits Amazon Microsoft Snapchat Yahoo Bloomberg Palantir

/*
 * The LRU cache is a hash table of keys and double linked nodes. 
 * The hash table makes the time of get() to be O(1). 
 * The list of double linked nodes make the nodes adding/removal operations O(1).
 * */

public class LRUCache {
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
    
    public LRUCache(int capacity) {
        this.map = new HashMap<Integer, Node>();
        this.size = capacity;
        head = null;
        end = null;
    }
    
    public int get(int key) {
        if(map.containsKey(key)){
            Node n = map.get(key);
            remove(n);
            setHead(n);
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
    }
    
    public static void main(String[] args) {
    	LRUCache cache= new LRUCache(2);
    	cache.put(1, 1);
    	cache.put(2, 2);
    	System.out.println(cache.get(1));       // returns 1
    	cache.put(3, 3);    // evicts key 2
    	System.out.println(cache.get(2));       // returns -1 (not found)
    	cache.put(4, 4);    // evicts key 1
    	System.out.println(cache.get(1));       // returns -1 (not found)
    	System.out.println(cache.get(3));       // returns 3
    	System.out.println(cache.get(4));       // returns 4
	}
}
