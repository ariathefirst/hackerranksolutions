#!/bin/python

import math
import os
import random
import re
import sys

# Complete the alternate function below.
def alternate(s):
    idx = 0
    unique = ''.join(set(s))
    print(unique)
    res = 0
    for a in unique:
        for b in unique:
            if a is not b:
                tmp = s
                tmp = filter(lambda c: c is a or c is b, tmp)
                if not hasRepeat(tmp):
                    res = max(res, len(tmp))
    return res
  
def hasRepeat(tmp):
    for idx in range(len(tmp)-1):
        if tmp[idx] == tmp[idx+1]:
            return True
    return False

if __name__ == '__main__':
    fptr = open(os.environ['OUTPUT_PATH'], 'w')

    l = int(raw_input().strip())

    s = raw_input()

    result = alternate(s)

    fptr.write(str(result) + '\n')

    fptr.close()

