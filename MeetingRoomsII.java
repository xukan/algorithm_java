package algorithm_java;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

//Google Snapchat Facebook Yelp

//public class Interval {
//     int start;
//     int end;
//     Interval() { start = 0; end = 0; }
//     Interval(int s, int e) { start = s; end = e; }
//}

public class MeetingRoomsII {
	//solution1, worst case O(n^2)
	public static  int minMeetingRooms(Interval[] intervals) {
		if(intervals==null || intervals.length==0)
            return 0;
        Arrays.sort(intervals, (Interval a, Interval b)->(a.start - b.start));
//        Arrays.sort(intervals, new Comparator<Interval>(){
//            public int compare(Interval i1, Interval i2){
//                return Integer.compare(i1.start, i2.start);
//            }
//        });
        List<Interval> list = new ArrayList();
        list.add(intervals[0]);
        for(int i=1;i<intervals.length;i++){
            Interval next = intervals[i];
            boolean find = false;
            for(Interval inter: list){
                if(inter.end <= next.start){
                    inter.end = Math.max(inter.end, next.end);
                    find = true;
                    break;
                }
            }
            if(!find)
                list.add(next);
        }
        return list.size();
    }
	
	//my solution
	/*
	 * when we add intervals to the queue, we sort them by start time. Then we can iterate the queue, and merge the intervals.
	 * we can create a list to store the intervals if their end time smaller than others' start time. And merge the intervals
	 * without collision. 
	 * */

//        PriorityQueue<Interval> queue = new PriorityQueue<Interval>(intervals.length, new Comparator<Interval>(){
//            public int compare(Interval i1, Interval i2){
//                return Integer.compare(i1.start, i2.start);
//            }
//        });
        
        //PriorityQueue<Interval> queue = new PriorityQueue<Interval>((Interval i1, Interval i2)->i1.start - i2.start);
        //sort by String
        //Arrays.sort(myTypes, (a,b) -> a.name.compareTo(b.name));
//        Arrays.sort(intervals, new Comparator<Interval>(){
//            public int compare(Interval i1, Interval i2){
//                return i1.start-i2.start;
//            }
//        });
	
	//optimal solution, tc: O(nlogn)
	//we need to understand this algorithm by drawing pictures
	public int minMeetingRooms_optimal(Interval[] intervals) {
        if(intervals.length == 0)
            return 0;
        int len = intervals.length;
        int[] starts = new int[len];
        int[] ends = new int[len];
        int i=0;
        for(Interval inter: intervals){
            starts[i] = inter.start;
            ends[i] = inter.end;
            i++;
        }
        Arrays.sort(starts);
        Arrays.sort(ends);
        int endIter=0;
        int room = 0;
        for(int k=0;k<len;k++){
            if(starts[k]<ends[endIter])
                room++;
            else{
            	//what happens here can be thought of as we move newly added meeting to a room that previously ends
            	//thus we don’t need to increment rooms at this time and move both of the pointers forward.
                endIter++;
            }
        }
        return room;
    }
	
	
	public static void main(String[] args) {
		Interval i1= new Interval(0,10); 
        Interval i2= new Interval(5, 15);
        Interval i3= new Interval(12,20);
        Interval i4= new Interval(16,18);
        Interval[] intervals = {i1, i2, i3, i4};

        int res = minMeetingRooms(intervals);
        System.out.println(res);
	}
}
