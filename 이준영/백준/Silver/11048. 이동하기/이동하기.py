# 사탕은 각칸에 음아닌 정수만큼 놓여있으니 대각선으로 가는 건 의미가 없다 (가로, 세로 한칸씩 가는게 이득)
# 따라서 가로와 세로로 가는 것만 고려하여 최대값을 저장해놓으면 된다.

import sys

input = sys.stdin.readline
N, M = map(int, input().split())
arr = [list(map(int, input().split())) for _ in range(N)]

dp = [[0] * M for _ in range(N)]

dp[0][0] = arr[0][0]
for j in range(1, M):
    dp[0][j] = dp[0][j - 1] + arr[0][j]

for i in range(1, N):
    dp[i][0] = dp[i - 1][0] + arr[i][0]

for i in range(1, N):
    for j in range(1, M):
        dp[i][j] = max(dp[i][j - 1], dp[i - 1][j]) + arr[i][j]

print(dp[N - 1][M - 1])
