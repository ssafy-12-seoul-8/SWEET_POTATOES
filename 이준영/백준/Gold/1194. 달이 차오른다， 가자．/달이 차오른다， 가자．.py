import sys
from collections import deque

input = sys.stdin.readline
N, M = map(int, input().split())

arr = [list(input().rstrip()) for _ in range(N)]

visited = [[[int(1e9)] * 64 for _ in range(M)] for _ in range(N)]
dy = [0, 0, 1, -1]
dx = [1, -1, 0, 0]

s_y = -1
s_x = -1
for i in range(N):
    for j in range(M):
        if arr[i][j] == "0":
            s_y = i
            s_x = j
            arr[i][j] = "."
            break
    if s_y != -1:
        break

visited[s_y][s_x][0] = 0
dq = deque([(0, 0, s_y, s_x)])

ans = -1
while dq:
    t, key, y, x = dq.popleft()
    for k in range(4):
        ny = y + dy[k]
        nx = x + dx[k]
        if 0 <= ny < N and 0 <= nx < M and arr[ny][nx] != "#":
            if arr[ny][nx] == "1":
                ans = t + 1
                break

            elif arr[ny][nx] == ".":
                if visited[ny][nx][key] > t + 1:
                    visited[ny][nx][key] = t + 1
                    dq.append((t + 1, key, ny, nx))

            elif arr[ny][nx].isupper():
                target = ord(arr[ny][nx]) - ord("A")
                if (key & (1 << target)) != 0 and visited[ny][nx][key] > t + 1:
                    visited[ny][nx][key] = t + 1
                    dq.append((t + 1, key, ny, nx))
            else:
                target = ord(arr[ny][nx]) - ord("a")
                tmp = (key | (1 << target))
                if visited[ny][nx][tmp] > t + 1:
                    visited[ny][nx][tmp] = t + 1
                    dq.append((t + 1, tmp, ny, nx))

    if ans != -1:
        break

print(ans)
