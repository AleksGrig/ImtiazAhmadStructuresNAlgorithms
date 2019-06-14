package algorithms.recursion;

public class BinarySearchApp {

	public static void main(String[] args) {
		int[] array = new int[] { -200, -39, 3, 29, 56, 95, 200, 344, 500, 688 };
		System.out.println(binarySearch(array, 0, array.length - 1, -200));
	}

	public static int binarySearch(int[] a, int p, int r, int x) {
		if (p > r) {
			return -1;
		} else {
			int q = (p + r) / 2;
			if (a[q] == x) {
				return q;
			} else if (a[q] > x) {
				return binarySearch(a, p, q - 1, x);
			} else {
				return binarySearch(a, q + 1, r, x);
			}
		}
	}
}
