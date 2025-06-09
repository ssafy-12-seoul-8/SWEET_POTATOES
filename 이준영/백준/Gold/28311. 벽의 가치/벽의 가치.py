import sys
from collections import deque

input = sys.stdin.readline


def oob(y, x):
    return not (0 <= y < R and 0 <= x < C)


def game(sy, sx):
    visited = [[-1] * C for _ in range(R)]
    visited[sy][sx] = 0
    dq = deque([(sy, sx)])
    while dq:
        y, x = dq.popleft()

        for k in range(4):
            ny = y + dy[k]
            nx = x + dx[k]
            if not oob(ny, nx) and visited[ny][nx] == -1 and board[ny][nx] >= 0:
                visited[ny][nx] = visited[y][x] + 1
                dq.append((ny, nx))

    return visited


T = int(input())
dy = [0, 0, 1, -1]
dx = [1, -1, 0, 0]
for _ in range(T):
    R, C, N, r, c = map(int, input().split())
    r -= 1
    c -= 1
    lst = []
    for i in range(N):
        y, x = map(int, input().split())
        y -= 1
        x -= 1
        lst.append((y, x))

    board = [list(input().rstrip()) for _ in range(R)]
    wall = []
    for i in range(R):
        for j in range(C):
            if board[i][j] == "W":
                board[i][j] = -1
                wall.append((i, j))
            else:
                board[i][j] = 0
    for i in range(N):
        y, x = lst[i]
        board[y][x] = i + 1


    score = [0] * N
    distance = game(r, c)
    for i in range(N):
        y, x = lst[i]
        score[i] = distance[y][x]

    wall_score = 0

    for K in range(N):
        y, x = lst[K]
        tmp_distance = game(y, x)

        for wy, wx in wall:
            mn1 = 40001
            mn2 = 40001
            for k in range(4):
                ny = wy + dy[k]
                nx = wx + dx[k]
                if not oob(ny, nx):
                    if distance[ny][nx]>=0:
                        mn1 = min(mn1, distance[ny][nx])
                    if tmp_distance[ny][nx]>=0:
                        mn2 = min(mn2, tmp_distance[ny][nx])

            wall_score += max(0, score[K] - (mn1 + mn2 + 2))
    print(sum(score), wall_score)
