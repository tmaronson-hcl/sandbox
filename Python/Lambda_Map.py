# -*- coding: utf-8 -*-
"""
Created on Thu Mar 25 14:33:12 2021

@author: thomas.aronson
"""

# Complete the lambda function below.  It begins in the non-alterable code above
    # lambda x : (x[i]*x[i] for i in range(len(x)))
def lambdaMap(arr):
        ans = map(lambda x : (x[i]*x[i] for i in range(len(x)) if x[i] > 0), arr)
        return ans
    



if __name__ == '__main__':
    n = int(input())
    arr = []
    for _ in range(n):
        arr.append(list(map(int, input().split())))
    
    ans = lambdaMap(arr)
    for row in ans:
        print(' '.join(map(str, row)))