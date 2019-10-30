package leetCode;

public class LongestCommonSubstring {
	public int longestCommonSubsequenceLen(final String text1, final String text2) {
		final char[] s1 = text1.toCharArray();
		final char[] s2 = text2.toCharArray();

		final int l1 = s1.length;
		final int l2 = s2.length;
		final int[][] dp = new int[l1 + 1][l2 + 1];

		for (int i = 0; i <= l1; i++)
			for (int j = 0; j <= l2; j++) {
				if (i == 0 || j == 0)
					dp[i][j] = 0;
				else if (s1[i - 1] == s2[j - 1])
					dp[i][j] = 1 + dp[i - 1][j - 1];
				else
					dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
			}
		return dp[l1][l2];
	}

	// HackeRank
	public int[] longestCommonSubsequence(final int[] s1, final int[] s2) {
		final int l1 = s1.length;
		final int l2 = s2.length;
		final int[][] dp = new int[l1 + 1][l2 + 1];
		for (int i = 0; i <= l1; i++)
			for (int j = 0; j <= l2; j++) {
				if (i == 0 || j == 0)
					dp[i][j] = 0;
				else if (s1[i - 1] == s2[j - 1])
					dp[i][j] = 1 + dp[i - 1][j - 1];
				else
					dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
			}

		int k = dp[l1][l2] - 1;
		final int[] subSeq = new int[k + 1];
		int i = l1;
		int j = l2;
		while (k >= 0 && i > 0 && j > 0) {
			if (s1[i - 1] == s2[j - 1]) {
				subSeq[k--] = s1[i - 1];
				i--;
				j--;
			} else if (dp[i - 1][j] > dp[i][j - 1])
				i--;
			else
				j--;
		}
		return subSeq;
	}

	public static void main(final String[] args) {
		final LongestCommonSubstring cls = new LongestCommonSubstring();
		final int[] i1 = { 1, 2, 3, 4, 1 };
		final int[] i2 = { 3, 4, 1, 2, 1, 3 };
		System.out.println(cls.longestCommonSubsequence(i1, i2));
	}
}
