package algorithm_java;

//valid perfect square
//binary search

public class ConstructtheRectangle {
	public static int[] constructRectangle(int area) {
		long l=0, r=area;
        long m=0;
        while(l<=r){
            m = l + (r-l)/2;
            if(m*m<= area && area <= (m+1)*(m+1))   
                break;
            else if(area< m*m)
                r= m-1;
            else
                l = m+1;
        }
        int[] res = new int[2];
        int diff = Integer.MAX_VALUE;
        if(m==0)//corner case: if input is 1, m is 0, in case divide by 0 error
            m+=1;
        for(int i=(int)m;i<=area;i++){
            if(area%i==0){
                int k = area/i;
                res[0]=k>=i?k:i;
                res[1]=k<i?k:i;
                break;
            }
        }
        return res;
    }
	
	public static void main(String[] args) {

//		Expected:
//		[3200,3125]
		int area = 10000000;
		int[] res = constructRectangle(area);
		for(int i: res)
			System.out.print(i+" ");
	}
}
