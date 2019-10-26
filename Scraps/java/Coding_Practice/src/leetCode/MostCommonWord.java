package leetCode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class MostCommonWord {

	static public String mostCommonWord(String paragraph, String[] banned) {
		Map<String, Integer> map = new HashMap<>();
		Set<String> banSet = new HashSet<>();

		for (String s: banned)
			banSet.add(s);

		int maxC = -1;
		String best = null;

		for (String s: paragraph.split("\\s+|!|\\?|'|,|;|\\.")) {
			String retval = s.toLowerCase();
			if (!retval.isEmpty() && !banSet.contains(retval)) {
				Integer count = map.getOrDefault(retval, 0) + 1;
				map.put(retval, count);
				if (count > maxC) {
					best = retval;
					maxC = count;
				}
			}
		}
		return best;
	}

	public static void main(String[] args) {
		System.out.println(
				mostCommonWord("Bob hit a ball, the hit BALL flew far after it was hit.",
						new String[] { "hit" }));
	}

}
