package ds.queue;

public class App {

	public static void main(String[] args) {
		Queue queue = new Queue(2);
		queue.insert(4);
		queue.insert(14);
		queue.view();

		System.out.println(queue.remove());
		queue.view();

		System.out.println(queue.remove());
		queue.view();
		queue.remove();

		System.out.println(queue.peekFront());
		System.out.println(queue.peekRear());

		queue.insert(14);
		queue.insert(66);
		queue.view();
	}

}
