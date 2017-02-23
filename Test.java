package algorithm_java;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;

public class Test {
	public boolean isPerfectSquare(int num) {
        //int i=0;
        for(int i=0;i*i<=num; i++)
            if(i*i == num)
                return true;
        return false;
    }
	
	public static void main(String[] args) {
		Test s = new Test();
		boolean res = s.isPerfectSquare(16);
		System.out.println(res);
	}
}