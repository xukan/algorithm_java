package algorithm_java;

import java.util.ArrayList;
import java.util.List;

//Google

//merge Sort
//reference: http://www.geeksforgeeks.org/counting-inversions/

//BST
//reference:  
public class CountofSmallerNumbersAfterSelf {
	class TreeNode {
		int val;
		int num;
		TreeNode left;
		TreeNode right;
		TreeNode(int x) {
		val = x;
		num = 0;
		}
	}
	
	public List<Integer> countSmaller(int[] nums) {
	    if(nums.length == 0)
	        return new ArrayList<Integer>();
	    List<Integer> list = new ArrayList<Integer>();
	    List<Integer> list1 = new ArrayList<Integer>();
	    TreeNode root = new TreeNode(nums[nums.length-1]);
	    root.num=1;
	    list.add(0);
	    for(int i = nums.length-2;i >= 0;i--){
	        int num = get(root,nums[i],0);
	    	list.add(num);
	    }
	    for(int i = nums.length-1;i >= 0;i--){
	    	int num1 = list.get(i); 
	        list1.add(num1);
	    }
	    return list1;
	}
	
	public int get(TreeNode root,int val,int num){
	    if(root.val >= val){
	        root.num = root.num+1;
	        if(root.left == null)
	        {
	            TreeNode node = new TreeNode(val);
	            node.num = 1;
	            root.left = node;
	            return num;
	        }else{
	            return get(root.left,val,num);
	        }
	    }else{
	        num += root.num;
	        if(root.right == null){
	            TreeNode node = new TreeNode(val);
	            node.num = 1;
	            root.right = node;
	            return num;
	        }else{
	            return get(root.right,val,num);
	        }
	    }
	}
	
	public static void main(String[] args) {
		int[] nums= {5, 2, 6, 1};
		CountofSmallerNumbersAfterSelf s = new CountofSmallerNumbersAfterSelf();
		List<Integer> res = s.countSmaller(nums);
		res.forEach(i->System.out.print(i+" "));
	}
}
