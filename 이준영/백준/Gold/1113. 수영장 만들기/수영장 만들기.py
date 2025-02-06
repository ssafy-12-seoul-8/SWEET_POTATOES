# 0810~0816, 0819~
import sys
from collections import deque

input = sys.stdin.readline


def find_h(start_y, start_x, height):
    visited = [[False] * M for _ in range(N)]
    dq = deque([(start_y, start_x)])
    cnt = 1
    while dq:
        y, x = dq.popleft()
        if not visited[y][x]:
            visited[y][x] = True
            if y == 0 or y == N - 1 or x == 0 or x == M - 1:
                cnt = 0
                break
            for k in range(4):
                ny = y + dy[k]
                nx = x + dx[k]
                if arr[ny][nx] < height and not visited[ny][nx]:
                    dq.append((ny, nx))

    return cnt


N, M = map(int, input().split())
arr = [list(map(int, input().rstrip())) for _ in range(N)]

dy = [0, 0, 1, -1]
dx = [1, -1, 0, 0]
tot = 0

for h in range(2, 10):
    for i in range(1, N - 1):
        for j in range(1, M - 1):
            if arr[i][j] < h:
                tot += find_h(i, j, h)

print(tot)
