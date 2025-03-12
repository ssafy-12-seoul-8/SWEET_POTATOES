import sys

input = sys.stdin.readline


def btk(cur, y, x, hp, u, d):
    global mn
    if d + abs(y - e_y) + abs(x - e_x) >= mn:
        return

    if abs(y - e_y) + abs(x - e_x) <= hp + u:
        mn = d + abs(y - e_y) + abs(x - e_x)

    if cur == l:
        return

    for i in range(l):
        if visited[i] == 0:
            ny, nx = um[i]
            if abs(y - ny) + abs(x - nx) <= hp + u:
                visited[i] = 1
                a_hp = min(hp, hp + u + 1 - abs(y - ny) - abs(x - nx))
                btk(cur + 1, ny, nx, a_hp, D - 1, d + abs(y - ny) + abs(x - nx))
                visited[i] = 0


N, H, D = map(int, input().split())

arr = [list(input().rstrip()) for _ in range(N)]

um = []
for i in range(N):
    for j in range(N):
        if arr[i][j] == ".":
            continue
        if arr[i][j] == "U":
            um.append((i, j))
        elif arr[i][j] == "S":
            s_y = i
            s_x = j
        else:
            e_y = i
            e_x = j

l = len(um)
visited = [0] * l

mn = int(1e9)
btk(0, s_y, s_x, H, 0, 0)

if mn == int(1e9):
    print(-1)
else:
    print(mn)
