def myprint():
    for i in range(n):
        print(*arr[i])
    print("-" * 50)


n, m, K = map(int, input().split())

arr = [[[0, 0, 0] for _ in range(m)] for _ in range(n)]

for _ in range(K):
    y, x, s, d, b = map(int, input().split())
    d -= 1
    if d <= 1:
        s = s % (2 * (n - 1))
    else:
        s = s % (2 * (m - 1))
    arr[y - 1][x - 1] = [d, s, b]

tot = 0

for l in range(m):
    for i in range(n):
        if arr[i][l][2] != 0:
            tot += arr[i][l][2]
            arr[i][l] = [0] * 3
            break

    tmp_arr = [[[0, 0, 0] for _ in range(m)] for _ in range(n)]

    for i in range(n):
        for j in range(m):
            if arr[i][j][2] != 0:
                d, s, b = arr[i][j]

                if d == 0:
                    if s <= i:
                        ny, nx, nd = i - s, j, 0
                    elif s <= n - 1 + i:
                        ny, nx, nd = s - i, j, 1
                    else:
                        ny, nx, nd = 2 * n + i - 2 - s, j, 0

                elif d == 1:
                    if s <= n - 1 - i:
                        ny, nx, nd = s + i, j, 1
                    elif s <= 2 * n - 2 - i:
                        ny, nx, nd = 2 * n - 2 - i - s, j, 0
                    else:
                        ny, nx, nd = s - (2 * n - 2 - i), j, 1

                elif d == 2:
                    if s <= m - 1 - j:
                        ny, nx, nd = i, s + j, 2
                    elif s <= 2 * m - 2 - j:
                        ny, nx, nd = i, 2 * m - 2 - j - s, 3
                    else:
                        ny, nx, nd = i, s - (2 * m - 2 - j), 2
                else:
                    if s <= j:
                        ny, nx, nd = i, j - s, 3
                    elif s <= m - 1 + j:
                        ny, nx, nd = i, s - j, 2
                    else:
                        ny, nx, nd = i, 2 * m + j - 2 - s, 3

                if tmp_arr[ny][nx][2] < b:
                    tmp_arr[ny][nx] = [nd, s, b]

    arr = tmp_arr
print(tot)
