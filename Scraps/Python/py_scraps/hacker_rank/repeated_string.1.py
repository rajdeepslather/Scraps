#!/bin/python
import math
import os
import random
import re
import sys

s = raw_input().strip()
n = int(raw_input().strip())
print s.count("a") * (n // len(s)) + s.count('a', 0, n % len(s))
