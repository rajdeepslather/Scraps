package leetCode;

import java.util.HashMap;
import java.util.Map;

public class SubarraysWithKDistinct {

	static public int subarraysWithKDistinct(final int[] A, final int K) {
		final Map<Integer, Integer> history = new HashMap<>();
		int count = 0;
		int j = 0;
		for (int i = 0; i < A.length; i++) {
			while (j < A.length) {
				final int x = A[j++];
				Integer c = history.get(x);
				if (c == null)
					c = 0;
				history.put(x, c + 1);
				if (history.size() == K)
					count++;
				else if (history.size() > K)
					break;
			}
			final int x = A[i];
			final int c = history.get(x);
			if (c == 1)
				history.remove(x);
			else
				history.put(x, c - 1);
			if (history.size() == K)
				count++;
		}
		return count;
	}

	public static void main(final String[] args) {
		final int[] A = { 1, 2, 1, 2, 3 };
		System.out.println(subarraysWithKDistinct(A, 2));
	}
}
