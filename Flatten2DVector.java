package algorithm_java;

import java.util.Iterator;
import java.util.List;

//Google Airbnb Twitter Zenefits


public class Flatten2DVector implements Iterator<Integer> {
    
    List<List<Integer>> list;
    int curLine;
    int curElem;
    public Flatten2DVector(List<List<Integer>> vec2d) {
        this.list = vec2d;
    }

    @Override
    public Integer next() {
        return list.get(curLine).get(curElem++);
    }

    @Override
    public boolean hasNext() {
        while(curLine<list.size()){
            if(curElem < list.get(curLine).size())
                return true;
            curLine++;
            curElem = 0;
        }
        return false;
    }
    
    
    //follow-up
//    Iterator<List<Integer>> it;
//    Iterator<Integer> curr;
//    
//    public  Flatten2DVector(List<List<Integer>> vec2d) {
//        it = vec2d.iterator();
//    }
//    
//    @Override
//    public Integer next() {
//        return curr.next();
//    }
//
//    @Override
//    public boolean hasNext() {
//        // 当前列表的迭代器为空，或者当前迭代器中没有下一个值时，需要更新为下一个迭代器
//        while((curr == null || !curr.hasNext()) && it.hasNext()){
//            curr = it.next().iterator();
//        }
//        return curr != null && curr.hasNext();
//    }
}