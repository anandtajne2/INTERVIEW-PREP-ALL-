package strings;

import java.util.HashMap;
import java.util.Map;

public class CountRepeatedWordUsingMap {

	public static void main(String[] args) {
		String str = "this is is done by by anand tajne";
		String[] arr = str.split(" ");

		Map<String, Integer> map = new HashMap<String, Integer>();
		for (String key : arr) {
			if (map.containsKey(key)) {
				map.put(key, map.get(key) + 1);
			} else {
				map.put(key, 1);
			}
		}
		System.out.println(map);
		for (Map.Entry<String, Integer> entry : map.entrySet()) {
			if (entry.getValue() > 1) {
				System.out.println("key : " + entry.getKey() + " value : " + entry.getValue());
			}
		}
	}
}