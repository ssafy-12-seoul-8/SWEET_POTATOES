import sys
from collections import deque

input = sys.stdin.readline


def oob(y, x):
    return not (0 <= y < N and 0 <= x < M)


def oob2(y, x):
    return not (y_min <= y <= y_max and x_min <= x <= x_max)


def find_loc():
    for i in range(N):
        for j in range(M):
            if board[i][j] == "T":
                return i, j


N, M = map(int, input().split())
dy = [-1, 0, 1, 0]
dx = [0, 1, 0, -1]
direction = {(-1, 0): "U", (1, 0): "D", (0, 1): "R", (0, -1): "L"}
board = [list(input().rstrip()) for _ in range(N)]
visited = [[0] * M for _ in range(N)]
turtle = []
wall = []
sy, sx = find_loc()
ly, lx, ry, rx = sy, sx, sy, sx
visited[sy][sx] = 1
dq = deque([(sy, sx)])
while dq:
    y, x = dq.popleft()
    turtle.append((sy - y, sx - x))
    ly = min(ly, y)
    lx = min(lx, x)
    ry = max(ry, y)
    rx = max(rx, x)

    for k in range(4):
        ny = y + dy[k]
        nx = x + dx[k]
        if 0 <= ny < N and 0 <= nx < M and visited[ny][nx] == 0 and board[ny][nx] == "T":
            visited[ny][nx] = 1
            dq.append((ny, nx))

y_min = 0
y_max = N - 1 - (ry - sy)
x_min = sx - lx
x_max = M - 1 - (rx - sx)

for i in range(N):
    for j in range(M):
        if board[i][j] == "#":
            wall.append((i, j))
        elif board[i][j] == "H":
            ey, ex = i, j

visited = [[[] for _ in range(M)] for _ in range(N)]
dest = set()

for dy1, dx1 in turtle:
    for y2, x2 in wall:
        ny = y2 + dy1
        nx = x2 + dx1
        if not oob(ny, nx):
            visited[ny][nx] = [(ny, nx)]

    ny = ey + dy1
    nx = ex + dx1
    if not oob(ny, nx):
        dest.add((ny, nx))

visited[sy][sx] = [(sy, sx)]
dq = deque([(sy, sx)])
flag = False
while dq:
    y, x = dq.popleft()
    if (y, x) in dest:
        flag = True
        break

    for k in range(4):
        ny = y + dy[k]
        nx = x + dx[k]
        if not oob2(ny, nx) and not visited[ny][nx]:
            visited[ny][nx] = (y, x)
            dq.append((ny, nx))

if not flag:
    print(-1)
else:
    ans = []
    while (y, x) != (sy, sx):
        ny, nx = visited[y][x]
        ans.append(direction[(y - ny, x - nx)])
        y, x = ny, nx

    print(*ans[::-1], sep="")
