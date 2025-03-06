import sys
from collections import deque
input = sys.stdin.readline

def btk(cur):
    global mn
    if mn == 12:
        return
    if cur == 5:
        btk2(0)
        return

    for i in range(4):
        arr[cur] = [row[::-1] for row in zip(*arr[cur])]
        btk(cur + 1)


def btk2(cur):
    if cur == 5:
        check()
        return

    for i in range(5):
        if n_visited[i] == 0:
            n_visited[i] = 1
            b[cur] = [row[:] for row in arr[i]]
            btk2(cur + 1)
            n_visited[i] = 0


def check():
    for s_z, s_y, s_x, e_z, e_y, e_x in side:
        if b[s_z][s_y][s_x] == 0 or b[e_z][e_y][e_x] == 0:
            continue

        bfs(s_z, s_y, s_x, e_z, e_y, e_x)


def bfs(s_z, s_y, s_x, e_z, e_y, e_x):
    global mn
    cnt = 126
    visited = [[[0] * 5 for _ in range(5)] for _ in range(5)]
    visited[s_z][s_y][s_x] = 1
    dq = deque([(s_z, s_y, s_x, 0)])
    while dq:
        z, y, x, dis = dq.popleft()
        for k in range(6):
            nz = z + dz[k]
            ny = y + dy[k]
            nx = x + dx[k]
            if 0 <= nz < 5 and 0 <= ny < 5 and 0 <= nx < 5 and visited[nz][ny][nx] == 0 and b[nz][ny][nx] == 1:
                if nz == e_z and ny == e_y and nx == e_x:
                    cnt = dis + 1
                    break
                visited[nz][ny][nx] = 1
                dq.append((nz, ny, nx, dis + 1))
        if cnt != 126:
            break
    mn = min(mn, cnt)


tmp = 1
arr = [[0] * 5 for _ in range(5)]
for k in range(5):
    for i in range(5):
        arr[k][i] = list(map(int, input().split()))

side = [[0, 0, 0, 4, 4, 4],
        [0, 4, 0, 4, 0, 4],
        [0, 0, 4, 4, 4, 0],
        [0, 4, 4, 4, 0, 0]]

dz = [0, 0, 0, 0, 1, -1]
dy = [0, 0, 1, -1, 0, 0]
dx = [1, -1, 0, 0, 0, 0]
b = [[[0] * 5 for _ in range(5)] for _ in range(5)]
mn = 126
n_visited = [0] * 5
btk(0)

if mn == 126:
    print(-1)
else:
    print(mn)

