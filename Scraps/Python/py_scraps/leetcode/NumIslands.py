from typing import List


class Solution:
    def numIslands(self, grid: List[List[str]]) -> int:
        x = len(grid)
        y = len(grid[0])
        count = 0
        for i in range(x):
            for j in range(y):
                if grid[i][j] == '1':
                    count += 1
                    stack = [(i, j)]
                    while stack:
                        k, l = stack.pop()
                        if k < 0 or k > x - 1 or \
                                l < 0 or l > y - 1:
                            continue
                        elif grid[k][l] == '0':
                            continue
                        else:
                            grid[k][l] = '0'
                            stack.append((k - 1, l))
                            stack.append((k, l - 1))
                            stack.append((k + 1, l))
                            stack.append((k, l + 1))
        return count
