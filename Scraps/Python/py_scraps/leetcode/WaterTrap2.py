from typing import List


class Solution:
    def trap(self, height: List[int]) -> int:
        left = 0
        water = 0
        stack = []

        for i, h in enumerate(height):
            print(stack)
            while stack and stack[len(stack) - 1] < h:
                temp = stack.pop()
                dif = min(height[left] - temp, h - temp)
                water += dif
                stack.append(temp - dif)

            if h < height[left]:
                stack.append(h)

            # stack.append(h)

            if h >= height[left]:
                left = i
            #     while stack:
            #         water+=stack.pop()
            print(water)
            # elif i = len(height)-1:
            #     temp = 0
            #     for j in range(left, i):

        return water
