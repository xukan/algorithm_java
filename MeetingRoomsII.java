package algorithm_java;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//Google Snapchat Facebook

public class MeetingRoomsII {
	public static  int minMeetingRooms(Interval[] intervals) {
		if(intervals==null || intervals.length==0)
            return 0;
        Arrays.sort(intervals, (Interval a, Interval b)->(a.start - b.start));
        List<List<Integer>> list = new ArrayList<List<Integer>>();
        int len = intervals.length;
        List<Integer> l1 =new ArrayList<Integer>();
        l1.add(intervals[0].end);
        list.add(l1);
        int i=1;
        while(i<len){
            int s = intervals[i].start;
            int size = list.size();
            int k=0;
            for(;k<size;k++){
            	int len1 = list.get(k).size();
                if(s >= list.get(k).get(len1-1)){
                    list.get(k).add(intervals[i].end);
                    break;
                }
            }
            if(k == size){
            	 List<Integer> temp =new ArrayList<Integer>();
                 temp.add(intervals[i].end);
                 list.add(temp);
            }
            i++;
        }
        return list.size();
    }
	
	public static void main(String[] args) {
		Interval i1= new Interval(0,30); 
        Interval i2= new Interval(5, 10);
        Interval i3= new Interval(15,20);
       
        Interval[] intervals = {i1, i2, i3};

        int res = minMeetingRooms(intervals);
        System.out.println(res);
	}
}
