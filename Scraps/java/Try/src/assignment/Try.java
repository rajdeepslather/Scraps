package assignment;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class Try {
	
	

	public static void main(String[] args) {

		Set<ArrayList<String>> s = new HashSet<ArrayList<String>>(); // AF(s) = {}
		ArrayList<String> x = new ArrayList<String>(); // AF(x) = []
		ArrayList<String> y = new ArrayList<String>(); // AF(y) = []
		s.add(x); // AF(s) = {[]}
		s.add(y); // AF(s) = {[], []}? Or {[]}?
		s.contains(y); // true or false?
		y.add("cat"); // AF(y) = [“cat”]
						// AF(s) = ?????
		s.contains(y); // true or false?
		s.add(y); // s.state = {[], [“cat”]}???
		y.remove("cat"); // s.state = {[], []} ??? !!!!
		System.out.println(s);
		System.out.println(s.contains(y));
		System.out.println(s.contains(x));
		s.remove(y);
		System.out.println(s);
		System.out.println(s.contains(y));
		System.out.println(s.contains(x));
	}
}
