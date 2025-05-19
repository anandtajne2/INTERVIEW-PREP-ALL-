package numbers;

import java.util.Scanner;

public class Fibonnaci {

	public static void main(String[] args) {
		int num, a = 0, b = 0, c = 1;
		Scanner scanner = new Scanner(System.in);
		num = scanner.nextInt();
		for (int i = 1; i <= num; i++) {
			a = b;
			b = c;
			c = a + b;
			System.out.println("steps of factorial " + a);
		}
		System.out.println("factorial no of : " + num + " is " + a);
	}

}
