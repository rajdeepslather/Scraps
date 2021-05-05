package test;

import java.util.HashMap;
import java.util.LinkedHashSet;

public class LFUCache {
	class Pair {
		int value;
		int count;

		Pair(int value, int count) {
			this.value = value;
			this.count = count;
		}
	}

	HashMap<Integer, Pair> cache;
	HashMap<Integer, LinkedHashSet<Integer>> lists;
	int cap;
	int min;

	public LFUCache(int capacity) {
		cap = capacity;
		cache = new HashMap<>(capacity + 1);
		lists = new HashMap<>();
		lists.put(1, new LinkedHashSet<>(capacity));
	}

	public int get(int key) {
		Pair pair = cache.get(key);
		if (pair == null)
			return -1;

		return get(key, pair);
	}

	public int get(int key, Pair pair) {
		LinkedHashSet<Integer> oldSet = lists.get(pair.count);
		oldSet.remove(key);
		if (pair.count == min && oldSet.size() == 0)
			min++;

		pair.count++;

		LinkedHashSet<Integer> linkedSet = lists.get(pair.count);

		if (linkedSet == null) {
			linkedSet = new LinkedHashSet<>(cap / 4);
			lists.put(pair.count, linkedSet);
		}
		linkedSet.add(key);
		return pair.value;
	}

	public void put(int key, int value) {
		if (cap <= 0)
			return;

		Pair pair = cache.get(key);
		if (pair != null) {
			pair.value = value;
			get(key, pair);
			return;
		}

		if (cache.size() >= cap) {
			LinkedHashSet<Integer> minSet = lists.get(min);
			int evit = minSet.iterator().next();
			minSet.remove(evit);
			cache.remove(evit);
		}
		cache.put(key, new Pair(value, 1));
		min = 1;
		lists.get(1).add(key);
	}
}