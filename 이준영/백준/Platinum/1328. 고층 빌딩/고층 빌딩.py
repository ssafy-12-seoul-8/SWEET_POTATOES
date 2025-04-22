def f(N, L, R):
    if dp[N][L][R] >= 0:
        return dp[N][L][R]

    if L == 0 or R == 0:
        dp[N][L][R] = 0
        return 0

    if N < L or N < R or N + 1 < R + L:
        dp[N][L][R] = 0
        return 0

    dp[N][L][R] = (f(N - 1, L, R) * (N - 2) + f(N - 1, L - 1, R) + f(N - 1, L, R - 1)) % 1000000007
    return dp[N][L][R]


N, L, R = map(int, input().split())

dp = [[[-1] * (R + 1) for _ in range(L + 1)] for _ in range(N + 1)]
dp[1][1][1] = 1
ans = f(N, L, R)
print(ans)
