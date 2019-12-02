# Definition for singly-linked list.
class ListNode:
    def __init__(self, x):
        self.val = x
        self.next = None


class Solution:
    def reverseKGroup(self, head: ListNode, k: int) -> ListNode:
        curr = head
        i = 0
        result = None
        resultHead = None
        resultTail = None
        while curr:
            tempHead = None
            temp = None
            tempTail = None
            while curr and i < k:
                print(str(i) + ': ' + str(curr.val))
                node = ListNode(curr.val)
                if not temp:  # implies first iteration
                    tempTail = node
                    tempHead = curr

                node.next = temp
                temp = node
                i += 1
                curr = curr.next
            if i < k:
                temp = tempHead
            if result:
                resultTail.next = temp
                result = temp
            else:
                result = temp
                resultHead = result
            resultTail = tempTail
            i = 0

        return resultHead
