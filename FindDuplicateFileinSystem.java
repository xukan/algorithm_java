package algorithm_java;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//Dropbox

/*
 * Follow-up beyond contest:
 * Imagine you are given a real file system, how will you search files? DFS or BFS?
 * If the file content is very large (GB level), how will you modify your solution?
 * If you can only read the file by 1kb each time, how will you modify your solution?
 * What is the time complexity of your modified solution? What is the most time-consuming part and memory consuming part of it? How to optimize?
 * How to make sure the duplicated files you find are not false positive?
 * */

public class FindDuplicateFileinSystem {
	public static List<List<String>> findDuplicate(String[] paths) {
        List<List<String>> res = new ArrayList<List<String>>();
        HashMap<String, List<String>> map = new HashMap<>();
        for(String str: paths){
            String[] parts = str.split("\\s+");
            for(int i=1;i<parts.length;i++){
                int index = parts[i].indexOf("(");
                String content = parts[i].substring(index+1, parts[i].length()-1);
                String path = parts[0] + "/" + parts[i].substring(0, index);
                if(!map.containsKey(content))
                    map.put(content, new ArrayList<String>());
                map.get(content).add(path);
            }
        }
        for(Map.Entry<String, List<String>> entry: map.entrySet()){
            List<String> list = entry.getValue();
            if(list.size()>1){
                res.add(new ArrayList<String>(list));
            }
        }
        return res;
    }
	
	public static void main(String[] args) {
		String[] paths = {"root/a 1.txt(abcd) 2.txt(efgh)","root/c 3.txt(abcd)","root/c/d 4.txt(efgh)","root 4.txt(efgh)"};
		List<List<String>> res = findDuplicate(paths);
		for(List<String> list: res){
			for(String str: list){
				System.out.print(str+" ");
			}
			System.out.println();
		}
	}
}
