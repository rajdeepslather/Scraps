package test;

import java.util.HashMap;
import java.util.Map;

public class LRUCache<K, V> {
	class Node {
		final K key;
		V value;
		Node prev = null;
		Node next = null;

		Node(K key, V value) {
			this.key = key;
			this.value = value;
		}

		Node() {
			this.key = null;
			this.value = null;
		}

		@Override
		public String toString() {
			return "Node [value=" + value + "]";
		}
	}

	final Map<K, Node> map;
	final Node head = new Node();
	final Node tail = new Node();
	int size;

	public LRUCache(int size) {
		head.next = tail;
		tail.prev = head;
		this.size = size;
		map = new HashMap<>(size);
	}

	Node pop() {
		Node last = tail.prev;
		removeNode(last);
		return last;
	}

	void moveToHead(Node node) {
		removeNode(node);
		appendLeft(node);
	}

	void removeNode(Node node) {
		Node prev = node.prev;
		Node next = node.next;

		prev.next = next;
		next.prev = prev;
	}

	void appendLeft(Node node) {
		Node secondNode = head.next;

		node.next = secondNode;
		node.prev = head;

		secondNode.prev = node;
		head.next = node;
	}

	public V get(K key) {
		Node node = map.get(key);
		if (node == null)
			return null;

		moveToHead(node);
		return node.value;
	}

	public V peek() {
		return head.next.value;
	}

	public void put(K key, V value) {
		Node newNode = map.get(key);
		if (newNode != null) {
			newNode.value = value;
			moveToHead(newNode);
		} else {
			if (map.size() > size - 1)
				map.remove(pop().key);

			newNode = new Node(key, value);
			appendLeft(newNode);
			map.put(key, newNode);
		}
	}

	public static void main(String[] args) {
		LRUCache<Integer, String> obj = new LRUCache<>(2);
		String param_1 = obj.get(1);
		System.out.println(param_1);

		obj.put(1, "item_a");
		String param_2 = obj.get(1);

		System.out.println(obj.map);
		System.out.println(param_2);

		obj.put(2, "item_b");
		obj.put(1, "item_c");
		obj.put(3, "item_d");
		System.out.println(obj.map);

		System.out.println(obj.peek());
	}
}
