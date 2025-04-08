from collections import deque
import sys


def myprint(arr):
    for i in range(N):
        print(*arr[i])
    print("-" * 50)


def oob(y, x):
    return not (0 <= y < N and 0 <= x < M)


input = sys.stdin.readline
N, M = map(int, input().split())

arr = [list(input().rstrip()) for _ in range(N)]

distance = [[-1] * M for _ in range(N)]

dy = [0, 0, 1, -1]
dx = [1, -1, 0, 0, ]

for i in range(N):
    for j in range(M):
        if arr[i][j] == "Y":
            sy, sx = i, j
        elif arr[i][j] == "V":
            ey, ex = i, j

distance[ey][ex] = 0
dq = deque([(ey, ex, 0)])
while dq:
    y, x, dis = dq.popleft()
    for k in range(4):
        ny = y + dy[k]
        nx = x + dx[k]
        if not oob(ny, nx) and distance[ny][nx] == -1 and arr[ny][nx] != "I":
            distance[ny][nx] = dis + 1
            dq.append((ny, nx, dis + 1))

tmp = N * M + 1
sight = [[tmp] * M for _ in range(N)]

# 가로 채우기
for i in range(N):
    j = 0
    mn = tmp
    lst = []
    while j <= M - 1:
        if arr[i][j] == "I":
            if lst:
                for x in lst:
                    sight[i][x] = mn

            mn = tmp
            lst = []
        else:
            lst.append(j)
            mn = min(mn, distance[i][j])
        j += 1
    if lst:
        for x in lst:
            sight[i][x] = mn

# 세로 채우기
for j in range(M):
    i = 0
    mn = tmp
    lst = []
    while i <= N - 1:
        if arr[i][j] == "I":
            if lst:
                for y in lst:
                    sight[y][j] = min(mn, sight[y][j])

            mn = tmp
            lst = []
        else:
            lst.append(i)
            mn = min(mn, distance[i][j])
        i += 1
    if lst:
        for y in lst:
            sight[y][j] = min(mn, sight[y][j])

ans = "NO"
visited = [[0] * M for _ in range(N)]
visited[sy][sx] = 1
dq.append((sy, sx, 0))
while dq:
    y, x, dis = dq.popleft()
    if arr[y][x] == "T":
        ans = "YES"
        break

    for k in range(4):
        ny = y + dy[k]
        nx = x + dx[k]
        if not oob(ny, nx) and visited[ny][nx] == 0 and arr[ny][nx] != "I" and dis + 1 < sight[ny][nx]:
            visited[ny][nx] = 1
            dq.append((ny, nx, dis + 1))

print(ans)
