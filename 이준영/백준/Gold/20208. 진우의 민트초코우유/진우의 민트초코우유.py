def btk(y, x, cnt, hp):
    global mx
    if abs(s_y - y) + abs(s_x - x) <= hp:
        mx = max(mx, cnt)

    for i in range(l):
        if visited[i] == 0:
            ny, nx = milk[i]
            tmp = abs(y - ny) + abs(x - nx)
            if tmp <= hp:
                visited[i] = 1
                btk(ny, nx, cnt + 1, hp + H - tmp)
                visited[i] = 0


N, M, H = map(int, input().split())

arr = [list(map(int, input().split())) for _ in range(N)]

milk = []
for i in range(N):
    for j in range(N):
        if arr[i][j] == 1:
            s_y, s_x = i, j
            arr[i][j] = 0
        elif arr[i][j] == 2:
            milk.append((i, j))

l = len(milk)

mx = 0
visited = [0] * l

btk(s_y, s_x, 0, M)

print(mx)
