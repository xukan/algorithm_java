package algorithm_java;

//LinkedIn Google Facebook 

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
		int size = intervals.size();
        if(size ==0 || newInterval.start>=intervals.get(size-1).start){
            intervals.add(newInterval);
        }else if(newInterval.start<=intervals.get(0).start)
        	intervals.add(0, newInterval);
        else{
	        for( int k=0;k<size-1;k++){
	            if(intervals.get(k).start<=newInterval.start && newInterval.start <=intervals.get(k+1).start){
	                intervals.add(k+1, newInterval);
	                break;
	            }
	        }
        }
        
        //size will change since we remove interval from intervals
        //need to use intervals.size()
        for(int i=1;i<intervals.size();i++){
            while(i<intervals.size() && intervals.get(i).start<=intervals.get(i-1).end){
                intervals.get(i-1).end = Math.max(intervals.get(i).end, intervals.get(i-1).end);
                intervals.remove(i);
            }
        }
        return intervals;
    }
	
	public static void main(String[] args) {
		//[1,2],[3,5],[6,7],[8,10],[12,16]
		Interval i1= new Interval(1,2); 
        Interval i2= new Interval(3,5);
        Interval i3= new Interval(6,7);
        Interval i4= new Interval(8,10);
        Interval i5= new Interval(12,16);
		
        Interval newInter = new Interval(4,9);
		
		List<Interval> intervals =  new ArrayList();
		intervals.add(i1);
        intervals.add(i2);
        intervals.add(i3);
        intervals.add(i4);
        intervals.add(i5);
        intervals.add(i1);
		
		List<Interval> res = insert(intervals, newInter);
        for(Interval i:res)
            System.out.print("["+i.start+","+i.end+"]"+" ");
	}
}
