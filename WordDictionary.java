package algorithm_java;
//Add and Search Word - Data structure design
//reference: http://www.cnblogs.com/yrbbest/p/4979621.html
import java.util.LinkedList;

public class WordDictionary {
	class TrieNode{
        char c;
        LinkedList<TrieNode> child;
        int count;
        boolean isEnd;
        TrieNode(){
            c=' ';
            child = new LinkedList<TrieNode>();
            count=0;
            isEnd=false;
        }
        TrieNode(char c){
            this.c = c;
            child = new LinkedList<TrieNode>();
            count=1;
            isEnd=false;
        }
        public TrieNode subNode(char c){
            for(TrieNode node : child){
                if(node.c ==c)
                    return node;
            }
            return null;
        }
    }
    
    TrieNode root;
    WordDictionary(){
        root = new TrieNode();
    }
    
    // Adds a word into the data structure.
    public void addWord(String word) {
        if(search(word))
            return;
        TrieNode cur = root;
        for(int i=0;i<word.length();i++){
            char c = word.charAt(i);
            TrieNode node = cur.subNode(c);
            if(node!=null){
                node.count++;
                cur = node;
            }else{
                cur.child.add(new TrieNode(c));
                cur = cur.subNode(c);
            }
        }
        cur.isEnd=true;
    }

    // Returns if the word is in the data structure. A word could
    // contain the dot character '.' to represent any one letter.
    public boolean search(String word) {
    	return search(word, root, 0);
    }
    	    
	public boolean search(String word, TrieNode node, int depth) {
	    if (node == null) return false;
	    if (depth == word.length())
	    	return node.isEnd;
	    char c = word.charAt(depth);
	    if (c != '.') {
	        return search(word, node.subNode(c), depth + 1);
	    } else {
	        for (TrieNode nextNode : node.child) {
	            if (search(word, nextNode, depth + 1)) return true;
	        }
	        return false;
	    }
	}
    
    public static void main(String[] args) {  
    	WordDictionary s = new WordDictionary();
    	s.addWord("bad");
    	s.addWord("dad");
    	s.addWord("mad");
    	System.out.println(s.search("pad")); //-> false
    	System.out.println(s.search("bad"));//true
    	System.out.println(s.search(".ad"));//true
    	System.out.println(s.search("b.."));//true
    }  
}
