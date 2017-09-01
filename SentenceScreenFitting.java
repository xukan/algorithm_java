package algorithm_java;

import java.util.HashMap;
import java.util.LinkedList;

//Google

public class SentenceScreenFitting {
	public static int wordsTyping(String[] sentence, int rows, int cols) {
		String all = "";
        for(String word: sentence)
            all += (word + " ");
        int start = 0;
        int len = all.length();
        for(int i=0;i<rows;i++){
            start += cols;
            if(all.charAt(start%len) == ' ')
                start++;
            else{
                while(start>0 && all.charAt((start-1)%len)!=' ')
                    start--;
            }
        }
        return start/len;
    }
	
	/*
	 * For any index i for sentence string s, the map[i]defined here is the distance from char s[i]to the initial position of current word, 
	 * where going forward is positive distance and backward is negative distance.
	 * For example, let s = "abc df gherg gerg fd", then map[9] = -2 since we need to go backward 2 positions from s[9] = 'e'to the initial position of current word "gherg". 
	 * Also, it always defines the current word for a white space is the word right next to it, so for s[3] = ' ', map[3] = 1since the initial position of current word "df"is one position right next to s[3].
	 * The purpose for this map array is simply to decide how a word's position on screen should be adjusted when the word would have to be broken into two lines if had printed sequentially.
	 * 
	 * */
	
	public static int wordsTyping_another(String[] sentence, int rows, int cols) {
	    String s = String.join(" ", sentence) + " ";
	    int len = s.length(), count = 0;
	    int[] map = new int[len];
	    for (int i = 1; i < len; ++i) {
	        map[i] = s.charAt(i) == ' ' ? 1 : map[i-1] - 1;
	    }
	    for (int i = 0; i < rows; ++i) {
	        count += cols;
	        count += map[count % len];
	    }
	    return count / len;
	}
	
	public static int wordsTyping_memory(String[] sentence, int rows, int cols) {
	    int rowsc=0;
	    int index=0;
	    int res=0;
	    int cur;
	    HashMap<Integer,LinkedList<Integer>> map = new HashMap<>();
	    while (rowsc<rows){
	        rowsc++;
	        cur=0;
	        if (map.containsKey(index)){
	            LinkedList<Integer> list = map.get(index);
	            index=list.get(0);
	            res+=list.get(1);
	        }else{
	            int init = index;
	            int initres=res;
	            while (cur<cols){
	                if (cur+sentence[index].length()<=cols ){
	                    cur+=sentence[index].length();
	                    cur+=1;
	                    index++;
	                    if (index==sentence.length) {index=0;res++;}
	                }
	                else
	                    break;
	            }
	            LinkedList<Integer> list = new LinkedList<>();
	            list.add(index); list.add(res-initres);
	            map.put(init,list);
	        }
	    }
	    return res;
	}
	
	public static void main(String[] args) {
		int rows = 4, cols = 5;
		String[] sentence = {"I", "had", "apple", "pie"};
//		int rows = 5, cols = 11;
//		String[] sentence = {"I", "am", "fun"};
		int res = wordsTyping_another(sentence, rows, cols);
		int res1 = wordsTyping_memory(sentence, rows, cols);
		System.out.println(res);
		System.out.println(res1);
		
	}
}
