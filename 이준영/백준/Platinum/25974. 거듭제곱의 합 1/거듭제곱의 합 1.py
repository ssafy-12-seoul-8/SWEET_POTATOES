def combi(a, b):
    if a < b:
        return 0
    if b == 0:
        return 1

    ans = (fac[a] * reverse_fac[b] * reverse_fac[a - b]) % mod

    return ans


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

fac = [0] * (K + 2)
reverse_fac = [0] * (K + 2)

fac[0] = reverse_fac[0] = 1
for i in range(1, K + 2):
    fac[i] = (fac[i - 1] * i) % mod
    reverse_fac[i] = my_multi(fac[i], mod - 2)

dp = [0] * (K + 1)
dp[0] = N

for i in range(1, K + 1):
    tmp = my_multi(N + 1, i + 1) - 1
    for j in range(i):
        tmp = (tmp - combi(i + 1, j) * dp[j]) % mod

    dp[i] = (tmp * my_multi(i + 1, mod - 2)) % mod

print(dp[K])
