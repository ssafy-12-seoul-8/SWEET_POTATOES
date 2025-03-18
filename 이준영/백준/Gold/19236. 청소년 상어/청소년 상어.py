def fish_move():
    for i in range(1, 17):
        if loc[i][0] != -1:
            y, x, d = loc[i]
            for k in range(8):
                tmp = (d + k) % 8
                ny = y + dy[tmp]
                nx = x + dx[tmp]
                if 0 <= ny < 4 and 0 <= nx < 4 and arr[ny][nx] != 0:
                    t_num = arr[ny][nx]
                    arr[ny][nx] = i
                    loc[i] = [ny, nx, tmp]
                    arr[y][x] = t_num
                    if t_num > 0:
                        loc[t_num] = [y, x, loc[t_num][2]]
                    break


def btk(y, x, d, score):
    global mx, arr, loc

    t_arr = [row[:] for row in arr]
    t_loc = [row[:] for row in loc]
    flag = False
    for k in range(1, 4):
        ny = y + dy[d] * k
        nx = x + dx[d] * k
        if not (0 <= ny < 4 and 0 <= nx < 4):
            break

        if arr[ny][nx] > 0:
            flag = True
            num = arr[ny][nx]
            t_d = loc[num][2]
            loc[num] = [-1, -1, -1]
            arr[ny][nx] = 0
            arr[y][x] = -1
            fish_move()
            btk(ny, nx, t_d, score + num)
            loc = [row[:] for row in t_loc]
            arr = [row[:] for row in t_arr]
    if not flag:
        mx = max(mx, score)


dy = [-1, -1, 0, 1, 1, 1, 0, -1]
dx = [0, -1, -1, -1, 0, 1, 1, 1]
arr = [[0] * 4 for _ in range(4)]

loc = [0] * 17
for i in range(4):
    lst = list(map(int, input().split()))
    for j in range(4):
        num = lst[2 * j]
        d = lst[2 * j + 1] - 1
        arr[i][j] = num
        loc[num] = [i, j, d]

tot = arr[0][0]
loc[0] = [0, 0, loc[tot][2]]
loc[arr[0][0]] = [-1, -1, -1]
mx = 0
arr[0][0] = 0

fish_move()

btk(0, 0, loc[0][2], tot)

print(mx)
