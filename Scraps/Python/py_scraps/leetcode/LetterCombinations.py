from typing import List


class Solution:
    def letterCombinations(self, digits: str) -> List[str]:
        mapping = {'2': ('a', 'b', 'c'),
                   '3': ('d', 'e', 'f'),
                   '4': ('g', 'h', 'i'),
                   '5': ('j', 'k', 'l'),
                   '6': ('m', 'n', 'o'),
                   '7': ('p', 'q', 'r', 's'),
                   '8': ('t', 'u', 'v'),
                   '9': ('w', 'x', 'y', 'z')}
        result = []

        for digit in digits:
            temp = result[:]
            print(temp)
            result.clear()

            for ch in mapping[digit]:
                if temp:
                    for t in temp:
                        result.append(t + ch)
                else:
                    result.append(ch)

        return result
