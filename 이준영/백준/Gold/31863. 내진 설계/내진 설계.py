from collections import deque
import sys

input = sys.stdin.readline
N, M = map(int, input().split())
dy = [0, 0, 1, -1]
dx = [1, -1, 0, 0]
arr = [list(input().rstrip()) for _ in range(N)]

visited = [[0] * M for _ in range(N)]
dq = deque([])
tot = 0
for i in range(N):
    for j in range(M):
        if arr[i][j] == "@":
            dq.append((i, j, 2))
            arr[i][j] = "."
        elif arr[i][j] == "*":
            tot += 1
        elif arr[i][j] == "#":
            tot += 1
cnt = 0
while dq:
    y, x, d = dq.popleft()
    for k in range(4):
        for l in range(1, d + 1):
            ny = y + dy[k] * l
            nx = x + dx[k] * l
            if not (0 <= ny < N and 0 <= nx < M):
                break
            if arr[ny][nx] == ".":
                continue
            elif arr[ny][nx] == "|":
                break
            elif arr[ny][nx] == "#":
                arr[ny][nx] = "*"
            elif arr[ny][nx] == "*":
                arr[ny][nx] = "."
                cnt += 1
                dq.append((ny, nx, 1))

print(cnt, tot - cnt)
