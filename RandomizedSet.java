package algorithm_java;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

//Google Uber Twitter Amazon Yelp Pocket Gems Facebook

/*
 * 要求实现上述的三个操作，且操作时间为O(1)的操作时间。使用HashMap保存输入的数字的index，用ArrayList保存数组。
 * 一个值得注意的问题是，有一个getRandom的操作，计划是根据Random类的nextInt方法来获得下标，然后从ArrayList中返回数据，
 * 故应该保持ArrayList中的index的连续的，一个简单的做法是将删除的元素由最后一个元素取代，并删除原最后元素，保证size-1；
 * 
 * reference: http://blog.csdn.net/newpidian/article/details/52165221
 * */

public class RandomizedSet {
	private ArrayList<Integer> list;
    private HashMap<Integer, Integer> map;
    private Random rand;
    
    /** Initialize your data structure here. */
    public RandomizedSet() {
        list = new ArrayList();
        map = new HashMap();
        rand = new Random();
    }
    
    /** Inserts a value to the set. Returns true if the set did not already contain the specified element. */
    public boolean insert(int val) {
        if(map.containsKey(val))
            return false;
        list.add(val);
        map.put(val, list.size()-1);
        return true;
    }
    
    /** Removes a value from the set. Returns true if the set contained the specified element. */
    public boolean remove(int val) {
        if(!map.containsKey( val))
            return false;
        int index = map.remove(val);
        if( index < list.size()-1){
            int lastElement = list.get(list.size()-1);
            list.set(index, lastElement);
            map.put(lastElement, index);
        }
        list.remove(list.size()-1);
        return true;
    }
    
    /** Get a random element from the set. */
    public int getRandom() {
        return list.get(rand.nextInt(list.size()));
    }
    
    public static void main(String[] args) {
    	// Init an empty set.
    	RandomizedSet randomSet = new RandomizedSet();

    	// Inserts 1 to the set. Returns true as 1 was inserted successfully.
    	randomSet.insert(1);

    	// Returns false as 2 does not exist in the set.
    	randomSet.remove(2);

    	// Inserts 2 to the set, returns true. Set now contains [1,2].
    	randomSet.insert(2);

    	// getRandom should return either 1 or 2 randomly.
    	randomSet.getRandom();

    	// Removes 1 from the set, returns true. Set now contains [2].
    	randomSet.remove(1);

    	// 2 was already in the set, so return false.
    	randomSet.insert(2);

    	// Since 1 is the only number in the set, getRandom always return 1.
    	randomSet.getRandom();
	}
}
