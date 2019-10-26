package leetCode;

import java.util.HashMap;
import java.util.Map;

public class SubarraysWithKDistinct {

	public int inc(Map<Integer, Integer> map, int a) {
		int c = map.getOrDefault(a, 0) + 1;
		map.put(a, c);
		return c;
	}

	public int dec(Map<Integer, Integer> map, int a) {
		int c = map.getOrDefault(a, 0) - 1;
		if (c <= 0)
			map.remove(a);
		else
			map.put(a, c);
		return c;
	}

	public int subarraysWithKDistinct(final int[] A, final int K) {
		final Map<Integer, Integer> map = new HashMap<>();
		int count = 0;
		int windowC = 0;
		int i = 0;
		int j = 0;

		while (j < A.length) {
			inc(map, A[j]);
			if (map.size() > K) {
				dec(map, A[i]);
				windowC = 0;
				i++;
			}
			while (map.getOrDefault(A[i], 0) > 1) {
				dec(map, A[i]);
				i++;
				windowC++;
			}
			if (map.size() == K) {
				count += windowC + 1;
			}
			j++;
		}
		return count;
	}

	public static void main(final String[] args) {
		SubarraysWithKDistinct cls = new SubarraysWithKDistinct();
		final int[] A = { 1, 2, 1, 2, 3 };
		System.out.println(cls.subarraysWithKDistinct(A, 2));
	}
}
