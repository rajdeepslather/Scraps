from typing import List

from typing import List


class Solution:
    def prisonAfterNDays(self, cells: List[int], n: int) -> List[int]:
        if n == 0:
            return cells
        l = len(cells)
        cells2 = cells[:]
        cells2[0] = 0
        cells2[l - 1] = 0

        memo = {}

        for j in range(n):
            for i in range(1, l - 1):
                if cells[i - 1] == cells[i + 1]:
                    cells2[i] = 1
                else:
                    cells2[i] = 0

            if cells2 in memo.values():
                break
            else:
                memo[j] = cells2[:]
                cells = cells2[:]
        print(n)
        print(j)
        print(memo)
        l = len(memo)
        if l == 1:
            return memo[0]
        i = n % l
        if i <= 0:
            return memo[l - 1]
        else:
            return memo[i - 1]


if __name__ == '__main__':
    s = Solution()
    s.prisonAfterNDays([1, 0, 0, 1, 0, 0, 1, 0], 5)
