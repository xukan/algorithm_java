package algorithm_java;

import java.util.Stack;

//Google Facebook Twitter

public class FlattenNestedListIterator {
	Stack<NestedInteger> stack;
    public FlattenNestedIterator(List<NestedInteger> nestedList) {
        stack = new Stack<NestedInteger>();
        for(int i=nestedList.size()-1;i>=0;i--)
            stack.push(nestedList.get(i));
    }

    @Override
    public Integer next() {
        return stack.pop().getInteger();
    }

    @Override
    public boolean hasNext() {
        while(!stack.empty()){
            NestedInteger top = stack.peek();
            if(top.isInteger())
                return true;
            else{
                NestedInteger ni = stack.pop();
                List<NestedInteger> list = ni.getList();
                for(int i=list.size()-1;i>=0;i--){
                    stack.push(list.get(i));
                }
            }
        }
        return false;
    }
}
