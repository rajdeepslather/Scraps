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

	public static int[] twoSumSorted(int[] nums, int target) {
		Map<Integer, Integer> map = new HashMap<>(); // diff->num
		int j = nums.length - 1;
		int i = 0;
		while (i < j) {
			int x = nums[i];
			Integer k = map.get(x);
			if (k != null)
				return new int[] { ((k > i) ? i : k) + 1, ((k > i) ? k : i) + 1 };
			map.put(target - x, i);

			i++;
			x = nums[j];
			k = map.get(x);
			if (k != null)
				return new int[] { ((k > j) ? j : k) + 1, ((k > j) ? k : j) + 1 };
			map.put(target - x, j);
		}
		return null;
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
		System.out.println(twoSumSorted(A, 9));
	}
}
