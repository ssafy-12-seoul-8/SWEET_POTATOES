from collections import deque


def oob(y, x):
    return not (0 <= y < N and 0 <= x < M)


def find_road(arr):
    for i in range(N):
        start = -1
        cur = -1
        for j in range(M):
            if visited[i][j] != 0:
                if cur == visited[i][j]:
                    start = j
                elif cur == -1:
                    start = j
                    cur = visited[i][j]
                else:
                    if j - start >= 3:
                        length = j - start - 1
                        tmp = visited[i][j]
                        if road[cur][tmp] > length:
                            road[cur][tmp] = length
                            road[tmp][cur] = length

                        cur = visited[i][j]
                        start = j
                    else:
                        start = j
                        cur = visited[i][j]
            else:
                continue


def find(a):
    if p[a] != a:
        p[a] = find(p[a])

    return p[a]


N, M = map(int, input().split())

arr = [list(map(int, input().split())) for _ in range(N)]

visited = [[0] * M for _ in range(N)]

dy = [0, 0, 1, -1]
dx = [1, -1, 0, 0]

k = 0
dq = deque([])
for i in range(N):
    for j in range(M):
        if visited[i][j] == 0 and arr[i][j] == 1:
            k += 1
            dq.append((i, j))
            visited[i][j] = k
            while dq:
                y, x = dq.popleft()
                for l in range(4):
                    ny = y + dy[l]
                    nx = x + dx[l]
                    if not oob(ny, nx) and visited[ny][nx] == 0 and arr[ny][nx] == 1:
                        visited[ny][nx] = k
                        dq.append((ny, nx))

road = [[11] * (k + 1) for _ in range(k + 1)]

find_road(visited)
visited = list(zip(*visited))
N, M = M, N
find_road(visited)

p = [i for i in range(k + 1)]

tot_road = []
for i in range(k + 1):
    for j in range(i + 1, k + 1):
        if road[i][j] != 11:
            tot_road.append((road[i][j], i, j))

tot_road.sort()

tot = 0
cnt = 0
for l, y, x in tot_road:
    y2 = find(y)
    x2 = find(x)
    if y2 == x2:
        continue

    p[y2] = x2
    tot += l
    cnt += 1
    if cnt == k - 1:
        break

if cnt == k - 1:
    print(tot)

else:
    print(-1)
