#!/bin/python

import math
import os
import random
import re
import sys

# Complete the balancedSums function below.
def balancedSums(arr):
    # method 1:
    # always subtract right_sum to compare
    # always add left_sum after comparison
    if len(arr) == 1: return 'YES'
    left_sum = 0
    right_sum = sum(arr)
    for idx in range(0,len(arr)):
        right_sum -= arr[idx]
        if left_sum == right_sum:
            return 'YES'
        left_sum += arr[idx]
        
    return 'NO'
    
if __name__ == '__main__':
    fptr = open(os.environ['OUTPUT_PATH'], 'w')

    T = int(raw_input().strip())

    for T_itr in xrange(T):
        n = int(raw_input().strip())

        arr = map(int, raw_input().rstrip().split())

        result = balancedSums(arr)

        fptr.write(result + '\n')

    fptr.close()

