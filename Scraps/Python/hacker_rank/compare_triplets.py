#!/bin/python
import math
import os
import random
import re
import sys


def compareTriplets(a, b):
    score = [0, 0]
    for i in range(3):
        if a[i] > b[i]:
            score[0] += 1
        elif a[i] < b[i]:
            score[1] += 1
    return score


def main():
    a = [1, 2, 3]
    b = [3, 3, 1]

    result = compareTriplets(a, b)
    print ' '.join(map(str, result))


if __name__ == '__main__':
    main()
