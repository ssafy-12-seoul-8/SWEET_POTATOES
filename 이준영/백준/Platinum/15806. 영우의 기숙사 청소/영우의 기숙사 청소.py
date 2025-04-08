from collections import deque


def oob(y, x):
    return not (0 <= y < N and 0 <= x < N)


N, M, K, t = map(int, input().split())
visited = [[[t + 1, t + 1] for _ in range(N)] for _ in range(N)]

dy = [-1, -2, -2, -1, 1, 2, 2, 1]
dx = [-2, -1, 1, 2, 2, 1, -1, -2]
dq = deque([])
for _ in range(M):
    y, x = map(int, input().split())
    y -= 1
    x -= 1
    dq.append((y, x, 0))
    visited[y][x][0] = 0

check_lst = [list(map(int, input().split())) for _ in range(K)]

while dq:
    y, x, dis = dq.popleft()
    if dis == t:
        break
    for k in range(8):
        ny = y + dy[k]
        nx = x + dx[k]
        tmp = (dis + 1) % 2
        if not oob(ny, nx) and visited[ny][nx][tmp] == t + 1:
            visited[ny][nx][tmp] = dis + 1
            dq.append((ny, nx, dis + 1))

flag = False

tmp = (t % 2)

if N <= 2:
    flag = False
elif N == 3:
    for y, x in check_lst:
        if (y, x) == (2, 2):
            continue
        if visited[y - 1][x - 1][tmp] <= t:
            flag = True
            break
else:
    for y, x in check_lst:
        if visited[y - 1][x - 1][tmp] <= t:
            flag = True
            break
if flag:
    print("YES")
else:
    print("NO")
