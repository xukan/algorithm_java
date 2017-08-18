package algorithm_java;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

//Microsoft Google Airbnb

/*
 * 这道题的结果集如果用str+=board[i][j]做，就可以不用考虑sb.deleteCharAt(sb.length()-1),str在回溯的时候会自动变为上一次的字符串，
 * StringBuilder则不能，需要手动删除
 * */
public class WordSearchII {
	class TrieNode{
		char content;
		int count;
		List<TrieNode> children;
		boolean isWord;
		public TrieNode(){
			content = ' ';
			count=0;
			children = new ArrayList();
			isWord = false;
		}
		public TrieNode(char c ){
			content = c;
			count=0;
			children = new ArrayList();
			isWord = false;
		}
		public TrieNode subNode(char c){
			TrieNode node = null;
			for(TrieNode child: children)
				if(child.content == c)
					return child;
			return node;
		}
	}
	
	TrieNode root = new TrieNode();
	public void insert(String word){
		TrieNode cur = root;
		if(search(word))
			return;
		for(int i=0;i<word.length();i++){
			char c = word.charAt(i);
			TrieNode node = cur.subNode(c);
			if(node!=null){
				cur = node;
			}else{
				TrieNode n = new TrieNode(c);
				cur.children.add(n);
				cur = n;
			}
			cur.count++;
		}
		cur.isWord= true;
	}
	
	public boolean search(String word){
		TrieNode cur = root;
		for(int i=0;i<word.length();i++){
			char c = word.charAt(i);
			TrieNode node = cur.subNode(c);
			if(node==null)
				return false;
			else
				cur = node;
		}
		return cur.isWord;
	}
	
	public List<String> findWords(char[][] board, String[] words) {
		Set<String> res = new HashSet();
		if(words.length ==0)
			return new ArrayList();
		for(String word: words){
			insert(word);
		}
		int m = board.length;
		int n = board[0].length;
		boolean[][] visited = new boolean[m][n];
		for(int i=0;i<m;i++){
			for(int j=0;j<n;j++){
				for(TrieNode node: root.children){
					if(node.content == board[i][j])
				// 		helper(board, visited, node, "", i, j, res);
			        	helper(board, visited, node, new StringBuilder(), i, j, res);
				}
			}
		}
		return new ArrayList<String>(res);
	}
	
	//public void helper(char[][] board, boolean[][] visited, TrieNode cur,  String str, int i, int j, Set<String> res){
		public void helper(char[][] board, boolean[][] visited, TrieNode cur,  StringBuilder sb, int i, int j, Set<String> res){
			int m = board.length;
			int n = board[0].length;
			if(cur==null)
				return;
			sb.append(board[i][j]);
//	 		str+=board[i][j];
			visited[i][j] = true;
			if(cur.isWord){
//	 			res.add(str);
	            res.add(sb.toString());
			}
			int[][] dirs = {{-1,0},{1,0},{0,-1},{0,1}};
			for(int[] dir : dirs ){
				int x = i+dir[0];
				int y = j+dir[1];
				if(x<0 || x>=m || y<0 || y>=n || visited[x][y] )
					continue;
				TrieNode node = cur.subNode(board[x][y]); 
//	 			helper(board, visited, node, str, x, y, res);
	            helper(board, visited, node, sb, x, y, res);
	            
			}
			//如果是str就不用删除了
			if(sb.length()>0)
		        sb.deleteCharAt(sb.length()-1);
			visited[i][j] = false;
		}
	
	public static void main(String[] args) {
		WordSearchII s = new WordSearchII();
//		char[][] board = {{'o','a','a','n'},
//								  {'e','t','a','e'},
//								  {'i','h','k','r'}};
//		String[] words ={"oath","pea","eat","rain"};
		char[][] board={{'a','b'},
								{'a','a'}};
		String[] words ={"aaba", "aaab"};
		List<String> res = s.findWords(board, words);
		for(String str: res)
			System.out.print(str+" ");
	}
	
}
