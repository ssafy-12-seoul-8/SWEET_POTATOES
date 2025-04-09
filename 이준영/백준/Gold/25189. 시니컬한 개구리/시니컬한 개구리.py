import sys
from collections import deque

input = sys.stdin.readline


def oob(y, x):
    return not (0 <= y < N and 0 <= x < M)


N, M = map(int, input().split())
dy = [0, 0, 1, -1]
dx = [1, -1, 0, 0]
sy, sx, ey, ex = map(int, input().split())
sy -= 1
sx -= 1
ey -= 1
ex -= 1
arr = [list(map(int, input().split())) for _ in range(N)]
visited = [[[0, 0] for _ in range(M)] for _ in range(N)]

visited[sy][sx] = [1] * 2
dq = deque([(sy, sx, 0, 0)])

row = [0] * N
col = [0] * M
ans = -1

while dq:
    y, x, l_jump, dis = dq.popleft()
    if (y, x) == (ey, ex):
        ans = dis
        break
    if l_jump == 1:
        # 일반 점프
        for k in range(4):
            ny = y + dy[k] * arr[y][x]
            nx = x + dx[k] * arr[y][x]
            if not oob(ny, nx) and sum(visited[ny][nx]) == 0:
                visited[ny][nx][1] = 1
                dq.append((ny, nx, 1, dis + 1))

    else:
        # 일반 점프
        for k in range(4):
            ny = y + dy[k] * arr[y][x]
            nx = x + dx[k] * arr[y][x]
            if not oob(ny, nx) and visited[ny][nx][0] == 0:
                visited[ny][nx][0] = 1
                dq.append((ny, nx, 0, dis + 1))

        # 슈퍼 점프
        if col[x] == 0:
            col[x] = 1
            for i in range(N):
                if visited[i][x][1] == 1 or visited[i][x][0] == 1:
                    continue

                visited[i][x][1] = 1
                dq.append((i, x, 1, dis + 1))
        if row[y] == 0:
            row[y] = 1
            for j in range(M):
                if visited[y][j][1] == 1 or visited[y][j][0] == 1:
                    continue

                visited[y][j][1] = 1
                dq.append((y, j, 1, dis + 1))

print(ans)
