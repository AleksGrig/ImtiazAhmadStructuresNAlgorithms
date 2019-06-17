package algorithms.recursion.quicksort;

public class App {

	public static void main(String[] args) {
		int[] myArray = new int[] { 200, 34, 8, 66, 1, 45, 100 };
		QuickSort sorter = new QuickSort();
		sorter.quickSort(myArray, 0, myArray.length - 1);
		for (int i : myArray) {
			System.out.print(i + " ");
		}

	}

}
