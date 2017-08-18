package algorithm_java;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;

//Pure Storage

//http://www.geeksforgeeks.org/check-given-four-points-form-square/

public class ValidSquare {
	public static boolean validSquare_solutionI(int[] p1, int[] p2, int[] p3, int[] p4) {
        int d12 = getDis(p1, p2);
        int d13 = getDis(p1, p3);
        int d14 = getDis(p1, p4);
        if(d12==0 || d13 ==0 || d14 ==0)//corner case, all input are 0s
            return false;
        if(d12==d13 && d14 == 2*d12){
            int d24 = getDis(p2, p4);
            int d34 = getDis(p3, p4);
            return d24==d34 && d12 == d24;
        }
        if(d13==d14 && d12 == 2*d14){
            int d24 = getDis(p2, p4);
            int d23 = getDis(p2, p3);
            return d24==d23 && d14 == d24;
        }
        if(d12==d14 && d13 == 2*d14){
            int d23 = getDis(p2, p3);
            int d34 = getDis(p3, p4);
            return d23==d34 && d12 == d23;
        }
        return false;
    }
    
    public static int getDis(int [] p1, int[] p2){
        return (p1[0]-p2[0])*(p1[0]-p2[0]) + (p1[1]-p2[1])*(p1[1]-p2[1]);
    }
    
    //solution 2
    public boolean validSquare(int[] p1, int[] p2, int[] p3, int[] p4) {
        HashSet<Integer> set = new HashSet<Integer>(Arrays.asList(distance(p1,p2), distance(p1,p3),distance(p1,p4),distance(p2,p3),distance(p2,p4),distance(p3,p4)));
        if(set.size()!=2)
            return false;
        Iterator<Integer> iterator = set.iterator();
        int a=0, b=0;
        a= iterator.next();
        b = iterator.next();
        return !set.contains(0) && (a == 2*b || b == 2*a);
    }
    
    public int distance(int[] p1, int[] p2){
        return (int)(Math.pow((p1[0] - p2[0]),2) + Math.pow((p1[1] - p2[1]), 2));
    }
    
    public static void main(String[] args) {
    	ValidSquare s = new ValidSquare();
    	int[] p1 = {0,0}, p2 = {1,1}, p3 = {1,0}, p4 = {0,1};
    	boolean res = s.validSquare(p1,p2, p3,p4);
    	System.out.println(res);
	}
}
