package algorithm_java;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

//https://yisuang1186.gitbooks.io/java-/content/amicable_pair.html
//amicable chain
//http://www.cnblogs.com/theskulls/p/5022080.html

public class AmicablePair {
	public static int factorSum(int num) {
        int res = 1;
        for (int i = 2; i * i < num; i++) {
            if (num % i == 0) {
                res += i + num / i;
            }
        }
        return res;
    }

    public static List<List<Integer>> amicablePair(int k) {
        // Write your code here
        List<List<Integer> > res = new ArrayList<List<Integer> >();
        for (int i = 2; i < k; i++) {
            int temp = factorSum(i);
            if (temp < i || temp > k) {
                continue;
            }
            if (i == factorSum(temp) && i != temp) {
                ArrayList<Integer> pair = new ArrayList<Integer>();
                pair.add(i);
                pair.add(temp);
                Collections.sort(pair);
                res.add(pair);
            }
        }
        return res;
    }
}
