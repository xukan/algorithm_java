package algorithm_java;

import java.util.ArrayList;
import java.util.List;

public class TwoSumIII {
	List<Integer> list;
    /** Initialize your data structure here. */
    public TwoSumIII() {
        list = new ArrayList<Integer>();
    }
    
    /** Add the number to an internal data structure.. */
    public void add(int number) {
        int l = 0, r = list.size()-1;
        while(l<=r){
            int m = l + (r-l)/2;
            if(list.get(m) == number){
                list.add(m, number);
                return;
            }else if( list.get(m) < number)
                l = m+1;
            else
                r = m - 1;
        }
        list.add(l, number);
    }
    
    /** Find if there exists any pair of numbers which sum is equal to the value. */
    public boolean find(int value) {
        int l = 0, r = list.size()-1;
        while(l < r){
            int n1 = list.get(l);
            int n2 = list.get(r);
            if( n1 + n2 == value)
                return true;
            else if( n1 + n2 < value)
                l++;
            else
                r--;
        }
        return false;
    }
    
    public static void main(String[] args) {
    	TwoSumIII s = new TwoSumIII();
    	s.add(0);
    	s.add(0);
    	System.out.println(s.find(0));
	}
}
