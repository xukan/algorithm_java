package algorithm_java;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//SnapChat

public class LogSystem {
	HashMap<Integer, String> logs;
    HashMap<String, Integer> map;
    public LogSystem() {
        logs = new HashMap<Integer, String>();
        map = new HashMap<String, Integer>();
        map.put("Year", 4);
        map.put("Month", 7);
        map.put("Day", 10);
        map.put("Hour", 13);
        map.put("Minute", 16);
        map.put("Second", 19);
    }
    
    public void put(int id, String timestamp) {
        logs.put(id, timestamp);
    }
    
    public List<Integer> retrieve(String s, String e, String gra) {
        int index = map.get(gra);
        String start = s.substring(0, index);
        String end = e.substring(0, index);
        List<Integer> res = new ArrayList<Integer>();
        for(Map.Entry<Integer, String> entry: logs.entrySet()){
            String time = entry.getValue().substring(0,index);
            // str1.compareTo(str2)<=0 if str1 is lexicographically less than str2
            if(start.compareTo(time) <=0 && end.compareTo(time)>=0)
                res.add(entry.getKey());
        }
        return res;
    }
	
    public static void main(String[] args) {    					
    	LogSystem ls = new LogSystem();
    	ls.put(1, "2017:01:01:23:59:59");
    	ls.put(2, "2017:01:02:23:59:59");
//    	ls.put(3, "2016:01:01:00:00:00");
    	List<Integer> res = ls.retrieve("2017:01:01:23:59:58","2017:01:02:23:59:58","Month"); // return [1,2,3],
    	for(int i: res)
    		System.out.print(i + " ");
    	System.out.println();
//    	List<Integer> res1 = ls.retrieve("2016:01:01:01:01:01","2017:01:01:23:00:00","Hour");
//    	for(int i: res1)
//    		System.out.print(i + " ");
	}
}
