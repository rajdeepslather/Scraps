package leetCode;

public class SubarraysWithKDistinct2 {

	public int inc(int[] arr, int distinct, int a) {
		int c = arr[a];
		if (c == 0)
			distinct++;
		arr[a] = c + 1;
		return distinct;
	}

	public int dec(int[] arr, int distinct, int a) {
		int c = arr[a];
		if (c == 1)
			distinct--;
		if (c > 0)
			arr[a] = c - 1;
		return distinct;
	}

	public int subarraysWithKDistinct(final int[] A, final int K) {
		int distinct = 0;
		int[] arr = new int[20001];

		int count = 0;
		int windowC = 0;
		int i = 0;
		int j = 0;

		while (j < A.length) {
			distinct = inc(arr, distinct, A[j]);
			if (distinct > K) {
				distinct = dec(arr, distinct, A[i]);
				windowC = 0;
				i++;
			}
			while (arr[A[i]] > 1) {
				distinct = dec(arr, distinct, A[i]);
				i++;
				windowC++;
			}
			if (distinct == K) {
				count += windowC + 1;
			}
			j++;
		}
		return count;
	}

	public static void main(final String[] args) {
		SubarraysWithKDistinct2 cls = new SubarraysWithKDistinct2();
		final int[] A = { 1, 2, 1, 2, 3 };
		System.out.println(cls.subarraysWithKDistinct(A, 2));
	}
}
