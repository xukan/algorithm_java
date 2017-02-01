package algorithm_java;

public class mergeSort {
	private int[] array;
    private int[] tempMergArr;
    private int length;
    
    public static void main(String a[]){
         
       // int[] inputArr = {45,23,11,89,77,98,4,28,65,43,1,7,15};
        //                                  / \
        //                                 /   \
        //               45 23 11 89 77 98 4                   28 65 43 1 7 15
        //                         / \                               /  \
        //                        /   \                             /    \
        //               45 23 11 89   77 98 4               28 65 43     1 7 15
        //                   / \           / \
        //                  /   \         /   \
        //               45 23  11 89   77 98  4
        //             45  23  11  89  77  98   4
        //              \  /         \  /       \  /    /
        //            23 45   11 89     77 98   4
        //               \         /             \       /
        //                \       /                \     /
        //         11 23 45 89             4 77 98
        //                  \                     /
        //              4 11 23 45 77 89 98
         
        //int[] inputArr = {45,23,11,89,77,98,4,28,65,43,1,7,15};
    	int[] inputArr = {45,23,11,89,77,98,4,28,65};
        mergeSort mms = new mergeSort();
        mms.sort(inputArr);
        for(int i:inputArr){
            System.out.print(i);
            System.out.print(" ");
        }
    }		
    								
    public void sort(int inputArr[]) {
        this.array = inputArr;
        this.length = inputArr.length;
        this.tempMergArr = new int[length];
        doMergeSort(0, length - 1);
    }
    
    public void doMergeSort(int lowerIndex, int higherIndex) {
        if (lowerIndex < higherIndex) {
            int middle = lowerIndex + (higherIndex - lowerIndex) / 2;
            // Below step sorts the left side of the array
            doMergeSort(lowerIndex, middle);
            // Below step sorts the right side of the array
            doMergeSort(middle + 1, higherIndex);
            // Now merge both sides
            mergeParts(lowerIndex, middle, higherIndex);
        }
    }
   
    public void mergeParts(int lowerIndex, int middle, int higherIndex) {	
        for (int i = lowerIndex; i <= higherIndex; i++) {
            tempMergArr[i] = array[i];
        }
        int i = lowerIndex;//i是第一段的起点, 第一段下标l->m
        int j = middle + 1;//j是第二段的起点, 第二段下标m+1->h
        int k = lowerIndex;//k是合并后数组的下标
        while (i <= middle && j <= higherIndex) {
            if (tempMergArr[i] <= tempMergArr[j]) {
                array[k] = tempMergArr[i];
                i++;
            } else {
                array[k] = tempMergArr[j];
                j++;
            }
            k++;
        }
        while (i <= middle) {
            array[k] = tempMergArr[i];
            k++;
            i++;
        }	
    }	
}
