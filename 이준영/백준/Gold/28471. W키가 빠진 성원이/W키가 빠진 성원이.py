import sys
from collections import deque

input = sys.stdin.readline


def oob(y, x):
    return not (0 <= y < N and 0 <= x < N)


def find_start():
    for i in range(N):
        for j in range(N):
            if arr[i][j] == "F":
                return i, j


N = int(input())
arr = [list(input().rstrip()) for _ in range(N)]
visited = [[0] * N for _ in range(N)]

dy = [0, 0, -1, 1, 1, -1, -1]
dx = [1, -1, 0, 1, -1, 1, -1]

sy, sx = find_start()
visited[sy][sx] = 1
dq = deque([(sy, sx)])
cnt = 0
while dq:
    y, x = dq.popleft()
    for k in range(7):
        ny = y + dy[k]
        nx = x + dx[k]
        if not oob(ny, nx) and visited[ny][nx] == 0 and arr[ny][nx] == ".":
            visited[ny][nx] = 1
            cnt += 1
            dq.append((ny, nx))

print(cnt)
