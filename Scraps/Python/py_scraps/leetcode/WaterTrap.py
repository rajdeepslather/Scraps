from typing import List


class Solution:
    def trap(self, height: List[int]) -> int:
        if not height:
            return 0
        l = len(height)
        water = 0
        left_max = [0] * l
        left_max[0] = height[0]
        for i in range(1, l):
            left_max[i] = max(left_max[i - 1], height[i])

        right_max = [0] * l
        right_max[l - 1] = height[l - 1]
        for i in range(l - 2, -1, -1):
            right_max[i] = max(right_max[i + 1], height[i])

        for i in range(0, l):
            water += min(left_max[i], right_max[i]) - height[i]

        print(left_max)
        print(right_max)
        return water
