def oob(y, x):
    return not (0 <= y < 5 and 0 <= x < 5)


def btk(t, jy, jx, hy, hx):
    global cnt
    if t == t_limit:
        flag = 0
        for k in range(4):
            ny = jy + dy[k]
            nx = jx + dx[k]
            if not oob(ny, nx) and visited[ny][nx] == 0:
                flag += 1
                break
        for k in range(4):
            ny = hy + dy[k]
            nx = hx + dx[k]
            if not oob(ny, nx) and visited[ny][nx] == 0:
                flag += 1
                break

        if flag == 2:
            cnt += 1

        return

    for k in range(4):
        njy = jy + dy[k]
        njx = jx + dx[k]
        if not oob(njy, njx) and visited[njy][njx] == 0:
            visited[njy][njx] = 1
            for k2 in range(4):
                nhy = hy + dy[k2]
                nhx = hx + dx[k2]
                if not oob(nhy, nhx) and visited[nhy][nhx] == 0:
                    visited[nhy][nhx] = 1
                    btk(t + 1, njy, njx, nhy, nhx)
                    visited[nhy][nhx] = 0

            visited[njy][njx] = 0


visited = [[0] * 5 for _ in range(5)]
visited[0][0] = visited[4][4] = 1
K = int(input())
for _ in range(K):
    a, b = map(int, input().split())
    visited[a - 1][b - 1] = 1

dy = [0, 0, 1, -1]
dx = [1, -1, 0, 0]
cnt = 0
t_limit = (23 - K) // 2

btk(0, 0, 0, 4, 4)

print(cnt)
