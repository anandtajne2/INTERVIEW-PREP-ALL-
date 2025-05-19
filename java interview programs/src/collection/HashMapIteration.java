package collection;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class HashMapIteration {

	public static void main(String[] args) {

		Map<Integer, String> map = new HashMap<Integer, String>();
		map.put(2, "Saket");
		map.put(25, "Saurav");
		map.put(12, "HashMap");
		System.out.println(map.size());
		System.out.println("---------- While Loop ----------");
		// 1. using iterator
		Iterator itr = map.entrySet().iterator();
		while (itr.hasNext()) {
			Map.Entry<Integer, String> entry = (Map.Entry<Integer, String>) itr.next();
			System.out.println("Key is " + entry.getKey() + " Value is " + entry.getValue());
		}
		System.out.println("---------- For Loop ----------");
		// 2. using enhance for loop
		for (Map.Entry<Integer, String> entry : map.entrySet()) {
			System.out.println("Key is " + entry.getKey() + " Value is " + entry.getValue());
		}
	}

}
