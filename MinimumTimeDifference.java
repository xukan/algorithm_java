package algorithm_java;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

//Palantir

public class MinimumTimeDifference {
	class Time implements Comparable<Time> {
	    int h;
	    int m;
	    public Time(int h, int m) {
	        this.h = h;
	        this.m = m;
	    }
	    
	    public int compareTo(Time other) {
	        if (this.h == other.h) {
	            return this.m - other.m;
	        }
	        return this.h - other.h;
	    }
	    
	    public int getDiff(Time other) {
	        return (this.h - other.h) * 60 + (this.m - other.m);            
	    }
	}
	
	public int findMinDifference(List<String> timePoints) {
        int n = timePoints.size();
        List<Time> times = new ArrayList<>();
        for (String tp : timePoints) {
            String[] strs = tp.split(":");
            times.add(new Time(Integer.parseInt(strs[0]), Integer.parseInt(strs[1])));
        }
        Collections.sort(times);
        Time earlist = times.get(0);
        times.add(new Time(earlist.h + 24, earlist.m));
        int minDiff = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            int diff = (int) Math.abs(times.get(i).getDiff(times.get(i + 1)));
            minDiff = Math.min(minDiff, diff);
        }
        return minDiff;
    }
	
	//solutionII, bucket
	public int findMinDifference_bucket(List<String> timePoints) {
        boolean[] mark = new boolean[24 * 60];
        for (String time : timePoints) {
            String[] t = time.split(":");
            int h = Integer.parseInt(t[0]);
            int m = Integer.parseInt(t[1]);
            if (mark[h * 60 + m]) return 0;
            mark[h * 60 + m] = true;
        }
        
        int prev = 0, min = Integer.MAX_VALUE;
        int first = Integer.MAX_VALUE, last = Integer.MIN_VALUE;
        for (int i = 0; i < 24 * 60; i++) {
            if (mark[i]) {
                if (first != Integer.MAX_VALUE) {
                    min = Math.min(min, i - prev);
                }
                first = Math.min(first, i);
                last = Math.max(last, i);
                prev = i;
            }
        }
        min = Math.min(min, (24 * 60 - last + first));  
        return min;
    }
	
	public static void main(String[] args) {
		MinimumTimeDifference s = new MinimumTimeDifference();
		//["05:31","22:08","00:35"]
		List<String> input = Arrays.asList("23:59","00:00");
		List<String> input1 = Arrays.asList("05:31","22:08","00:35");
		int res = s.findMinDifference_bucket(input1);
		System.out.println(res);
	}
}
