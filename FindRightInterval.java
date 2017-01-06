package algorithm_java;

import java.util.Arrays;

//http://massivealgorithms.blogspot.com/2016/10/leetcode-436-find-right-interval.html

// Definition for an interval.
class Interval {
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

public class FindRightInterval {
	public int[] findRightInterval(Interval[] intervals) {
		int len = intervals.length;
		int[] res = new int[len];
		Interval[] sortedInters = new Interval[len];
		for(int i=0;i<len;i++){
			Interval inter = intervals[i];
			sortedInters[i] = new Interval( inter.start, i);
		}
		//ascending array
		Arrays.sort(sortedInters, (Interval a, Interval b)->(a.start - b.start));
		for(Interval i: sortedInters)
			System.out.print(i.start + " ");
		System.out.println();
		binarySearch(intervals, sortedInters, res);
		
		return res;
	}
	
	public void binarySearch(Interval[] intervals, Interval[] sinters, int[] res){
		int len = intervals.length;
		boolean[] visited = new boolean[len];
		for(int i=0;i<len;i++){
//			int key = ;
			int l=0;
			int r= len-1;
			int right = -1;
			while(l<=r){
				int m= l+(r-l)/2;
				if(intervals[i].end == sinters[m].start){
					right = sinters[m].end;
					break;
				}
				else if(intervals[i].end > sinters[m].start)
					l=m+1;
				else
					r=m-1;
			}
			if ((right == -1) && (l < len) && (sinters[l].start > intervals[i].end)) {
                right = sinters[l].end; // original index is stored in end
            }
            res[i] = right;
		}
	}
	
	public static void main(String[] args) {
		Interval a = new Interval(3,4);
		Interval b = new Interval(2,3);
		Interval c = new Interval(1,2);
//		Interval d = new Interval();
//		Interval e = new Interval();
		Interval[] intervals ={a,b,c};
		FindRightInterval s = new FindRightInterval();
		int[] res = s.findRightInterval(intervals);
		for(int i: res)
			System.out.print(i+" ");
	}
}
