import sys
from collections import deque

input = sys.stdin.readline


def firestorm(arr, l):
    tmp = [[0] * (2 ** N) for _ in range(2 ** N)]
    for n in range(2 ** (N - l)):
        for m in range(2 ** (N - l)):
            for i in range(2 ** l):
                for j in range(2 ** l):
                    tmp[2 ** l * n + i][2 ** l * m + j] = arr[2 ** l * n + 2 ** l - 1 - j][2 ** l * m + i]

    lst = []
    for i in range(2 ** N):
        for j in range(2 ** N):
            if tmp[i][j] == 0:
                continue
            cnt = 0
            for k in range(4):
                ny = i + dy[k]
                nx = j + dx[k]
                if 0 <= ny < 2 ** N and 0 <= nx < 2 ** N and tmp[ny][nx] > 0:
                    cnt += 1
            if cnt <= 2:
                lst.append((i, j))

    for y, x in lst:
        tmp[y][x] -= 1

    return tmp


def bfs():
    visited = [[0] * (2 ** N) for _ in range(2 ** N)]
    mx = 0
    for i in range(2 ** N):
        for j in range(2 ** N):
            if visited[i][j] == 0 and arr[i][j] > 0:
                visited[i][j] = 1
                dq = deque([(i, j)])
                cnt = 1
                while dq:
                    y, x = dq.popleft()
                    for k in range(4):
                        ny = y + dy[k]
                        nx = x + dx[k]
                        if 0 <= ny < 2 ** N and 0 <= nx < 2 ** N and visited[ny][nx] == 0 and arr[ny][nx] > 0:
                            visited[ny][nx] = 1
                            cnt += 1
                            dq.append((ny, nx))

                mx = max(mx, cnt)
    return mx


N, Q = map(int, input().split())
arr = [list(map(int, input().split())) for _ in range(2 ** N)]
dy = [0, 0, 1, -1]
dx = [1, -1, 0, 0]
L = list(map(int, input().split()))

for i in range(Q):
    arr = firestorm(arr, L[i])

tot = 0
mx = bfs()
for i in range(2 ** N):
    for j in range(2 ** N):
        tot += arr[i][j]
print(tot)
print(mx)
