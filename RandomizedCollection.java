package algorithm_java;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Random;

//https://www.hrwhisper.me/leetcode-contains-duplicate-i-ii-iii/
//桶方法

public class RandomizedCollection {
	ArrayList<Integer> list;
    HashMap<Integer, HashSet<Integer>> map;
    Random rand;
    /** Initialize your data structure here. */
    public RandomizedCollection() {
        list = new ArrayList();
        map = new HashMap();
        rand = new Random();
    }
    
    /** Inserts a value to the collection. Returns true if the collection did not already contain the specified element. */
    public boolean insert(int val) {
        list.add(val);
        int index = list.size()-1;
        if(map.containsKey(val)){
        	HashSet<Integer> indexSet = map.get(val);
            indexSet.add(index);
            map.put( val, indexSet);
            return false;
        }else{
            HashSet<Integer> set = new HashSet<Integer>();
            set.add(index);
            map.put(val, set);
        }
        return true;
    }
    
    /** Removes a value from the collection. Returns true if the collection contained the specified element. */
    public boolean remove(int val) {
        if(!map.containsKey(val))
            return false;
        //
        HashSet<Integer> toRemoveSet = map.get(val);
        int removeIdx = toRemoveSet.iterator().next();
        toRemoveSet.remove(removeIdx);
        if(toRemoveSet.size() == 0){
        	map.remove(val);
        }
        //当删除的元素不是list中的最后一个元素的时候，可以用最后一个元素替代删除的元素，
        //以此保证每一个元素被选中的概率相同，这道题要求每个元素选中的几率与出现的频率成
        //线性关系，实际上还是保证每个元素被选中的概率相等
        if( removeIdx< list.size() -1){
	        int lastElement = list.get(list.size()-1);
	        list.set(removeIdx, lastElement);
	        HashSet<Integer> changeSet = map.get(lastElement);
	        changeSet.remove(list.size()-1);
	        changeSet.add(removeIdx);
        }
        list.remove(list.size()-1);
        
        return true;
    }
    
    /** Get a random element from the collection. */
    public int getRandom() {
        return list.get(rand.nextInt(list.size()));
    }
    
    public static void main(String[] args) {
    	
    	RandomizedCollection collection = new RandomizedCollection();

    	
    	collection.insert(1);
    	collection.insert(1);
    	collection.insert(2);
    	collection.insert(1);
    	collection.insert(2);
    	collection.insert(2);
    	collection.remove(1);
    	collection.remove(2);
    	collection.remove(2);
    	collection.remove(2);
    	// Inserts 1 to the collection. Returns true as the collection did not contain 1.
//    	collection.insert(10);
//    	collection.insert(10);
//    	collection.insert(20);
//    	collection.insert(20);
//    	collection.insert(30);
//    	collection.insert(30);
//    	
//    	collection.remove(10);
//    	collection.remove(10);
//    	collection.remove(30);
//    	collection.remove(30);

    	// getRandom should return 1 with the probability 2/3, and returns 2 with the probability 1/3.
    	collection.getRandom();

    	// Removes 1 from the collection, returns true. Collection now contains [1,2].
    	

    	// getRandom should return 1 and 2 both equally likely.
    	collection.getRandom();
	}
}
