import sys
from collections import deque

input = sys.stdin.readline


def bfs(s_y, s_x):
    visited[s_y][s_x] = 1
    dq = deque([(s_y, s_x)])

    while dq:
        y, x = dq.popleft()
        for k in range(4):
            ny = (y + dy[k]) % N
            nx = (x + dx[k]) % M
            if visited[ny][nx] == 0 and arr[ny][nx] == 0:
                visited[ny][nx] = 1
                dq.append((ny, nx))


N, M = map(int, input().split())
arr = [list(map(int, input().split())) for _ in range(N)]
dy = [0, 0, 1, -1]
dx = [1, -1, 0, 0]

visited = [[0] * M for _ in range(N)]

cnt = 0

for i in range(N):
    for j in range(M):
        if visited[i][j] == 0 and arr[i][j] == 0:
            cnt += 1
            bfs(i, j)

print(cnt)
