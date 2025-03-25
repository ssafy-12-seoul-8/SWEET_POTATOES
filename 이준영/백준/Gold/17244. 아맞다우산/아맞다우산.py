from collections import deque


def oob(y, x):
    return not (0 <= y < N and 0 <= x < M)


M, N = map(int, input().split())
arr = [list(input()) for _ in range(N)]

k = 0
for i in range(N):
    for j in range(M):
        if arr[i][j] == "#":
            arr[i][j] = -2
        elif arr[i][j] == ".":
            arr[i][j] = -1
        elif arr[i][j] == "S":
            sy, sx = i, j
            arr[i][j] = -1
        elif arr[i][j] == "E":
            ey, ex = i, j
            arr[i][j] = -1
        else:
            arr[i][j] = k
            k += 1

visited = [[[0] * (1 << k) for _ in range(M)] for _ in range(N)]

visited[sy][sx][0] = 1
dq = deque([(sy, sx, 0, 0)])
dy = [0, 0, 1, -1]
dx = [1, -1, 0, 0]
while dq:
    y, x, g, dis = dq.popleft()

    if (y, x) == (ey, ex) and g == ((1 << k) - 1):
        print(dis)
        break

    for l in range(4):
        ny = y + dy[l]
        nx = x + dx[l]
        if not oob(ny, nx) and arr[ny][nx] != -2:
            if arr[ny][nx] == -1:
                tg = g
            else:
                tg = g | (1 << arr[ny][nx])

            if visited[ny][nx][tg] == 0:
                visited[ny][nx][tg] = 1
                dq.append((ny, nx, tg, dis + 1))
