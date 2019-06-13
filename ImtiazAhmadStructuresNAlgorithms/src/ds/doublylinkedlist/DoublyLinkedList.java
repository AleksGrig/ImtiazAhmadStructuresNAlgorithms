package ds.doublylinkedlist;

public class DoublyLinkedList {

	private Node first;
	private Node last;

	public DoublyLinkedList() {
		this.first = null;
		this.last = null;
	}

	public boolean isEmpty() {
		return (first == null);
	}

	public void insertFirst(Object data) {
		Node newNode = new Node();
		newNode.data = data;

		if (isEmpty()) {
			last = newNode;
		} else {
			first.previous = newNode;
			newNode.next = first;
		}

		first = newNode;
	}

	public void insertLast(Object data) {
		Node newNode = new Node();
		newNode.data = data;

		if (isEmpty()) {
			first = newNode;
		} else {
			last.next = newNode;
			newNode.previous = last;
		}

		last = newNode;
	}

	// insert node after node with given data
	public boolean insertAfter(Object key, Object data) {
		if (isEmpty()) {
			System.out.println("insertAfter(): Can't insert element. List is empty.");
			System.out.println();
			return false;
		}
		Node current = first;
		while (!current.data.equals(key)) {
			current = current.next;
			if (current == null) {
				System.out.println("insertAfter(): Can't insert element. Key is not found.");
				System.out.println();
				return false;
			}
		}
		Node newNode = new Node();
		newNode.data = data;

		if (current == last) {
			last = newNode;
		} else {
			newNode.next = current.next;
			current.next.previous = newNode;
		}
		current.next = newNode;
		newNode.previous = current;
		return true;
	}

	public Node deleteKey(Object key) {
		if (isEmpty()) {
			System.out.println("deleteKey(): Can't delete element. List is empty. ");
			System.out.println();
			return null;
		}
		Node current = first;
		while (!current.data.equals(key)) {
			current = current.next;
			if (current == null) {
				System.out.println("deleteKey(): Can't delete element. Key is not found.");
				System.out.println();
				return null;
			}
		}
		if (current == first) {
			first = current.next;
		} else {
			current.previous.next = current.next;
		}
		if (current == last) {
			last = current.previous;
		} else {
			current.next.previous = current.previous;
		}
		return current;
	}

	public Node deleteFirst() {
		if (isEmpty()) {
			System.out.println("deleteFirst(): Cant't delete first element. List is empty.");
			System.out.println();
			return null;
		} else {
			Node temp = first;
			if (first.next == null) {// if there is only one element in list
				last = null;
			} else {
				first.next.previous = null;
			}
			first = first.next;
			return temp;
		}
	}

	public Node deleteLast() {
		if (isEmpty()) {
			System.out.println("deleteFirst(): Cant't delete first element. List is empty.");
			System.out.println();
			return null;
		} else {
			Node temp = last;
			if (last.previous == null) {
				first = null;
			} else {
				last.previous.next = null;
			}
			last = last.previous;
			return temp;
		}
	}

	public void displayList() {
		if (first == null) {
			System.out.println("List is empty.");
		} else {
			System.out.println("displayList():");
			Node current = first;
			while (current != null) {
				current.displayNode();
				current = current.next;
			}
		}
		System.out.println();
		System.out.println();
	}
}
