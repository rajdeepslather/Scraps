from typing import List


class Solution(object):
    def generateParenthesis(self, n):
        if n == 0:
            return ['']

        if n == 1:
            return ['()']

        ans = []
        for c in range(n):
            for left in self.generateParenthesis(c):
                for right in self.generateParenthesis(n - 1 - c):
                    ans.append('(' + left + ')' + right)
        return ans
