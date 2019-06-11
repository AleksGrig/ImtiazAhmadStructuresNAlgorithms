package ds.stack;

public class App {

	public static void main(String[] args) {
		Stack stack = new Stack(4);
		stack.push('h');
		stack.push('e');
		stack.push('l');
		stack.push('p');
		stack.push('!');

		for (int i = 0; i < 10; i++) {
			System.out.println(stack.pop());
		}

		System.out.println();
		System.out.println(reverse("AureliuS"));
	}

	public static String reverse(String str) {
		char[] arr = str.toCharArray();
		Stack stack = new Stack(arr.length);

		for (int i = 0; i < arr.length; i++) {
			stack.push(arr[i]);
		}

		for (int i = 0; i < arr.length; i++) {
			arr[i] = (char) stack.pop();
		}

		return String.valueOf(arr);
	}

}
