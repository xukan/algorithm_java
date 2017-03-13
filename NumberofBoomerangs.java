package algorithm_java;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

//Google

public class NumberofBoomerangs {
	public static int numberOfBoomerangs(int[][] points) {
		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        int count=0;
        for(int i=0;i<points.length;i++){
            for(int j=0;j<points.length;j++){
                if(i==j)
                    continue;
                int dis = getDistance(points[i][0], points[i][1], points[j][0], points[j][1]);
                map.put(dis, map.getOrDefault(dis, 0)+1);
            }
            for(int val: map.values()){
                count += val*(val-1);
            }
            map.clear();
        }
        return count;
    }
	
	public static int getDistance(int x1, int y1, int x2, int y2){
        return (x1-x2)*(x1-x2) + (y1-y2)*(y1-y2);
    }
	
	public static void main(String[] args) {
		int[][] input = {{1,1},{2,2},{3,3}};
		int res = numberOfBoomerangs(input);
		System.out.println(res);
	}
}
