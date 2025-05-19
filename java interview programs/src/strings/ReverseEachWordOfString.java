package strings;

import java.util.Arrays;
import java.util.stream.Collectors;

public class ReverseEachWordOfString {

	public static void main(String[] args) {

		// 1. using split method and nested while loop
		String input = "Hello World from Java";
		String result = "";

		String[] words = input.split(" ");
		for (String word : words) {
			int j = word.length() - 1;
			String revWord = "";
			while (j >= 0) {
				revWord += word.charAt(j);
				j--;
			}
			result += revWord + " ";
		}
		System.out.println("result : " + result);

		// 2. using string builder reverse and append method
		String reversed = reverseEachWord(input);
		System.out.println("------------ using string builder reverse and append method ---------------");
		System.out.println(reversed);

		// 3. Using Java 8 Streams
		System.out.println("------------ Using Java 8 Streams ---------------");
		String reverseWords = Arrays.stream(input.split(" ")).map(word -> new StringBuilder(word).reverse().toString())
				.collect(Collectors.joining(" "));
		System.out.println(reverseWords);
	}

	private static String reverseEachWord(String input) {
		String[] words = input.split(" ");
		StringBuilder result = new StringBuilder();
		for (String word : words) {
			StringBuilder reverseWord = new StringBuilder(word);
			result.append(reverseWord.reverse()).append(" ");
		}
		return result.toString().trim();
	}
}
