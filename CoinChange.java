package algorithm_java;

import java.util.Arrays;
import java.util.Collections;

//reference: http://www.cnblogs.com/grandyang/p/5138186.html
//dynamic programming solution is similar to climb stairs

public class CoinChange {
	public int coinChange(int[] coins, int amount) {	
		if(amount==0) return 0;
		 
	    int[] dp = new int [amount+1];
	    dp[0]=0; // do not need any coin to get 0 amount
	    //dp[i] represents the minimum number of coins required to get the amount i
	    for(int i=1;i<=amount; i++)
	        //dp[i]= Integer.MAX_VALUE;
	    	dp[i] = amount + 1;
	 
	    for(int i=0; i<=amount; i++){
	        for(int coin: coins){
	        	if (coin <= i) {
	        		dp[i] = Math.min(dp[i], dp[i - coin] + 1);
            	}
	        }
	    }
	    return dp[amount] > amount ? -1 : dp[amount];
    }
	
	//coin change2
	//reference: 
	//http://bookshadow.com/weblog/2017/02/12/leetcode-coin-change-2/
	//http://www.geeksforgeeks.org/dynamic-programming-set-7-coin-change/
	//Time complexity: O(mn) (m = amount)
	//Space                : O(n)
	public int change(int amount, int[] coins) {
		//Time complexity of this function: O(mn)
        //Space Complexity of this function: O(n)
 
        // table[i] will be storing the number of solutions
        // for value i. We need n+1 rows as the table is
        // constructed in bottom up manner using the base
        // case (n = 0)
        int[] table = new int[amount+1];
    
        // Base case (If given value is 0)
        table[0] = 1;
    
        // Pick all coins one by one and update the table[]
        // values after the index greater than or equal to
        // the value of the picked coin
        for (int coin : coins)
        	for (int j=coin; j<amount+1; j++)
            		table[j] += table[j-coin];
     
        //to get permutation
        int[] permutation = new int[amount + 1];
        permutation[0] =1 ;
        for (int i=0; i<amount+1; i++)
        	for (int coin : coins)
        		if(coin <=i)
        			permutation[i] += permutation[i-coin];
        
        for(int i: table)
        	System.out.print(i+" ");
        System.out.println();
        for(int i: permutation)
        	System.out.print(i+ " ");
        System.out.println();
        System.out.println( "permutations: "+permutation[amount]);
        return table[amount];
	}
	
	public static void main(String[] args) {
		//int[] coins = {186,419,83,408};//6249
		int[] coins= { 5, 3, 1};
		CoinChange s = new CoinChange();
//		int res = s.coinChange(coins, 11);
//		System.out.println(res );
		
		//int arr[] = {1, 2, 3};
		int arr[] = {1,2,5};
		int amount = 5;
		int count = s.change(amount, arr);
		System.out.println(count);
	}
}
