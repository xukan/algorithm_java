package algorithm_java;

public class HeapSort {
	public static void buildMaxHeap(int[] A, int size){
		for(int i=(size-1)/2;i>=0;i--)
			maxHeapify(A, i, size);
	}
	
	public static void maxHeapify(int[] A, int i, int size){
		int l = 2*i+1;
		int r = 2*i+2;
		int largest =i;
		if(l<size && A[l]>A[i])
			largest = l;
		if(r<size && A[r]>A[largest])
			largest = r;
		if(largest != i){
			swap(A, i, largest);
			maxHeapify(A, largest, size);
		}
	}
	
	public static void heapSort(int[] A) {
        buildMaxHeap(A, A.length);
        /*       after buildMaxHeap:
         *                               16
         *                        14          10
         *                    8       7    9       3
         *                 2   4   1   
         * */
		for(int i=A.length-1;i>=0;i--){
			swap(A,0, i);
			maxHeapify(A, 0, i);//attention: here, each time size(i) is 1 smaller than last time 
		}
    }
	
	public static void swap(int[] A, int a, int b){
        int temp = A[a];
        A[a] = A[b];
        A[b] = temp;
    }
	
	public static void main(String[] args) {
		/*                            4
		 *                      1          3 
		 *                  2     16  9   10
		 *              14  8  7    
 		 * */
		
		int[] input = {4,1,3,2,16,9,10,14,8,7};
		heapSort(input);
		//In this method, we build a maxHeap, then we use heapSort to sort the elements. 
	    //The result is sorted in ascending order.
		for(int i: input)
			System.out.print(i+" ");
		//output: 1 2 3 4 7 8 9 10 14  16 
	}
}
