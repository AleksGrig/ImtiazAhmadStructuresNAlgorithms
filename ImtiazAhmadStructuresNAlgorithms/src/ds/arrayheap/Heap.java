package ds.arrayheap;

public class Heap {

	private Node[] heapArray;
	private int maxSize;// Size of the array
	private int currentSize;// Number of nodes in the array and next available slot

	public Heap(int size) {
		this.maxSize = size;
		this.currentSize = 0;
		heapArray = new Node[maxSize];
	}

	public int getSize() {
		return currentSize;
	}

	public boolean isEmpty() {
		return currentSize == 0;
	}

	// Insert at the bottom of the heap and then trickle up
	public boolean insert(int key) {
		if (currentSize == maxSize) {
			return false;
		}

		Node newNode = new Node(key);
		heapArray[currentSize] = newNode;

		trickleUp(currentSize);// Trickle up newly added node

		currentSize++;
		return true;
	}

	public Node remove() {
		Node nodeToReturn = null;
		// In case if heap is empty
		if (isEmpty()) {
			return nodeToReturn;
		}
		// In case if there is only one node in heap
		else if (currentSize == 1) {
			currentSize--;
			nodeToReturn = heapArray[0];
		}
		// If there are two or more nodes in heap
		else {
			nodeToReturn = heapArray[0];
			heapArray[0] = heapArray[currentSize - 1];
			currentSize--;
			// After deleting one node we have two or more nodes in heap
			if (currentSize > 1) {
				int index = 0;
				Node nodeToSwap = heapArray[0];
				boolean nextSwap = true;
				while (nextSwap) {
					nextSwap = false;
					int leftChild = index * 2 + 1;
					int rightChild = index * 2 + 2;
					// Node has two children
					if (leftChild < currentSize && rightChild < currentSize) {
						int max = heapArray[leftChild].getKey() >= heapArray[rightChild].getKey() ? leftChild
								: rightChild;
						if (nodeToSwap.getKey() < heapArray[max].getKey()) {
							heapArray[index] = heapArray[max];
							index = max;
							heapArray[max] = nodeToSwap;
							nextSwap = true;
						}
					}
					// Node has only left child, node cant't have only right child by heap rules
					else if (leftChild < currentSize) {
						if (heapArray[leftChild].getKey() > nodeToSwap.getKey()) {
							heapArray[index] = heapArray[leftChild];
							heapArray[leftChild] = nodeToSwap;
						}
					}
				}
			}
		}
		return nodeToReturn;
	}

	public void displayHeap() {
		if (isEmpty()) {
			System.out.println("Heap is empty.");
		} else {
			int count = 0;
			int row = 0;
			while (count < currentSize) {
				int blank = (int) (32 / Math.pow(2, row));
				for (int i = 0; (count < currentSize) && (i < Math.pow(2, row)); i++) {
					for (int j = 0; j < blank; j++) {
						System.out.print(" ");
					}
					System.out.print(heapArray[count].getKey());
					count++;
					for (int j = 0; j < blank; j++) {
						System.out.print(" ");
					}
				}
				System.out.println();
				row++;
			}
		}
	}

	public void display() {
		if (isEmpty()) {
			System.out.println("Heap is empty.");
		} else {
		for (int i = 0; i < currentSize; i++) {
			System.out.println(heapArray[i].getKey());
			}
		}
		System.out.println();
	}

	private void trickleUp(int index) {
		int parentIndex = (index - 1) / 2;// Formula for finding parent in heap
		Node nodeToInsert = heapArray[index];

		// Loop as long as we haven't reached root and parent's key less than new node
		while (index > 0 && heapArray[parentIndex].getKey() < nodeToInsert.getKey()) {
			heapArray[index] = heapArray[parentIndex];
			index = parentIndex;
			parentIndex = (parentIndex - 1) / 2;
		}
		heapArray[index] = nodeToInsert;
	}
}
