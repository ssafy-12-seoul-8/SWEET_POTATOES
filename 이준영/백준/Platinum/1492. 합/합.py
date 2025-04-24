def combi(a, b):
    if a < b:
        return 0
    if b == 0:
        return 1
    ans = 1
    for i in range(a - b + 1, a + 1):
        ans = ans * i
    for i in range(1, b + 1):
        ans = ans // i
    return ans % mod


def my_multi(a, b):
    if b == 0:
        return 1

    c = my_multi(a, b // 2)
    c = (c * c) % mod
    if b % 2 == 1:
        c = (c * a) % mod
    return c


mod = 1000000007
N, K = map(int, input().split())
dp = [0] * (K + 1)
dp[0] = N

for i in range(1, K + 1):
    tmp = my_multi(N + 1, i + 1) - 1
    for j in range(i):
        tmp = (tmp - combi(i + 1, j) * dp[j]) % mod

    dp[i] = (tmp * my_multi(i + 1, mod - 2)) % mod

print(dp[K])
