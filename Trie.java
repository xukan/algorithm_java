package algorithm_java;
//Google Uber Facebook Twitter Microsoft Bloomberg

//similar problem : add and search word(WordDictionary)
import java.util.LinkedList;

class TrieNode{
	char content ;
	LinkedList<TrieNode> child;
	int count;
	boolean isEnd;
	
	TrieNode(){
		content=' ';
		child = new LinkedList<TrieNode>();
		count=0;
		isEnd = false;
	}
	
	TrieNode(char c){
		content =c;
		child = new LinkedList<TrieNode>();
		count=1;
		isEnd = false;
	}
	
	public TrieNode subNode(char c){
		if(child != null){
			for(TrieNode node : child){
				if(node.content==c)
					return node;
			}
		}
		return null;
	}
}

public class Trie {
	private TrieNode root;

    public Trie() {
        root = new TrieNode();
    }

    // Inserts a word into the trie.
    public void insert(String word) {
        if(search(word))
            return;
        TrieNode cur = root;
        for(int i=0;i<word.length();i++){
            char c = word.charAt(i);
            TrieNode node = cur.subNode(c);
            if(node!=null){
                node.count++;
                cur=node;
            }else{
                cur.child.add(new TrieNode(c));
                cur = cur.subNode(c);
            }
        }
        cur.isEnd=true;
    }

    // Returns if the word is in the trie.
    public boolean search(String word) {
        TrieNode cur = root;
        for(int i=0;i<word.length();i++){
            char c = word.charAt(i);
            TrieNode node = cur.subNode(c);
            if(node==null)
                return false;
            else
                cur = node;
        }
        return cur.isEnd;
    }

    // Returns if there is any word in the trie
    // that starts with the given prefix.
    public boolean startsWith(String prefix) {
        TrieNode cur = root;
        for(int i=0;i<prefix.length();i++){
            char c = prefix.charAt(i);
            TrieNode node = cur.subNode(c);
            if(node==null){
                return false;
            }else{
                cur = node;
            }
        }
        return true;
    }
    
    public void delete(String word){
        if(!search(word)){
            return;
        }
        TrieNode cur =root;
        for(int i=0;i<word.length();i++){
            char c = word.charAt(i);
            TrieNode node = cur.subNode(c);
            if(node.count==1){
                cur.child.remove(node);
                return;
            }else{
                node.count--;
                cur = node;
            }
        }
        cur.isEnd=false;
    }
    
    public static void main(String[] args) {  
        Trie trie = new Trie();  
        trie.insert("ball");  
        trie.insert("balls");  
        trie.insert("sense");  
      
        // testing deletion  
        System.out.println(trie.search("balls"));  
//        System.out.println(trie.search("ba"));  
        trie.delete("balls");  
//        System.out.println(trie.search("balls"));  
//        System.out.println(trie.search("ball")); 
//        System.out.println(trie.startsWith("ba"));
    }  
}
