package algorithm_java;

//Pocket Gems Microsoft Facebook 

public class SortColors {
	//tc: O(n), sc: O(1)
	public int[] sortColors(int[] nums) {
        int left = 0, right = nums.length - 1;
        int i = 0;
        while(i <= right){
            // 遇到0交换到前面
            if(nums[i] == 0){
                swap(nums, i, left);
                left++;
                // 因为左边必定有序，所以可以直接i++  //i.e, {0,1}
                i++;
            // 遇到2交换到后面
            } else if(nums[i] == 2){
                swap(nums, i, right);
                right--;
            } else {
            // 遇到1跳过 
                i++;
            }
        }
        return nums;
    }
    
    private void swap(int[] nums, int i1, int i2){
        int tmp = nums[i1];
        nums[i1] = nums[i2];
        nums[i2] = tmp;
    }
	
	public static void main(String[] argv) {
		SortColors s = new SortColors();
        int[] A = s.sortColors(new int[]{0,2,1,1,2,2,0,0,1,2});
        for(int i:A)
        	System.out.print(i+" ");
    }
}
