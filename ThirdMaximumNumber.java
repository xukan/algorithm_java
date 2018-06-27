package algorithm_java;

//Amazon

public class ThirdMaximumNumber {
	
	//use three variables, O(n)
	public int thirdMax(int[] nums) {
        long a=Long.MIN_VALUE, b=Long.MIN_VALUE, c=Long.MIN_VALUE;
        for(int n: nums){
            if(n>a){
                c=b;
                b=a;
                a=n;
            }else if( a > n && n> b){
                c=b;
                b=n;
            }else if( b >n && n > c){
                c=n;
            }
        }
        return (int )( ( c != Long.MIN_VALUE && c!= b)? c: a); 
    }
	
	
	//heap sort
	public int thirdMaxII(int[] nums) {
        buildMinHeap(nums, nums.length);
        for(int i=nums.length-1;i>=0;i--){
            swap(nums, 0, i);
            minHeapify(nums, 0, i);
        }
        
        for(int i: nums)
        	System.out.print(i+ " ");
        int max = nums[0];
        int count=1;
        for(int i=1;i<nums.length;i++){
            if(i>0 && nums[i] == nums[i-1]){
                continue;
            }
            if(i>0 && nums[i]<nums[i-1])
                count++;
            if(count == 3)
                return nums[i];
        }
        if(count <3)
            return max;
        return 0;
    }
    
    public void buildMinHeap(int[] nums, int size){
        for(int i=(size-1)/2;i>=0;i--){
            minHeapify(nums, i, size);
        }
    }
    
    public void minHeapify(int[] nums, int i, int size){
        int l = 2*i+1;
        int r = 2*i+2;
        int smallest = i;
        if(l<size && nums[l]<nums[smallest])
            smallest = l;
        if(r<size && nums[r] < nums[smallest])
            smallest =r;
        if( smallest != i){
            swap(nums, smallest , i);
            minHeapify(nums, smallest, size);
        }
    }
    
    public void swap(int[] array, int x, int y){
		int temp = array[x];
		array[x] = array[y];
		array[y] = temp;
	}
    
    public static void main(String[] args) {
//    	int[] nums = {1,2,-2147483648};//we need to use long 
		int[] nums= {3,2,1};
		ThirdMaximumNumber s = new ThirdMaximumNumber();
		int res =s.thirdMax(nums);
		System.out.println(res);
	}
}
