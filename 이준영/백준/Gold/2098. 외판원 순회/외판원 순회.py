import sys

input = sys.stdin.readline

N = int(input())
road = [list(map(int, input().split())) for _ in range(N)]
dp = [[int(1e9)] * (1 << N) for _ in range(N)]
final = (1 << N) - 1

dp[0][1] = 0

for i in range(1 << N):
    for j in range(N):
        if dp[j][i] == int(1e9):
            continue
        for k in range(N):
            if road[j][k] != 0 and (i & (1 << k)) == 0:
                tmp = i | (1 << k)
                dp[k][tmp] = min(dp[k][tmp], road[j][k] + dp[j][i])

ans = int(1e9)
for i in range(N):
    if road[i][0] != 0:
        ans = min(ans, road[i][0] + dp[i][(1 << N) - 1])

print(ans)
