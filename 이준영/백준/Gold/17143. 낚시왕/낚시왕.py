n, m, k = map(int, input().split())
arr = [[[0, 0, 0] for _ in range(m)] for _ in range(n)]

dy = [-1, 1, 0, 0]
dx = [0, 0, 1, -1]
change = [1, 0, 3, 2]
for _ in range(k):
    y, x, s, d, b = map(int, input().split())
    arr[y - 1][x - 1] = [s, d - 1, b]

score = 0
for l in range(m):
    new_arr = [[[0, 0, 0] for _ in range(m)] for _ in range(n)]
    for i in range(n):
        if arr[i][l][2] != 0:
            score += arr[i][l][2]
            arr[i][l] = [0, 0, 0]
            break

    for i in range(n):
        for j in range(m):
            if arr[i][j][2] != 0:
                s, d, b = arr[i][j]
                if d == 0:
                    nx = j
                    s = s % (2 * (n - 1))
                    if 0 <= s < i:
                        ny = i - s
                        nd = d
                    elif s < i + n - 1:
                        ny = s - i
                        nd = change[d]
                    else:
                        ny = i + 2 * (n - 1) - s
                        nd = d
                elif d == 1:
                    nx = j
                    s = s % (2 * (n - 1))
                    if 0 <= s < n - 1 - i:
                        ny = i + s
                        nd = d
                    elif s < 2 * n - i - 2:
                        ny = 2 * n - i - 2 - s
                        nd = change[d]
                    else:
                        ny = i + s - 2 * n + 2
                        nd = d
                elif d == 2:
                    ny = i
                    s = s % (2 * (m - 1))
                    if 0 <= s < m - 1 - j:
                        nx = j + s
                        nd = d
                    elif s < 2 * m - j - 2:
                        nx = 2 * m - j - 2 - s
                        nd = change[d]
                    else:
                        nx = j + s - 2 * m + 2
                        nd = d
                else:
                    ny = i
                    s = s % (2 * (m - 1))
                    if 0 <= s < j:
                        nx = j - s
                        nd = d
                    elif s < j + m - 1:
                        nx = s - j
                        nd = change[d]
                    else:
                        nx = j + 2 * (m - 1) - s
                        nd = d

                if new_arr[ny][nx][2] < b:
                    new_arr[ny][nx] = [s, nd, b]
    arr = new_arr
print(score)
