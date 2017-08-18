package algorithm_java;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BrickWall {
	public static int leastBricks(List<List<Integer>> wall) {
        HashMap<Integer, Integer> map = new HashMap();
        for(List<Integer> list : wall){
            int sum = 0;
            for(int i=0;i<list.size()-1;i++){
                sum += list.get(i);
                map.put(sum, map.getOrDefault(sum, 0)+1);
            }
        }
        int max = 0;
        for(Map.Entry<Integer, Integer> entry: map.entrySet()){
            max = Math.max(max, entry.getValue());
        }
        return wall.size()-max;
    }
	
	public static void main(String[] args) {
		List<List<Integer>> wall = new ArrayList<List<Integer>>();
		int[][] bw = {{1,2,2,1},   //this is called jagged array
				              {3,1,2},
				              {1,3,2},
				              {2,4},
				              {3,1,2},
				              {1,3,1,1}};
		for(int i=0;i<bw.length;i++){
			List<Integer> list = new ArrayList<Integer>();
			for(int j=0;j<bw[i].length;j++){
				list.add(bw[i][j]);
			}
			wall.add(list);
		}
		int res = leastBricks(wall);
		System.out.println(res);
	}
}
