package algorithm_java;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

//Amazon Dropbox Google Uber Facebook

//similar question: combination

public class LetterCombinationsofaPhoneNumber {
	public static ArrayList<String> letterCombinations(String digits) {
	      ArrayList<String> result=new ArrayList<String>();
	      if (digits==null)
	          return result;

	      String[] keyboard={"","","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};
	      StringBuilder current=new StringBuilder();
	      
	      int index=0;
	      helper(digits, index, current, keyboard, result);
	      return result;
	  }
	  
	  private static void helper(String digits, int index, StringBuilder current, String[] keyboard, ArrayList<String> result){
	      if (index==digits.length()){
	        result.add(current.toString());
	        return;
	        }
	        
	      int num=digits.charAt(index)-'0';//get integer number
	      String str = keyboard[num];
	      for (int i=0; i<str.length(); i++){
	        current.append(str.charAt(i));
	        helper(digits, index+1, current, keyboard, result);
	        current.deleteCharAt(current.length()-1);
	        }
	    }
	
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
	
	
	
	public static void main(String[] args) {
		String input = "23";
		List<String> res = letterCombinations(input);
		for(String s: res)
			System.out.print(s + " ");
	}
}
