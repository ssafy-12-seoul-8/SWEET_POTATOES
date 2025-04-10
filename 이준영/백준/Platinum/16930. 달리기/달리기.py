import sys
from collections import deque

input = sys.stdin.readline


def myprint():
    for i in range(N):
        print(*distance[i])


def oob(y, x):
    return not (0 <= y < N and 0 <= x < M)


N, M, K = map(int, input().split())
board = [list(input().rstrip()) for _ in range(N)]

distance = [[int(1e9)] * M for _ in range(N)]

sy, sx, ey, ex = map(int, input().split())
sy -= 1
sx -= 1
ey -= 1
ex -= 1

dy = [-1, 0, 1, 0]
dx = [0, 1, 0, -1]
distance[sy][sx] = 0
nd = [[0, 1, 3], [0, 1, 2], [1, 2, 3], [0, 2, 3], [0, 1, 2, 3]]
dq = deque([(sy, sx, 0, 4)])
ans = -1
while dq:
    y, x, dis, ld = dq.popleft()
    if (y, x) == (ey, ex):
        ans = dis
        break

    for k in nd[ld]:
        for l in range(1, K + 1):
            ny = y + dy[k] * l
            nx = x + dx[k] * l
            if oob(ny, nx):
                break
            if board[ny][nx] == "#" or distance[ny][nx] <= dis:
                break

            if distance[ny][nx] > dis + 1:
                distance[ny][nx] = dis + 1
                dq.append((ny, nx, dis + 1, k))
print(ans)