# 0 ~ n까지 1이 몇번 나오는지를 세는 함수를 재귀적으로 구성
# n이 m진수라 할 때 가장 앞의 1은 n - (1 << (m - 1)) + 1 번 나오고 n~2^(m-1)까지 1의 개수는 0~ n-2**(m-1)까지의 개수와 같으며
# 0 ~ 2^(m-1)-1 까지 1의 개수는 (m-1)*(2**(m-2))개이다
import sys

sys.setrecursionlimit(100000)


def calc(a):
    ans = 1
    while a > 1:
        a = a // 2
        ans += 1
    return ans


def count_1(n):
    if n in dct:
        return dct[n]
    if n == 0:
        dct[n] = 0
        return 0
    if n == 1:
        dct[n] = 1
        return 1
    m = calc(n)
    dct[n] = n - (1 << (m - 1)) + 1 + count_1(n - (1 << (m - 1))) + (m - 1) * (1 << (m - 2))
    return dct[n]


A, B = map(int, input().split())
dct = {}
print(count_1(B) - count_1(A - 1))
