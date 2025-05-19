package strings;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class CountWordOccurrenceInSentence {

	public static void main(String[] args) {

		String str = "GeeksForGeeks a computer science portal for geesk portal";
		String word = "portal";

		// 1. using for each to compare word
		String arr[] = str.split(" ");
		int count = 0;
		for (String words : arr) {
			if (words.equalsIgnoreCase(word)) {
				count++;
				System.out.println(" " + words + " count " + count);
			}
		}

		// 2. using collections frequency to find repeated word
		System.out.println("-------------- using collections frequncy ---------------");
		List<String> wordList = Arrays.asList(str.split(" "));
		int count2 = Collections.frequency(wordList, word);
		System.out.println(" " + word + " count " + count2);

	}

}
