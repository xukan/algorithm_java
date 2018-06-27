package algorithm_java;

import java.util.Arrays;
import java.util.List;

public class FindPointmaxIntervalsOverlap {
	public int findMaxGuests(List<Interval> intervals){
		int n = intervals.size();
		int[] starts = new int[n];
		int[] ends = new int[n];
	   // Sort arrival and exit arrays
	   Arrays.sort(starts);
	   Arrays.sort(ends);
	   
	   // count indicates number of guests at a time
	   int count = 1, max = 1, time = starts[0];
	   int i = 1, j = 0;
	 
	   // Similar to merge in merge sort to process
	   // all events in sorted order
	   while (i < n && j < n)
	   {
	      // If next event in sorted order is arrival,
	      // increment count of guests
	      if (starts[i] <= ends[j])
	      {
	          count++;
	 
	          // Update max if needed
	          if (count > max)
	          {
	              max = count;
	              time = starts[i];
	          }
	          i++;  //increment index of arrival array
	      }
	      else // If event is exit, decrement count
	      {    // of guests.
	          count--;
	          j++;
	      }
	   }
	   return max;
	 
	}
}	
