package algorithm_java;

import java.util.ArrayList;
import java.util.List;

//Facebook 

//https://discuss.leetcode.com/topic/102168/java-simple-solution-o-n-time

public class MaximumSwap {
	//tc: O(n)
	public static int maximumSwap(int num) {
		String s = String.valueOf(num);
        char[] array = s.toCharArray();
        int[] pos = new int[10];
        for(int i=0;i<array.length;i++){
            pos[array[i] - '0'] = i;
        }
        for(int i=0;i<array.length;i++){
            int n = array[i] - '0';
            for(int j=9;j>n;j--){
                if(pos[j]>i){
                    char tmp = array[i];
                    array[i] = array[pos[j]];
                    array[pos[j]] = tmp;
                    return Integer.parseInt(new String(array));
                }
            }
        }
        return num;
    }
	
	//solutionII
	/*思路很清晰,
	 * 1.先找到第一段降序的最后一个点k
	 * 2.找到k~len-1中最大的数字的位置pos
	 * 3.找到0~k中第一个比nums[pos]小的数交换即可
	 * tc: O(n)
	 * */
	public static int MaximumSwap(int num) {
		String s = String.valueOf(num);
        char[] array = s.toCharArray();
        int k= -1;
        for(int i=1;i<array.length;i++){
            if(array[i]>array[i-1]){
                k = i-1;
                break;
            }
        }
        if(k == -1)
            return num;
        int max= array[k];
        int pos = -1;
        for(int j=k;j<array.length;j++){
            if(array[j]>=max){
                pos = j;
                max = array[j];
            }
        }
        for(int i=0;i<pos;i++){
            if(array[pos]>array[i]){
                char tmp = array[i];
                array[i] = array[pos];
                array[pos] = tmp;
                break;
            }
        }
        return Integer.parseInt(new String(array));
    }
	
	public static void main(String[] args) {
		int n1 = 984386;
//		int n2 = 2736;
		int n3 = 99901;
		int n4 = 984365;
		int res = maximumSwap(n4);
//		int res = MaximumSwap(n1);
		System.out.println(res);
	}
}
