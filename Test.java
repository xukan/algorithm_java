package algorithm_java;



/*
 *              5
 *           /      \
 *          4       8
 *         /       /    \
 *       11     13    4
 *      /    \             \
 *     7     2            1 
 * */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Stack;

public class Test {
	void preorderMorrisTraversal(TreeNode root) {
		if(root.left ==null){
			System.out.println(root.val);
			root = root.right;
		}else{
			TreeNode temp = root.left;
			while(temp.right!=null && temp.right != root){
				temp = temp.right;
			}
			if(temp.right ==null){
				System.out.println(root.val);
				temp.right = root;
				root = root.left;
			}else{
				temp.right = null;
				root = root.right;
			}
		}
    }
    
	public List<List<Integer>> fourSum(int[] nums, int target) {
		List<List<Integer>> res = new ArrayList<List<Integer>>();
		Arrays.sort(nums);
		int len=nums.length-1;
		if(nums[0]*4>target || nums[len]*4<target)
			return res;
		for(int i=0;i+3<len;i++){
			if(i>0 && nums[i] == nums[i-1])
				continue;
			if(nums[i]+3*nums[len]<target)
				continue;
			if(4*nums[i] == target && nums[i+3]==nums[i])
				res.add(Arrays.asList(nums[i], nums[i],nums[i],nums[i] ));
			threeSum(nums, target-nums[i], i+1, len, nums[i], res);
		}
		return res;
    }
	
	public void threeSum(int[] nums, int target, int l, int r, int z1, List<List<Integer>> res){
		if(nums[l]*3>target || nums[r]*3<target)
			return;
		int i, z;
		for(i=l;i+2<=r;i++){
			z=nums[i];
			if(i>0 && nums[i] == nums[i-1])
				continue;
			if(z+2*nums[r]<target)
				continue;
			if(3*nums[i] == target && nums[i+2] == nums[i])
				res.add(Arrays.asList(nums[i], nums[i],nums[i] ));
			twoSum(nums, target-z, i+1, r, z1, z, res);
		}
	}
	
	public void twoSum(int[] nums, int target, int l, int r, int z1,int z2, List<List<Integer>> res){
		if(nums[l]*2>target || nums[r]*2<target)
			return;
		int x;
		int sum=0;
		while(l<r){
			sum = nums[l]+nums[r];
			if(sum==target)
				res.add(Arrays.asList(z1,z2, nums[l], nums[r]));
			else{
				x = nums[l];
				while (++l< r && x == nums[l]) // avoid duplicate
					;
				x = nums[r];
				while (l < --r && x == nums[r]) // avoid duplicate
					;
			}
			if (sum < target)
				l++;
			if (sum > target)
				r--;
		}
	}
	
    public static void main(String[] args){
		TreeNode node1 = new TreeNode(1);
		TreeNode node2 = new TreeNode(2);
		TreeNode node3 = new TreeNode(4);
		TreeNode node4 = new TreeNode(3);
//		TreeNode node5 = new TreeNode(5);
//		TreeNode node6 = new TreeNode(6);
//		TreeNode node7 = new TreeNode(7);
		node1.left =node2;
		node1.right = node3;
		node2.left = node4;
//		node2.right = node5;
//		node3.left = node6;
//		node3.right = node7;
		Test s = new Test();
		int[] nums = {1,2,3};
		List<List<Integer>>res = s.permute(nums);
		
	}
}