import sys
from collections import deque

input = sys.stdin.readline


def bfs(s_y, s_x):
    dq = deque([(s_y, s_x)])
    while dq:
        y, x = dq.popleft()
        if not visited[y][x]:
            visited[y][x] = True
            for k in range(4):
                ny = y + dy[k]
                nx = x + dx[k]
                if 0 <= ny < N and 0 <= nx < M and not visited[ny][nx] and arr[ny][nx]!=0:
                    dq.append((ny, nx))


N, M = map(int, input().split())
arr = [list(map(int, input().split())) for _ in range(N)]
day = 0
dy = [0, 0, 1, -1]
dx = [1, -1, 0, 0]

while True:

    cnt = 0
    visited = [[False] * M for _ in range(N)]

    for i in range(N):
        for j in range(M):
            if not visited[i][j] and arr[i][j] != 0:
                cnt += 1
                if cnt == 2:
                    break
                bfs(i, j)
        if cnt == 2:
            break
    if cnt == 2 or cnt == 0:
        break

    tmp = []
    for i in range(N):
        for j in range(M):
            if arr[i][j] != 0:
                for k in range(4):
                    ny = i + dy[k]
                    nx = j + dx[k]
                    t_cnt = 0
                    if 0 <= ny < N and 0 <= nx < M and arr[ny][nx] == 0:
                        t_cnt += 1
                    tmp.append((i, j, t_cnt))

    for y, x, d in tmp:
        arr[y][x] = max(arr[y][x] - d, 0)

    day += 1

if cnt == 2:
    print(day)
else:
    print(0)
