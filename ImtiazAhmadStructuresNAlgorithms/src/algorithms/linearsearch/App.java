package algorithms.linearsearch;

public class App {

	public static void main(String[] args) {
		Object[] array = { 0, -39, 350, 269, 56, 95, -400, 44, 1000, 488 };
		System.out.println(linearSearch(array, 56));
	}

	public static int linearSearch(Object[] a, Object x) {
		for (int j = 0; j < a.length; j++) {
			if (a[j].equals(x)) {
				return j;
			}
		}
		return -1;
	}
}
