import sys
from collections import deque

input = sys.stdin.readline


def bfs(s_y, s_x, a):
    visited[s_y][s_x] = a
    dq = deque([(s_y, s_x)])
    flag = False
    while dq:
        y, x = dq.popleft()
        for k in range(4):
            ny = y + dy[k]
            nx = x + dx[k]
            if 0 <= ny < R and 0 <= nx < C and visited[ny][nx] == 0 and arr[ny][nx] == "x":
                visited[ny][nx] = a
                dq.append((ny, nx))
                if ny == R - 1:
                    flag = True

    return flag


def drop(a):
    h = 101
    for j in range(C):
        loc = -1
        ground = R
        for i in range(R - 1, -1, -1):
            if arr[i][j] == "x":
                if visited[i][j] != a:
                    ground = i
                else:
                    loc = i
                    break
        if loc == -1:
            continue
        else:
            h = min(h, ground - loc - 1)

    for j in range(C):
        lst = []
        for i in range(R - 1, -1, -1):
            if arr[i][j] == "x" and visited[i][j] == a:
                lst.append((i, j))

        for y, x in lst:
            arr[y][x] = "."
        for y, x in lst:
            arr[y + h][x] = "x"


dy = [0, 0, 1, -1]
dx = [1, -1, 0, 0]
R, C = map(int, input().split())
arr = [list(input().rstrip()) for _ in range(R)]

N = int(input())
lst = list(map(int, input().split()))

for i in range(N):
    if i % 2 == 0:
        d = 1
        start_x = 0
    else:
        d = -1
        start_x = C - 1

    start_y = R - lst[i]
    while 0 <= start_x < C and arr[start_y][start_x] == ".":
        start_x += d

    if not (0 <= start_x < C):
        continue

    else:
        arr[start_y][start_x] = "."

        visited = [[0] * C for _ in range(R)]

        for k in range(4):
            ny = start_y + dy[k]
            nx = start_x + dx[k]
            if 0 <= ny < R and 0 <= nx < C and visited[ny][nx] == 0 and arr[ny][nx] == "x":
                check = bfs(ny, nx, k + 1)
                if not check:
                    drop(k + 1)

for i in range(R):
    print(*arr[i], sep="")
