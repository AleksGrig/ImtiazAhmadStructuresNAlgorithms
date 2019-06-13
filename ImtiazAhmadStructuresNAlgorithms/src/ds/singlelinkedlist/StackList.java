package ds.singlelinkedlist;

public class StackList {

	private SingleLinkedList list = new SingleLinkedList();

	public void push(Object data) {
		list.insertFirst(data);
	}

	public Object pop() {
		Node deleted = list.deleteFirst();
		if (deleted == null) {
			System.out.println("pop(): Stack is empty.");
			return null;
		} else {
			return deleted.data;
		}
	}
}
