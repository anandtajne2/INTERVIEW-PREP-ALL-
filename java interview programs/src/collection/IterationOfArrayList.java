package collection;

import java.util.ArrayList;
import java.util.Iterator;

public class IterationOfArrayList {

	public static void main(String[] args) {
		ArrayList list = new ArrayList();
		list.add("20");
		list.add("30");
		list.add("40");
		System.out.println(list.size());
		System.out.println("While Loop");
		Iterator iterator = list.iterator();
		while (iterator.hasNext()) {
			System.out.println(iterator.next());
		}

		System.out.println("Advanced For Loop");
		for (Object object : list) {
			System.out.println(object);
		}

		System.out.println("For Loop");
		for (int i = 0; i < list.size(); i++) {
			System.out.println(list.get(i));
		}
	}

}
