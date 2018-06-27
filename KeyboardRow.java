package algorithm_java;

import java.util.ArrayList;
import java.util.List;

//MathWorks

public class KeyboardRow {
	public String[] findWords(String[] words) {
        String[] keyboard = {"qwertyuiop", "asdfghjkl", "zxcvbnm"};
        List<String> res = new ArrayList<String>();
        for(String word : words){
            String lword = word.toLowerCase();
            char c = lword.charAt(0);
            String target = "";
            if(keyboard[0].indexOf(c)!=-1)
                target = keyboard[0];
            if(keyboard[1].indexOf(c)!=-1)
                target = keyboard[1];
            if(keyboard[2].indexOf(c)!=-1)
                target = keyboard[2];
            if(helper(lword, target))
                res.add(word);
        }
        return res.toArray(new String[res.size()]);
    }
    
    public boolean helper(String str, String s){
        for(char c : str.toCharArray())
            if(s.indexOf(c)==-1)
                return false;
        return true;
    }
}
