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
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Set;
import java.util.Stack;

class BTreeNode{
	int val;
	BTreeNode parent;
	BTreeNode left;
	BTreeNode right;
	boolean visited;
	public BTreeNode(int v){
		val = v;
		parent = null;
		left = null;
		right = null;
		visited = false;
		String letter = "ab";
	}
}

public class Test {	
	public static String intToRoman(int num) {
        String res ="";
        String[] symbol ={"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};
        int value[] =        {1000,  900,  500,  400,    100,   90,    50,    40,    10,     9,       5,     4,     1};
        
        for(int i=0;i<10;i++){
        	System.out.println(i);
        }
        
        for(int i=0;num!=0;i++){
        	while(num >= value[i]){
        		num -= value[i];
        		res += symbol[i];
        	}
        }
        return res;
    }

	public static void main(String[] args) {
		int input = 2372;
		String res = intToRoman(input);
		System.out.println(res);
	}
}