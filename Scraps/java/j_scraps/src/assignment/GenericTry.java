package assignment;

import java.util.ArrayList;
import java.util.List;

public class GenericTry {

	public static void main(String[] args) {
		List<? super Long> ol = new ArrayList<Long>();
//		ol.add("");
		ol.add(new Long(1));
//		Long l = ol.get(0);
		Object[] x = new String[1];
		x[0] = 1;
		System.out.println(x);

		List<Object> l = new ArrayList<Object>();
		l.add(new Integer(1));
	}

	<E> List<E> func() {
		return new ArrayList<E>();
	}

	public static <T> T getObjectFrom(List<T> list) {
		return list.get((int) (Math.random() * list.size())); // return random element
																// from list.
	}
}
