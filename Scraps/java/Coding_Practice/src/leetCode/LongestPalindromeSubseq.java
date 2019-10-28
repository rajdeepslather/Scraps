package leetCode;

public class LongestPalindromeSubseq {
	public int longestCommonSubseq(final char[] s1, final char[] s2) {
		final int l1 = s1.length;
		final int l2 = s2.length;
		final int[][] dp = new int[l1 + 1][l2 + 1];

		for (int i = 0; i <= l1; i++)
			for (int j = 0; j <= l2; j++) {
				if (i == 0 || j == 0)
					continue;
				else if (s1[i - 1] == s2[j - 1])
					dp[i][j] = 1 + dp[i - 1][j - 1];
				else
					dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
			}
		return dp[l1][l2];
	}

	public int longestPalindromeSubseq(final String s) {
		final char[] cArr = s.toCharArray();
		final char[] rev = new char[cArr.length];
		int j = 0;
		for (int i = cArr.length - 1; i >= 0; i--)
			rev[j++] = cArr[i];

		return longestCommonSubseq(cArr, rev);
	}

	public static void main(final String[] args) {
		final LongestPalindromeSubseq cls = new LongestPalindromeSubseq();
		System.out.println(cls.longestPalindromeSubseq("abcde"));
	}
}
