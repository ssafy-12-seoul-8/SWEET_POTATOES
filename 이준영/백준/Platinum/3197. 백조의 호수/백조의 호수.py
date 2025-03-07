import sys
from collections import deque

input = sys.stdin.readline


def bfs(s_y, s_x, c):
    arr[s_y][s_x] = c
    dq.append((s_y, s_x))
    while dq:
        y, x = dq.popleft()
        for k in range(4):
            ny = y + dy[k]
            nx = x + dx[k]
            if 0 <= ny < R and 0 <= nx < C:
                if arr[ny][nx] == -1:
                    arr[ny][nx] = c
                    dq.append((ny, nx))
                elif arr[ny][nx] == 0:
                    n_dq.append((ny, nx, c))


def find(a):
    if par[a] != a:
        par[a] = find(par[a])

    return par[a]


R, C = map(int, input().split())
arr = [list(input().rstrip()) for _ in range(R)]
dy = [0, 0, 1, -1]
dx = [1, -1, 0, 0]

x1, y1, x2, y2 = -1, -1, -1, -1

for i in range(R):
    for j in range(C):
        if arr[i][j] == "X":
            arr[i][j] = 0
        elif arr[i][j] == ".":
            arr[i][j] = -1
        else:
            arr[i][j] = -1
            if x1 != -1:
                x2 = j
                y2 = i
            else:
                x1 = j
                y1 = i

cur = 1
dq = deque([])
n_dq = deque([])

for i in range(R):
    for j in range(C):
        if arr[i][j] == -1:
            bfs(i, j, cur)
            cur += 1

par = [i for i in range(cur)]
c1 = arr[y1][x1]
c2 = arr[y2][x2]

time = 0
while True:
    if find(c1) == find(c2):
        break

    l = len(n_dq)
    for _ in range(l):
        y, x, c = n_dq.popleft()
        if arr[y][x] == 0:
            arr[y][x] = c
            for k in range(4):
                ny = y + dy[k]
                nx = x + dx[k]
                if 0 <= ny < R and 0 <= nx < C:
                    if arr[ny][nx] == 0:
                        n_dq.append((ny, nx, c))
                    elif arr[ny][nx] != c:
                        d = arr[ny][nx]
                        a = find(c)
                        b = find(d)
                        if a == b:
                            continue
                        else:
                            par[b] = a
        else:
            if arr[y][x] == c:
                continue
            else:
                d = arr[y][x]
                a = find(c)
                b = find(d)
                if a == b:
                    continue
                else:
                    par[b] = a

    time += 1
print(time)
