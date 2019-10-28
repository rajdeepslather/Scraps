package leetCode;

public class LongestCommonSubsequence {

	public int longestCommonSubsequence(final String text1, final String text2) {
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

	public static void main(final String[] args) {
		final LongestCommonSubsequence cls = new LongestCommonSubsequence();
		System.out.println(cls.longestCommonSubsequence("abcde", "ace"));
	}
}
