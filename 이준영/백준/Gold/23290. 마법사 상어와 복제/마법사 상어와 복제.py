def go(i, j, k, y, x):
    lst = [i, j, k]
    st = set([])
    for i in range(3):
        y = y + sdy[lst[i]]
        x = x + sdx[lst[i]]
        if not (0 <= y < 4 and 0 <= x < 4):
            return -1, -1, -1

        st.add((y, x))
    cnt = 0
    for i, j in st:
        for k in range(8):
            cnt = cnt + new_fish_loc[i][j][k]

    return y, x, cnt


M, S = map(int, input().split())

arr = [[[] for _ in range(4)] for _ in range(4)]

fish_loc = [[[0] * 8 for _ in range(4)] for _ in range(4)]
smell_map = [[0] * 4 for _ in range(4)]

dy = [0, -1, -1, -1, 0, 1, 1, 1]
dx = [-1, -1, 0, 1, 1, 1, 0, -1]
sdy = [-1, 0, 1, 0]
sdx = [0, -1, 0, 1]
for _ in range(M):
    y, x, c = map(int, input().split())
    fish_loc[y - 1][x - 1][c - 1] += 1

s_y, s_x = map(int, input().split())
s_y -= 1
s_x -= 1

for _ in range(S):
    tmp_fish_loc = [[lst[:] for lst in row] for row in fish_loc]
    new_fish_loc = [[[0] * 8 for _ in range(4)] for _ in range(4)]
    for i in range(4):
        for j in range(4):
            for l in range(8):
                if fish_loc[i][j][l] != 0:
                    cnt = fish_loc[i][j][l]
                    for k in range(8):
                        tmp = (l - k) % 8
                        ny = i + dy[tmp]
                        nx = j + dx[tmp]
                        if 0 <= ny < 4 and 0 <= nx < 4 and smell_map[ny][nx] == 0 and (ny, nx) != (s_y, s_x):
                            new_fish_loc[ny][nx][tmp] += cnt
                            break
                    else:
                        new_fish_loc[i][j][l] += cnt

    for i in range(4):
        for j in range(4):
            if smell_map[i][j] > 0:
                smell_map[i][j] -= 1

    mx = -1

    for i in range(4):
        for j in range(4):
            for k in range(4):
                y, x, ans = go(i, j, k, s_y, s_x)
                if ans > mx:
                    mx = ans
                    s_move = [i, j, k]

    for i in s_move:
        s_y = s_y + sdy[i]
        s_x = s_x + sdx[i]
        flag = False
        for k in range(8):
            if new_fish_loc[s_y][s_x][k] != 0:
                new_fish_loc[s_y][s_x][k] = 0
                flag = True

        if flag:
            smell_map[s_y][s_x] = 2

    for i in range(4):
        for j in range(4):
            for k in range(8):
                new_fish_loc[i][j][k] += tmp_fish_loc[i][j][k]

    fish_loc = new_fish_loc

tot_cnt = 0
for i in range(4):
    for j in range(4):
        for k in range(8):
            tot_cnt += fish_loc[i][j][k]

print(tot_cnt)
