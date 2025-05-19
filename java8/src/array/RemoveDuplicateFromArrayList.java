package array;

import java.util.ArrayList;
import java.util.List;

public class RemoveDuplicateFromArrayList {

	public static void main(String[] args) {
		List<String> list = new ArrayList<>();
		list.add("Apple");
		list.add("Banana");
		list.add("Cherry");
		list.add("Apple"); // Duplicate
		list.add("Elderberry");
		list.add("Fig");
		list.add("Grapes");
		list.add("Banana"); // Duplicate
		list.add("Indian Fig");
		list.add("Jackfruit");
		list.add("Kiwi");
		list.add("Lemon");
		list.add("Mango");
		list.add("Cherry"); // Duplicate
		list.add("Orange");
		list.add("Papaya");
		list.add("Quince");
		list.add("Apple"); // Duplicate
		list.add("Strawberry");
		list.add("Banana"); // Duplicate

		System.out.println(list);

		System.out.println("-------------- removing duplicate ----------------");

		list.stream().distinct().filter(f -> f.startsWith("A") || f.startsWith("M") | f.startsWith("B"))
				.forEach(System.out::println);
		
		System.out.println("List: " + String.join(", ", list));
	}

}
