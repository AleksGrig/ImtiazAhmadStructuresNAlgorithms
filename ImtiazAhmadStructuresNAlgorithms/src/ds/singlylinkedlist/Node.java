package ds.singlylinkedlist;

public class Node {
	public Object data;
	public Node next = null;

	public void displayNode() {
		System.out.print("{ " + data + " } ");
	}
}
