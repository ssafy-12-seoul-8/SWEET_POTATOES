def myprint():
    print("board")
    for i in range(n):
        print(*arr[i])

    print("-" * 50)


def oob(y, x):
    return not (0 <= y < n and 0 <= x < n)


dy = [0, -1, 1, 0, 0]
dx = [0, 0, 0, -1, 1]
n, m, K = map(int, input().split())
arr = [list(map(int, input().split())) for _ in range(n)]
direction = list(map(int, input().split()))
order = [[]] + [[[]] + [list(map(int, input().split())) for _ in range(4)] for _ in range(m)]
ground = [[[0, 0] for _ in range(n)] for _ in range(n)]
player_loc = [0] * (m + 1)
for i in range(n):
    for j in range(n):
        if arr[i][j] != 0:
            tmp = arr[i][j]
            ground[i][j] = [tmp, K]
            player_loc[tmp] = [i, j, direction[tmp - 1]]

turn = 0
ans = -1
cnt = m
while turn <= 999:
    turn += 1
    tmp_arr = [[0] * n for _ in range(n)]

    for i in range(1, m + 1):
        if player_loc[i][0] == -1:
            continue

        flag = False
        y, x, d = player_loc[i]
        for k in order[i][d]:
            ny = y + dy[k]
            nx = x + dx[k]
            if not oob(ny, nx) and ground[ny][nx][0] == 0:
                flag = True
                if tmp_arr[ny][nx] == 0:
                    tmp_arr[ny][nx] = i
                    player_loc[i] = [ny, nx, k]
                else:
                    cnt -= 1
                    player_loc[i] = [-1, -1, -1]
                break
        if flag:
            continue

        for k in order[i][d]:
            ny = y + dy[k]
            nx = x + dx[k]
            if not oob(ny, nx) and ground[ny][nx][0] == i:
                if tmp_arr[ny][nx] == 0:
                    tmp_arr[ny][nx] = i
                    player_loc[i] = [ny, nx, k]
                else:
                    cnt -= 1
                    player_loc[i] = [-1, -1, -1]
                break

    for i in range(n):
        for j in range(n):
            if ground[i][j][1] > 0:
                ground[i][j][1] -= 1
                if ground[i][j][1] == 0:
                    ground[i][j] = [0, 0]

    for i in range(1, m + 1):
        if player_loc[i][0] != -1:
            y, x, d = player_loc[i]
            ground[y][x] = [i, K]

    arr = tmp_arr

    if cnt == 1:
        ans = turn
        break


print(ans)
