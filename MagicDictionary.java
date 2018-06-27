package algorithm_java;

import java.util.ArrayList;
import java.util.List;

//Google

public class MagicDictionary {
	class TrieNode{
        char c;
        boolean isWord;
        List<TrieNode> children;
        public TrieNode(){
            c = ' ';
            isWord = false;
            children = new ArrayList<TrieNode>();
        }
        public TrieNode(char c){
            this.c = c;
            isWord = false;
            children = new ArrayList<TrieNode>();
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
    /** Initialize your data structure here. */
    public MagicDictionary() {
        root = new TrieNode();
    }
    
    /** Build a dictionary through a list of words */
    public void buildDict(String[] dict) {
        for(String str: dict)
            addWord(str);
    }
    
    public void addWord(String word){
        TrieNode cur = root;
        for(char c: word.toCharArray()){
            TrieNode node = cur.subNode(c);
            if(node == null){
                TrieNode n = new TrieNode(c);
                cur.children.add(n);
                cur = n;
            }else{
                cur = node;
            }
        }
        cur.isWord = true;
    }
    
    /** Returns if there is any word in the trie that equals to the given word after modifying exactly one character */
    public boolean search(String word) {
        TrieNode cur = root;
        return helper(word, 0, cur, 0);
    }
    
    public boolean helper(String word, int index, TrieNode cur, int count){
        if(index == word.length() && count ==1)
            return cur.isWord;
        if(index == word.length() && count ==0)
            return false;
        if(count >1)
            return false;
        char c = word.charAt(index);
        for(TrieNode n : cur.children){
            if(n.c == c){
                if(helper(word, index+1, n, count))
                    return true;
            }else{
                if(helper(word, index+1, n, count+1))
                    return true;
            }   
        }
        return false;
    }
    
    public static void main(String[] args) {
    	MagicDictionary md = new MagicDictionary();
    	String[] dict = {"hello","hallo", "good"};
    	md.buildDict(dict);
    	System.out.println(md.search("hello"));
    	System.out.println(md.search("hallo"));
    	System.out.println(md.search("goood"));
	}
}
