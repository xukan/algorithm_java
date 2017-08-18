package algorithm_java;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Random;


//https://www.hrwhisper.me/leetcode-contains-duplicate-i-ii-iii/
//桶方法

//Yelp

public class RandomizedCollection {
//	ArrayList<Integer> list;
//    HashMap<Integer, HashSet<Integer>> map;
//    Random rand;
//    /** Initialize your data structure here. */
//    public RandomizedCollection() {
//        list = new ArrayList();
//        map = new HashMap();
//        rand = new Random();
//    }
//    
//    /** Inserts a value to the collection. Returns true if the collection did not already contain the specified element. */
//    public boolean insert(int val) {
//    	boolean hasVal = false;
//        if(!map.containsKey(val)){
//            map.put(val, new HashSet<Integer>());
//            hasVal = true;
//        }
//        list.add(val);
//        map.get(val).add(list.size()-1);
//        return hasVal;
//    }
//    
//    /** Removes a value from the collection. Returns true if the collection contained the specified element. */
//    public boolean remove(int val) {
//        if(!map.containsKey(val))
//            return false;
//        //
//        HashSet<Integer> toRemoveSet = map.get(val);
//        int removeIdx = toRemoveSet.iterator().next();
//        toRemoveSet.remove(removeIdx);
//        if(toRemoveSet.size() == 0){
//        	map.remove(val);
//        }
//        //当删除的元素不是list中的最后一个元素的时候，可以用最后一个元素替代删除的元素，
//        //以此保证每一个元素被选中的概率相同，这道题要求每个元素选中的几率与出现的频率成
//        //线性关系，实际上还是保证每个元素被选中的概率相等
//        if( removeIdx< list.size() -1){
//	        int lastElement = list.get(list.size()-1);
//	        list.set(removeIdx, lastElement);
//	        HashSet<Integer> changeSet = map.get(lastElement);
//	        changeSet.remove(list.size()-1);
//	        changeSet.add(removeIdx);
//        }
//        list.remove(list.size()-1);
//        
//        return true;
//    }
//    
//    /** Get a random element from the collection. */
//    public int getRandom() {
//        return list.get(rand.nextInt(list.size()));
//    }
    
	HashMap<Integer, List<Integer>> map;
    List<Integer> list;
    Random random;
    /** Initialize your data structure here. */
    public RandomizedCollection() {
        map = new HashMap<Integer, List<Integer>>();
        list = new ArrayList<>();
        random = new Random();
    }
    
    /** Inserts a value to the collection. Returns true if the collection did not already contain the specified element. */
    public boolean insert(int val) {
        boolean hasVal = false;
        if(!map.containsKey(val)){
            map.put(val, new ArrayList<Integer>());
            hasVal = true;
        }
        list.add(val);
        map.get(val).add(list.size()-1);
        return hasVal;
    }
    
    /** Removes a value from the collection. Returns true if the collection contained the specified element. */
    public boolean remove(int val) {
    	if(!map.containsKey(val))
            return false;
        List<Integer> positions = map.get(val);
        int pos = positions.get(0);
        positions.remove(0);
        if(positions.size()==0)
            map.remove(val);
        if(pos < list.size()-1){
            int lastElmt = list.get(list.size()-1);
            list.set(pos, lastElmt);
            List<Integer> lastElmtPos = map.get(lastElmt);
            lastElmtPos.add(0,pos);
            lastElmtPos.remove(lastElmtPos.size()-1);
        }
        list.remove(list.size()-1);
        return true;
    }
    
    /** Get a random element from the collection. */
    public int getRandom() {
        if(list.size()>0)
            return list.get(random.nextInt(list.size()));
        return -1;
    }
	
	
    public static void main(String[] args) {
    	RandomizedCollection collection = new RandomizedCollection();
    	
    	collection.insert(4);
    	collection.insert(3);
    	collection.insert(4);
    	collection.insert(2);
    	collection.insert(4);
    	collection.remove(4);
    	collection.remove(3);
    	collection.remove(4);
    	collection.remove(4);
    	
    	// getRandom should return 1 with the probability 2/3, and returns 2 with the probability 1/3.
    	collection.getRandom();

    	// Removes 1 from the collection, returns true. Collection now contains [1,2].
    	

    	// getRandom should return 1 and 2 both equally likely.
    	collection.getRandom();
	}
}
