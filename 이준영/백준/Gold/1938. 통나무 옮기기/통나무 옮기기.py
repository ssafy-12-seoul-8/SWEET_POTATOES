import sys
from collections import deque

input = sys.stdin.readline
N = int(input())
arr = [list(input().rstrip()) for _ in range(N)]

dy = [0, 0, 1, -1]
dx = [1, -1, 0, 0]
for i in range(N):
    for j in range(N):
        if arr[i][j] == "B":
            if j + 1 < N and arr[i][j + 1] == "B":
                s_d = 0
                s_y, s_x = i, j + 1
                for k in range(3):
                    arr[i][j + k] = 0
            else:
                s_d = 1
                s_y, s_x = i + 1, j
                for k in range(3):
                    arr[i + k][j] = 0
        elif arr[i][j] == "E":
            if j + 1 < N and arr[i][j + 1] == "E":
                e_d = 0
                e_y, e_x = i, j + 1
                for k in range(3):
                    arr[i][j + k] = 0
            else:
                e_d = 1
                e_y, e_x = i + 1, j
                for k in range(3):
                    arr[i + k][j] = 0
        else:
            arr[i][j] = int(arr[i][j])

visited = [[[0, 0] for _ in range(N)] for _ in range(N)]
visited[s_y][s_x][s_d] = 1
dq = deque([(0, s_y, s_x, s_d)])
ans = 0
while dq:
    t, y, x, d = dq.popleft()
    if y == e_y and x == e_x and d == e_d:
        ans = t
        break

    # 가로상태
    if d == 0:
        for k in range(4):
            if k <= 1:
                ny = y
                nx = x + dx[k]
                c_nx = x + dx[k] * 2
                if 0 <= c_nx < N and arr[ny][c_nx] == 0 and visited[ny][nx][d] == 0:
                    visited[ny][nx][d] = 1
                    dq.append((t + 1, ny, nx, d))
            else:
                ny = y + dy[k]
                nx = x
                if 0 <= ny < N:
                    flag = True
                    for k in range(-1, 2):
                        if arr[ny][nx + k] == 1:
                            flag = False
                            break

                    if flag and visited[ny][nx][d] == 0:
                        visited[ny][nx][d] = 1
                        dq.append((t + 1, ny, nx, d))
    # 세로 상태
    else:
        for k in range(4):
            if k <= 1:
                ny = y
                nx = x + dx[k]
                if 0 <= nx < N:
                    flag = True
                    for k in range(-1, 2):
                        if arr[ny + k][nx] == 1:
                            flag = False
                            break

                    if flag and visited[ny][nx][d] == 0:
                        visited[ny][nx][d] = 1
                        dq.append((t + 1, ny, nx, d))
            else:
                ny = y + dy[k]
                c_ny = y + dy[k] * 2
                nx = x
                if 0 <= c_ny < N and arr[c_ny][nx] == 0 and visited[ny][nx][d] == 0:
                    visited[ny][nx][d] = 1
                    dq.append((t + 1, ny, nx, d))

    # 회전
    flag = True
    for ddy in range(-1, 2):
        for ddx in range(-1, 2):
            ny = y + ddy
            nx = x + ddx
            if not (0 <= ny < N and 0 <= nx < N) or arr[ny][nx] == 1:
                flag = False

    if flag and visited[y][x][1 - d] == 0:
        visited[y][x][1 - d] = 1
        dq.append((t + 1, y, x, 1 - d))
print(ans)
