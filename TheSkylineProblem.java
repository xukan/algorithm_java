package algorithm_java;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class TheSkylineProblem {
	public static List<int[]> getSkyline(int[][] buildings) {
        List<int[]> result = new ArrayList<>();
        List<int[]> height = new ArrayList<>();
        // 拆解矩形，构建顶点的列表
        for(int[] b:buildings) {
            // 左顶点存为负数
            height.add(new int[]{b[0], -b[2]});
            // 右顶点存为正数
            height.add(new int[]{b[1], b[2]});
        }
        // 根据横坐标对列表排序，相同横坐标的点纵坐标小的排在前面
        Collections.sort(height, new Comparator<int[]>(){
            public int compare(int[] a, int[] b){
                if(a[0] != b[0]){
                    return a[0] - b[0];
                } else {
                    return a[1] - b[1];
                }
            }
        });
        for(int[] pos : height){
			System.out.println(pos[0] + " " + pos[1]);
		}
        // 构建堆，按照纵坐标来判断大小
        PriorityQueue<Integer> pq = new PriorityQueue<Integer>(11, new Comparator<Integer>(){
            public int compare(Integer i1, Integer i2){
                return i2 - i1;
            }
        });
        // 将地平线值9先加入堆中
        pq.offer(0);
        // prev用于记录上次keypoint的高度
        int prev = 0;
        for(int[] h:height) {
            // 将左顶点加入堆中
            if(h[1] < 0) {
                pq.offer(-h[1]);
            } else {
            // 将右顶点对应的左顶点移去
                pq.remove(h[1]);
            }
            int cur = pq.peek();
            // 如果堆的新顶部和上个keypoint高度不一样，则加入一个新的keypoint
            if(prev != cur) {
                result.add(new int[]{h[0], cur});
                prev = cur;
            }
        }
        return result;
    }
	
	//solutionII, merge sort
	public List<int[]> getSkyline_ms(int[][] buildings) {
		if (buildings.length == 0)
			return new ArrayList<int[]>();
		return getSkyline(buildings, 0, buildings.length - 1);
	}

	private List<int[]> getSkyline(int[][] buildings, int left, int right) {
		if (left < right) {
			int mid = left + ( right - left) / 2;
			List<int[]> fromLeft = getSkyline(buildings, left, mid);
			List<int[]> fromRight = getSkyline(buildings, mid + 1, right);
			return merge(fromLeft, fromRight);
		} else {
			int[] building = buildings[left];
			List<int[]> res = new ArrayList<>();
			res.add(new int[] { building[0], building[2] });
			res.add(new int[] { building[1], 0 });
			return res;
		}
	}

	private List<int[]> merge(List<int[]> fromLeft, List<int[]> fromRight) {
		List<int[]> res = new ArrayList<>();
		int left = 0;
		int leftSize = fromLeft.size();
		int right = 0;
		int rightSize = fromRight.size();

		int lastRight =  0;
		int lastLeft = 0;
		int currPeek = -1;
		
		while (left < leftSize && right < rightSize) {
			int[] currLeft = fromLeft.get(left);
			int[] currRight = fromRight.get(right);

			if (currLeft[0] < currRight[0]) {
				int newPeek = Math.max(lastRight, currLeft[1]);
				if(newPeek != currPeek){
					res.add(new int[]{currLeft[0], newPeek});
					currPeek = newPeek;
				}
				lastLeft = currLeft[1];
				left++;
			}else if(currLeft[0] > currRight[0]){
				int newPeek = Math.max(lastLeft, currRight[1]);
				if(newPeek != currPeek){
					res.add(new int[]{currRight[0], newPeek});
					currPeek = newPeek;
				}
				lastRight = currRight[1];
				right++;
			}else{
				int newPeek = Math.max(currRight[1], currLeft[1]);
				if(newPeek != currPeek){
					res.add(new int[]{currLeft[0], newPeek});
					currPeek = newPeek;
				}
				lastRight = currRight[1];
				lastLeft = currLeft[1];
				left++;
				right++;
			}
		}
		while (left < leftSize)
			res.add(fromLeft.get(left++));
		while (right < rightSize)
			res.add(fromRight.get(right++));
		return res;
	}
	
	public static void main(String[] args) {
		int[][] buildings = {{2, 9, 10}, {3,7,15}, {5, 12, 12}, {15, 20, 10}, {19, 24,8}};
		List<int[]> res = getSkyline(buildings);
		for(int[] pos : res){
			System.out.println(pos[0] + " " + pos[1]);
		}
	}
}
