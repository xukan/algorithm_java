package algorithm_java;

import java.util.Iterator;
import java.util.LinkedList;

public class BFS {
	// elements to construct a graph

	static class Node{
		int value;
		boolean visited;
		LinkedList<Node> adj;
		Node(int v){
			value = v;
			visited=false;
			adj = new LinkedList<Node>();
		}
	}
	
	public void bfs(Node startNode){
		LinkedList<Node> queue = new LinkedList();
		queue.add(startNode);
		startNode.visited = true;
		while(!queue.isEmpty()){
			Node node = queue.poll();
			System.out.print(node.value + " " );

			Iterator<Node> iter = node.adj.listIterator();
			while(iter.hasNext()){
				Node next = iter.next();
				if(!next.visited){
					queue.offer(next);
					next.visited = true;
				}
			}
		}
	}

	public static void main(String[] args) {
		Node node0 = new Node(0);
		Node node1 = new Node(1);
		Node node2 = new Node(2);
		Node node3 = new Node(3);
		
		node0.adj.add(node1);
		node0.adj.add(node2);
		node1.adj.add(node2);
		node2.adj.add(node0);
		node2.adj.add(node3);
		node3.adj.add(node3);
		
		BFS s = new BFS();
		s.bfs(node2);
	}
}
