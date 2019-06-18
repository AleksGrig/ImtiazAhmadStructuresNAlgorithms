package ds.arrayheap;

public class App {

	public static void main(String[] args) {
		Heap heap = new Heap(10);
		heap.insert(1);
		heap.insert(2);
		heap.insert(3);
		heap.insert(10);
		heap.insert(66);
		heap.insert(3);
		heap.insert(10);
		heap.insert(66);
		heap.displayHeap();
	}
}
