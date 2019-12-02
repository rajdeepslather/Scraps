from typing import List


def sort(arr):
    if len(arr) > 2:
        mid = int(len(arr) / 2)
        left = sort(arr[:mid])
        right = sort(arr[mid:])
        print('merging')
        arr = merge(left, right)
        print(arr)
        return arr
    elif len(arr) == 2:
        if arr[0] < arr[1]:
            print(arr)
            return arr
        else:
            print(arr[::-1])
            return arr[::-1]
    else:
        print(arr)
        return arr


def merge(arr1, arr2):
    arr = []
    i1 = 0
    i2 = 0
    while i1 < len(arr1) and i2 < len(arr2):
        if arr1[i1] < arr2[i2]:
            arr.append(arr1[i1])
            i1 += 1
        else:
            arr.append(arr2[i2])
            i2 += 1

    while i1 < len(arr1):
        print('l1')
        arr.append(arr1[i1])
        i1 += 1

    while i2 < len(arr2):
        print('l2')
        arr.append(arr2[i2])
        i2 += 1

    return arr


def search(arr, k):
    if len(arr) <= 1:
        return 0

    idx = 0
    return idx


class Solution:
    def findKthLargest(self, nums: List[int], k: int) -> int:
        sorted = []
        # for num in nums:
        #     k

        # nums.sort()
        sorted = sort(nums)
        print(sorted)
        return sorted[-k]
