import sys

input = sys.stdin.readline
N, M = map(int, input().split())

arr = [list(input().rstrip()) for _ in range(N)]

dy = [-1, 0, 1, 0]
dx = [0, 1, 0, -1]
n_d = {0: "U", 1: "R", 2: "D", 3: "L"}
change = [[0, 1, 2, 3],
          [1, 0, 3, 2],
          [3, 2, 1, 0]]

for i in range(N):
    for j in range(M):
        if arr[i][j] == ".":
            arr[i][j] = 0
        elif arr[i][j] == "/":
            arr[i][j] = 1
        elif arr[i][j] == "C":
            arr[i][j] = 3
        else:
            arr[i][j] = 2

s_y, s_x = map(int, input().split())
s_y -= 1
s_x -= 1

ans = 0
ans_d = 0
for i in range(4):
    d = i
    visited = [[[0] * 4 for _ in range(M)] for _ in range(N)]
    visited[s_y][s_x][d] = 1
    y = s_y
    x = s_x
    time = 1
    while True:
        ny = y + dy[d]
        nx = x + dx[d]
        if 0 <= ny < N and 0 <= nx < M:
            if arr[ny][nx] == 3:
                break
            d = change[arr[ny][nx]][d]
            if visited[ny][nx][d] == 1:
                time = int(1e9)
                break
            visited[ny][nx][d] = 1
            y = ny
            x = nx
        else:
            break

        time += 1

    if ans < time:
        ans = time
        ans_d = i
    if ans == int(1e9):
        break

print(n_d[ans_d])
if ans == int(1e9):
    print("Voyager")
else:
    print(ans)
