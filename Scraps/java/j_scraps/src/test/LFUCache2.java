package test;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class LFUCache2 {
	class Node implements Comparable<Node> {
		final int key;
		int value;
		int counter = 0;
		long lastUsed = 0;

		Node(int key, int value) {
			this.key = key;
			this.value = value;
		}

		Node() {
			this.key = -1;
		}

		void use(long lastUsed) {
			counter++;
			this.lastUsed = lastUsed;
		}

		@Override
		public int compareTo(LFUCache2.Node o) {
			if (counter > o.counter)
				return 1;
			if (counter < o.counter)
				return -1;
			if (lastUsed > o.lastUsed)
				return 1; // pop older
			if (lastUsed < o.lastUsed)
				return -1; // pop older
			return 0;
		}

		@Override
		public String toString() {
			return "Node [value=" + value + ", counter=" + counter + ", lastUsed=" + lastUsed + "]";
		}
	}

	final Map<Integer, Node> map;
	final PriorityQueue<Node> heap;
	long globalCounter = 0;

	int size;

	public LFUCache2(int size) {
		this.size = size;
		map = new HashMap<>(size + 1);
//		map = new TreeMap<>(comparator);
		heap = new PriorityQueue<>(size + 1);
	}

	public int get(int key) {
		Node node = map.get(key);
		if (node == null)
			return -1;

		globalCounter++;
		node.use(globalCounter);

		heap.remove(node);
		heap.add(node);

		return node.value;
	}

	public void put(int key, int value) {
		if (size <= 0)
			return;

		Node newNode = map.get(key);
		if (newNode != null) {
			newNode.value = value;
			heap.remove(newNode);
		} else {
			if (map.size() > size - 1)
				map.remove(heap.remove().key);

			newNode = new Node(key, value);
			map.put(key, newNode);
		}
		globalCounter++;
		newNode.use(globalCounter);
		heap.add(newNode);

		// System.out.println(map);
		// System.out.println(heap);
	}

	public static void main(String[] args) {
		LFUCache2 obj = new LFUCache2(2);
		int param_1 = obj.get(1);
		System.out.println(param_1);

		obj.put(1, 1);
		int param_2 = obj.get(1);

		System.out.println(obj.map);
		System.out.println(param_2);

		obj.put(2, 2);
		obj.put(1, 11);
		obj.put(3, 3);
		System.out.println(obj.map);
		System.out.println(obj.heap);

	}
}

/**
 * Your LFUCache object will be instantiated and called as such: LFUCache obj =
 * new LFUCache(capacity); int param_1 = obj.get(key); obj.put(key,value);
 */
