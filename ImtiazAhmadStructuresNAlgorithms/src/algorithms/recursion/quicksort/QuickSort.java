package algorithms.recursion.quicksort;

public class QuickSort {

	public void quickSort(int[] a, int p, int r) {
		if (r > p) {
			int q = partition(a, p, r);
			quickSort(a, p, q - 1);
			quickSort(a, q + 1, r);
		}
	}

	private int partition(int[] a, int p, int r) {
		int pivot = a[r];
		int j = p;
		int i = j - 1;
		while (j < r) {
			if (a[j] > pivot) {
				j++;
			} else {
				i++;
				int temp = a[j];
				a[j] = a[i];
				a[i] = temp;
				j++;
			}
		}
		int temp = a[j];
		a[j] = a[i + 1];
		a[i + 1] = temp;
		return i + 1;
	}
}
