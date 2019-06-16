package algorithms.recursion.mergesort;

public class App {

	public static void main(String[] args) {
		int[] myArray = new int[] { 9, 7, 3, 1, 6, 3, 2, 6, 8, 9, 2, 3, 0 };
		MergeSort sorter = new MergeSort();
		sorter.sort(myArray);
		for (int i : myArray) {
			System.out.print(i + " ");
		}
	}

}
