N = int(input())
A = input()
arr = [list(input()) for _ in range(N)]
d = 0
dy = [1, 0, -1, 0]  # 아래기준 왼쪽 회전
dx = [0, 1, 0, -1]
d_y = [0, -1, -1, -1, 0, 1, 1, 1,0]
d_x = [-1, -1, 0, 1, 1, 1, 0, -1,0]

zombie = []
for i in range(N):
    for j in range(N):
        if arr[i][j] == "Z":
            zombie.append([i, j, 0])

light = [[0] * N for _ in range(N)]
flag = True
y = 0
x = 0
for s in A:
    if s == "F":
        ny = y + dy[d]
        nx = x + dx[d]
        if 0 <= ny < N and 0 <= nx < N:
            y = ny
            x = nx
            if arr[y][x] == "S":
                for k in range(9):
                    ny = y + d_y[k]
                    nx = x + d_x[k]
                    if 0 <= ny < N and 0 <= nx < N:
                        light[ny][nx] = 1

    elif s == "L":
        d = (d + 1) % 4
    else:
        d = (d - 1) % 4

    for i in range(len(zombie)):
        s_y = zombie[i][0]
        s_x = zombie[i][1]
        dir = zombie[i][2]
        if s_y == y and s_x == x and light[s_y][s_x] == 0:
            flag = False
            break

        ny = s_y + dy[dir]
        nx = s_x + dx[dir]
        if not (0 <= ny < N and 0 <= nx < N):
            zombie[i][2] = (dir + 2) % 4
        else:
            zombie[i][0], zombie[i][1] = ny, nx
            if ny == y and nx == x and light[ny][nx] == 0:
                flag = False
                break

        if not flag:
            break
    if not flag:
        break

if flag:
    print("Phew...")
else:
    print("Aaaaaah!")
