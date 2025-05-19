package strings;

public class PalindromeString {

	public static void main(String[] args) {
		String str = "madam";
		String temp = str;
		String result = "";

		for (int i = str.length() - 1; i >= 0; i--) {
			result += str.charAt(i);
		}
		if (result.equals(temp)) {
			System.out.println(result + " string is palindrome");
		} else {
			System.out.println(result + " string is not palindrome");
		}
	}
}