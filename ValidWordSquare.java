package algorithm_java;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class ValidWordSquare {
	public static boolean validWordSquare(List<String> words) {
        if(words == null || words.size()==0)
            return false;
        HashMap<Integer, String> map = new HashMap();
        int i=0;
        int len = words.get(0).length();
        for(String word : words){
            map.put(i++, word);
        }
        for(int j=0;j<words.size();j++){
            StringBuilder sb = new StringBuilder();
            for(String word: words){
                if(j<word.length())
                    sb.append(word.charAt(j));
            }
            if(!map.get(j).equals(sb.toString()))
                return false;
        }
        return true;
    }
	
	public static void main(String[] args) {
		String[] array = {"abcd","bnrt","crm","dt"};
		List<String> words  = Arrays.asList(array);
		boolean res = validWordSquare(words);
		System.out.println(res);
	}
}
