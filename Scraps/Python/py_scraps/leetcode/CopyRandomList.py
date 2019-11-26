# Definition for a Node.
class Node:
    def __init__(self, val, next, random):
        self.val = val
        self.next = next
        self.random = random


class Solution:
    def copyRandomList(self, head: 'Node') -> 'Node':
        if head is None:
            return None

        memo = {}
        new_head = Node(head.val, None, None)
        memo[head] = new_head

        curr = head.next
        new_curr = new_head

        while curr is not None:
            new_node = Node(curr.val, None, None)
            new_curr.next = new_node
            new_curr = new_node
            memo[curr] = new_curr
            curr = curr.next

        new_curr = new_head
        curr = head
        while new_curr is not None:
            if curr.random is None:
                new_curr.random = None
            else:
                new_curr.random = memo[curr.random]
            new_curr = new_curr.next
            curr = curr.next

        return new_head
