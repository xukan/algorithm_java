package algorithm_java;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;

//Microsoft Facebook 

public class AutocompleteSystem {
	class Pair implements Comparable{
		String s;
		int f;
		@Override
		public int compareTo(Object o) {
			Pair p1 = (Pair)o;
			if(p1.f == this.f)
				return this.s.compareTo(p1.s);
			return p1.f - this.f;
		}
		public Pair(String s, int f){
			this.s = s;
			this.f = f;
		}
	}
	
	class TrieNode{
        char c;
        List<TrieNode> children;
        int freq;
        boolean isWord;
        public TrieNode(char c){
            this.c = c;
            children = new ArrayList<TrieNode>();
            freq = 0;
            isWord = false;
        }
        public TrieNode(){
            this.c = ' ';
            children = new ArrayList<TrieNode>();
            freq = 0;
            isWord = false;
        }
        public TrieNode subNode(char c){
            for(TrieNode node : children){
                if(node.c == c)
                    return node;
            }
            return null;
        }
    }
    TrieNode root;
    String inputStr="";
    public void insert(String word, int f){
        TrieNode cur = root;
        for(char c : word.toCharArray()){
            TrieNode node = cur.subNode(c);
            if(node!=null){
                cur = node;
            }else{
                TrieNode n = new TrieNode(c);
                cur.children.add(n);
                cur = n;
            }
        }
        cur.isWord = true;
        cur.freq = f;
    }
    
    public List<String> startWith(String prefix){
        TrieNode cur = root;
        List<Pair> pairs = new ArrayList<Pair>();
        int i = 0;
        for(char c: prefix.toCharArray()){
            TrieNode node = cur.subNode(c);
            if(node!=null){
                cur = node;
                i++;
            }else{
                break;
            }
        }
//        if(cur.isWord)
//            cur.freq++;
        if(prefix.length() == i)
            helper(cur, prefix, pairs);
        Collections.sort(pairs);
        List<String> res = new ArrayList<String>();
        for(int k=0;k<Math.min(pairs.size(), 3);k++){
        	System.out.print(pairs.get(k).s + ":" + pairs.get(k).f );
        	res.add(pairs.get(k).s);
        }
        System.out.println();
        return res;
    }
    
    public TrieNode search(String word){
    	TrieNode cur = root;
        for(char c: word.toCharArray()){
            TrieNode node = cur.subNode(c);
            if(node==null){
                return node;
            }else{
                cur = node;
            }
        }
        return cur;
    }
    
    public void helper(TrieNode cur, String str, List<Pair> res){
        if(cur.isWord){
            res.add(new Pair(str, cur.freq));
        }
        for(TrieNode n: cur.children)
            helper(n, str+n.c, res);
    }
    
    public AutocompleteSystem(String[] sentences, int[] times) {
        root = new TrieNode();
        int len = sentences.length;
        for(int i=0;i<len;i++){
            insert(sentences[i], times[i]);
        }
    }
    
    public List<String> input(char c) {
    	if(c == '#'){
    		TrieNode node = search(inputStr);
            if(node == null)
                insert(inputStr, 1);
            else
            	node.freq++;
            inputStr = "";
    		return new ArrayList<String>();
        }
        inputStr += c;
        List<String> res = startWith(inputStr);
        return res;
    }
    
    public static void main(String[] args){
//    	String[] sentences = {"i love you", "island", "ironman", "i love leetcode"};
//    	int[] times = {5,3,2,2};
    	
    	String[] sentences = {"abc","abbc","a"};
    	int[] times = {3,3,3};
    	AutocompleteSystem as = new AutocompleteSystem(sentences, times);
    	String in= "abc#";
    	int i=0;
    	for(char c: in.toCharArray() ){
    		List<String>strs= as.input(c);
    		System.out.println("input is " + in.substring(0,i+1));
    		for(String str: strs)
    			System.out.print(str+ " ");
    		System.out.println();
    		i++;
    	}
    	i=0;
    	for(char c: in.toCharArray() ){
    		List<String>strs= as.input(c);
    		System.out.println("input is " + in.substring(0,i+1));
    		for(String str: strs)
    			System.out.print(str+ " ");
    		System.out.println();
    		i++;
    	}
//    	i=0;
//    	for(char c: in.toCharArray() ){
//    		List<String>strs= as.input(c);
//    		System.out.println("input is " + in.substring(0,i+1));
//    		for(String str: strs)
//    			System.out.print(str+ " ");
//    		System.out.println();
//    		i++;
//    	}
	}
}


//["AutocompleteSystem","input","input","input","input","input","input","input","input","input","input","input","input","input","input"]
//[[["abc","abbc","a"],[3,3,3]],["b"],["c"],["#"],["b"],["c"],["#"],["a"],["b"],["c"],["#"],["a"],["b"],["c"],["#"]]
//		
//["AutocompleteSystem","input","input","input","input","input","input","input","input","input","input","input","input","input","input"]
//[[["abc","abbc","a"],[3,3,3]],["b"],["c"],["#"],["b"],["c"],["#"],["a"],["b"],["c"],["#"],["a"],["b"],["c"],["#"]]

//[null,[],[],[],["bc"],["bc"],[],["a","abbc","abc"],["abbc","abc"],["abc"],[],["a","abc","abbc"],["abc","abbc"],["abc"],[]]
//[null,[],[],[],["bc"],["bc"],[],["a","abbc","abc"],["abbc","abc"],["abc"],[],["abc","a","abbc"],["abc","abbc"],["abc"],[]]
