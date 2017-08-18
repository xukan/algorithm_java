package algorithm_java;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Set;
import java.util.TreeMap;

public class MinimumIndexSumofTwoLists {
	public static String[] findRestaurant(String[] list1, String[] list2) {
        List<String> res = new ArrayList();
        HashMap<String, Integer> map = new HashMap();
        for(int i=0;i<list1.length;i++){
            map.put(list1[i], i);
        }
        TreeMap<Integer, List<String>> common = new TreeMap();
        for(int i=0;i<list2.length;i++){
            String name = list2[i];
            if(map.containsKey(name)){
                int sum = map.get(name)+i;
                if(!common.containsKey(sum))
                    common.put(sum, new ArrayList<String>()); 
                common.get(sum).add(name);
            }
        }
        Set<Integer> keys = common.keySet();
        int k=0;
        for(int key: keys){
            if(k>0)
                break;
            if(k==0)
                res = common.get(key);
            k++;
        }
        return res.toArray(new String[k]);
    }
	
	public static void main(String[] args) {
		String[] l1 = {"Shogun","Tapioca Express","Burger King","KFC"};
		String[] l2 = {"KFC","Burger King","Tapioca Express","Shogun"};
		String[] res = findRestaurant(l1, l2);
		for(String str: res)
			System.out.println(str + " ");
	}
}
