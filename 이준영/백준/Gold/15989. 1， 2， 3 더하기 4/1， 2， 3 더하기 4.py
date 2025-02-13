# 미리 계산하고 테스트케이스마다 뱉어낸다.
T = int(input())
dp = [[0] * 10001 for _ in range(4)]
for i in range(4):
    dp[i][0] = 1

for i in range(1, 4):
    for j in range(1, 10001):
        if j < i:
            dp[i][j] = dp[i - 1][j]
        else:
            dp[i][j] = dp[i - 1][j] + dp[i][j - i]

for _ in range(T):
    n = int(input())
    print(dp[3][n])
