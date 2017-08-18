package algorithm_java;

//正反向遍历
//这道题用到的思路和Trapping Rain Water是一样的
/*
* 举例：
* 1 2 3 3 3 =》 8  因为candy数可以是
* 1 2 3 1 1
* 1 2 3 2 3 =》 9  因为candy数可以是
* 1 2 3 1 2
* 
* 3, 2, 3, 2, 3, 1 => 9 因为candy数可以是
* 2, 1, 2, 1, 2, 1
* 这个例子就解释了为什么需要从右向左扫描
* */

/*
* d[i] 是给第i个小孩最少几块糖
rank[i] > rank[i - 1]，必须比前一个多给一块，d[i] = d[i - 1] + 1
rank[i] == rank[i - 1]，两个排名一样，第二个就给一块就行了, d[i] = 1
rank[i] < rank[i - 1]，比上一个排名低，应该少给一块，但是若上一个已经只给一块了，就得往前推一个一个多给。
推到什么时候为止呢？若排名比下一个高，糖还一样多，就得再给；直到这个关系打破（排名一样或比下一个还低，或是糖已经满足关系）就不用再往前推了。
* */

public class Candy {
	public static int candy(int[] ratings) {  
	    if(ratings==null || ratings.length==0){  
	        return 0;  
	    }  
	    int[] nums = new int[ratings.length];  
	    nums[0]=1;  
	      
	    for(int i=1;i<ratings.length;i++){  
	        if(ratings[i]>ratings[i-1]){  
	            nums[i] = nums[i-1]+1;  
	        }else{  
	            nums[i] = 1;  
	        }  
	    }  
	    int res = nums[ratings.length-1];  
	    for(int i=ratings.length-2;i>=0;i--){  
	        int cur = 1;  
	        if(ratings[i]>ratings[i+1]){  
	            cur = nums[i+1]+1;  
	        } 
	        nums[i] = Math.max(nums[i], cur); //i.e. [1,2,2], expected res: 4
            res += nums[i];
	    }  
	    return res;  
	}  

	public static void main(String[] args){
		int[] input = {3, 2, 3, 2, 3, 1};
		int maxVol = candy(input);
		System.out.println(maxVol);
	}
}
