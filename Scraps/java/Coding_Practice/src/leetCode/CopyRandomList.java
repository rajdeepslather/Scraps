package leetCode;

import java.util.HashMap;
import java.util.Map;

public class CopyRandomList {

	class Node {
		public int val;
		public Node next;
		public Node random;

		public Node() {
		}

		public Node(int _val, Node _next, Node _random) {
			val = _val;
			next = _next;
			random = _random;
		}
	};

	public Node copyRandomList(final Node head) {
		final Map<Node, Node> map = new HashMap<>();
		
		if (head == null)
			return null;
		Node cpyHead = new Node(head.val, head.next, head.random);
		map.put(head, cpyHead);
		
		Node curr = head.next;
		Node cpy = cpyHead;
		
		while (true) {
			if (curr == null)
				break;
			final Node cpy2 = new Node(curr.val, curr.next, curr.random);
			cpy.next = cpy2;
			cpy = cpy2;
			map.put(curr, cpy);
			curr = curr.next;
		}

		cpy = cpyHead;
		while (true) {
			if (cpy == null)
				break;
			cpy.random = map.get(cpy.random);
			cpy = cpy.next;
		}
		return cpyHead;
	}
}
