#!/bin/python
import math
import os
import random
import re
import sys
from collections import Counter


def repeatedString(s, n):
    chars = []
    map(chars.extend, s)
    remainder = n % len(chars)
    count = Counter(chars)['a'] * n // len(chars)
    i = 0
    while remainder > 0:
        if 'a' == chars[i]:
            count += 1
        remainder -= 1
        i += 1
    return count


if __name__ == '__main__':
    # fptr = open(os.environ['OUTPUT_PATH'], 'w')

    s = raw_input()
    n = int(raw_input())
    result = repeatedString(s, n)

    # fptr.write(str(result) + '\n')
    # fptr.close()
