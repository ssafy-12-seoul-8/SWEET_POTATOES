N, K = map(int, input().split())

arr = [list(map(int, input().split())) for _ in range(N)]

dy = [-1, 0, 1, 0]
dx = [0, 1, 0, -1]
move = [[1, -1, -1, 2],
        [3, 2, -1, -1],
        [-1, -1, 1, 0],
        [-1, 0, 3, -1],
        [0, -1, 2, -1],
        [-1, 1, -1, 3]]

distance = [[-1] * N for _ in range(N)]
cnt = 0
distance[0][0] = 0

if move[arr[0][0]][1] != -1:
    distance[0][0] = 1
    y, x = 0, 0
    d = 1
    cnt += 1

    while True:
        nd = move[arr[y][x]][d]
        ny = y + dy[nd]
        nx = x + dx[nd]

        if not (0 <= ny < N and 0 <= nx < N):
            break
        if move[arr[ny][nx]][nd] != -1:
            cnt += 1
            y, x, d = ny, nx, nd
            distance[y][x] = cnt
        else:
            break

if K == 0:
    if distance[N - 1][N - 1] > 0 and 1 in move[arr[N - 1][N - 1]]:
        print(distance[N - 1][N - 1])
    else:
        print(-1)

else:
    if distance[N - 1][N - 1] > 0:
        if 1 in move[arr[N - 1][N - 1]]:
            if cnt == N ** 2:
                print(-1)
            else:
                print(distance[N - 1][N - 1])
        else:
            print(distance[N - 1][N - 1])

    else:
        mn = 2501
        if arr[N - 1][N - 1] not in (2, 5):
            for k in (0, 3):
                ny = N - 1 + dy[k]
                nx = N - 1 + dx[k]
                if distance[ny][nx] > 0 and (k + 2) % 4 in move[arr[ny][nx]]:
                    mn = min(mn, distance[ny][nx] + 1)

        else:
            y = N - 1
            x = N - 1
            d = 3
            dis = 1
            while True:
                for k in range(4):
                    ny = y + dy[k]
                    nx = x + dx[k]
                    if 0 <= ny < N and 0 <= nx < N:
                        if distance[ny][nx] > 0:
                            if k == move[arr[y][x]][d] or (k + 2) % 4 in move[arr[ny][nx]]:
                                mn = min(mn, distance[ny][nx] + dis)
                        elif distance[ny][nx] == 0:
                            if k in move[arr[y][x]]:
                                mn = min(mn, dis + 1)
                        elif k == move[arr[y][x]][d]:
                            flag = True
                            for l in range(4):
                                nny = ny + dy[l]
                                nnx = nx + dx[l]
                                if 0 <= nny < N and 0 <= nnx < N and distance[nny][nnx] > 0 and (l + 2) % 4 in move[
                                    arr[nny][nnx]]:
                                    mn = min(mn, distance[nny][nnx] + dis + 1)

                nd = move[arr[y][x]][d]
                ny = y + dy[nd]
                nx = x + dx[nd]

                if not (0 <= ny < N and 0 <= nx < N):
                    break

                if move[arr[ny][nx]][nd] != -1:
                    dis += 1
                    y, x, d = ny, nx, nd
                else:
                    break

        if mn == 2501:
            print(-1)
        else:
            print(mn)
