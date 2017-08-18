package algorithm_java;

import java.util.Stack;
/*
 *           5
 *         /    \
 *       2      6
 *     /    \
 *    1     3
 * */

//Zenefits 

//https://segmentfault.com/a/1190000003874375

//similar question
//Verify Preorder Serialization of a Binary Tree

public class VerifyPreorderSequenceinBinarySearchTree {
	public static boolean verifyPreorder(int[] preorder) {
	    int low = Integer.MIN_VALUE;
	    Stack<Integer> path = new Stack();
	    for (int p : preorder) {
	        if (p < low)
	            return false;
	        while (!path.empty() && p > path.peek())
	            low = path.pop();
	        path.push(p);
	    }
	    return true;
	}
	
	//tc:O(n), sc: O(1)
	public static boolean verifyPreorder_better(int[] preorder) {
		// 用i标记栈顶
        int i = -1, min = Integer.MIN_VALUE;
        for(int num : preorder){
            if(num < min) return false;
            // 同样的解法，但是复用了数组作为栈，每pop一次相当于i--
            while(i >= 0 && num > preorder[i]){
                min = preorder[i--];
            }
            // push相当于i++
            preorder[++i] = num;
        }
        return true;
	}

	/*
	 * Q：如何验证后序序列？
	 * A：后序序列的顺序是left - right - root，而先序的顺序是root - left - righ.
	 * 我们同样可以用本题的方法解，不过是从数组的后面向前面遍历，因为root在后面了.
	 * 而且因为从后往前看是先遇到right再遇到left，所以我们要记录的是限定的最大值，而不再是最小值，
	 * 栈pop的条件也变成pop所有比当前数大得数。栈的增长方向也是从高向低了。
	 * */
	public boolean IsValidPostOrderBst(int[] nums){
        int i = nums.length;
        int max = Integer.MAX_VALUE;
        for (int j = nums.length - 1; j >= 0; j--)
        {
            if (nums[j] > max) return false;
            while (i <= nums.length - 1 && nums[j] > nums[i])
                max = nums[i++];
            nums[--i] = nums[j];
        }
        return true;
    }
	public static void main(String[] args) {
		int[] input = {5,2,1,3,6};
		boolean res = verifyPreorder_better(input);
		System.out.println(res);
	}
}
