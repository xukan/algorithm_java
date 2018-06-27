package algorithm_java;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

//Amazon Dropbox Google Uber Facebook

//similar question: combination, permutation

public class LetterCombinationsofaPhoneNumber {
//	public static ArrayList<String> letterCombinations(String digits) {
//	      ArrayList<String> result=new ArrayList<String>();
//	      if (digits==null)
//	          return result;
//
//	      String[] keyboard={"","","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};
//	      StringBuilder current=new StringBuilder();
//	      
//	      int index=0;
//	      helper(digits, index, current, keyboard, result);
//	      return result;
//	  }
//	  
//	  private static void helper(String digits, int index, StringBuilder current, String[] keyboard, ArrayList<String> result){
//	      if (index==digits.length()){
//	        result.add(current.toString());
//	        return;
//	        }
//	        
//	      int num=digits.charAt(index)-'0';//get integer number
//	      String str = keyboard[num];
//	      for (int i=0; i<str.length(); i++){
//	        current.append(str.charAt(i));
//	        helper(digits, index+1, current, keyboard, result);
//	        current.deleteCharAt(current.length()-1);
//	        }
//	    }
	
//	public static List<String> letterCombinations(String digits) {
//		HashMap<Integer, String> map = new HashMap<Integer, String>();
//	    map.put(2, "abc");
//	    map.put(3, "def");
//	    map.put(4, "ghi");
//	    map.put(5, "jkl");
//	    map.put(6, "mno");
//	    map.put(7, "pqrs");
//	    map.put(8, "tuv");
//	    map.put(9, "wxyz");
//	    map.put(0, "");
//	    
//	    List<String> res = new ArrayList<String>();
//		if(digits == null || digits.length() == 0)
//			return res;
//		res.add("");
//		for(int i=0;i<digits.length();i++){
//			String letters = map.get(digits.charAt(i)-'0');
//			List<String> temp = new ArrayList<String>();
//			for(int j=0;j<res.size();j++){
//				for(int k=0;k<letters.length();k++){
//					temp.add(res.get(j)+Character.toString(letters.charAt(k)));
//				}
//			}
//			res = temp;
//		}
//		return res;
//    }
	private static final String[] keyboard = {"","","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};
    
    public List<String> letterCombinations(String digits) {
        List<String> res = new ArrayList<String>();
        if(digits == null || digits.length() == 0)
            return res;
        helper(digits, 0, "", res);
        return res;
    }
    
    public void helper(String digits, int index, String cur, List<String> res){
        if(index == digits.length()){
            res.add(cur);
            return;
        }
        char c = digits.charAt(index);
        //corner case, string contains "*" || "#"
        if(c == '*' || c == '#'){
            helper(digits, index+1, cur, res);
            return;
        }
        String str = keyboard[c-'0'];
        for(int i=0;i<str.length();i++){
            char c1 = str.charAt(i);
            helper(digits, index+1, cur+c1, res);
        }
    }
	
	public static void main(String[] args) {
		LetterCombinationsofaPhoneNumber s = new LetterCombinationsofaPhoneNumber();
		String input = "2*3"; //note input string may contain "#" || "*"
		List<String> res = s.letterCombinations(input);
		for(String str: res)
			System.out.print(str + " ");
	}
}
