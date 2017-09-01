package algorithm_java;

import java.util.Random;

//http://www.geeksforgeeks.org/reservoir-sampling/

public class ReservoirSampling {
	public static int[] selectKItems(int[] stream, int k){
		int n = stream.length;
		int i = 0;
		int[] reservoir = new int[k];
		for(;i<k;i++)
			reservoir[i] = stream[i];
				
		Random rand = new Random();
		for(;i<n;i++){
			int j = rand.nextInt(i+1);
			if(j<k)
				reservoir[j] = stream[i];
		}
		return reservoir;
	}
	
	public static void main(String[] args) {
		 int stream[] = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12};
		 int k = 5;
		 int[] res = selectKItems(stream, k);
		 for(int i: res)
			 System.out.print(i + " ");
	}
}
