package leetCode;

public class SearchMatrix {
	public boolean searchMatrix(final int[][] matrix, final int target) {
		final boolean result = false;
		int i = 0;
		int j = 0;

		if (matrix == null)
			return false;

		final int li = matrix.length;
		int lj;
		if (li == 0)
			return false;
		else
			lj = matrix[0].length;

		if (lj == 0)
			return false;
		while (i < li && j < lj) {
			if (matrix[i][j] == target)
				return true;
			else if (j < lj - 1) {
				if (matrix[i][j + 1] == target)
					return true;
				else if (matrix[i][j + 1] < target)
					j++;
				else {
					i++;
					j = 0;
				}
			} else if (i < li - 1) {
				if (matrix[i + 1][j] == target)
					return true;
				else if (matrix[i + 1][j] < target)
					i++;
				else {
					i++;
					j = 0;
				}
			} else
				return false;
		}
		return result;
	}

	public static void main(final String[] args) {
		final SearchMatrix s = new SearchMatrix();
		final int[][] m = { { 1, 4, 7, 11, 15 }, { 2, 5, 8, 12, 19 }, { 3, 6, 9, 16, 22 },
				{ 10, 13, 14, 17, 24 }, { 18, 21, 23, 26, 30 } };

		final int[][] m1 = { {} };
		System.out.println(s.searchMatrix(m1, 5));
	}

}
