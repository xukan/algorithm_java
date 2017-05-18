package algorithm_java;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

//BFS to find the shortest path
//From each word, we can change its letter one by one, thus a bread first search tree is constructed. 
//The problem becomes to find the shortest path from the start word to the end word. 
//A bread first search (BFS) algorithm can be used as it guarantees the path is the shortest.

public class WordLadder {
	public static int ladderLength(String beginWord, String endWord, List<String> wordList) {
		if( beginWord.length()==0 || endWord.length()==0 || beginWord.length()!=endWord.length() || !wordList.contains(endWord))
            return 0; 
        Set<String> dict= new HashSet<String>(wordList);
        LinkedList<String> queue = new LinkedList();
        int count = 0;
        queue.offer(beginWord);
        int curnum = 1;
        int nextnum = 0;
        int level = 1;
        while(!queue.isEmpty()){
            String word = queue.poll();
            curnum--;
            
            for(int i=0;i<word.length();i++){
                char[] wordunit = word.toCharArray();
                for(char j = 'a'; j <= 'z'; j++){
                    wordunit[i] = j;
                    String temp = new String(wordunit);  
                    
                    if(temp.equals(endWord))
                        return level+1;
                    if(dict.contains(temp)){
                        queue.offer(temp);
                        nextnum++;
                        dict.remove(temp);
                    }
                }
            }
            if(curnum==0){
                level+=1;
                curnum=nextnum;
                nextnum=0;
            }
        }
        return 0;
    }
	
	public static void main(String[] args){
		List<String> dict = new ArrayList<String>();
		String start = "hit", end="cog";
		dict.add("hot");
		dict.add("dot");
		dict.add("dog");
		dict.add("lot");
		dict.add("log");
		dict.add(end);
		int res = ladderLength(start, end, dict);
		
		System.out.println(res);

	} 
	
}
