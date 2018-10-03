#!/bin/python

import math
import os
import random
import re
import sys

# Complete the beautifulPairs function below.
def beautifulPairs(A, B):
    dict_A = {}
    dict_B = {}
    for a in A:
        if a not in dict_A:
            dict_A[a] = 1
        else:
            dict_A[a] += 1
    for b in B:
        if b not in dict_B:
            dict_B[b] = 1
        else:
            dict_B[b] += 1
            
        if b not in dict_A:
            print('jert')
            dict_A[b] = 0
    filtered = filter(lambda num: dict_A[num] != dict_B[num], dict_B)
    r = len(B)
    if len(filtered) == 0:
        return len(B) - 1
    for key in filtered:
        r = r - dict_B[key] + min(dict_A[key], dict_B[key])
    return r+1

if __name__ == '__main__':
    fptr = open(os.environ['OUTPUT_PATH'], 'w')

    n = int(raw_input())

    A = map(int, raw_input().rstrip().split())

    B = map(int, raw_input().rstrip().split())

    result = beautifulPairs(A, B)

    fptr.write(str(result) + '\n')

    fptr.close()

