package algorithm_java;

//same as Trapping Rain Water
//Bloomberg

public class ContainerWithMostWater {
	//my solution: Time Limit Exceeded 
//	public int maxArea(int[] height) {
//		if( height.length ==1 )
//			return 0;
//		int max = 0;
//        for( int i=0;i<height.length; i++){
//        	for( int j=i+1;j<height.length;j++){
//        		int h = Math.min(height[i], height[j]);
//        		int w = j-i;
//        		int area = h*w;
//        		max = Math.max(max, area);
//        	}
//        }
//        return max;
//    }
	public static int maxArea(int[] height) {
		if(height == null || height.length == 0)
			return 0;
		int left = 0, right = height.length-1;
		int maxArea = 0, area = 0;
		while(left < right){
			int width = right - left;
			area = width*(Math.min(height[left], height[right]));
			maxArea = Math.max(maxArea, area);
			if(height[left]<height[right])
				left++;
			else
				right--;
		}
		return maxArea;
	}
	
	public static void main(String[] args) {
		int[] input = { 3, 5, 4, 7, 3, 2};
		ContainerWithMostWater solution = new ContainerWithMostWater();
		int result = solution.maxArea(input);
		System.out.println( result );
	}
}
