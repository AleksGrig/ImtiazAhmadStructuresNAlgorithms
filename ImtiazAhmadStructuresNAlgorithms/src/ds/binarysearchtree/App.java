package ds.binarysearchtree;

public class App {

	public static void main(String[] args) {
		BinarySearchTree tree = new BinarySearchTree();
		tree.insert(20, "Five");
		tree.insert(10, "Sixty six");
		tree.insert(30, "Twenty five");
		tree.insert(5, "One");
		tree.insert(11, "One");
		tree.insert(25, "One");
		tree.insert(40, "One");

		tree.displayTree();
		tree.displayTreeInstructor();

		tree.remove(20);

		tree.displayTree();
		tree.displayTreeInstructor();

		tree.remove(10);

		tree.displayTreeInstructor();
	}

}
