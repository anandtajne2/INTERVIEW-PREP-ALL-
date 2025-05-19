package numbers;

public class FactorialNo {

	public static void main(String[] args) {
		int num = 5;
		int fact = 1;
		for (int i = 1; i <= num; i++) {
			fact *= i;
		}
		System.out.println("factorial of given no " + num + " is " + fact);
	}

}
