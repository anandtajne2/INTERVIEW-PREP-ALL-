package numbers;

import java.util.Scanner;

public class FibonacciSerise {

	public static void main(String[] args) {
		int num, a = 0, b = 0, c = 1;
		Scanner scanner = new Scanner(System.in);
		num = scanner.nextInt();
		for (int i = 0; i < num; i++) {
			a = b;
			b = c;
			c = a + b;
		}
		System.out.println(a + " fibonacci serise");
	}

}
