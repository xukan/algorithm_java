package algorithm_java;

import java.util.Random;
//http://blog.csdn.net/qq508618087/article/details/52188179

/*
 * 思路: 一般的来说, 可以先计算出长度, 然后随机一个在长度范围内的值, 走到那里将值返回即可. 
 * 但是如果长度无限大, 就无法计算长度了, 这种情况下成为一个水池抽样的算法, 
 * 其原理为一个个的对元素取样, 在遍历到每个元素的时候可以有个概率选取, 或者不选取. 
 * 因为是随机选取一个数, 所以相当于水池的容量是1. 相对简单一些.
 * 那么如何确保对于每个元素都有相等的概率呢? 这里用到了概率论的知识, 在遍历到第i个数时设置选取这个数的概率为1/i, 
 * 然后来证明一下每个数被选到的概率: 对于第一个数其被选择的概率为1/1*(1-1/2)*(1-1/3)*(1-1/4)*...*(1-1/n) = 1/n, 
 * 其中(1-1/n)的意思是不选择n的概率, 也就是选择1的概率乘以不选择其他数的概率. 
 * 对于任意一个数i来说, 其被选择的概率为1/i*(1-1/(i+1))*...*(1-1/n), 
 * 所以在每一个数的时候我们只要按照随机一个是否是i的倍数即可决定是否取当前数即可.
 * */

public class LinkedListRandomNode {
	Random r = null;
    ListNode node = null;
    /** @param head The linked list's head.
        Note that the head is guaranteed to be not null, so it contains at least one node. */
    public LinkedListRandomNode(ListNode head) {
        r = new Random();
        node = head;
    }
    
    /** Returns a random node's value. */
    public int getRandom() {
        int count = 1;
        int res = 0;
        ListNode p = node;
        while(p!=null){
            if(r.nextInt(count)==0)
                res = p.val;
            count++;
            p = p.next;
        }
        return res;
    }
    
    public static void main(String[] args) {
		
	}
}
