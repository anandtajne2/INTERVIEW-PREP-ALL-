package strings;

import java.util.Arrays;

public class AnagramOfString {

	public static void main(String[] args) {
		String str1 = "below";
		String str2 = "elbow";

		// String e.g mary-army | race-care | 
		
		str1 = str1.toLowerCase();
		str2 = str2.toLowerCase();

		char[] arr1 = str1.toCharArray();
		char[] arr2 = str2.toCharArray();

		Arrays.sort(arr1);
		Arrays.sort(arr2);
		
		if (Arrays.equals(arr1,arr2)) {
			System.out.println("String is Anagram");
		}else {
			System.out.println("String is Not Anagram");
		}
	}
}