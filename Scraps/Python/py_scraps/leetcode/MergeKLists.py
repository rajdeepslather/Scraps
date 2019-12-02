from typing import List


# Definition for singly-linked list.
class ListNode:
    def __init__(self, x):
        self.val = x
        self.next = None


class Solution:
    def mergeKLists(self, lists: List[ListNode]) -> ListNode:
        new_l = []
        for l in lists:
            if l:
                new_l.append(l)
        lists = new_l

        if not lists:
            return None

        lists.sort(key=lambda x: x.val)  # O(klgk)

        result = ListNode(None)
        head = result
        while True:
            if result.val is None:
                result.val = lists[0].val
            else:
                temp = ListNode(lists[0].val)
                result.next = temp
                result = temp

            if not lists[0].next:
                lists.pop(0)
            else:
                lists[0] = lists[0].next

                up = len(lists) - 1
                low = 0
                j = int((up + low) / 2)
                while True:
                    if j == 0:
                        if up == 0 or lists[0].val <= lists[j + 1].val:
                            break
                        else:
                            lists.insert(2, lists[0])
                            lists.pop(0)
                            break
                    elif lists[j].val <= lists[0].val and \
                            (j == up or lists[0].val <= lists[j + 1].val):
                        lists.insert(j + 1, lists[0])
                        lists.pop(0)
                        break
                    elif lists[j].val < lists[0].val:  # go right
                        low = j + 1
                        j = int((up + low) / 2)
                    else:  # go left
                        up = j - 1
                        j = int((up + low) / 2)

            if not lists:
                break

        return head
