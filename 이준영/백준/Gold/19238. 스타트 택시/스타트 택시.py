from collections import deque


def go(y, x, ey, ex):
    visited = [[0] * N for _ in range(N)]
    visited[y][x] = 1
    dq = deque([(y, x, 0)])
    while dq:
        ty, tx, d = dq.popleft()
        for k in range(4):
            ny = ty + dy[k]
            nx = tx + dx[k]
            if 0 <= ny < N and 0 <= nx < N and visited[ny][nx] == 0 and arr[ny][nx] != 1:
                if (ny, nx) == (ey, ex):
                    return d + 1
                visited[ny][nx] = 1
                dq.append((ny, nx, d + 1))

    return -1


N, M, oil = map(int, input().split())
arr = [list(map(int, input().split())) for _ in range(N)]

s_y, s_x = map(int, input().split())

dy = [0, 0, 1, -1]
dx = [1, -1, 0, 0]
s_y -= 1
s_x -= 1
people = [0] * (M + 2)

for i in range(M):
    sy, sx, ey, ex = map(int, input().split())
    arr[sy - 1][sx - 1] = i + 2
    people[i + 2] = (ey - 1, ex - 1)

flag = True
for i in range(M):
    if arr[s_y][s_x] >= 2:
        ey, ex = people[arr[s_y][s_x]]
        arr[s_y][s_x] = 0
        l = go(s_y, s_x, ey, ex)
        if l == -1:
            flag = False
            break
        if oil >= l:
            s_y = ey
            s_x = ex
            oil = oil + l
            continue
        else:
            flag = False
            break

    visited = [[0] * N for _ in range(N)]
    visited[s_y][s_x] = 1
    dq = deque([(s_y, s_x)])
    lst = []
    d = 1
    while dq:
        l = len(dq)
        for _ in range(l):
            y, x = dq.popleft()
            for k in range(4):
                ny = y + dy[k]
                nx = x + dx[k]
                if 0 <= ny < N and 0 <= nx < N and visited[ny][nx] == 0 and arr[ny][nx] != 1:
                    visited[ny][nx] = 1
                    if arr[ny][nx] >= 2:
                        lst.append((ny, nx))
                    else:
                        dq.append((ny, nx))
        if lst:
            lst.sort()
            oil = oil - d
            s_y = lst[0][0]
            s_x = lst[0][1]
            break
        d += 1
    if not lst:
        flag = False
        break

    if oil < 0:
        flag = False
        break

    ey, ex = people[arr[s_y][s_x]]
    arr[s_y][s_x] = 0
    l = go(s_y, s_x, ey, ex)
    if l == -1:
        flag = False
        break
    if oil >= l:
        s_y = ey
        s_x = ex
        oil = oil + l
        continue
    else:
        flag = False
        break
if flag:
    print(oil)
else:
    print(-1)
