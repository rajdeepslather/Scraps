from typing import List
import collections


# Definition for a binary tree node.
class TreeNode:
    def __init__(self, x):
        self.val = x
        self.left = None
        self.right = None


class Node:
    def __init__(self, treeNode, level):
        self.treeNode = treeNode
        self.level = level


class Solution:
    def zigzagLevelOrder(self, root: TreeNode) -> List[List[int]]:
        if not root:
            return None
        nodes = []
        queue = [(root, 0)]
        while queue:
            node, level = queue.pop(0)
            if not node:
                continue

            if len(nodes) > level:
                if level % 2 == 1:
                    nodes[level].appendleft(node.val)
                else:
                    nodes[level].append(node.val)
            else:
                nodes.append(collections.deque([node.val]))

            queue.append((node.left, level + 1))
            queue.append((node.right, level + 1))
        return nodes
