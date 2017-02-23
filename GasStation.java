package algorithm_java;
/*
 * To solve this problem, we need to understand and use the following 2 facts:
 * 1) if the sum of gas >= the sum of cost, then the circle can be completed.
 * 2) if A can not reach C in a the sequence of A-->B-->C, then B can not make it either.
 * Proof of fact 2:
 * If gas[A] < cost[A], then A can not even reach B. 
 * So to reach C from A, gas[A] must >= cost[A]. 
 * Given that A can not reach C, we have gas[A] + gas[B] < cost[A] + cost[B],
 * and gas[A] >= cost[A],
 * Therefore, gas[B] < cost[B], i.e., B can not reach C. 
 * 
 * reference:
 * http://www.programcreek.com/2014/03/leetcode-gas-station-java/
 * */
public class GasStation {
	public int canCompleteCircuit(int[] gas, int[] cost) {
        int sumRemaining=0; //track current remaining;
        int total = 0; //track total remaining;
        int start = 0; 
        for(int i=0;i<gas.length;i++){
        	int remaining = gas[i] - cost[i];
        	if(sumRemaining >= 0){
        		sumRemaining += remaining;
        	}else{
        		sumRemaining = remaining;
        		start = i;
        	}
        	total += remaining;
        }
        if(total >=0)
        	return start;
        else
        	return -1;
    }
	
	public static void main(String[] args) {
		
	}
}
