package algorithm_java;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

//BFS to find the shortest path
//From each word, we can change its letter one by one, thus a breadth first search tree is constructed. 
//The problem becomes to find the shortest path from the start word to the end word. 
//A bread first search (BFS) algorithm can be used as it guarantees the path is the shortest.

public class WordLadder {
	public static int ladderLength(String beginWord, String endWord, List<String> wordList) {
        if(beginWord.length() == 0 || endWord.length() ==0 || beginWord.length()!=endWord.length() || !wordList.contains(endWord))
            return 0;
        Set<String> wordDict = new HashSet<>(wordList);
        Queue<String> queue = new LinkedList<>();
        queue.offer(beginWord);
        int count = 1;
        while(!queue.isEmpty()){
            int size = queue.size();
            for(int i=0;i<size;i++){
                String str = queue.poll();
                char[] array = str.toCharArray();
                for(int j=0;j<str.length();j++){
                    char origin = array[j];
                    for(char c = 'a';c<='z';c++){
                        array[j] = c;
                        String word = new String(array);
                        if(word.equals(endWord))
                            return ++count;
                        if(wordDict.contains(word)){
                            wordDict.remove(word);
                            queue.offer(word);
                        }
                    }
                    array[j] = origin;
                }
            }
            count++;
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
