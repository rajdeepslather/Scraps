package leetCode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class MostCommonWord {

	static public String mostCommonWord(final String paragraph, final String[] banned) {
		final Map<String, Integer> map = new HashMap<>();
		final Set<String> banSet = new HashSet<>(banned.length);

		for (final String s: banned)
			banSet.add(s);

		int maxC = -1;
		String best = null;

		for (final String retval: paragraph.toLowerCase().split("\\s+|!|\\?|'|,|;|\\.")) {
			if (!retval.isEmpty() && !banSet.contains(retval)) {
				final Integer c = map.getOrDefault(retval, 0) + 1;
				map.put(retval, c);
				if (c > maxC) {
					best = retval;
					maxC = c;
				}
			}
		}
		return best;
	}

	public static void main(final String[] args) {
		System.out.println(
				mostCommonWord("Bob hit a ball, the hit BALL flew far after it was hit.",
						new String[] { "hit" }));
	}

}
