package numbers;

public class SwappingNumber {

	public static void main(String[] args) {
		int x = 20, y = 30, temp = 0;

		// using 3rd variable to swap no
		System.out.println("before swapping : " + "x : " + x + " y : " + y);

		temp = x;
		x = y;
		y = temp;

		System.out.println("after swapping : " + "x : " + x + " y : " + y);

		// without using 3rd variable
		System.out.println("before swapping : " + "x : " + x + " y : " + y);

		x = x + y;
		y = x - y;
		x = x - y;

		System.out.println("after swapping : " + "x : " + x + " y : " + y);
	}
}