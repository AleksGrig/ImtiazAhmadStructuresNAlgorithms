package ds.doublylinkedlist;

public class App {

	public static void main(String[] args) {
		DoublyLinkedList list = new DoublyLinkedList();
		list.insertFirst("First element");
		list.displayList();

		list.deleteKey("First element");
		list.displayList();

		list.insertFirst("New first element");
		list.displayList();

		list.deleteLast();
		list.displayList();
	}

}
