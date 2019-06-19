package ds.graph;

public class App {

	public static void main(String[] args) {
		BetterGraph graph = new BetterGraph();
		graph.addVertex("Denver");
		graph.addVertex("San Francisco");
		graph.addVertex("Los Angeles");
		graph.addVertex("New York");
		graph.addVertex("Washington");
		graph.addEdge("Los Angeles", "San Francisco");
		graph.addEdge("San Francisco", "New York");
		graph.addEdge("New York", "Washington");
		graph.addEdge("Washington", "Los Angeles");
		graph.addEdge("San Francisco", "Denver");
		graph.addEdge("Washington", "Denver");
		graph.addEdge("Denver", "New York");
		graph.addEdge("Denver", "Los Angeles");
		graph.printGraph();

		graph.removeVertex("Denver");
		graph.addVertex("Denver");
		graph.printGraph();
	}

}
