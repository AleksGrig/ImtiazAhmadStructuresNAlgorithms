package ds.hashtable;

public class HashTable {

	String[] hashArray;
	int arraySize;
	int size = 0; // Number of elements in hash table

	public HashTable(int arraySize) {
		if (isPrime(arraySize)) {
			this.arraySize = arraySize;
		} else {
			this.arraySize = getNextPrime(arraySize);
			System.out.println("Given hash table size " + arraySize + " is not prime");
			System.out.println("Size is set to " + this.arraySize);
		}
		hashArray = new String[this.arraySize];
	}

	private int getNextPrime(int num) {
		for (int i = num; true; i++) {
			if (isPrime(i)) {
				return i;
			}
		}
	}

	private boolean isPrime(int num) {
		for (int i = 2; i * i <= num; i++) {
			if (num % i == 0) {
				return false;
			}
		}
		return true;
	}

	// Returns preferred index position
	private int hashFunc1(String word) {
		int hashVal = word.hashCode();
		hashVal = hashVal % arraySize;
		if (hashVal < 0) {
			hashVal += arraySize;
		}
		return hashVal;// This is ideal index position
	}

	// Returns step size greater than zero
	private int hashFunc2(String word) {
		int hashVal = word.hashCode();
		hashVal = hashVal % arraySize;
		if (hashVal < 0) {
			hashVal += arraySize;
		}
		return 3 - hashVal % 3;// Use a prime number smaller than array size
	}

	public void insert(String word) {
		if (size < arraySize) {
			int hashVal = hashFunc1(word);
			int stepSize = hashFunc2(word);

			while (hashArray[hashVal] != null) {
				hashVal = hashVal + stepSize;
				hashVal = hashVal % arraySize;
			}

			hashArray[hashVal] = word;
			System.out.println("Inserted word: " + word + "HashCode is " + hashVal);
			size++;
		} else {
			System.out.println("Hash Table is full");
		}
	}

	public String find(String word) {
		int hashVal = hashFunc1(word);
		int stepSize = hashFunc2(word);

		while (hashArray[hashVal] != null) {
			if (hashArray[hashVal].equals(word)) {
				return hashArray[hashVal];
			}
			hashVal = hashVal + stepSize;
			hashVal = hashVal % arraySize;
		}
		return hashArray[hashVal];
	}

	public void displayTable() {
		System.out.println("Table: ");
		for (int i = 0; i < arraySize; i++) {
			if (hashArray[i] != null) {
				System.out.print(hashArray[i] + " ");
			} else {
				System.out.print("** ");
			}
			System.out.println();
		}
	}

}
