package ds.singlelinkedlist;

public class SingleLinkedList {

	private Node first;
	private Node last;

	public SingleLinkedList() {
		first = null;
		last = first;
	}

	public boolean isEmpty() {
		return (first == null);
	}

	// insert at the beginning of the list
	public void insertFirst(Object data) {
		Node newNode = new Node();
		newNode.data = data;
		newNode.next = first;
		if (isEmpty()) {
			last = newNode;
		}
		first = newNode;
	}

	public void insertLast(Object data) {
		Node newNode = new Node();
		newNode.data = data;
		if (isEmpty()) {
			first = newNode;
			last = newNode;
		} else {
			last.next = newNode;
			last = newNode;
		}
	}

	public void insertAtIndex(int index, Object data) {
		if (index == 0) {
			insertFirst(data);
			return;
		}
		int counter = 0;
		Node current = first;
		while (current != null) {
			counter++;
			if (counter == index) {
				Node inserted = new Node();
				if (current.next == null) {
					last = inserted;
				}
				inserted.data = data;
				inserted.next = current.next;
				current.next = inserted;
				return;
			}
			current = current.next;
		}
		System.out.println("insertedAtIndex(): Index is out of boundary.");
	}

	public Node deleteFirst() {
		if (isEmpty()) {
			System.out.println("deleteFirst(): Can't delete. List is empty.");
			System.out.println();
			return null;
		} else {
		Node deleted = first;
		first = first.next;
			if (isEmpty()) {
				last = null;
			}
			return deleted;
		}
	}

	public Node deleteLast() {
		if (isEmpty()) {
			System.out.println("deleteLast(): Can't delete. List is empty.");
			System.out.println();
			return null;
		} else if (first.next == null) {
			first = null;
			last = null;
			return null;
		} else {
			Node deleted = last;
			Node current = first;
			while (current.next.next != null) {
				current = current.next;
			}
			current.next = null;
			last = current;
			return deleted;
		}
	}

	public Node deleteAtIndex(int index) {
		if (index == 0) {
			Node result = deleteFirst();
			return result;
		}
		int counter = 0;
		Node current = first;
		while (index - counter > 1) {
			if (current.next != null) {
				current = current.next;
				counter++;
			} else {
				System.out.println("deleteAtIndex(): Index is out of boundary.");
				System.out.println();
				return null;
			}
		}
		Node result = current.next;
		if (current.next != null) {
			current.next = current.next.next;
		} else {
			System.out.println("deleteAtIndex(): Index is out of boundary.");
			System.out.println();
			return null;
		}
		if (current.next == null) {
			last = current;
		}
		return result;
	}

	public Node getFirst() {
		return first;
	}

	public Node getLast() {
		return last;
	}

	public void displayList() {
		if (isEmpty()) {
			System.out.println("displayList(): List is empty.");
			System.out.println();
		} else {
			System.out.println("displayList: List (first --> last)");
		}
		Node current = first;
		while (current != null) {
			current.displayNode();
			if (current.next != null) {
				System.out.print("--> ");
			}
			current = current.next;
		}
		System.out.println();
		System.out.println();
	}
}
