package algorithm_java;

//http://www.geeksforgeeks.org/check-whether-a-given-point-lies-inside-a-triangle-or-not/
//https://zhidao.baidu.com/question/20387521.html

class PointInaTriangle {
	class Point{
		int x;
		int y;
		public Point(int a, int b){
			this.x = a;
			this.y = b;
		}
	}
	
	public double area(int x1, int y1, int x2, int y2, int x3, int y3){
		return Math.abs(x1*(y2 - y3) + x2*(y3-y1) + x3*(y1-y2))/2.0;
	}
	
	public boolean isInside(int x1, int y1, int x2, int y2, int x3, int y3, int x, int y){
		Point A = new Point(x1,y1);	
		Point B = new Point(x2,y2);
		Point C = new Point(x3,y3);
		Point P = new Point(x,y);
		double area1 = area(A.x, A.y, B.x, B.y, P.x, P.y);
		double area2 = area(B.x, B.y, C.x, C.y, P.x, P.y);
		double area3 = area(A.x, A.y, C.x, C.y, P.x, P.y);
		double area4 = area(A.x, A.y, B.x, B.y, C.x, C.y);
		return area4 == area1 + area2 + area3;
	}
	
	public static void main(String[] args) {
		PointInaTriangle s = new PointInaTriangle();
		
		/* Let us check whether the point P(10, 15) lies inside the triangle 
	      formed by A(0, 0), B(20, 0) and C(10, 30) */
	
	   if (s.isInside(0, 0, 20, 0, 10, 30, 10, 15))
	      System.out.println("Inside");
	   else
	     System.out.println("Not Inside");
	}
}
