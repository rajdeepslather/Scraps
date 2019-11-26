class Solution:
    def jump(self, nums, start=0, memo=None) -> int:
        if memo is None:
            memo = {len(nums) - 1: 0}

        if start in memo:
            memo[start]

        nxt = nums[start] + start
        if nxt >= len(nums) - 1:
            memo[start] = 1
        else:
            min_d = 99999999999
            for j in range(nxt, start, -1):
                new_d = self.jump(nums, j, memo)
                if min_d > new_d:
                    min_d = new_d
                if min_d == 1:
                    break
            memo[start] = min_d + 1
        return memo[start]
