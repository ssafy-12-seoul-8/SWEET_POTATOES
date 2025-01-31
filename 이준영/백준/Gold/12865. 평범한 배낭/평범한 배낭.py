N, K = map(int, input().split())
itm = [0]
itm.extend([list(map(int, input().split())) for _ in range(N)])
dp = [[0] * (K + 1) for _ in range(N + 1)]
for i in range(1, N + 1):
    for j in range(1, K + 1):
        if itm[i][0] > j:
            dp[i][j] = dp[i - 1][j]
        else:
            dp[i][j] = max(dp[i - 1][j], itm[i][1] + dp[i - 1][j - itm[i][0]])
print(dp[N][K])
