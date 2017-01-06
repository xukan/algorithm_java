package algorithm_java;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
/*
 * class Interval {
	int start;
	int end;
	Interval() {
		start = 0;
		end = 0;
	}
	Interval(int s, int e) {
		start = s;
		end = e;
	}
}
 * 
 * http://www.cnblogs.com/grandyang/p/6017505.html
 * greedy
 * */
public class NonoverlappingIntervals {
	public static int eraseOverlapIntervals(Interval[] intervals) {
        if(intervals == null || intervals.length ==0)
        	return 0;
        Arrays.sort(intervals, (Interval a, Interval b)->(a.start - b.start));
       int size = intervals.length;
        int last=0;
        int res=0;
        for( int i=1;i<size ;i++){
	       if(intervals[last].end > intervals[i].start){
	    	   res++;
	    	   if(intervals[last].end > intervals[i].end)
	    		   last = i;
	       }else
	    	   last=i;
        }
        return res;
    }
	
	public static void main(String[] args) {
		Interval i1= new Interval(0,2); 
	    Interval i2= new Interval(1,3);
	    Interval i3= new Interval(2,4);
	    Interval i4= new Interval(3,5);
	    Interval i5= new Interval(4,6);
	    Interval[]  intervals = {i1,i2,i3,i4,i5};
	    //intervals.add(i5);
	    int res = eraseOverlapIntervals(intervals);
	    System.out.print(res);
	}
}
