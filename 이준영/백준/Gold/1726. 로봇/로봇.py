from collections import deque


def oob(y, x):
    return not (0 <= y < N and 0 <= x < M)


N, M = map(int, input().split())
arr = [list(map(int, input().split())) for _ in range(N)]
dy = [0, 0, 1, -1]
dx = [1, -1, 0, 0]

sy, sx, sd = map(int, input().split())
ey, ex, ed = map(int, input().split())
sy -= 1
sx -= 1
sd -= 1
ey -= 1
ex -= 1
ed -= 1
change = [[2, 3], [2, 3], [0, 1], [0, 1]]

visited = [[[0] * 4 for _ in range(M)] for _ in range(N)]

visited[sy][sx][sd] = 1

dq = deque([(sy, sx, sd, 0)])

while dq:
    y, x, d, dis = dq.popleft()

    if (y, x, d) == (ey, ex, ed):
        print(dis)
        break
    # 앞으로 전진

    for l in range(1, 4):
        ny = y + dy[d] * l
        nx = x + dx[d] * l
        if oob(ny, nx):
            break

        if arr[ny][nx] == 1:
            break

        if arr[ny][nx] == 0 and visited[ny][nx][d] == 0:
            visited[ny][nx][d] = 1
            dq.append((ny, nx, d, dis + 1))

    # 회전
    for k in change[d]:
        if visited[y][x][k] == 0:
            visited[y][x][k] = 1
            dq.append((y, x, k, dis + 1))
