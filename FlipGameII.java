package algorithm_java;

import java.util.HashMap;

//Google 

public class FlipGameII {
//	public boolean canWin(String s) {
//		if (s == null || s.length() == 0) {
//			return false;
//		}
//		HashMap<String, Boolean> map = new HashMap<>();
//		return canWinHelper(s.toCharArray(), map);
//	}
//
//	public boolean canWinHelper(char[] arr, HashMap<String, Boolean> map) {
//		for (int i = 0; i < arr.length - 1; i++) {
//			if (arr[i] == '+' && arr[i + 1] == '+') {
//				arr[i] = '-';
//				arr[i + 1] = '-';
//				boolean win = false;
//				String t = new String(arr);
//				if(map.containsKey(t))
//					win = map.get(t);
//				else{
//					win = canWinHelper(arr, map);
//					map.put(t, win);
//				}
//				arr[i] = '+';
//				arr[i + 1] = '+';
//				// if there is a flip which makes the other player lose, the
//				// first play wins
//				if (!win) {
//					return true;
//				}
//			}
//		}
//		return false;
//	}
	
	//variable win represent whether the player can win with current string, if win is false, it means previous player will win the game.
	//Which means current player will lose.
	//For example. If input = "++++++", win = false when input turns into "++--++". In this situation, the starting player can guarantee a win
	HashMap<String, Boolean> map = new HashMap<>();
	public boolean canWin(String s) {
		if (s == null || s.length() == 0) {
			return false;
		}
		for(int i=0;i<s.length()-1;i++){
			//s.charAt(i) == '+' && s.charAt(i + 1) == '+' can be shorten as s.startsWith("++", i)
			if(s.startsWith("++", i)){ // 
				String t = s.substring(0, i) + "--" + s.substring(i+2);
				boolean win = false;
				if(map.containsKey(t)){
					win = map.get(t);
				}else{
					win = canWin(t);
					map.put(t, win);
				}
				if(!win)
					return true;
			}
		}
		return false;
	}
	
	public static void main(String[] args) {
		String s = "++++++";
		FlipGameII f = new FlipGameII();
		boolean win = f.canWin(s);
		System.out.println(win);
	}
}
