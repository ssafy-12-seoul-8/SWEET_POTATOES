import sys
from collections import deque

input = sys.stdin.readline
k = int(input())

arr = [list(input().rstrip()) for _ in range(4 * k)]
visited = [[[0] * 4 for _ in range(4 * k)] for _ in range(4 * k)]
rotate_loc = [[[] for _ in range(4 * k)] for _ in range(4 * k)]
for i in range(4 * k):
    for j in range(4 * k):
        n = i // 4
        m = j // 4
        rotate_loc[i][j] = [(i, j), (4 * n + j - 4 * m, 4 * m + 3 - (i - 4 * n)),
                            (4 * n + 3 - (i - 4 * n), 4 * m + 3 - (j - 4 * m)),
                            (4 * n + 3 - (j - 4 * m), 4 * m + i - 4 * n)]

dy = [0, 1, 0, -1]
dx = [1, 0, -1, 0]
for i in range(4 * k):
    for j in range(4 * k):
        if arr[i][j] == "#":
            arr[i][j] = 1
        elif arr[i][j] == ".":
            arr[i][j] = 0
        elif arr[i][j] == "S":
            sy, sx = i, j
            arr[i][j] = 0
        elif arr[i][j] == "E":
            ey, ex = i, j
            arr[i][j] = 0

visited[sy][sx][0] = 1
dq = deque([(sy, sx, 0, 0)])
ans = -1
while dq:
    y, x, d, dis = dq.popleft()
    ry, rx = rotate_loc[y][x][d]
    if y == ey and x == ex:
        ans = dis
        break
    n, m = y // 4, x // 4
    tmp = (d + 1) % 4
    if visited[y][x][tmp] == 0:
        visited[y][x][tmp] = 1
        dq.append((y, x, tmp, dis + 1))

    for l in range(4):
        ny = y + dy[l]
        nx = x + dx[l]
        if 0 <= ny < 4 * k and 0 <= nx < 4 * k and ny // 4 == n and nx // 4 == m:
            if visited[ny][nx][(d + 1) % 4] == 0 and arr[ny][nx] == 0:
                visited[ny][nx][(d + 1) % 4] = 1
                dq.append((ny, nx, (d + 1) % 4, dis + 1))
        else:
            rd = (l + d) % 4
            ny = ry + dy[rd]
            nx = rx + dx[rd]
            if 0 <= ny < 4 * k and 0 <= nx < 4 * k and arr[ny][nx] == 0 and visited[ny][nx][1] == 0:
                visited[ny][nx][1] = 0
                dq.append((ny, nx, 1, dis + 1))


print(ans)
