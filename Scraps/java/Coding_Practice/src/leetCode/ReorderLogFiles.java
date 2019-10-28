package leetCode;

import java.util.Arrays;
import java.util.Comparator;

public class ReorderLogFiles {

	class Sorter implements Comparator<String> {
		@Override
		public int compare(final String s1, final String s2) {
			final int i1 = s1.indexOf(" ") + 1;
			final int i2 = s2.indexOf(" ") + 1;
			final boolean is1 = Character.isDigit(s1.charAt(i1));
			final boolean is2 = Character.isDigit(s2.charAt(i2));

			if (is1)
				if (is2)
					return 0;
				else
					return +1;
			else {
				if (is2)
					return -1;
				else {
					final String newS1 = s1.substring(i1);
					final String newS2 = s2.substring(i2);
					final int result = newS1.compareTo(newS2);
					if (result != 0)
						return result;
					else
						return s1.compareTo(s2);
				}
			}
		}
	}

	Sorter sorter = new Sorter();

	public String[] reorderLogFiles(final String[] logs) {
		Arrays.sort(logs, sorter);
		return logs;
	}

	public static void main(final String[] args) {
		final String[] s = { "dig1 8 1 5 1", "let1 art can", "dig2 3 6",
				"let2 own kit dig", "let3 art zero" };
		final ReorderLogFiles r = new ReorderLogFiles();
		System.out.println(r.reorderLogFiles(s));
	}

}
