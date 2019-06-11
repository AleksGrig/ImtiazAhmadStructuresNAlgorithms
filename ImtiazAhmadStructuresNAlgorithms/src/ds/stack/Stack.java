package ds.stack;

public class Stack {

	private int maxSize;
	private Object[] stack;
	private int top;

	public Stack(int size) {
		this.maxSize = size;
		this.stack = new Object[maxSize];
		this.top = -1;
	}

	public void push(Object j) {
		if (!isFull()) {
			stack[++top] = j;
		} else {
			System.out.println("Stack is full");
		}
	}

	public Object pop() {
		if (!isEmpty()) {
			return stack[top--];
		} else {
			return "Stack is empty";
		}
	}

	public boolean isFull() {
		return (maxSize - 1 == top);
	}

	public boolean isEmpty() {
		return (top == -1);
	}
}
