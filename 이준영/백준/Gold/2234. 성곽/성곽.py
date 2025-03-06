import sys
from collections import deque

input = sys.stdin.readline


def bfs(s_y, s_x, c):
    new_arr[s_y][s_x] = c
    dq = deque([(s_y, s_x)])
    cnt = 1
    while dq:
        y, x = dq.popleft()
        for k in range(4):
            if (arr[y][x] & (1 << k)) == 0:
                ny = y + dy[k]
                nx = x + dx[k]
                if 0 <= ny < N and 0 <= nx < M and new_arr[ny][nx] == 0:
                    new_arr[ny][nx] = c
                    cnt += 1
                    dq.append((ny, nx))

    return cnt


M, N = map(int, input().split())
dy = [0, -1, 0, 1]
dx = [-1, 0, 1, 0]

arr = [list(map(int, input().split())) for _ in range(N)]
dct = {}
cur = 1
new_arr = [[0] * M for _ in range(N)]

mx1 = 0
for i in range(N):
    for j in range(M):
        if new_arr[i][j] != 0:
            continue
        cnt = bfs(i, j, cur)
        dct[cur] = cnt
        mx1 = max(mx1, cnt)
        cur += 1

mx2 = 0
for i in range(N):
    for j in range(M):
        a1 = new_arr[i][j]
        for k in range(4):
            ny = i + dy[k]
            nx = j + dx[k]
            if 0 <= ny < N and 0 <= nx < M and new_arr[ny][nx] != a1:
                tmp = dct[a1] + dct[new_arr[ny][nx]]
                mx2 = max(mx2, tmp)

print(cur - 1, mx1, mx2, sep="\n")
