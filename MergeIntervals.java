package algorithm_java;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

//LinkedIn Google Facebook Twitter Microsoft Bloomberg Yelp

//similar : meeting rooms II

//class Interval {
//	int start;
//	int end;
//	Interval() {
//		start = 0;
//		end = 0;
//	}
//	Interval(int s, int e) {
//		start = s;
//		end = e;
//	}
//}
public class MergeIntervals {
	public static List<Interval> merge(List<Interval> intervals) {
		if(intervals==null || intervals.size()==0)  
            return intervals;
        List<Interval> res = new ArrayList<Interval>();

        Collections.sort(intervals, (Interval a, Interval b) -> (a.start - b.start));
        res.add(intervals.get(0));
        int i=1, j=0,size =intervals.size();    
        while(i<size){
            if(intervals.get(i).start<=res.get(j).end){
                res.get(j).end = Math.max(res.get(j).end, intervals.get(i).end);
            }else{
                res.add(intervals.get(i));
                j++;
            }
            i++;
        }
        return res;
    }
	
public static void main(String a[]){
        //[[2,3],[4,5],[6,7],[8,9],[1,10]]
        Interval i1= new Interval(2,3); 
        Interval i2= new Interval(4,5);
        Interval i3= new Interval(6,7);
        Interval i4= new Interval(8,9);
        Interval i5= new Interval(1,10);
        List<Interval> intervals = new ArrayList<Interval>();
        intervals.add(i1);
        intervals.add(i2);
        intervals.add(i3);
        intervals.add(i4);
        intervals.add(i5);
        List<Interval> res = merge(intervals);
        for(Interval i:res)
            System.out.print("["+i.start+","+i.end+"]"+" ");
    }
}
