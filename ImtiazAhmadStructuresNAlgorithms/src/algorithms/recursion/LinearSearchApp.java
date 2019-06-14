package algorithms.recursion;

public class LinearSearchApp {

	public static void main(String[] args) {
		System.out.println(linearSearch(new int[] { -200, -39, 3, 29, 56, 95, 200, 344, 500, 688 }, 0, 1000));
	}

	public static int linearSearch(int[] a, int i, int x) {
		if (i > a.length - 1) {
			return -1;
		} else if (a[i] == x) {
			return i;
		} else {
			return linearSearch(a, i + 1, x);
		}
	}

}
