import sys
from heapq import heapify, heappush, heappop

input = sys.stdin.readline
M, N = map(int, input().split())
dy = [0, 0, 1, -1]
dx = [1, -1, 0, 0]

arr = [list(map(int, input().split())) for _ in range(N)]
visited = [[0] * M for _ in range(N)]
visited[0][0] = visited[0][M - 1] = visited[N - 1][0] = visited[N - 1][M - 1] = 1
pq = []

mn = 10 ** 9 + 1

for i in (0, N - 1):
    for j in range(1, M - 1):
        mn = min(mn, arr[i][j])
        heappush(pq, (arr[i][j], i, j))
        visited[i][j] = 1

for i in range(1, N - 1):
    for j in (0, M - 1):
        mn = min(mn, arr[i][j])
        heappush(pq, (arr[i][j], i, j))
        visited[i][j] = 1

ans = 0
while pq:
    h, y, x = heappop(pq)
    if mn < h:
        mn = h
    else:
        ans += (mn - h)

    for k in range(4):
        ny = y + dy[k]
        nx = x + dx[k]
        if 0 <= ny < N and 0 <= nx < M and visited[ny][nx] == 0:
            visited[ny][nx] = 1
            heappush(pq, (arr[ny][nx], ny, nx))

print(ans)
