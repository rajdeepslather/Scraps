class Solution:
    def isValid(self, s: str) -> bool:
        stack = []
        mp = {')': '(', '}': '{', ']': '['}

        for ch in s:
            if ch in mp:
                if stack:
                    if mp[ch] is not stack.pop():
                        return False
                else:
                    return False
            else:
                stack.append(ch)
        if stack:
            return False
        else:
            return True
