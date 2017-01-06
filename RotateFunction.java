package algorithm_java;

public class RotateFunction {
	//O(n^2),my solution exceeds time limit
//	public int maxRotateFunction(int[] A) {
//        int max = 0;
//        for( int i=0;i< A.length; i++){
//            int f = rotate( A, i);
//            max = Math.max( max, f );
//        }
//        return max;
//    }
//    
//    public int rotate(int[] A, int pos){
//        for( int i=0; i< pos; i++){
//            int temp = A[i];
//            A[i] = A[A.length-1-i];
//            A[A.length-1-i] = temp;
//        }
//        int sum = 0;
//        for( int i=0;i<A.length; i++){
//            sum += i*A[i];
//        }
//        return sum;
//    }
	//We have F(k) - F(k-1) = sum -nA[n-k]
	//sum = A[0] + A[1] + ... + A[n-1]
	public int maxRotateFunction(int[] A) {
		int f=0;
		int sum=0, n = A.length;
		for(int i=0; i<n;i++){
			sum += A[i];
		}
		for( int i=0;i<n;i++){
			f += i*A[i];
		}
		A[0]= f;
		int max=f, next=0;
		for( int i=1; i<n; i++){
			next = f+sum - n*A[n-i];
			System.out.println( next );
			max = Math.max(max, next);
			f = next;
		}
		return max;
	}
    
    public static void main(String[] args) {
		int[] A = {4, 3, 2, 6};
		RotateFunction solution = new RotateFunction();
		int result = solution.maxRotateFunction(A);
		System.out.println( result );
	}
}
