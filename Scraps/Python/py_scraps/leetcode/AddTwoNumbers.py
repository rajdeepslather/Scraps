# Definition for singly-linked list.
class ListNode:
    def __init__(self, x):
        self.val = x
        self.next = None


class Solution:
    def addTwoNumbers(self, l1: ListNode, l2: ListNode) -> ListNode:
        n1 = 0
        mult = 1
        while l1:
            n1 += l1.val * mult
            mult = mult * 10
            l1 = l1.next

        n2 = 0
        mult = 1
        while l2:
            n2 += l2.val * mult
            mult = mult * 10
            l2 = l2.next

        total = n1 + n2
        print(n1)
        print(n2)
        print(total)

        total_s = str(total)

        result = ListNode(int(total_s[-1]))
        total_s = total_s[:-1]
        head = result
        while total_s:
            node = ListNode(total_s[-1])
            result.next = node
            result = result.next
            total_s = total_s[:-1]

        return head
