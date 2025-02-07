import sys
from collections import deque

input = sys.stdin.readline


def find_h(start_y, start_x, height):
    dq = deque([(start_y, start_x)])
    cnt = 0
    check = True
    while dq:
        y, x = dq.popleft()
        if not visited[y][x]:
            visited[y][x] = True
            cnt += 1
            for k in range(4):
                ny = y + dy[k]
                nx = x + dx[k]
                if 0 <= ny < N and 0 <= nx < M and arr[ny][nx] < height and not visited[ny][nx]:
                    dq.append((ny, nx))
                    if ny == 0 or ny == N - 1 or nx == 0 or nx == M - 1:
                        check = False

    if check:
        return cnt
    return 0


N, M = map(int, input().split())
arr = [list(map(int, input().rstrip())) for _ in range(N)]

dy = [0, 0, 1, -1]
dx = [1, -1, 0, 0]
tot = 0

for h in range(2, 10):
    visited = [[False] * M for _ in range(N)]
    for i in range(1, N - 1):
        for j in range(1, M - 1):
            if arr[i][j] < h and not visited[i][j]:
                tot += find_h(i, j, h)

print(tot)
