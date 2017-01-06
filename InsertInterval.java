package algorithm_java;

import java.util.ArrayList;

//LinkedIn Google Facebook

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
 * */

public class InsertInterval {
	
	public static List<Interval> insert(List<Interval> intervals, Interval newInterval) {
		if(intervals==null || intervals.size()==0)  
            return intervals;  
		List<Interval> res = new ArrayList<Interval>();
        int i=0, len= intervals.size();
        while(i<len && intervals.get(i).end < newInterval.start){
        	res.add(intervals.get(i++));
        }
        if(i<len)
        	newInterval.start = Math.min(newInterval.start, intervals.get(i).start );
        res.add(newInterval);
        while(i<len && intervals.get(i).start <= newInterval.end){
        	newInterval.end = Math.max(newInterval.end, intervals.get(i).end );
        	i++;
        }
     	
        while(i<len){
        	res.add(intervals.get(i++));
        }
        return res;
    }
	
	public static void main(String[] args) {
		//[1,2],[3,5],[6,7],[8,10],[12,16]
		Interval i1= new Interval(1,2); 
        Interval i2= new Interval(3,5);
        Interval i3= new Interval(6,7);
        Interval i4= new Interval(8,10);
        Interval i5= new Interval(12,16);
		
        Interval addi6= new Interval(4,9);
		
		Interval newInter = new Interval(4,9);
		List<Interval> intervals =  new ArrayList();
		intervals.add(i1);
        intervals.add(i2);
        intervals.add(i3);
        intervals.add(i4);
        intervals.add(i5);
//        intervals.add(i1);
		
		List<Interval> res = insert(intervals, addi6);
        for(Interval i:res)
            System.out.print("["+i.start+","+i.end+"]"+" ");
	}
}
