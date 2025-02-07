import sys

input = sys.stdin.readline

R, C = map(int, input().split())
arr = [list(input().rstrip()) for _ in range(R)]

visited = [[False] * C for _ in range(R)]

dy = [0, 0, 1, -1]
dx = [1, -1, 0, 0]
dq1 = []
dq2 = []

for i in range(R):
    for j in range(C):
        if arr[i][j] == "S":
            s_y, s_x = i, j
            dq2.append((s_y, s_x))
            arr[i][j] = "."
            visited[i][j] = True
        elif arr[i][j] == "*":
            dq1.append((i, j))

t = 1
check = False
while dq2:

    tmp_dq1 = []
    tmp_dq2 = []

    for y, x in dq1:
        for k in range(4):
            ny = y + dy[k]
            nx = x + dx[k]
            if 0 <= ny < R and 0 <= nx < C and arr[ny][nx] == ".":
                arr[ny][nx] = "*"
                tmp_dq1.append((ny, nx))

    for y, x in dq2:
        for k in range(4):
            ny = y + dy[k]
            nx = x + dx[k]
            if 0 <= ny < R and 0 <= nx < C and not visited[ny][nx]:
                if arr[ny][nx] == "D":
                    check = True
                    break
                elif arr[ny][nx] == ".":
                    visited[ny][nx] = True
                    tmp_dq2.append((ny, nx))

        if check:
            break

    if check:
        break
    t += 1
    dq1 = tmp_dq1
    dq2 = tmp_dq2


if check:
    print(t)
else:
    print("KAKTUS")
