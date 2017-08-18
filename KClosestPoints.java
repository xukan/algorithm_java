package algorithm_java;

import java.util.Comparator;
import java.util.PriorityQueue;

//Amazon
/*
 * Given some points and a point origin in two dimensional space, find k points out of the some points which are nearest to origin.
 * Return these points sorted by distance, if they are same with distance, sorted by x-axis, otherwise sorted by y-axis.
 * 
 * Given points = [[4,6],[4,7],[4,4],[2,5],[1,1]], origin = [0, 0], k = 3
 * return [[1,1],[2,5],[4,4]]
 * */


//Definition for a point.
class Point {
	int x;
	int y;

	Point(int a, int b) {
		x = a;
		y = b;
	}
}

public class KClosestPoints {
	Point globalOrigin = null;

	public Point[] kClosest(Point[] points, Point origin, int k) {
		// Write your code here
		globalOrigin = origin;
		PriorityQueue<Point> queue = new PriorityQueue<Point>(k, new Comparator<Point>() {
			public int compare(Point p1, Point p2) {
				int diff = getDis(p2, globalOrigin) - getDis(p1, globalOrigin);
				if (diff == 0) {
					diff = p2.x - p1.x;
				}
				if (diff == 0) {
					diff = p2.y - p1.y;
				}
				return diff;
			}
		});
		for (Point p : points) {
			queue.offer(p);
			while (queue.size() > k) {
				queue.poll();
			}
		}
		Point[] res = new Point[queue.size()];
		int i = queue.size() - 1;
		while (queue.size() > 0)
			res[i--] = queue.poll();
		return res;
	}

	public int getDis(Point a, Point b) {
		return (a.x - b.x) * (a.x - b.x) + (a.y - b.y) * (a.y - b.y);
	}
	
	public static void main(String[] args) {
		KClosestPoints  s = new KClosestPoints();
		//[[4,6],[4,7],[4,4],[2,5],[1,1]], [0,0], 3
		Point p1 = new Point(4,6);
		Point p2 = new Point(4,7);
		Point p3 = new Point(4,4);
		Point p4 = new Point(2,5);
		Point p5 = new Point(1,1);
		Point[] points= {p1,p2,p3,p4,p5};
		Point origin = new Point(0,0);
		int k=3;
		Point[] res = s.kClosest(points, origin, k);
		for(Point p: res)
			System.out.println(p.x + " " + p.y);
	}
}
