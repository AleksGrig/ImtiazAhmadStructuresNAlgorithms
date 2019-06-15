package algorithms.selectionsort;

public class App {

	public static void main(String[] args) {
		int[] myArray = selectionSort(new int[] { 200, 34, 8, 66, 1, 45, 100 });
		for (int i : myArray) {
			System.out.print(i + " ");
		}
	}

	public static int[] selectionSort(int[] a) {
		for (int i = 0; i < a.length - 1; i++) {
			int min = i;
			for (int j = i + 1; j < a.length; j++) {
				if (a[j] < a[min]) {
					min = j;
				}
			}
			int temp = a[i];
			a[i] = a[min];
			a[min] = temp;
		}
		return a;
	}
}
