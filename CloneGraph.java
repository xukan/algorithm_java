package algorithm_java;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

//Pocket Gems Google Uber Facebook

public class CloneGraph {
	 class UndirectedGraphNode {
		 int label;
		 List<UndirectedGraphNode> neighbors;
		 UndirectedGraphNode(int x) { label = x; neighbors = new ArrayList<UndirectedGraphNode>(); }
	};
	
	public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
        if(node == null)
            return null;
        HashMap<UndirectedGraphNode, UndirectedGraphNode> map = new HashMap<>();
        UndirectedGraphNode start = new UndirectedGraphNode(node.label);
        map.put(node, start);
        Queue<UndirectedGraphNode> queue = new LinkedList<UndirectedGraphNode>();
        queue.offer(node);
        while(!queue.isEmpty()){
            UndirectedGraphNode n = queue.poll();
            for(UndirectedGraphNode neighbor: n.neighbors){
                if(map.containsKey(neighbor)){
                    map.get(n).neighbors.add(map.get(neighbor));
                }else{
                    UndirectedGraphNode copy = new UndirectedGraphNode(neighbor.label);
                    map.put(neighbor, copy);
                    map.get(n).neighbors.add(copy);
                    queue.offer(neighbor);
                }
                //we can't add queue.offer() here, if so, it is going to be infinite loop
                // queue.offer(neighbor);
            }
        }
        return start;
    }
}
