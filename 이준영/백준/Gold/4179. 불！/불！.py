import sys
from collections import deque

input = sys.stdin.readline

N, M = map(int, input().split())
arr = [list(input().rstrip()) for _ in range(N)]

dy = [0, 0, 1, -1]
dx = [1, -1, 0, 0]
f_dq = deque([])
j_dq = deque([])
visited = [[0] * M for _ in range(N)]

for i in range(N):
    for j in range(M):
        if arr[i][j] == "J":
            j_dq.append((i, j))
            arr[i][j] = "."
            visited[i][j] = 1
        elif arr[i][j] == "F":
            f_dq.append((i, j))

time = 0
flag = False
while j_dq:

    time += 1
    l1 = len(f_dq)
    l2 = len(j_dq)

    for _ in range(l1):
        y, x = f_dq.popleft()
        for k in range(4):
            ny = y + dy[k]
            nx = x + dx[k]
            if 0 <= ny < N and 0 <= nx < M and arr[ny][nx] == ".":
                arr[ny][nx] = "F"
                f_dq.append((ny, nx))

    for _ in range(l2):
        y, x = j_dq.popleft()
        for k in range(4):
            ny = y + dy[k]
            nx = x + dx[k]
            if not (0 <= ny < N and 0 <= nx < M):
                flag = True
                break
            elif (visited[ny][nx] == 0 and arr[ny][nx] == "."):
                visited[ny][nx] = 1
                j_dq.append((ny, nx))
    if flag:
        break

if flag:
    print(time)
else:
    print("IMPOSSIBLE")
