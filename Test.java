package algorithm_java;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;
	TreeNode(int x) {
		val = x;
	}
}
//class ListNode {
//	int val;
//    ListNode next;
//    ListNode(int x) { val = x; }
//}

public class Test {
	int[] array;
	int[] temparray;
	int len;
	public static void main(String a[]){
        
        int[] inputArr = {45,23,11,89,77,98,4,28,65,43,1,7,15};
        Test mms = new Test();
        mms.sort(inputArr);
        for(int i:inputArr){
            System.out.print(i);
            System.out.print(" ");
        }
    }
	
	public void sort(int[] input){
		this.array = input;
		this.len = input.length;
		temparray = new int[len];
		doMergeSort(0, len-1);
	}
	
	public void doMergeSort(int l, int h){
		if(l<h){
		int m = l+(h-l)/2;
		doMergeSort(l, m);
		doMergeSort(m+1, h);
		merge(l, m, h);
		}
	}
	public void merge(int l, int m, int h){
		for(int i=l;i<=h;i++){
			this.temparray[i] = array[i];
		}
		int i=l;
		int j=m+1;
		int k=l;
		while(i<=m && j<=h){
			if(temparray[i]<temparray[j]){
				array[k] = temparray[i];
				i++;
			}else{
				array[k] = temparray[j];
				j++;
			}
			k++;
		}
		while(i<=m){
			array[k++] = temparray[i++];
		}
	}
	
}