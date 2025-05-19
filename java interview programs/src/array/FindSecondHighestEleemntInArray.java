package array;

import java.util.Arrays;
import java.util.Random;

public class FindSecondHighestEleemntInArray {

	public static void main(String[] args) {
		int[] arr = new int[10];

		Random random = new Random();

		for (int i = 0; i < arr.length; i++) {
			arr[i] = random.nextInt(50);
		}

		System.out.println("array : " + Arrays.toString(arr));
		Arrays.sort(arr);
		System.out.println("sorted array : " + Arrays.toString(arr));

		int highest = arr[0];
		int secondHighest = arr[0];

		for (int i = 0; i < arr.length; i++) {
			if (arr[i] > highest) {
				secondHighest = highest;
				highest = arr[i];
			} else if (arr[i] > secondHighest) {
				secondHighest = arr[i];
			}
		}
		System.out.println("highest no : " + highest);
		System.out.println("second highest no : " + secondHighest);
	}

}
