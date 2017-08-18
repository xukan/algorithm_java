package algorithm_java;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import algorithm_java.WordDictionary.TrieNode;

//http://techieme.in/building-an-autocomplete-system-using-trie/

public class AutoComplete {
	class TrieNode {
		char c;
		LinkedList<TrieNode> children;
		int count;
		boolean isEnd;
		String word;

		TrieNode() {
			c = ' ';
			children = new LinkedList<TrieNode>();
			count = 0;
			isEnd = false;
		}

		TrieNode(char c) {
			this.c = c;
			children = new LinkedList<TrieNode>();
			count = 1;
			isEnd = false;
		}

		public TrieNode subNode(char c) {
			for (TrieNode node : children) {
				if (node.c == c)
					return node;
			}
			return null;
		}
	}

	TrieNode root;

	AutoComplete(){
        root = new TrieNode();
    }

	// Adds a word into the data structure.
	public void addWord(String word) {
//		if (search(word))
//			return;
		TrieNode cur = root;
		for (int i = 0; i < word.length(); i++) {
			char c = word.charAt(i);
			TrieNode node = cur.subNode(c);
			if (node != null) {
				node.count++;
				cur = node;
			} else {
				cur.children.add(new TrieNode(c));
				cur = cur.subNode(c);
			}
		}
		cur.isEnd = true;
		cur.word = word;
	}

	public String[] wordsByPrefix(String prefix) {
		TrieNode cur = root;
		for(int i=0;i<prefix.length();i++){
			char c = prefix.charAt(i);
			TrieNode node = cur.subNode(c);
			if(node == null)
				return null;
			else{
				cur = node;
			}
		}
		LinkedList<TrieNode> queue = new LinkedList<TrieNode>();
		queue.offer(cur);
		List<String> words = new ArrayList<String>();
		while(!queue.isEmpty()){
			TrieNode n = queue.poll();
			if(n.isEnd)
				words.add(n.word);
			for(TrieNode next : n.children)
				queue.offer(next);
		}
		return words.toArray(new String[0]);
	}
	
	public boolean search(String word){
		if(word.length() == 0)
			return false;
		TrieNode cur = root;
		return helper(word, cur, 0);
	}
	
	public boolean helper(String word, TrieNode node, int index){
		if(node == null)
			return false;
		if(index == word.length())
			return node.isEnd;
		char c = word.charAt(index);
		if(c!= '.'){
			for(TrieNode n : node.children){
				if(n.c == c)
					return helper(word, n, index+1);
			}
		}else{
			for(TrieNode n: node.children)
				return helper(word, n, index+1);
		}
		return false;
	}
	
	public static void main(String[] args) {
		AutoComplete s = new AutoComplete();
		s.addWord("ab");
		s.addWord("aba");
		s.addWord("abcd");
		s.addWord("abefg");
		s.addWord("bed");
		s.addWord("beg");
		String[] words = s.wordsByPrefix("ab");
		for(String str: words)
			System.out.print(str+" ");
	}
	
}
