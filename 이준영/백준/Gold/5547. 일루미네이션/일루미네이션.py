from collections import deque


def oob(y, x):
    return not (0 <= y < N and 0 <= x < M)


M, N = map(int, input().split())
dydx = [[(-1, -1), (-1, 0), (0, 1), (1, 0), (1, -1), (0, -1)], [(-1, 0), (-1, 1), (0, 1), (1, 1), (1, 0), (0, -1)]]

board = [[0] * (M + 2)] + [[0] + list(map(int, input().split())) + [0] for _ in range(N)] + [[0] * (M + 2)]
M += 2
N += 2

visited = [[0] * M for _ in range(N)]
dq = deque([(0, 0)])
cnt = 0
while dq:
    y, x = dq.popleft()
    tmp = y % 2
    for k in range(6):
        ny = y + dydx[tmp][k][0]
        nx = x + dydx[tmp][k][1]
        if not oob(ny, nx) and visited[ny][nx] == 0:
            if board[ny][nx] == 0:
                visited[ny][nx] = 1
                dq.append((ny, nx))
            else:
                cnt += 1

print(cnt)
