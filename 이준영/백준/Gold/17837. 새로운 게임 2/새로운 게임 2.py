def myprint():
    print("말")
    for i in range(n + 2):
        print(*knight[i])

    print("좌표")
    print(*knight_loc)

    print("-" * 50)


n, K = map(int, input().split())

arr = [[2] * (n + 2)] + [[2] + list(map(int, input().split())) + [2] for _ in range(n)] + [[2] * (n + 2)]

knight = [[[] for _ in range(n + 2)] for _ in range(n + 2)]
knight_loc = [0] * K
change = [1, 0, 3, 2]
dy = [0, 0, -1, 1]
dx = [1, -1, 0, 0]
for i in range(K):
    y, x, d = map(int, input().split())
    knight_loc[i] = [y, x, 0]
    knight[y][x].append((i, d - 1))

ans = -1
time = 0
flag = True
while time < 1000:

    time += 1
    for i in range(K):
        y, x, z = knight_loc[i]
        num, d = knight[y][x][z]

        ny = y + dy[d]
        nx = x + dx[d]

        if arr[ny][nx] == 2:
            d = change[d]
            ny = y + dy[d]
            nx = x + dx[d]
            knight[y][x][z] = [num, d]
            if arr[ny][nx] == 2:
                continue

        l = len(knight[ny][nx])

        if arr[ny][nx] == 0:
            for k in range(z, len(knight[y][x])):
                t_num, t_d = knight[y][x][k]
                knight_loc[t_num] = [ny, nx, l + k - z]
                knight[ny][nx].append((t_num, t_d))
            knight[y][x] = knight[y][x][:z]
            if len(knight[ny][nx]) >= 4:
                flag = False
                break

        else:
            l2 = len(knight[y][x])
            for k in range(l2 - 1, z - 1, -1):
                t_num, t_d = knight[y][x][k]
                knight_loc[t_num] = [ny, nx, l + l2 - 1 - k]
                knight[ny][nx].append((t_num, t_d))
            knight[y][x] = knight[y][x][:z]
            if len(knight[ny][nx]) >= 4:
                flag = False
                break

    if not flag:
        ans = time
        break

print(ans)
