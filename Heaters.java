package algorithm_java;

import java.util.Arrays;

public class Heaters {
	public static int findRadius(int[] houses, int[] heaters) {
		Arrays.sort(houses);
		Arrays.sort(heaters);

		int i = 0, res = 0;
		for (int house : houses) {
			while (i + 1 < heaters.length && Math.abs(heaters[i] - house) >= Math.abs(heaters[i + 1] - house)) {
				i++;
			}
			res = Math.max(res, Math.abs(heaters[i] - house));
		}
		return res;
	}
	
	public static void main(String[] args) {
		int[] houses = {1,2,3,4,5};
		int[] heaters = {1,4};
		int res = findRadius(houses, heaters);
		System.out.println(res);
	}
}
