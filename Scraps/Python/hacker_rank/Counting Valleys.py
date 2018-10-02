#!/bin/python

import math
import os
import random
import re
import sys


# Complete the countingValleys function below.
def countingValleys(n, steps):
    current_level = 0
    num_valleys = 0
    for step in list(steps):
        if step == 'D':
            if current_level == 0:
                num_valleys += 1
            current_level -= 1
        elif step == 'U':
            current_level += 1
        else:
            # TODO raise exception
            pass
    return num_valleys


if __name__ == '__main__':
    n = int(raw_input())
    s = raw_input()
    result = countingValleys(n, s)
    print result
