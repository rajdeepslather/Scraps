package leetCode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MinPathSum {
	public int optimumPathSum(int[][] grid, boolean min) {
		int[][] hist = new int[grid.length][grid[0].length];
		for (int i = 0; i < grid.length; i++) {
			for (int j = 0; j < grid[0].length; j++) {
				if (i > 0 && j > 0)
					if (min ^ !(hist[i - 1][j] < hist[i][j - 1]))
						hist[i][j] = grid[i][j] + hist[i - 1][j];
					else
						hist[i][j] = grid[i][j] + hist[i][j - 1];
				else if (i > 0)
					hist[i][j] = grid[i][j] + hist[i - 1][j];
				else if (j > 0)
					hist[i][j] = grid[i][j] + hist[i][j - 1];
				else
					hist[i][j] = grid[i][j];
			}
		}
		return hist[grid.length - 1][grid[0].length - 1];
	}

	public int minPathSum(int[][] grid) {
		return optimumPathSum(grid, true);
	}

	public int maxMinPathSum(int[][] grid) {
		int r = grid.length, c = grid[0].length;

		int[][] hist = new int[r][c];
		hist[0][0] = Integer.MAX_VALUE;

		for (int i = 1; i < r; ++i)
			hist[i][0] = Math.min(hist[i - 1][0], grid[i][0]);
		for (int j = 1; j < c; ++j)
			hist[0][j] = Math.min(hist[0][j - 1], grid[0][j]);

		for (int i = 1; i < r; ++i)
			for (int j = 1; j < c; ++j) {
				int score1 = Math.min(hist[i][j - 1], grid[i][j]); // left
				int score2 = Math.min(hist[i - 1][j], grid[i][j]); // up
				hist[i][j] = Math.max(score1, score2);
			}
		return Math.max(hist[r - 2][c - 1], hist[r - 1][c - 2]);
	}

	public static void main(final String[] args) {
		MinPathSum cls = new MinPathSum();
//		int[][] grid = { { 1, 2, 3 }, { 4, 5, 1 } };
//		int[][] grid = { { 5, 1 }, { 4, 5 } };

		int[][] grid1 = new int[][] { { 5, 1 }, { 4, 5 } }; // 4
		int[][] grid2 = new int[][] { { 5, 1, 7 }, { 4, 8, 5 } }; // 4
		int[][] grid3 = new int[][] { { 1, 9, 9 }, { 9, 9, 9 }, { 9, 9, 9 } }; // 9
		int[][] grid4 = new int[][] { { 10, 7, 3 }, { 12, 11, 9 }, { 1, 2, 8 } }; // 9
		int[][] grid5 = new int[][] { { 20, 20, 3 }, { 20, 3, 20 }, { 3, 20, 20 } }; // 3
		System.out.println("grid1: Expected: 4, Actual: " + cls.maxMinPathSum(grid1));
		System.out.println("grid2: Expected: 4, Actual: " + cls.maxMinPathSum(grid2));
		System.out.println("grid3: Expected: 9, Actual: " + cls.maxMinPathSum(grid3));
		System.out.println("grid4: Expected: 9, Actual: " + cls.maxMinPathSum(grid4));
		System.out.println("grid5: Expected: 3, Actual: " + cls.maxMinPathSum(grid5));
	}
}