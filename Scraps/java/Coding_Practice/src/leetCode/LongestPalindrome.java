package leetCode;

import static util.Utils.print;

public class LongestPalindrome {

	public String longestPalindrome(final String s) {
		final char[] cArr = s.toCharArray();
		final boolean[][] dp = new boolean[cArr.length][cArr.length];
		int length = 0;
		int start = 0;

		for (int i = 0; i < cArr.length; ++i) {
			length = 1;
			dp[i][i] = true;
		}

		for (int i = 0; i < dp.length - 1; ++i)
			if (cArr[i] == cArr[i + 1]) {
				dp[i][i + 1] = true;
				start = i;
				length = 2;
			}

		// k is the size of our window
		for (int k = 3; k <= dp.length; ++k)
			for (int i = 0; i < dp.length - k + 1; ++i) {
				final int j = i + k - 1;
				if (dp[i + 1][j - 1] && cArr[i] == cArr[j]) {
					dp[i][j] = true;
					if (k > length) {
						start = i;
						length = k;
					}
				}
			}
		return s.substring(start, start + length);
	}

	public static void main(final String[] args) {
		final LongestPalindrome cls = new LongestPalindrome();
		print(cls.longestPalindrome("babad"));
	}
}
