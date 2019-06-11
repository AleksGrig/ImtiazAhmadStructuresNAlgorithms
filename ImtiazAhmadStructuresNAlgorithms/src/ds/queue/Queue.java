package ds.queue;

public class Queue {

	private int maxSize;
	private Object[] queue;
	private int front;
	private int rear;
	private int nItems;// number of items in our queue

	public Queue(int size) {
		this.maxSize = size;
		this.queue = new Object[maxSize];
		this.front = 0;
		this.rear = -1;
		this.nItems = 0;
	}

	public void insert(Object j) {
		if (rear == maxSize - 1) {
			rear = -1;
		}
		queue[++rear] = j;
		nItems++;
	}

	public Object remove() {
		if (nItems > 0) {
		Object temp = queue[front++];
		if (front == maxSize) {
			front = 0;// we set front back to 0th index so we can use entire array again
		}
		nItems--;
			return temp;
		} else {
			System.out.println("Queue is empty");
			return "Queue is empty";
		}
	}

	public Object peekFront() {
		return queue[front];
	}

	public Object peekRear() {
		return queue[rear];
	}

	public boolean isEmpty() {
		return (nItems == 0);
	}

	public boolean isFull() {
		return (nItems == maxSize);
	}

	public void view() {
		System.out.print("[ ");
		for (int i = front; i < front + nItems; i++) {
			System.out.print(queue[i] + " ");
		}
		System.out.println("]");
	}

}
