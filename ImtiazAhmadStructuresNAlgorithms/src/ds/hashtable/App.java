package ds.hashtable;

public class App {

	public static void main(String[] args) {
		HashTable hashTable = new HashTable(111);
		hashTable.insert("Apple");
		hashTable.insert("Pear");
		hashTable.insert("Melon");
		hashTable.insert("Cucumber");
//		hashTable.insert("Tomato");
//		hashTable.insert("Potato");
		hashTable.insert("BMW");
		hashTable.displayTable();

//		System.out.println("Element found is " + hashTable.find("Apple"));
//		System.out.println("Element found is " + hashTable.find("Carrot"));
//		System.out.println("Element found is " + hashTable.find("Potato"));
	}

}
