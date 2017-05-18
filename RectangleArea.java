package algorithm_java;

public class RectangleArea {
	public static int computeArea(int A, int B, int C, int D, int E, int F, int G, int H) {
		int common;
        if(H<B || D <F || C<E || G<A)
            common= 0;
        else{
            int width = Math.abs( Math.min(G, C) - Math.max(A,E));
            int height = Math.abs( Math.min(D,H) - Math.max(B,F));
            common = width*height;
        }
        int area1 = (D-B)*(C-A);
        int area2 = (H-F)*(G-E);
        return area1+area2-common;
    }
	
	public static void main(String[] args) {
		int A= 0;
		int B=0;
		int C =0;
		int D=0;
		int E=-1;
		int F =-1;
		int G=1;
		int H=1;
		int area = computeArea(A,B,C,D,E,F,G, H);
		System.out.println(area);
	}
	
}
