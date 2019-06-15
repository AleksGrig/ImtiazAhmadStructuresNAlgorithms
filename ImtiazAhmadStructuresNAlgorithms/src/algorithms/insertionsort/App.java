package algorithms.insertionsort;

public class App {

	public static void main(String[] args) {
		int[] myArray = insertionSort(new int[] { 200, 34, 8, 66, 1, 45, 100 });
		System.out.println();
		System.out.println("****************************************************");
		System.out.println("Sorted array");
		for (int i : myArray) {
			System.out.print(i + " ");
		}
	}

	public static int[] insertionSort(int[] a) {
		for (int i = 1; i < a.length; i++) {
			int element = a[i];
			int j = i - 1;
			while (j >= 0 && a[j] > element) {
				a[j + 1] = a[j];
				j--;
			}
			a[j + 1] = element;
		}
		return a;
	}

}
