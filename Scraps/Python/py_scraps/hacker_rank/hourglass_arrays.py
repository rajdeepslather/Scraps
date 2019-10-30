#!/bin/python

import math
import os
import random
import re
import sys


def hourglassSum(arr):
    max_sum = None
    
    for i in range(4):
        for j in range(4):
            temp_sum = arr[i][j] + arr[i][j+1] + arr[i][j+2] + \
                arr[i+1][j+1] + arr[i+2][j] + arr[i+2][j+1] + arr[i+2][j+2]
            if (max_sum is None) or (temp_sum > max_sum):
                max_sum = temp_sum
    return max_sum


if __name__ == '__main__':
    # fptr = open(os.environ['OUTPUT_PATH'], 'w')

    arr = []
    for _ in xrange(6):
        arr.append(map(int, raw_input().rstrip().split()))
    result = hourglassSum(arr)
    print result

    # fptr.write(str(result) + '\n')
    # fptr.close()
