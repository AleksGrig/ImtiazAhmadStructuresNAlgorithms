package ds.graph;

import java.util.ArrayList;

public class BetterGraph {

	private ArrayList<ArrayList<String>> adjacents = new ArrayList<ArrayList<String>>();

	public void addVertex(String src) {
		ArrayList<String> list = new ArrayList<String>();
		list.add(src);
		adjacents.add(list);
	}

	public boolean addEdge(String src, String dest) {
		for (ArrayList<String> arrayList : adjacents) {
			if(arrayList.get(0).equals(src)) {
				for (ArrayList<String> vertixList: adjacents) {
					if(vertixList.get(0).equals(dest)) {
						arrayList.add(dest);
						return true;
					}
				}
			}
		}
		return false;
	}

	public void removeVertex(String src) {
		int counter = 0;
		int vertexToDelete = 0;
		boolean delete = false;
		for (ArrayList<String> arrayList : adjacents) {
			for (int i = 0; i < arrayList.size(); i++) {
				if (arrayList.get(i).equals(src)) {
					if (i == 0) {
						delete = true;
						vertexToDelete = counter;
					} else {
					arrayList.remove(i);
						break;
					}
				}
			}
			counter++;
		}
		if (delete) {
			adjacents.remove(vertexToDelete);
		}
	}

	public void printVertices() {
		for (ArrayList<String> arrayList : adjacents) {
			System.out.println(arrayList.get(0));
		}
	}

	public void printGraph() {
		System.out.println("********************************************");
		for (ArrayList<String> arrayList : adjacents) {
			for (int i = 0; i < arrayList.size(); i++) {
				System.out.print(arrayList.get(i));
				if (i < arrayList.size() - 1) {
					System.out.print(" --> ");
				}
			}
			System.out.println();
		}
		System.out.println("");
	}
}
