package algorithm_java;


import java.util.HashSet;
import java.util.Set;

public class DistributeCandies {
	public static int distributeCandies(int[] candies) {
		Set<Integer> kinds = new HashSet<>();
        for (int candy : candies) kinds.add(candy);
        return kinds.size() >= candies.length / 2 ? candies.length / 2 : kinds.size();
    }
	
	public static void main(String[] args) {
		//int[] candies = {1,2};
		int[] candies ={1,1,1,1,1,2,2,2,3,3,3};
		int res = distributeCandies(candies);
		System.out.println(res);
	}
}
