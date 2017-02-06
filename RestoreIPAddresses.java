package algorithm_java;

import java.util.ArrayList;
import java.util.List;

public class RestoreIPAddresses {
	public List<String> restoreIpAddresses(String s) {
		ArrayList<String> res = new ArrayList<String>();
		String item = new String();
		if (s.length() < 4 || s.length() > 12)
			return res;

		dfs(s, 0, item, res);
		return res;
	}

	public void dfs(String s, int start,  String item, ArrayList<String> res) {
		if(start >3)
			return;
		if (start == 3 && isValid(s)) {
			res.add(item + s);
			return;
		}
		for (int i = 0; i < 3 && i<s.length()-1; i++) {
			String substr = s.substring(0, i + 1);
			if (isValid(substr))
				dfs(s.substring(i + 1), start + 1, item + substr + '.', res);
		}
	}

	public boolean isValid(String s) {
		if (s.charAt(0) == '0')
			return s.equals("0");
		int num = Integer.parseInt(s);

		if (num <= 255 && num > 0)
			return true;
		else
			return false;
	}

	public static void main(String[] args) {
		String str = "25525511135";
		//String str ="1111";
		RestoreIPAddresses s = new RestoreIPAddresses();
		List<String> res = s.restoreIpAddresses(str);
		res.forEach(ss -> System.out.print(ss + " "));
	}

}
