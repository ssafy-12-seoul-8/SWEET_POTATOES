import sys
from collections import deque

input = sys.stdin.readline

N, M = map(int, input().split())
arr = [list(map(int, input().split())) for _ in range(N)]
visited = [[False] * M for _ in range(N)]

dy = [0, -1, 0, 1]
dx = [1, 0, -1, 0]

change = [[0, 0, 0, 0],
          [-1, 1, -1, 3],
          [0, -1, 2, -1],
          [1, 0, 3, 2],
          [3, 2, 1, 0]]

dq = deque([])
for i in range(N):
    for j in range(M):
        if arr[i][j] == 9:
            for k in range(4):
                dq.append((i, j, k))
            visited[i][j] = True

while dq:
    y, x, d = dq.popleft()
    ny = y + dy[d]
    nx = x + dx[d]
    if 0 <= ny < N and 0 <= nx < M:
        visited[ny][nx] = True
        if arr[ny][nx] == 9:
            continue
        if arr[ny][nx] == 0:
            dq.append((ny, nx, d))
        else:
            tmp = change[arr[ny][nx]][d]
            if tmp == -1:
                continue
            else:
                dq.append((ny, nx, tmp))

cnt = 0
for i in range(N):
    for j in range(M):
        if visited[i][j]:
            cnt += 1

print(cnt)
