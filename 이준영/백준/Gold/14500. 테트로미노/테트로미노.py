def btk(y, x, cnt, sm):
    global mx
    if cnt == 4:
        mx = max(mx, sm)
        return

    for k in range(4):
        ny = y + dy[k]
        nx = x + dx[k]
        if 0 <= ny < n and 0 <= nx < m and visited[ny][nx] == 0:
            visited[ny][nx] = 1
            btk(ny, nx, cnt + 1, sm + arr[ny][nx])
            visited[ny][nx] = 0


n, m = map(int, input().split())
arr = [list(map(int, input().split())) for _ in range(n)]

mx = 0

dy = [0, 0, 1, -1]
dx = [1, -1, 0, 0]

visited = [[0] * m for _ in range(n)]
for i in range(n):
    for j in range(m):
        visited[i][j] = 1
        btk(i, j, 1, arr[i][j])
        visited[i][j] = 0

for i in range(n):
    for j in range(m):
        for k in range(4):
            sm = arr[i][j]
            flag = True
            for l in range(4):
                if k == l:
                    continue
                ny = i + dy[l]
                nx = j + dx[l]
                if 0 <= ny < n and 0 <= nx < m:
                    sm += arr[ny][nx]
                else:
                    flag = False
                    break
            if flag:
                mx = max(mx, sm)

print(mx)
