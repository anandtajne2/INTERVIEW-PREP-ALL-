package sorting;

import java.util.Arrays;

public class BubbleSortTest {

	public static void main(String[] args) {
		int intArray[] = { 23, 43, 13, 65, 11, 62, 76, 83, 9, 71, 84, 34, 96, 80 };
		System.out.println("Original array: " + Arrays.toString(intArray));
		int n = intArray.length;

		for (int i = 0; i < n - 1; i++) {
			for (int j = 0; j < (n - i - 1); j++) {
				if (intArray[j] > intArray[j + 1]) {
					int temp = intArray[j];
					intArray[j] = intArray[j + 1];
					intArray[j + 1] = temp;
				}
			}
		}
		System.out.println("Sorted array: " + Arrays.toString(intArray));
//		System.out.println("---------------- using arrays sort method -------------");
//		Arrays.sort(intArray);
//		System.out.println("Sorted array: " + Arrays.toString(intArray));
	}

}
