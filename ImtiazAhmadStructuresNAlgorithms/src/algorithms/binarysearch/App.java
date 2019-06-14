package algorithms.binarysearch;

public class App {

	public static void main(String[] args) {
		System.out.println(binarySearch(new int[] { -200, -39, 3, 29, 56, 95, 200, 344, 500, 688 }, 95));
	}

	public static int binarySearch(int[] a, int x) {
		int p = 0;
		int r = a.length - 1;
		int q = 0;
		while (p <= r) {
			q = (p + r) / 2;
			if (a[q] == x) {
				return q;
			} else if (a[q] < x) {
				p = q + 1;
			} else {
				r = q - 1;
			}
		}
		return -1;
	}

}
