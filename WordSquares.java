package algorithm_java;

import java.util.ArrayList;
import java.util.List;

//Google
//use List<String>startBy to remember strings with given prefix

public class WordSquares {
	class TrieNode{
        char content;
        boolean isWord;
        List<TrieNode> children;
        List<String> startBy;
        int count=0;
        public TrieNode(){
            content = ' ';
            isWord = false;
            count = 1;
            children = new ArrayList<TrieNode>();
            startBy = new ArrayList<String>();
        }
        
        public TrieNode(char c){
            content = c;
            isWord = false;
            count = 1;
            children = new ArrayList<TrieNode>();
            startBy = new ArrayList<String>();
        }
        
        public void add(){
            count++;
        }
        
        public TrieNode subNode(char c){
            for(TrieNode node: children)
                if(node.content == c)
                    return node;
            return null;
        }
    }
	
	public void insert(String word){
        if(search(word))
            return;
        TrieNode cur = root;
        for(int i=0;i<word.length();i++){
            char c = word.charAt(i);
            TrieNode node = cur.subNode(c);
            if(node==null){
                TrieNode n = new TrieNode(c);
                cur.children.add(n);
                cur.add();
                cur = n;
            }else
                cur = node;
            cur.startBy.add(word);
        }
        cur.isWord = true;
    }
    
    public boolean search(String word){
        TrieNode cur = root;
        for(int i=0;i<word.length();i++){
            char c = word.charAt(i);
            TrieNode node = cur.subNode(c);
            if(node!=null)
                cur = node;
            else
                return false;
        }
        return cur.isWord;
    }
    
    public List<String> startWith(String prefix){
        TrieNode cur = root;
        List<String> ans = new ArrayList<String>();
        for(int i=0;i<prefix.length();i++){
            char c = prefix.charAt(i);
            TrieNode node = cur.subNode(c);
            if(node!=null){
                cur = node;
            }else
                return ans;
        }
        ans.addAll(cur.startBy);
        return ans;
    }
    
    TrieNode root;
    
    public List<List<String>> wordSquares(String[] words) {
    	root = new TrieNode();
    	for(String word: words)
    		insert(word);
        List<List<String>> res = new ArrayList<List<String>>();
        List<String> sol = new ArrayList<String>();
        boolean[] visited = new boolean[words.length];
        for(int i=0;i<words.length;i++){
            sol.add(words[i]);
            helper(1, words, sol, res);
            sol.remove(sol.size()-1);
        }
        return res;
    }
    
    public void helper(int pos, String[] words, List<String> sol, List<List<String>> res){
        if(sol.size() == sol.get(0).length()){
            res.add(new ArrayList<String>(sol));
            return;
        }
        String pre = "";
        for(String str: sol)
            pre += str.charAt(pos);
        List<String> candidates = new ArrayList<String>();
        candidates = startWith(pre);
        	
        for(int i=0;i<candidates.size();i++){
                sol.add(candidates.get(i));
                helper(pos+1, words,sol, res);
                sol.remove(sol.size()-1);
        }
    }
	
    public static void main(String[] args) {
    	WordSquares s = new WordSquares();
    	//String[] words = {"area","lead","wall","lady","ball"};
    	//String[] words = {"abat","baba","atan","atal"};
    	String[] words ={"aaab","abaa","baaa","aaba"};
    	List<List<String>> res = s.wordSquares(words);
    	for(List<String> list: res){
			for(String str: list)
				System.out.print(str+ " ");
			System.out.println();
		}
    	
    	/*
    	 * [["aaab","aaba","abaa","baaa"],
    	 *  ["aaab","abaa","aaba","baaa"],
    	 *  ["aaba","aaab","baaa","abaa"],
    	 *  ["aaba","abaa","baaa","aaab"],
    	 *  ["abaa","baaa","aaab","aaba"],
    	 *  ["abaa","baaa","aaba","aaab"],
    	 *  ["baaa","aaab","aaba","abaa"],
    	 *  ["baaa","aaba","abaa","aaab"],
    	 *  ["baaa","abaa","aaab","aaba"],
    	 *  ["baaa","abaa","aaba","aaab"]]

    	 * */
	}
}
