import sys
from collections import deque

input = sys.stdin.readline


def check(s_y, s_x):
    visited = [[0] * M for _ in range(N)]
    visited[s_y][s_x] = 1
    dq = deque([(s_y, s_x, 0)])

    while True:
        y, x, dis = dq.popleft()
        for k in range(4):
            ny = y + dy[k]
            nx = x + dx[k]
            if 0 <= ny < N and 0 <= nx < M and visited[ny][nx] == 0 and arr[ny][nx] == "L":
                visited[ny][nx] = 1
                dq.append((ny, nx, dis + 1))

        if not dq:
            res = dis
            break
    return res


N, M = map(int, input().split())
dy = [0, 0, 1, -1]
dx = [1, -1, 0, 0]
arr = [list(input().rstrip()) for _ in range(N)]
ans = 0
for i in range(N):
    for j in range(M):
        if arr[i][j] == "L":
            ans = max(ans, check(i, j))

print(ans)
