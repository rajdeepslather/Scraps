class Solution:
    def firstUniqChar(self, s: str) -> int:
        uniq = {}

        for ch in s:
            if ch in uniq:
                uniq[ch] = False
            else:
                uniq[ch] = True

        for i, ch in enumerate(s):
            if uniq[ch]:
                return i
        return -1
