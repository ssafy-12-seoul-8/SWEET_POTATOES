def oob(y, x):
    return not (0 <= y < N and 0 <= x < N)


def player_move():
    global py, px

    d = change_direction[command[time - 1]]
    ny = py + dy[d]
    nx = px + dx[d]
    if not oob(ny,nx) and board[ny][nx] == 0:
        py, px = ny, nx


def zombi_move(t):
    y, x, ty, d, v = zombi_loc[t]
    if ty == 0:
        for _ in range(v):
            ny = y + dy[d]
            nx = x + dx[d]
            if not oob(ny, nx) and board[ny][nx] == 0:
                y, x = ny, nx
            else:
                zombi_loc[t][3] = reverse_direction[d]
                break
        zombi_loc[t][0], zombi_loc[t][1] = y, x
    else:
        for _ in range(v):
            ny = y + dy[d]
            nx = x + dx[d]
            if not oob(ny, nx):
                if board[ny][nx] == -1:
                    board[ny][nx] = 0
                    break
                else:
                    y, x = ny, nx
            else:
                break

        zombi_loc[t][0], zombi_loc[t][1] = y, x

        final_d = -1
        mx_cnt = -1
        for direction in (0, 3, 1, 2):
            cnt = 0
            y, x = zombi_loc[t][0], zombi_loc[t][1]
            while True:
                ny = y + dy[direction]
                nx = x + dx[direction]
                if oob(ny, nx):
                    break

                y, x = ny, nx
                if board[y][x] == -1:
                    cnt += 1

            if mx_cnt < cnt:
                final_d = direction
                mx_cnt = cnt
        zombi_loc[t][3] = final_d


N = int(input())
command = list(input())
py, px = map(int, input().split())
py -= 1
px -= 1
W = int(input())
change_direction = {"U": 0, "D": 1, "L": 2, "R": 3, "S": 4}
reverse_direction = [1, 0, 3, 2]
dy = [-1, 1, 0, 0, 0]
dx = [0, 0, -1, 1, 0]

board = [[0] * N for _ in range(N)]

for _ in range(W):
    y, x = map(int, input().split())
    board[y - 1][x - 1] = -1

Z = int(input())
zombi_loc = []

for _ in range(Z):
    y, x, t, d, v = input().split()
    y = int(y) - 1
    x = int(x) - 1
    t = int(t)
    d = change_direction[d]
    v = int(v)
    zombi_loc.append([y, x, t, d, v])

D = int(input())

isAlive = -1

for time in range(1, D + 1):

    player_move()

    for t in range(Z):
        zombi_move(t)

    for t in range(Z):
        if (zombi_loc[t][0], zombi_loc[t][1]) == (py, px):
            isAlive = time
            break
    # print(py, px)
    # print(zombi_loc)
    # for i in range(N):
    #     print(*board[i])
    if isAlive != -1:
        break
if isAlive == -1:
    print("ALIVE!")
else:
    print(isAlive)
    print("DEAD...")
