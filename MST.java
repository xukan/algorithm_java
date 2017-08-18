package algorithm_java;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.PriorityQueue;

//http://www.geeksforgeeks.org/greedy-algorithms-set-2-kruskals-minimum-spanning-tree-mst/
//http://vancexu.github.io/2015/07/13/intro-to-union-find-data-structure.html

/*
 * 
 * input data After sorting:
Weight   Src    Dest
1         7      6
2         8      2
2         6      5
4         0      1
4         2      5
6         8      6
7         2      3
7         7      8
8         0      7
8         1      2
9         3      4
10        5      4
11        1      7
14        3      5
 * */

//A class to represent a graph edge
class Edge implements Comparable<Edge>{
    int src, dest, weight;
    // Comparator function used for sorting edges based on
    // their weight
    public int compareTo(Edge compareEdge){
        return this.weight-compareEdge.weight;
    }
    public Edge(){
    	this.src = -1;
    	this.dest = -1;
    	this.weight = -1;
    }
    
    public Edge(int s, int d, int w){
    	this.src = s;
    	this.dest = d;
    	this.weight = w;
    }
};

//A class to represent a subset for union-find
class subset{
    int parent, rank;
};

public class MST {
    List<Edge> graph; // collection of all edges
    HashSet<Integer> vertices;
    // Creates a graph with V vertices and E edges
    int[] id ;
    int[] size;
    int count = 0;// number of components
    public MST(){
        graph= new ArrayList<Edge>();
        vertices = new HashSet<>();
    }
    
    public void setId(int n){
    	id = new int[n];
    	for(int i=0;i<n;i++)
    		id[i] = i;
    }
    
    public void setSize(int n){
    	size = new int[n];
    	for(int i=0;i<n;i++)
    		size[i] = 1;
    }
    
    
    public int find(int i){
    	while(i!=id[i]){
    		id[i] = id[id[i]];
    		i = id[i];
    	}
    	return i;
    }
 
    // A function that does union of two sets of x and y
    // (uses union by rank)
    public void union(int p, int q) {
		int i = find(p);
		int j = find(q);
		if (i == j) return;
		// Make smaller root point to larger one.
		if (size[i] < size[j]){ 
			id[i] = j; size[j] += size[i]; 
		}else {
			id[j] = i; size[i] += size[j];
		}
		count--;
	}
    
    // The main function to construct MST using Kruskal's algorithm
    public void KruskalMST(){
    	int V = vertices.size(); 
    	count = V;
    	setId(V);
    	setSize(V);
    	Edge result[] = new Edge[V];
        // Step 1:  Sort all the edges in non-decreasing order of their
        // weight.  If we are not allowed to change the given graph, we
        // can create a copy of array of edges
        Collections.sort(graph);
 
        int e = 0;  // An index variable, used for result[]
        int i = 0;  // Index used to pick next edge
 
        // Number of edges to be taken is equal to V-1
        while (e < V - 1){
            // Step 2: Pick the smallest edge. And increment the index
            // for next iteration
            Edge next_edge = new Edge();
            next_edge = graph.get(i++);
 
            int x = find(next_edge.src);
            int y = find(next_edge.dest);
 
            // If including this edge does't cause cycle, include it
            // in result and increment the index of result for next edge
            if (x != y)
            {
                result[e++] = next_edge;
                union( x, y);
            }
            // Else discard the next_edge
        }
 
        // print the contents of result[] to display the built MST
        System.out.println("Following are the edges in the constructed MST");
        for (i = 0; i < e; ++i)
            System.out.println(result[i].src+" -- "+result[i].dest+" == "+
                               result[i].weight);
        System.out.println("total set:" + count);
    }
    
	// Driver Program
    public static void main (String[] args) throws IOException{
        //int V = 9;  // Number of vertices in graph
        //int E = 14;  // Number of edges in graph
        MST mst = new MST();
        
        BufferedReader br = new BufferedReader(new FileReader("data/graph.txt"));
        try {
            String line = br.readLine();

            while (line != null) {
            	String[] info = line.split("\\s+");//This groups all white spaces as a delimiter.
            	int w = Integer.parseInt(info[0]);
            	int s = Integer.parseInt(info[1]);
            	int d = Integer.parseInt(info[2]);
            	Edge edge = new Edge(s, d, w);
            	mst.graph.add(edge);
            	mst.vertices.add(s);
            	mst.vertices.add(d);
                line = br.readLine();
            }
        } finally {
            br.close();
        }
        mst.KruskalMST();
    }
}
