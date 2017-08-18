package algorithm_java;

/* http://liangjiabin.com/blog/2015/04/leetcode-best-time-to-buy-and-sell-stock.html
 * 分析：特殊动态规划法。传统的动态规划我们会这样想，到第i天时进行j次交易的最大收益，要么等于到第i-1天时进行j次交易的最大收益（第i天价格低于第i-1天的价格），要么等于到第i-1天时进行j-1次交易，然后第i天进行一次交易（第i天价格高于第i-1天价格时）。于是得到动规方程如下（其中diff = prices[i] – prices[i – 1]）：
 * profit[i][j] = max(profit[i – 1][j], profit[i – 1][j – 1] + diff)
 * 看起来很有道理，但其实不对，为什么不对呢？因为diff是第i天和第i-1天的差额收益，如果第i-1天当天本身也有交易呢，
 * 那么这两次交易就可以合为一次交易，这样profit[i – 1][j – 1] + diff实际上只进行了j-1次交易，而不是最多可以的j次，
 * 这样得到的最大收益就小了。(要理解这个观点，
 * 需要首先弄明白Best Time to Buy and Sell Stock II的原理， -a+b+c-b= c-a,其中b是第i-1天的价格，如果i-1天有交易，i天也有交易，那么i-1天的价格就被抵消了)
 * 那么怎样计算第i天进行交易的情况的最大收益，才会避免少计算一次交易呢？
 * 我们用一个局部最优解和全局最有解表示到第i天进行j次的收益，这就是该动态规划的特殊之处。
 * 用local[i][j]表示到达第i天时，最多进行j次交易的局部最优解；用global[i][j]表示到达第i天时，最多进行j次的全局最优解。它们二者的关系如下（其中diff = prices[i] – prices[i – 1]）：
 * local[i][j] = max(global[i – 1][j – 1] + max(diff, 0), local[i – 1][j] + diff)
 * global[i][j] = max(global[i – 1][j], local[i][j])
 * 其中的local[i – 1][j] + diff就是为了避免第i天交易和第i-1天交易合并成一次交易而少一次交易收益。
 * 
 * 下面的解法是一维数组的，其实二维数组的解法更容易理解：
 * http://www.programcreek.com/2014/03/leetcode-best-time-to-buy-and-sell-stock-iv-java/
 * 
 * 还有下面是code ganker的分析：
 * http://blog.csdn.net/linhuanmars/article/details/23236995
 * 这里我们先解释最多可以进行k次交易的算法，然后最多进行两次我们只需要把k取成2即可。我们还是使用“局部最优和全局最优解法”。
 * 我们维护两种量，一个是当前到达第i天可以最多进行j次交易，最好的利润是多少（global[i][j]），
 * 另一个是当前到达第i天，最多可进行j次交易，并且最后一次交易在当天卖出的最好的利润是多少（local[i][j]）。
 * 下面我们来看递推式，全局的比较简单，
 * global[i][j]=max(local[i][j],global[i-1][j])，
 * 也就是去当前局部最好的，和过往全局最好的中大的那个（因为最后一次交易如果包含当前天一定在局部最好的里面，否则一定在过往全局最优的里面）。对于局部变量的维护，递推式是
 * local[i][j]=max(global[i-1][j-1]+max(diff,0),local[i-1][j]+diff)，
 * 也就是看两个量，第一个是全局到i-1天进行j-1次交易，然后加上今天的交易，如果今天是赚钱的话（也就是前面只要j-1次交易，最后一次交易取当前天），第二个量则是取local第i-1天j次交易，然后加上今天的差值（这里因为local[i-1][j]比如包含第i-1天卖出的交易，所以现在变成第i天卖出，并不会增加交易次数，而且这里无论diff是不是大于0都一定要加上，因为否则就不满足local[i][j]必须在最后一天卖出的条件了）。
 * */

public class BestTimetoBuyandSellStockIV {
	public static int maxProfit(int k, int[] prices) {
        if (prices.length < 2 || k <= 0)
		    return 0;
        /*
         * 如果k的值远大于prices的天数，比如k是好几百万，而prices的天数就为若干天的话，上面的DP解法就非常的没有效率，
         * 应该直接用Best Time to Buy and Sell Stock II 买股票的最佳时间之二的方法来求解，
         * 所以实际上这道题是之前的二和三的综合体，
         * */
       //if k >= n/2, then you can make maximum number of transactions.
        if(k>=prices.length/2)
        	return maxProfit2(prices);
        
        //二维数组解法：
//        int[][] local = new int[len][k + 1];
//    	int[][] global = new int[len][k + 1];
//     
//    	for (int i = 1; i < len; i++) {
//    		int diff = prices[i] - prices[i - 1];
//    		for (int j = 1; j <= k; j++) {
//    			local[i][j] = Math.max(
//    					global[i - 1][j - 1] + Math.max(diff, 0),
//    					local[i - 1][j] + diff);
//    			global[i][j] = Math.max(global[i - 1][j], local[i][j]);
//    		}
//    	}    
//    	return global[prices.length - 1][k];
        
        int[] local = new int[k+1];
        int[] global = new int[k+1];
        
        for(int i=1;i<prices.length;i++){
        	int diff = prices[i] - prices[i-1];
        	for(int j=k;j>0;j--){
        		local[j] = Math.max(global[j-1]+(diff>0?diff:0), local[j]+diff);
        		global[j] = Math.max(global[j], local[j]);
        	}
        }
       
        
        return global[k];
	}
	
	public static int maxProfit2(int[] prices){
		int maxProfit=0;
		for(int i=1;i<prices.length;i++){
			if(prices[i]>prices[i-1])
				maxProfit+= prices[i] - prices[i-1];
		}
		return maxProfit;
	}
	
	public static void main(String[] args){
		int[] prices = {9,20,5,3,100,50,70,90};
		int maxProfit = maxProfit(3,prices);
		System.out.println(maxProfit);
	}
}
