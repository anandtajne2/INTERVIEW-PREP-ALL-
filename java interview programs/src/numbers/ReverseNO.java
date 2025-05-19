package numbers;

public class ReverseNO {

	public static void main(String[] args) {
		int num = 876;
		int result = 0;

		while (num != 0) {
			int reminder = num % 10;
			result = result * 10 + reminder;
			num = num / 10;
		}
		System.out.println("reverse no : " + result);
	}

}
