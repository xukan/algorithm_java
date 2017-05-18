package algorithm_java;

//Amazon

public class SuperWashingMachines {
	public static int findMinMoves(int[] machines) {
		int sum =0;
        for(int load: machines)
            sum += load;
        int len = machines.length;
        int[] transition = new int[len];
        if(sum%len!=0)
            return -1;
        int avg = sum/len;
        int max = 0, cnt=0;
        int k=0;
        for(int load: machines){
            cnt += load - avg;
            max = Math.max(max, Math.max(Math.abs(cnt), load-avg));
        }
        return max;
    }
	
	public static void main(String[] args) {
		int[] input =  {1,1,2,2,15,1,2,1,2};
		int result = findMinMoves(input);
		System.out.println(result);
	}
}
