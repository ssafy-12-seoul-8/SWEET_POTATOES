# 피보나치수의 성질을 사용하는 문제이다.
# n번쩨 피보나치 수를 f_n이라 하고 A = [[0,1],[1,1]]이라 할때 A^k = [[f_k,f_(k+1)],[f_(k+1),f_(k+2)]] 가 됨을 이용
# 행렬의 거듭제곱을 분할 정복으로 계산하면 된다.

import sys
sys.setrecursionlimit(10000)

def mul(A, B):                                                  # 2*2 행렬 2개의 곱
    C = [[0] * 2 for _ in range(2)]
    for i in range(2):
        for j in range(2):
            for k in range(2):
                C[i][j] = (C[i][j] + A[i][k] * B[k][j]) % mod
    return C


def ex(arr, n):                                                 # 재귀를 활용한 분할 정복
    if n == 0:
        arr2 = [[1, 0], [0, 1]]
        return arr2
    else:
        arr3 = ex(arr, n // 2)
        arr2 = mul(arr3, arr3)
        if n % 2 == 1:
            tmp = [[0, 1], [1, 1]]
            arr2 = mul(arr2, tmp)
        return arr2


n = int(input())
mod = 1000000007

arr = [[0, 1], [1, 1]]
arr2 = ex(arr, n)
print(arr2[0][1])
