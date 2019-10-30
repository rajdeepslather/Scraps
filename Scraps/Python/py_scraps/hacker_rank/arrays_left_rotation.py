#!/bin/python
import math
import os
import random
import re
import sys
from collections import deque


def rotLeft_old(a, d):
    dq = deque(a)
    dq.rotate(-d)
    return dq


def rotLeft(a, d):
    i = 0
    length = len(a)
    b = []
    while i < length:
        b.append(a[(i+d) % length])
        i += 1
    return b


if __name__ == '__main__':
    nd = raw_input().split()
    n = int(nd[0])
    d = int(nd[1])
    a = map(int, raw_input().rstrip().split())
    result = rotLeft(a, d)

    print ' '.join(map(str, result))
