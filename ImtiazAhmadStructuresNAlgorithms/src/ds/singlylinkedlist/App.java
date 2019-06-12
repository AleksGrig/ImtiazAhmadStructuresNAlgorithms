package ds.singlylinkedlist;

public class App {

	public static void main(String[] args) {
		SinglyLinkedList list = new SinglyLinkedList();
		list.insertFirst("First element");
		list.insertLast("Second element");
		list.insertLast("Last");
		list.displayList();

		list.deleteAtIndex(2);
		list.displayList();

		list.insertLast("New Last!!!");
		list.insertFirst("New First!!!");
		list.displayList();

		list.deleteFirst();
		list.deleteLast();
		list.displayList();


	}

}
