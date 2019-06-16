package algorithms.recursion.mergesort;

public class MergeSort {

	public void sort(int[] a) {
		divide(a, 0, a.length - 1);
	}

	private void divide(int[] a, int p, int r) {
		if (r <= p) {
			return;
		}

		int q = (p + r) / 2;
		divide(a, p, q);
		divide(a, q + 1, r);
		merge(a, p, q, r);
	}

	@SuppressWarnings("unused")
	private void merge(int[] a, int p, int q, int r) {
		int leftCount = q - p + 1;
		int rightCount = r - q;
		int[] left = new int[leftCount + 1];
		int[] right = new int[rightCount + 1];
		for (int i = 0; i < leftCount; i++) {
			left[i] = a[p + i];
		}
		for (int j = 0; j < rightCount; j++) {
			right[j] = a[q + 1 + j];
		}
		left[leftCount] = Integer.MAX_VALUE;
		right[rightCount] = Integer.MAX_VALUE;
		int i = 0;
		int j = 0;
		for (int k = p; k <= r; k++) {
			if (left[i] < right[j]) {
				a[k] = left[i];
				i++;
			} else {
				a[k] = right[j];
				j++;
			}
		}
	}

	@SuppressWarnings("unused")
	private void merge2(int[] a, int p, int q, int r) {
		int[] temp = new int[r - p + 1];
		int i = p;// Counter for the left side of array
		int j = q + 1;// Counter for the right side of array
		int k = 0;// Position in merging array

		while (i <= q && j <= r) {
			if (a[i] < a[j]) {
				temp[k] = a[i];
				i++;
			} else {
				temp[k] = a[j];
				j++;
			}
			k++;
		}

		// Only one of sub-arrays reached the end after loop above, so we need to dump
		// the other one into merging array
		if (i <= q) {
			while (i <= q) {
			temp[k] = a[i];
			i++;
			k++;
			}
		} else if (j <= r) {
			while (j <= r) {
			temp[k] = a[j];
			j++;
			k++;
			}
		}

		// Copy the temporary array into appropriate slots of input array
		for (int m = 0; m < temp.length; m++) {
			a[p + m] = temp[m];
		}
	}

}
