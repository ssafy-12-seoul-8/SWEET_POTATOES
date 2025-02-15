import sys
from collections import deque

input = sys.stdin.readline

N, M, T = map(int, input().split())
arr = [list(map(int, input().split())) for _ in range(N)]
visited = [[0] * M for _ in range(N)]

time = T + 1
visited[0][0] = 1
dq = deque([(0, 0, 1)])
dy = [0, 0, 1, -1]
dx = [1, -1, 0, 0]

while dq:
    y, x, t = dq.popleft()
    if t >= time:
        break

    for k in range(4):
        ny = y + dy[k]
        nx = x + dx[k]
        if 0 <= ny < N and 0 <= nx < M and arr[ny][nx] != 1 and visited[ny][nx] == 0:
            if ny == N - 1 and nx == M - 1:
                time = min(time, t)
                break
            visited[ny][nx] = 1
            if arr[ny][nx] == 2:
                if t + abs(ny - N + 1) + abs(nx - M + 1) <= T:
                    time = min(t + abs(ny - N + 1) + abs(nx -M + 1), time)
            else:
                dq.append((ny, nx, t + 1))

if time == T + 1:
    print("Fail")

else:
    print(time)
