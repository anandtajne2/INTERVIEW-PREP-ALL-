package numbers;

public class CheckPrimeNo {

	public static void main(String[] args) {
		int num = 17, temp = 0;
		boolean isPrime = true;
		for (int i = 2; i < num / 2; i++) {
			temp = num % i;
			if (temp == 0) {
				isPrime = false;
				break;
			}
		}
		if (isPrime) {
			System.out.println(num + " no is prime");
		} else {
			System.out.println(num + " no is not prime");
		}
	}

}
