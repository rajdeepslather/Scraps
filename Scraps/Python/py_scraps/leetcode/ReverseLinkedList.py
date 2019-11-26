# Definition for singly-linked list.
class ListNode:
    def __init__(self, x):
        self.val = x
        self.next = None


class Solution:
    def reverse_list(self, head: ListNode, tail=None) -> ListNode:
        if head is None:
            return tail

        new_tail = ListNode(head.val)
        new_tail.next = tail
        tail = new_tail

        temp = self.reverse_list(head.next, tail)
        return temp


class IterSol:
    @staticmethod
    def reverse_list(head: ListNode) -> ListNode:
        new_head = None

        while head is not None:
            nxt = head.next
            head.next = new_head
            new_head = head
            head = nxt

        return new_head
