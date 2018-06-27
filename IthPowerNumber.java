package algorithm_java;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

//WePay

public class IthPowerNumber {
	class Num implements Comparable<Num>{
		int base;
		int power;
		long val;
		public Num(int b, int p){
			base = b;
			power = p;
			val = (long)Math.pow(base, power);
		}
		@Override
		public int compareTo(Num n2){
                if(this.val == n2.val )
                	return this.base - n2.base;
                return this.val < n2.val?-1:1;
	    }
	}
	
	public long getPowerNumber(int n){
		if(n<0)
			return -1;
		if(n==0)
			return 4;
		if(n==1)
			return 8;
		PriorityQueue<Num> queue = new PriorityQueue<Num>();
		
		List<Long> res = new ArrayList<Long>();
		queue.offer(new Num(2, 2));
		int upper = 10;
		int  count = 0, i=3;
		Num prev = null;
		while(count<n-1){
			long candidate = (long)Math.pow(i, 2);
			Num	num = queue.poll();
			if(prev!=null && prev.val !=num.val)
				count++;
			prev = num;
			res.add(num.val);
			Num next = new Num(num.base, num.power+1);
			queue.offer(next);
			if(candidate <= next.val){
				queue.offer(new Num(i, 2));
				i++;
			}
		}
		while(queue.size()>0 && (prev!=null && queue.peek().val == prev.val)){
			res.add(queue.poll().val);
		}
		res.add(queue.peek().val);
		res.forEach(k->System.out.print(k+" "));
		System.out.println();
		return queue.poll().val;
	}
	
	public static void main(String[] args) {
		IthPowerNumber s = new IthPowerNumber();
		long res = s.getPowerNumber(100);
		System.out.println(res);
	}
}
