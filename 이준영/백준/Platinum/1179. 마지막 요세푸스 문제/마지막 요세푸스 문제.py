import sys

sys.setrecursionlimit(10000)


def f(N, K):
    if K == 1:
        return N - 1
    if N == 1:
        return 0

    if N < K:
        return (f(N - 1, K) + K) % N

    r = N % K
    q = N // K

    tmp = f(N - q, K)
    if tmp <= r - 1:
        return tmp + K * q
    else:
        h = tmp - r
        m = h % (K - 1)
        t = h // (K - 1)
        return K * t + m


N, K = map(int, input().split())
ans = f(N, K)
print(ans + 1)
