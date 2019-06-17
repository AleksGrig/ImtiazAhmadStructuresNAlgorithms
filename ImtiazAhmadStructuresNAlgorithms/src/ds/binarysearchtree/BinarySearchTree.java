package ds.binarysearchtree;

import java.util.ArrayList;
import java.util.Stack;

public class BinarySearchTree {

	private Node root;

	public void insert(int key, String value) {
		Node newNode = new Node(key, value);
		if (root == null) {
			root = newNode;
		} else {
			Node current = root;
			Node parent = null;
			while (true) {
				parent = current;
				if (key < current.key) {
					current = current.leftChild;
					if (current == null) {
						parent.leftChild = newNode;
						return;
					}
				} else {
					current = current.rightChild;
					if (current == null) {
						parent.rightChild = newNode;
						return;
					}
				}
			}
		}
	}

	public Node findMin() {
		Node current = root;
		Node last = null;
		while (current != null) {
			last = current;
			current = current.leftChild;
		}
		return last;
	}

	public Node findMax() {
		Node current = root;
		Node last = null;
		while (current != null) {
			last = current;
			current = current.rightChild;
		}
		return last;
	}

	public boolean remove(int key) {
		Node current = root;
		Node parent = root;
		boolean isLeftChild = false;

		// Searching to find node to delete
		while (current != null && current.key != key) {
			parent = current;
			if (key < current.key) {
				isLeftChild = true;
				current = current.leftChild;
			} else {
				isLeftChild = false;
				current = current.rightChild;
			}
		}
		// Node with key is found or equals to null
		Node nodeToDelete = current;
		if (nodeToDelete == null) {
			return false;
		}

		// We have 3 different scenarios, node has no children, one child or two
		// children.
		// We'll treat them differently

		// Node has no children
		if (nodeToDelete.leftChild == null && nodeToDelete.rightChild == null) {
			if(nodeToDelete == root) {
				root = null;
			} else if(isLeftChild) {
				parent.leftChild = null;
			} else {
				parent.rightChild = null;
			}
		} 
		// Node has one child on its left
		else if (nodeToDelete.rightChild == null) {
			if (nodeToDelete == root) {
				root = nodeToDelete.leftChild;
			} else if (isLeftChild) {
				parent.leftChild = nodeToDelete.leftChild;
			} else {
				parent.rightChild = nodeToDelete.leftChild;
			}
		}
		// Node has one child on its right
		else if (nodeToDelete.leftChild == null) {
			if (nodeToDelete == root) {
				root = nodeToDelete.rightChild;
			} else if (isLeftChild) {
				parent.leftChild = nodeToDelete.rightChild;
			} else {
				parent.rightChild = nodeToDelete.rightChild;
			}
		}
		// Node has two children
		else {
			Node successor = getSuccessor(nodeToDelete);

			// After finding of successor we need to connect parent of nodeToDelete to
			// successor
			if (nodeToDelete == root) {
				root = successor;
			} else if (isLeftChild) {
				parent.leftChild = successor;
			} else {
				parent.rightChild = successor;
			}
			successor.leftChild = nodeToDelete.leftChild;
		}
		return true;
	}

	private Node getSuccessor(Node nodeToDelete) {
		Node successorParent = nodeToDelete;
		Node successor = nodeToDelete;

		// We go to the right child
		Node current = nodeToDelete.rightChild;

		// Go left down the tree until node has no left child, is smallest on the
		// sub-tree
		while (current != null) {
			successorParent = successor;
			successor = current;
			current = current.leftChild;
		}

		// If successor is not right child
		if (successor != nodeToDelete.rightChild) {
			successorParent.leftChild = successor.rightChild;
			successor.rightChild = nodeToDelete.rightChild;
		}
		return successor;
	}

	public void displayTreeDesc() {
		if (root == null) {
			System.out.println("Tree is empty");
			return;
		} else {
			display(root);
		}
	}

	public void displayTree() {
		if (root == null) {
			System.out.println("Tree is empty");
			return;
		} else {
			ArrayList<Node> list = new ArrayList<Node>();
			list.add(root);
			while (!list.isEmpty()) {
				for (Node node : list) {
					System.out.print(node.key + " ");
				}
				System.out.println();
				ArrayList<Node> helpList = new ArrayList<Node>();
				while (!list.isEmpty()) {
					Node node = list.remove(0);
					if (node.leftChild != null) {
						helpList.add(node.leftChild);
					}
					if (node.rightChild != null) {
						helpList.add(node.rightChild);
					}
				}
				for (int i = 0; i < helpList.size(); i++) {
					list.add(helpList.get(i));
				}
			}
		}
		System.out.println();
	}

	private void display(Node root) {
		if (root.rightChild != null) {
			display(root.rightChild);
		}

		System.out.println(root.key);

		if (root.leftChild != null) {
			display(root.leftChild);
		}
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	public void displayTreeInstructor() {
		Stack globalStack = new Stack();
		globalStack.push(root);
		int nBlanks = 32;
		boolean isRowEmpty = false;
		System.out.println("......................................................");

		while (isRowEmpty == false) {
			Stack localStack = new Stack();
			isRowEmpty = true;
			for (int j = 0; j < nBlanks; j++) {
				System.out.print(" ");
			}

			while (globalStack.isEmpty() == false) {
				Node temp = (Node) globalStack.pop();
				if (temp != null) {
					System.out.print(temp.key);
					localStack.push(temp.leftChild);
					localStack.push(temp.rightChild);
					if (temp.leftChild != null || temp.rightChild != null) {
						isRowEmpty = false;
					}
				} else {
					System.out.print("--");
					localStack.push(null);
					localStack.push(null);
				}

				for (int j = 0; j < nBlanks * 2 - 2; j++) {
					System.out.print(" ");
				}
			}

			System.out.println();
			nBlanks = nBlanks / 2;

			while (localStack.isEmpty() == false) {
				globalStack.push(localStack.pop());
			}
		}
		System.out.println("......................................................");

	}
}
