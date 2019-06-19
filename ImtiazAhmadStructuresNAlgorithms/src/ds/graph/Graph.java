package ds.graph;

import java.util.ArrayList;

public class Graph {

	private int vCount;// number of vertices
	private int eCount;// number of edges

	@SuppressWarnings("rawtypes")
	private ArrayList[] adjacents;// array of integer lists

	public Graph(int vertices) {
		this.vCount = vertices;
		this.eCount = 0;
		adjacents = new ArrayList[vCount];
		
		for (int i = 0; i < vCount; i++) {
			adjacents[i] = new ArrayList<Integer>();
		}
	}

	public int getvCount() {
		return vCount;
	}

	public int geteCount() {
		return eCount;
	}
	
	@SuppressWarnings("unchecked")
	public void addEdge(int src, int dest) {
		adjacents[src].add(dest);
		eCount++;
	}

	public Object[] adj(int src) {
		return adjacents[src].toArray();
	}
}
