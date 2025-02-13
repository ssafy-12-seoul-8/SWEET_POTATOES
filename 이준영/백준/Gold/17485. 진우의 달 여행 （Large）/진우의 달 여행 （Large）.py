# 이전 방향이 중요하기 때문에 dp[i][j][k]는 i행 j열칸까지 오는데 직전 방향이 k인 경우의 수로 정의하자
# 처음은 이전 방향이 없어서 다 채우나 불가능한 방향 0행은 다 가능하므로 다 채움
# (i,0)은 이전에서 왼쪽 대각선에서, (i,M-1)은 오른쪽 대각선에서 올 수 없으므로 충분히 큰 값을 넣음 (최대가 10^8이므로 넉넉하게 설정)

import sys

input = sys.stdin.readline

N, M = map(int, input().split())

arr = [list(map(int, input().split())) for _ in range(N)]

dp = [[[0] * 3 for _ in range(M)] for _ in range(N)]

for j in range(M):
    for k in range(3):
        dp[0][j][k] = arr[0][j]

for i in range(1, N):
    for j in range(M):
        if j == 0:
            dp[i][0][0] = arr[i][j] + min(dp[i - 1][1][1], dp[i - 1][1][2])
            dp[i][0][1] = arr[i][j] + dp[i - 1][0][0]
            dp[i][0][2] = int(1e9)
        elif j == M - 1:
            dp[i][j][0] = int(1e9)
            dp[i][j][1] = arr[i][j] + dp[i - 1][M - 1][2]
            dp[i][j][2] = arr[i][j] + min(dp[i - 1][M - 2][0], dp[i - 1][M - 2][1])
        else:
            dp[i][j][0] = arr[i][j] + min(dp[i - 1][j + 1][1], dp[i - 1][j + 1][2])
            dp[i][j][1] = arr[i][j] + min(dp[i - 1][j][0], dp[i - 1][j][2])
            dp[i][j][2] = arr[i][j] + min(dp[i - 1][j - 1][0], dp[i - 1][j - 1][1])

mn = int(1e9)
for j in range(M):
    for k in range(3):
        mn = min(mn, dp[N - 1][j][k])

print(mn)
