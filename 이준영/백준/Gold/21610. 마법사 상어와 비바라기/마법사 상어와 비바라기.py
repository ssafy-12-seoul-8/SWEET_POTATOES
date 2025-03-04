n, m = map(int, input().split())
arr = [list(map(int, input().split())) for _ in range(n)]

dy = [0, -1, -1, -1, 0, 1, 1, 1]
dx = [-1, -1, 0, 1, 1, 1, 0, -1]

lst = [(n - 2, 0), (n - 2, 1), (n - 1, 0), (n - 1, 1)]
for _ in range(m):
    d, p = map(int, input().split())
    d = d - 1
    visited = [[0] * n for _ in range(n)]

    for y, x in lst:
        ny = (y + dy[d] * p) % n
        nx = (x + dx[d] * p) % n
        visited[ny][nx] = 1
        arr[ny][nx] += 1

    grow = {}
    for y, x in lst:
        ny = (y + dy[d] * p) % n
        nx = (x + dx[d] * p) % n
        cnt = 0
        for k in range(4):
            t_ny = ny + dy[2 * k + 1]
            t_nx = nx + dx[2 * k + 1]
            if 0 <= t_ny < n and 0 <= t_nx < n and arr[t_ny][t_nx] >= 1:
                cnt += 1

        grow[(ny, nx)] = cnt
    for y, x in grow:
        arr[y][x] += grow[(y, x)]

    tmp_lst = []
    for i in range(n):
        for j in range(n):
            if visited[i][j] == 0 and arr[i][j] >= 2:
                arr[i][j] -= 2
                tmp_lst.append((i, j))

    lst = tmp_lst

tot = 0
for i in range(n):
    for j in range(n):
        tot += arr[i][j]

print(tot)
