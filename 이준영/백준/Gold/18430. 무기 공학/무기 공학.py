def btk(cur, sm):
    global mx

    if cur == N * M:
        mx = max(mx, sm)
        return

    y = cur // M
    x = cur % M
    if visited[y][x] == 1:
        btk(cur + 1, sm)
        return

    visited[y][x] = 1
    for i in range(4):
        flag = True
        for j in range(2):
            ny = y + w[i][j][0]
            nx = x + w[i][j][1]
            if 0 <= ny < N and 0 <= nx < M and visited[ny][nx] == 0:
                continue
            flag = False

        if not flag:
            continue

        tmp = sm + 2 * arr[y][x]
        lst = []
        for j in range(2):
            ny = y + w[i][j][0]
            nx = x + w[i][j][1]
            visited[ny][nx] = 1
            lst.append((ny, nx))
            tmp += arr[ny][nx]

        btk(cur + 1, tmp)
        for t_y, t_x in lst:
            visited[t_y][t_x] = 0

    visited[y][x] = 0
    btk(cur + 1, sm)


w = [[(0, -1), (1, 0)], [(0, -1), (-1, 0)], [(-1, 0), (0, 1)], [(0, 1), (1, 0)]]

N, M = map(int, input().split())
arr = [list(map(int, input().split())) for _ in range(N)]

if N == 1 or M == 1:
    print(0)

else:
    mx = 0
    visited = [[0] * M for _ in range(N)]
    btk(0, 0)
    print(mx)
