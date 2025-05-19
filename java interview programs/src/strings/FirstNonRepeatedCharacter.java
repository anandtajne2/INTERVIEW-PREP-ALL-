package strings;

import java.util.LinkedHashMap;
import java.util.Map;

public class FirstNonRepeatedCharacter {

	public static void main(String[] args) {
		String str = "hello world";
		boolean flag = true;

		// 1. using index of and last index comparing
		for (char ch : str.toCharArray()) {
			if (str.indexOf(ch) == str.lastIndexOf(ch)) {
				System.out.println("1st non repeated character : " + ch);
				flag = false;
				break;
			}
		}
		if (flag == true) {
			System.out.println("Non repeated character not found!!");
		}

		// 2. using linked hash map
		char result = findFirstNonRepeatedChar(str);
		System.out.println("-------------- using map - linked list --------------");
		if (result != '\0') {
			System.out.println("First non-repeated character: " + result);
		} else {
			System.out.println("No non-repeated character found.");
		}
	}

	private static char findFirstNonRepeatedChar(String str) {
		Map<Character, Integer> map = new LinkedHashMap<>();

		// Count occurrences of each character
		for (char ch : str.toCharArray()) {
			map.put(ch, map.getOrDefault(ch, 0) + 1);
		}

		// Find the first character with a count of 1
		for (Map.Entry<Character, Integer> entry : map.entrySet()) {
			if (entry.getValue() == 1) {
				return entry.getKey();
			}
		}
		return '\0';
	}

}
