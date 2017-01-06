package algorithm_java;

import java.util.HashMap;

public class LongestAbsoluteFilePath {
	public int lengthLongestPath(String input) {
		if(input =="")
			return 0;
		int res = 0;
		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
		map.put(0, 0);   //for test case input="a.txt"
		String[] paths = input.split("\n");
		for( String path : paths){
			int level = path.lastIndexOf("\t")+1;
			int len = path.substring(level).length();
			if( path.contains(".")){
				res = Math.max(res, map.get(level)+len);
			}else{
				map.put( level+1, map.get(level)+len );
			}
		}
		return res;
    }
	
	public static void main(String[] args) {
		String input = "dir\n\tsubdir1\n\t\tfile1.ext\n\t\tsubsubdir1\n\tsubdir2\n\t\tsubsubdir2\n\t\t\tfile2.ext";
		//String input = "dir\n\tsubdir1\n\tsubdir2\n\t\tfile.ext";
		//String input = "a.txt";
		LongestAbsoluteFilePath solution = new LongestAbsoluteFilePath();
		int res = solution.lengthLongestPath(input);
		System.out.println(res);
	}
}
