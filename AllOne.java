package algorithm_java;

import java.util.HashMap;
import java.util.PriorityQueue;
import java.util.Comparator;

public class AllOne {
	class Node{
        String key;
        int val;
        public Node(String k, int v){
            this.key = k;
            this.val = v;
        }
    }
    HashMap<String, Node> map;
    PriorityQueue<Node> minQ;
    PriorityQueue<Node> maxQ;
    
    public AllOne() {
        map = new HashMap();
        minQ = new PriorityQueue<Node>(new Comparator <Node>(){
            public int compare(Node n1, Node n2){
                return n1.val - n2.val;
            }    
        });
        
        maxQ = new PriorityQueue<Node>(new Comparator<Node>(){
            public int compare(Node n1, Node n2){
                return n2.val - n1.val;
            }    
        });
    }
    
    /** Inserts a new key <Key> with value 1. Or increments an existing key by 1. */
    public void inc(String key) {
        if(!map.containsKey(key)){
            Node node = new Node(key, 1);
            map.put(key, node);
            minQ.offer(node);
            maxQ.offer(node);
        }else{
            Node node = map.get(key);
            minQ.remove(node);
            maxQ.remove(node);
            node.val++;
            minQ.offer(node);
            maxQ.offer(node);
        }
    }
    /** Decrements an existing key by 1. If Key's value is 1, remove it from the data structure. */
    public void dec(String key) {
        if(!map.containsKey(key))
            return;
        else{
            Node node = map.get(key);
            if (node.val == 1) {
                map.remove(key);
                minQ.remove(node);
                maxQ.remove(node);
            }else{
                minQ.remove(node);
                maxQ.remove(node);
                --node.val;
                minQ.offer(node);
                maxQ.offer(node);
            }
                
        }
    }
    
    /** Returns one of the keys with maximal value. */
    public String getMaxKey() {
        return maxQ.isEmpty() ? "" : maxQ.peek().key;
    }
    
    /** Returns one of the keys with Minimal value. */
    public String getMinKey() {
        return minQ.isEmpty() ? "" : minQ.peek().key;
    }
}
