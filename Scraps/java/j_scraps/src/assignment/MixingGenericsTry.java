package assignment;

import java.util.ArrayList;
import java.util.List;

public class MixingGenericsTry {
	public static void main(String[] args) {
		List<String> strings = new ArrayList<String>();
		strings.add("test");
		print(strings);
		print2(strings);

		unsafeAdd(strings, new Integer(42));
		String s = strings.get(0); // Exception from compiler generated cast
	}

	// note use of raw types
	private static void unsafeAdd(List list, Object o) {
		list.add(o);
	}

	private static <T extends String> void print(List<T> list) {
		for (T t : list) {
			System.out.println(t);
		}
	}

	private static void print2(List<? extends String> list) {
		for (String t : list) {
			System.out.println(t);
		}
	}

}
