import sys

input = sys.stdin.readline
n = int(input())
arr = [list(map(int, input().split())) for _ in range(n)]
dp = [[1] * n for _ in range(n)]
lst = []
dy = [0, 0, 1, -1]
dx = [1, -1, 0, 0]
for i in range(n):
    for j in range(n):
        lst.append([arr[i][j], i, j])

lst.sort(reverse=True)

for i in range(n ** 2):
    num, y, x = lst[i]
    for k in range(4):
        ny = y + dy[k]
        nx = x + dx[k]
        if 0 <= ny < n and 0 <= nx < n and arr[ny][nx] > num:
            dp[y][x] = max(dp[y][x], 1 + dp[ny][nx])

mx = max(map(max, dp))

print(mx)
