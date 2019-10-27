package leetCode;

public class LongestPalindrome {

	public String longestPalindrome(String s) {
		int leftIdx = 0;
		String ans = "";
		char[] cArr = s.toCharArray();

		for (int i = 0; i < cArr.length; i++) {
			System.out.println(ans);
			if (cArr[leftIdx] == cArr[i]) {
				if (ans.length() < 1 + i - leftIdx)
					ans = s.substring(leftIdx, i);
			} else
				while (leftIdx <= i) {
					if (cArr[leftIdx] == cArr[i])
						break;
					else
						leftIdx++;
				}
		}

		return ans;
	}

	public static void main(final String[] args) {
		LongestPalindrome cls = new LongestPalindrome();
		System.out.println(cls.longestPalindrome("babad"));
	}
}
