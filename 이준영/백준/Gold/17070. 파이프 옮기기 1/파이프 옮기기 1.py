N = int(input())
arr = [list(map(int, input().split())) for _ in range(N)]
dp = [[[0, 0, 0] for _ in range(N + 1)] for _ in range(N + 1)]  # 오른쪽 끝 기준으로 생각, 가로, 세로, 대각선
dp[1][2][0] = 1
for i in range(1, N + 1):
    for j in range(3, N + 1):
        if arr[i - 1][j - 1] == 0:
            dp[i][j][0] = dp[i][j - 1][0] + dp[i][j - 1][2]
            dp[i][j][1] = dp[i - 1][j][1] + dp[i - 1][j][2]
            if i >= 2 and arr[i - 1][j - 2] == 0 and arr[i - 2][j - 1] == 0:
                dp[i][j][2] = sum(dp[i - 1][j - 1])

print(sum(dp[N][N]))
