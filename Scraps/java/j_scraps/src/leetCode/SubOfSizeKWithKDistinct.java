package leetCode;

import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class SubOfSizeKWithKDistinct {

	public int inc(Map<Character, Integer> map, char a) {
		int c = map.getOrDefault(a, 0) + 1;
		map.put(a, c);
		return c;
	}

	public int dec(Map<Character, Integer> map, char a) {
		int c = map.getOrDefault(a, 0) - 1;
		if (c <= 0)
			map.remove(a);
		else
			map.put(a, c);
		return c;
	}

	public Collection<String> subOfSizeKWithKDistinct(final String s, final int k) {
		final Map<Character, Integer> map = new HashMap<>();
		Set<String> ans = new HashSet<>();

		String sub = s.substring(0, k);
		char[] cArr = sub.toCharArray();

		for (char c: cArr)
			inc(map, c);

		if (map.size() == k)
			ans.add(sub);

		System.out.println(sub + "   " + map);

		dec(map, cArr[0]);
		int i = 1;
		int j = k + 1;

		while (j <= s.length()) {
			sub = s.substring(i, j);
			cArr = sub.toCharArray();
			inc(map, cArr[k - 1]);

			System.out.println(sub + "   " + map);

			if (map.size() == k)
				ans.add(sub);

			dec(map, cArr[0]);

			i++;
			j++;
		}
		return ans;
	}

	public static void main(final String[] args) {
		SubOfSizeKWithKDistinct cls = new SubOfSizeKWithKDistinct();
//		final int[] A = { 1, 2, 1, 2, 3 };
		String s = "awaglknagawunagwkwagl";
		System.out.println(cls.subOfSizeKWithKDistinct(s, 4));
	}
}
