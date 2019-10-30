#!/bin/python
import math
import os
import random
import re
import sys


def jumpingOnClouds(c):
    counter = 0
    num_clouds = len(c)
    i = 0
    while i < len(c)-1:
        if i < num_clouds-2 and c[i+2] == 0:
            i += 2
        else:
            i += 1
        counter += 1
    return counter


if __name__ == '__main__':
    n = int(raw_input())
    c = map(int, raw_input().rstrip().split())
    result = jumpingOnClouds(c)
    print str(result)
