from collections import deque


def check(sy, sx, ny, nx):
    if sy == ny:
        if sx < nx:
            if (sy, sx) in one_wall:
                return False

        elif (ny, nx) in one_wall:
            return False

    if sx == nx:
        if sy < ny:
            if (ny, nx) in zero_wall:
                return False

        elif (sy, sx) in zero_wall:
            return False
    return True


R, C, K = map(int, input().split())
arr = [list(map(int, input().split())) for _ in range(R)]
temp = [[0] * C for _ in range(R)]
W = int(input())
dct = {}
dy = [0, 0, -1, 1]
dx = [1, -1, 0, 0]

spread = [[(0, 1), (-1, 1), (1, 1)], [(0, -1), (-1, -1), (1, -1)], [(-1, 0), (-1, 1), (-1, -1)],
          [(1, 0), (1, 1), (1, -1)]]

zero_wall = set([])
one_wall = set([])
for _ in range(W):
    y, x, t = map(int, input().split())
    if t == 0:
        zero_wall.add((y - 1, x - 1))
    else:
        one_wall.add((y - 1, x - 1))

o_lst = []
show = []
for i in range(R):
    for j in range(C):
        if arr[i][j] == 5:
            show.append((i, j))
        elif arr[i][j] > 0:
            o_lst.append((i, j, arr[i][j] - 1))

cnt = 0
while True:
    for y, x, d in o_lst:
        dq = deque([])
        visited = [[0] * C for _ in range(R)]
        ny = y + dy[d]
        nx = x + dx[d]
        temp[ny][nx] += 5
        dq.append((ny, nx, 5))

        while dq:
            sy, sx, power = dq.popleft()

            ny = sy + spread[d][0][0]
            nx = sx + spread[d][0][1]
            if power == 1:
                break

            if (0 <= ny < R and 0 <= nx < C) and check(sy, sx, ny, nx):
                if visited[ny][nx] == 0:
                    visited[ny][nx] = 1
                    temp[ny][nx] += (power - 1)
                    dq.append((ny, nx, power - 1))

            for k in range(1, 3):
                ny = sy + spread[d][k][0]
                nx = sx + spread[d][k][1]
                cny = ny - dy[d]
                cnx = nx - dx[d]

                if not (0 <= ny < R and 0 <= nx < C):
                    continue

                if not check(sy, sx, cny, cnx) or not check(cny,cnx,ny,nx):
                    continue

                if visited[ny][nx] == 0:
                    visited[ny][nx] = 1
                    temp[ny][nx] += (power - 1)
                    dq.append((ny, nx, power - 1))

    tmp_temp = [[0] * C for _ in range(R)]

    for i in range(R):
        for j in range(C):

            for k in range(4):
                ny = i + dy[k]
                nx = j + dx[k]

                if 0 <= ny < R and 0 <= nx < C:
                    if not check(i, j, ny, nx):
                        continue

                    if temp[ny][nx] > temp[i][j]:
                        tmp_temp[i][j] += ((temp[ny][nx] - temp[i][j]) // 4)
                    else:
                        tmp_temp[i][j] -= ((temp[i][j] - temp[ny][nx]) // 4)

    for i in range(R):
        for j in range(C):
            temp[i][j] += tmp_temp[i][j]

    for i in range(R):
        for j in (0, C - 1):
            if temp[i][j] > 0:
                temp[i][j] -= 1

    for i in (0, R - 1):
        for j in range(1, C - 1):
            if temp[i][j] > 0:
                temp[i][j] -= 1


    cnt += 1

    if cnt == 101:
        break

    flag = True
    for y, x in show:
        if temp[y][x] < K:
            flag = False
            break
    if flag:
        break

print(cnt)
