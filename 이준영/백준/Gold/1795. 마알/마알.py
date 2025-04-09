from collections import deque


def myprint(arr):
    for i in range(N):
        print(*arr[i])
    print("-" * 50)


def oob(y, x):
    return not (0 <= y < N and 0 <= x < M)


N, M = map(int, input().split())
board = [list(input()) for _ in range(N)]
dy = [-1, -2, -2, -1, 1, 2, 2, 1]
dx = [-2, -1, 1, 2, 2, 1, -1, -2]

tot_cnt = 0
for i in range(N):
    for j in range(M):
        if board[i][j] != ".":
            tot_cnt += 1

ans = 100000

for i in range(N):
    for j in range(M):
        cnt = 0
        distance = 0
        visited = [[0] * M for _ in range(N)]
        dq = deque([(i, j, 0)])
        visited[i][j] = 1
        while dq:
            y, x, dis = dq.popleft()

            if board[y][x] != ".":
                tmp = int(board[y][x])
                cnt += 1
                distance += ((dis - 1) // tmp + 1)
                if cnt == tot_cnt:
                    break
            for k in range(8):
                ny = y + dy[k]
                nx = x + dx[k]
                if not oob(ny, nx) and visited[ny][nx] == 0:
                    visited[ny][nx] = 1
                    dq.append((ny, nx, dis + 1))

        if cnt == tot_cnt:
            ans = min(ans, distance)
        #
        # print(i,j,cnt,distance)
if ans == 100000:
    print(-1)
else:
    print(ans)
