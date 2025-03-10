N = int(input())
arr = [list(map(int, input().split())) for _ in range(N)]

dy = [0, 1, 0, -1]
dx = [-1, 0, 1, 0]
tmp = [[0, 0, 2, 0, 0],
       [0, 10, 7, 1, 0],
       [5, 0, 0, 0, 0],
       [0, 10, 7, 1, 0],
       [0, 0, 2, 0, 0]]

sand = [0] * 4
sand[0] = [row[:] for row in tmp]

for l in range(1, 4):
    b = [[0] * 5 for _ in range(5)]
    for i in range(5):
        for j in range(5):
            b[i][j] = tmp[j][4 - i]
    sand[l] = b
    tmp = b

d = 0
out = 0
y = x = N // 2

for l in range(1, N):
    for _ in range(2):
        for t in range(l):
            y = y + dy[d]
            x = x + dx[d]
            tot = arr[y][x]
            for i in range(5):
                for j in range(5):
                    if sand[d][i][j] == 0:
                        continue
                    else:
                        tmp = arr[y][x] * sand[d][i][j] // 100
                        ny = y + i - 2
                        nx = x + j - 2
                        if 0 <= ny < N and 0 <= nx < N:
                            arr[ny][nx] += tmp
                        else:
                            out += tmp
                        tot -= tmp

            arr[y][x] = 0
            ny = y + dy[d]
            nx = x + dx[d]
            if 0 <= ny < N and 0 <= nx < N:
                arr[ny][nx] += tot
            else:
                out += tot

        d = (d + 1) % 4

for t in range(N - 1):
    y = y + dy[d]
    x = x + dx[d]
    tot = arr[y][x]
    for i in range(5):
        for j in range(5):
            if sand[d][i][j] == 0:
                continue
            else:
                tmp = arr[y][x] * sand[d][i][j] // 100
                ny = y + i - 2
                nx = x + j - 2
                if 0 <= ny < N and 0 <= nx < N:
                    arr[ny][nx] += tmp
                else:
                    out += tmp
                tot -= tmp

    arr[y][x] = 0
    ny = y + dy[d]
    nx = x + dx[d]
    if 0 <= ny < N and 0 <= nx < N:
        arr[ny][nx] += tot
    else:
        out += tot

print(out)
