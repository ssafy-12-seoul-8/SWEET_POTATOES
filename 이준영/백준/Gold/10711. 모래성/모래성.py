import sys
from collections import deque

input = sys.stdin.readline

def myprint():
    for i in range(N):
        print(*board[i])
    print("-"*50)

def oob(y, x):
    return not (0 <= y < N and 0 <= x < M)


N, M = map(int, input().split())
board = [list(input().rstrip()) for _ in range(N)]
visited = [[0] * M for _ in range(N)]
dy = [0, -1, -1, -1, 0, 1, 1, 1]
dx = [-1, -1, 0, 1, 1, 1, 0, -1]

lst = []

for i in range(N):
    for j in range(M):
        if board[i][j] == ".":
            board[i][j] = 0
            visited[i][j] = 1
        else:
            board[i][j] = int(board[i][j])

for i in range(N):
    for j in range(M):
        if board[i][j] > 0:
            cnt = 0
            for k in range(8):
                ny = i + dy[k]
                nx = j + dx[k]
                if not oob(ny, nx) and board[ny][nx] == 0:
                    cnt += 1

            if cnt >= board[i][j]:
                lst.append((i, j))

time = 0
while lst:
    time += 1
    tmp_lst = []
    for y, x in lst:
        visited[y][x] = 1
        board[y][x] = 0

        for k in range(8):
            ny = y + dy[k]
            nx = x + dx[k]
            if not oob(ny, nx) and visited[ny][nx] == 0 and board[ny][nx] > 0:
                cnt = 0
                for kk in range(8):
                    nny = ny + dy[kk]
                    nnx = nx + dx[kk]
                    if not oob(nny, nnx) and board[nny][nnx] == 0:
                        cnt += 1

                if cnt >= board[ny][nx]:
                    visited[ny][nx] = 1
                    tmp_lst.append((ny, nx))
    lst = tmp_lst
print(time)
