package ds.doublylinkedlist;

public class Node {

	public Object data;
	public Node next;
	public Node previous;

	public void displayNode() {
		System.out.print("{ " + data + " } ");
	}
}
