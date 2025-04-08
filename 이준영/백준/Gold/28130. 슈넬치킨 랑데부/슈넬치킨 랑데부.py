import sys
from collections import deque

input = sys.stdin.readline


def myprint():
    print("선우 도착시간")
    for i in range(N):
        print(*arrived_time[i])

    print("상혁 도착시간")
    for i in range(N):
        print(*visited[i])


def oob(y, x):
    return not (0 <= y < N and 0 <= x < M)


N, M = map(int, input().split())
visited = [[-1] * M for _ in range(N)]
arrived_time = [[-1] * M for _ in range(N)]
arr = [list(input().rstrip()) for _ in range(N)]

dy = [0, 1, 0, -1]
dx = [1, 0, -1, 0]

for i in range(N):
    for j in range(M):
        if arr[i][j] == "A":
            fy, fx = i, j
            arr[i][j] = "."
        elif arr[i][j] == "B":
            sy, sx = i, j
            arr[i][j] = "."

arrived_time[sy][sx] = 0
if sy == 0:
    d = 0
elif sy == N - 1:
    d = 2
elif sx == 0:
    d = 3
else:
    d = 1

while True:
    ny = sy + dy[d]
    nx = sx + dx[d]
    if oob(ny, nx):
        d = (d + 1) % 4
        ny = sy + dy[d]
        nx = sx + dx[d]

    if arrived_time[ny][nx] == 0:
        break

    arrived_time[ny][nx] = arrived_time[sy][sx] + 1
    sy, sx = ny, nx

visited[fy][fx] = 0
dq = deque([(fy, fx, 0)])

while dq:
    y, x, dis = dq.popleft()
    for k in range(4):
        ny = y + dy[k]
        nx = x + dx[k]
        if not oob(ny, nx) and visited[ny][nx] == -1 and arr[ny][nx] != "G":
            visited[ny][nx] = dis + 1
            dq.append((ny, nx, dis + 1))

ans = int(1e9)
value = 2 * (N + M - 2)
for i in range(N):
    for j in (0, M - 1):
        if visited[i][j] == -1:
            continue

        t1 = visited[i][j]
        t2 = arrived_time[i][j]
        if (t1 - t2) % 2 == 1:
            continue

        k = max(0, (t1 - t2 - 1) // value + 1)

        ans = min(ans, t2 + k * value)

for i in (0, N - 1):
    for j in range(1, M - 1):
        if visited[i][j] == -1:
            continue

        t1 = visited[i][j]
        t2 = arrived_time[i][j]
        if (t1 - t2) % 2 == 1:
            continue

        k = max(0, (t1 - t2 - 1) // value + 1)

        ans = min(ans, t2 + k * value)

if ans == int(1e9):
    print(-1)
else:
    print(ans)
