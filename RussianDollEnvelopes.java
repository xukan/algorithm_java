package algorithm_java;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

public class RussianDollEnvelopes {
	public static int maxEnvelopes(int[][] envelopes) {
	    if(envelopes==null||envelopes.length==0)
	        return 0;
	 
	    Arrays.sort(envelopes, new Comparator<int[]>(){
	        public int compare(int[] a, int[] b){
	            if(a[0]!=b[0]){
	                return a[0]-b[0]; //ascending order
	            }else{
	                return b[1]-a[1]; // descending order
	            }
	        }
	    });
	 
	    ArrayList<Integer> list = new ArrayList<Integer>();
	 
	    for(int i=0; i<envelopes.length; i++){
	 
	        if(list.size()==0 || list.get(list.size()-1)<envelopes[i][1]){
	            list.add(envelopes[i][1]);
	            continue;
	        }
	 
	        int l=0;
	        int r=list.size()-1;
	 
	        while(l<r){
	            int m=l+(r-l)/2;
	            if(list.get(m)<envelopes[i][1]){
	                l=m+1;
	            }else{
	                r=m;
	            }
	        }
	        list.set(r, envelopes[i][1]);
	    }
	    return list.size();
	}
	
	public static void main(String[] args) {
		//int[][] es = {{2,100},{3,200},{4,300},{5,500},{5,400},{5,250},{6,370},{6,360},{7,380}};
		int[][] es = {{4,5},{4,6},{6,7},{2,3},{1,1}};
		int res = maxEnvelopes(es);
		System.out.println(res);
	}
	//[[2,100],[3,200],[4,300],[5,500],[5,400],[5,250],[6,370],[6,360],[7,380]]
}
