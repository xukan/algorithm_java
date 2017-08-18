package algorithm_java;

/*
 * we will use networking terminology for the rest of
 * this section and refer to the objects as sites, the pairs as connections,
 * and the equivalence classes as connected components, 
 * or just components for short.
 * */

//http://vancexu.github.io/2015/07/13/intro-to-union-find-data-structure.html

/*
 * As you can guess, there are many applications on this:
 * Friends in a social network
 * Pixels in a digital photo
 * Computers in a network
 * Transistors in a computer chip
 * Metallic sites in a coposite system
 * */

class UnionFind {
	private int count = 0;// number of components
	private int[] id;// id, id link (site indexed)
	private int[] size;// size of component for roots (site indexed)

	public UnionFind(int n) {
		count = n;
		id = new int[n];
		size = new int[n];
		for (int i = 0; i < n; i++) {
			id[i] = i;
		}
		for (int i = 0; i < n; i++) size[i] = 1;
	}

	//Find query: are objects 2 and 9 in the same set?
	//0 1 {239} {5-6} 7 {4-8}
	//Union command: merge sets containing 3 and 8.
	//0 1 {23489} {5-6} 7
	//path compression helps us descrese the depth of the tree.
	public int find(int p) {
		while (p != id[p]) {
			id[p] = id[id[p]]; // path compression by halving
			p = id[p];
		}
		return p;
	}

	/*Weighted quick-union.
	• Modify quick-union to avoid tall trees.
	• Keep track of size of each component.
	• Balance by linking small tree below large one.
	*/
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

	public int count() {
		return count;
	}
}