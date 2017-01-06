package algorithm_java;

//two pointers
//reference: http://blog.csdn.net/linhuanmars/article/details/20888505
//Google Twitter Zenefits Amazon Apple Bloomberg

public class TrappingRainWater {
	public static int trap(int[] height) {
        if(height == null || height.length == 0)
            return 0;
       int l=0;
       int r = height.length-1;
       int res=0;
       while(l<r){
    	   int min = Math.min(height[l], height[r]);
    	   if(height[l] == min){
    		   l++;
    		   while(l<r && height[l] < min){
    			   res += (min - height[l]);
    			   l++;
    		   }
    	   }else{
    		   r--;
    		   while(l<r && height[r]< min){
    			   res += (min-height[r]);
    			   r--;
    		   }
    	   }
       }
       return res;
	}	
	
	//similar question, Container With Most Water
//	public int maxArea(int[] height) {
//        int max=0, area=0;
//        int l=0;
//        int r=height.length-1;
//        while(l<r){
//            int min = Math.min(height[l], height[r]);
//            area = min*(r-l);
//            max= Math.max(max, area);
//            if( height[l] == min){
//                l++;
//                while(l<r && height[l]<min){
//                    l++;
//                }
//            }else{
//                r--;
//                while(l<r && height[r]<min){
//                    r--;
//                }
//            }
//        }
//        return max;
//    }
	
	public static void main(String[] args){
		int[] input = {0,1,0,2,1,0,1,3,2,1,2,1};
		//int[] input = {2,0,2};
		int maxVol = trap(input);
		System.out.println(maxVol);
	}
}
