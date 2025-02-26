n, m, t = map(int, input().split())
arr = [list(map(int, input().split())) for _ in range(n)]
dy = [0, 0, 1, -1]
dx = [1, -1, 0, 0]

s_y = -1
for i in range(n):
    for j in range(m):
        if arr[i][j] == -1:
            s_y = i
            break
    if s_y != -1:
        break

for _ in range(t):
    tmp = [row[:] for row in arr]

    for i in range(n):
        for j in range(m):
            if arr[i][j] == -1:
                continue
            give = arr[i][j] // 5
            for k in range(4):
                ny = i + dy[k]
                nx = j + dx[k]
                if 0 <= ny < n and 0 <= nx < m and arr[ny][nx] != -1:
                    tmp[ny][nx] += give
                    tmp[i][j] -= give

    for i in range(s_y - 1, 0, -1):
        tmp[i][0] = tmp[i - 1][0]
    for j in range(m - 1):
        tmp[0][j] = tmp[0][j + 1]
    for i in range(s_y):
        tmp[i][m - 1] = tmp[i + 1][m - 1]
    for j in range(m - 1, 1, -1):
        tmp[s_y][j] = tmp[s_y][j - 1]
    tmp[s_y][1] = 0
    for i in range(s_y + 2, n - 1):
        tmp[i][0] = tmp[i + 1][0]
    for j in range(m - 1):
        tmp[n - 1][j] = tmp[n - 1][j + 1]
    for i in range(n - 1, s_y + 1, -1):
        tmp[i][m - 1] = tmp[i - 1][m - 1]
    for j in range(m - 1, 1, -1):
        tmp[s_y + 1][j] = tmp[s_y + 1][j - 1]
    tmp[s_y + 1][1] = 0

    for i in range(n):
        for j in range(m):
            arr[i][j] = tmp[i][j]

sm = 0
for i in range(n):
    for j in range(m):
        if arr[i][j] != -1:
            sm += arr[i][j]

print(sm)
