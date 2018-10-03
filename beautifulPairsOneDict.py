#!/bin/python

import math
import os
import random
import re
import sys

# Complete the beautifulPairs function below.
def beautifulPairs(A, B):
    # use 1 dict
    dict_A = {}
    for a in A:
        if a not in dict_A:
            dict_A[a] = 1
        else:
            dict_A[a] += 1
    res = 0
    for b in B:
        if b in dict_A:
            if dict_A[b] == 1:
                dict_A.pop(b, None)
            else:
                dict_A[b] -= 1
            res += 1
    return res - 1 if res == len(A) else res + 1


if __name__ == '__main__':
    fptr = open(os.environ['OUTPUT_PATH'], 'w')

    n = int(raw_input())

    A = map(int, raw_input().rstrip().split())

    B = map(int, raw_input().rstrip().split())

    result = beautifulPairs(A, B)

    fptr.write(str(result) + '\n')

    fptr.close()

