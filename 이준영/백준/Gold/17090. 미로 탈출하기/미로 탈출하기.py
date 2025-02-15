import sys
from collections import deque

input = sys.stdin.readline


def bfs(s_y, s_x):
    global cnt
    visited[s_y][s_x] = 1
    cnt += 1
    dq = deque([(s_y, s_x)])

    while dq:
        y, x = dq.popleft()
        for k in range(4):
            ny = y + dy[k]
            nx = x + dx[k]

            if 0 <= ny < N and 0 <= nx < M and visited[ny][nx] == 0 and y == (ny + d[arr[ny][nx]][0]) and x == (nx + d[arr[ny][nx]][1]):
                cnt += 1
                visited[ny][nx] = 1
                dq.append((ny, nx))


N, M = map(int, input().split())
arr = [list(input().rstrip()) for _ in range(N)]

dy = [0, 0, 1, -1]
dx = [1, -1, 0, 0]

d = {"D": (1, 0), "U": (-1, 0), "L": (0, -1), "R": (0, 1)}

visited = [[0] * M for _ in range(N)]

cnt = 0

for i in (0, N - 1):
    for j in range(M):
        if visited[i][j] == 0:
            ny = i + d[arr[i][j]][0]
            nx = j + d[arr[i][j]][1]
            if not (0 <= nx < M and 0 <= ny < N):
                bfs(i, j)

for i in range(1, N - 1):
    for j in (0, M - 1):
        if visited[i][j] == 0:
            ny = i + d[arr[i][j]][0]
            nx = j + d[arr[i][j]][1]
            if not (0 <= nx < M and 0 <= ny < N):
                bfs(i, j)

print(cnt)
