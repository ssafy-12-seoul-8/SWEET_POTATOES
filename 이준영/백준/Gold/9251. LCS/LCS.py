A = input()
B = input()
n = len(A)
m = len(B)
dp = [[0] * (n + 1) for _ in range(m + 1)]
for i in range(m):
    for j in range(n):
        if B[i] == A[j]:
            dp[i + 1][j + 1] = max(dp[i][j] + 1, dp[i + 1][j])
        else:
            dp[i + 1][j + 1] = max(dp[i + 1][j],dp[i][j+1])

print(dp[m][n])
