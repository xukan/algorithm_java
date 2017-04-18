package algorithm_java;

public class QuickSort {
	//不带注释版
	public static void quickSort(int[] array, int low, int high){
		if(low>=high)
			return;
		int pivot = QuickSort_Partition(array, low, high);
		quickSort(array, low, pivot-1);
		quickSort(array, pivot+1, high);
	}
	
	public static int QuickSort_Partition(int[] array, int low, int high){
		int pivot = array[low];
		int i=low+1;
		int j=high;
		while(i<=j){
			while(i<=j && pivot>=array[i])
				i++;
			while(i<=j && pivot<=array[j])
				j--;
			if(i<j){
				swap(array, i, j);
				i++;
				j--;
			}
		}
		array[low] = array[j];
		array[j] = pivot;
		return j;
	}
	
	private static void swap(int[] array, int i, int j) {
		int temp = array[i];
		array[i] = array[j];
		array[j] = temp;
	}
	public static void main(String a[]){
        int[] input = {24,2,45,20,56,75,2,56,99,53,12};
        quickSort(input, 0, input.length-1);
        for(int i:input){
            System.out.print(i);
            System.out.print(" ");
        }
    }

}
