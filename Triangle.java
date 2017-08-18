package algorithm_java;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Triangle {
	public static int minimumTotal(List<List<Integer>> triangle) {
        int row = triangle.size();
        int col = triangle.get(row-1).size();
        int[] res = new int[col];
        for(int i=0;i<col;i++){
            res[i] = triangle.get(row-1).get(i);
        }
        for(int i=row-1;i>0;i--){
            for(int j=0;j<triangle.get(i-1).size();j++){
                res[j] = triangle.get(i-1).get(j)+Math.min(res[j], res[j+1]);
            }
        }
        return res[0];
    }
	
	public static void main(String[] args) {
		List<List<Integer>> triangle = new ArrayList<List<Integer>>();
		triangle.add(Arrays.asList(2));
		triangle.add(Arrays.asList(3,4));
		triangle.add(Arrays.asList(6,5,7));
		triangle.add(Arrays.asList(4,1,8,3));
		int res = minimumTotal(triangle);
		System.out.println(res);
	}
}
