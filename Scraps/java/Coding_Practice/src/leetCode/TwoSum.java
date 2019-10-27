package leetCode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

@SuppressWarnings({ "rawtypes", "unchecked" })
public class TwoSum {

	static public int[] twoSum(int[] nums, int target) {
		Map<Integer, Integer> map = new HashMap<>(); // diff->num
		for (int j = 0; j < nums.length; j++) {
			int x = nums[j];
			Integer i = map.get(x);
			if (i != null)
				return new int[] { i, j };
			map.put(target - x, j);
		}
		return null;
	}

	public int[] twoSumMax(int[] nums, int target) {
		int[] ans = new int[2];
		for (int j = 0; j < nums.length - 1; j++) {
			ans[0] = j;
			for (int i = j + 1; i < nums.length; i++) {
				if (nums[ans[0]] + nums[i] == target) {
					ans[1] = i;
					return ans;
				}
			}
		}
		return ans;
	}

	public static int[] twoSumSorted(int[] nums, int target) {
		int j = nums.length - 1;
		int i = 0;
		while (i < j) {
			if (nums[i] + nums[j] == target)
				return new int[] { i + 1, j + 1 };
			else if (nums[i] + nums[j] < target)
				i++;
			else
				j--;
		}
		return null;
	}

	public static int[] twoSumSortedMax(int[] nums, int target) {
		int j = nums.length - 1;
		int i = 0;
		int max = 0;
		int[] ans = new int[2];
		while (i < j) {
			if (nums[i] + nums[j] < target) {
				i++;
				if (max == nums[i] + nums[j]) {
					if (ans[1] < j) {
						max = nums[i] + nums[j];
						ans[0] = i;
						ans[1] = j;
					}
				} else if (max < nums[i] + nums[j]) {
					max = nums[i] + nums[j];
					ans[0] = i;
					ans[1] = j;
				}
			} else {
				j--;
			}
		}
		return ans;
	}

	static public int twoSumCountPairs(int[] nums, int target) {
		Map<Integer, Integer> map = new HashMap<>(); // diff->num
		Set<Integer> ans = new HashSet<>();

		for (int j = 0; j < nums.length; j++) {
			int x = nums[j];
			Integer i = map.get(x);
			if (i != null) {
				ans.add(nums[i]);
				ans.add(nums[j]);
			}
			map.put(target - x, j);
		}
		System.out.println(ans);
		return ans.size() / 2;
	}

	public static void main(String[] args) {
		final int[] A = { 2, 7, 11, 15 };
//		System.out.println(twoSumSorted(A, 9));
		System.out.println(twoSumSortedMax(A, 9));
	}
}
