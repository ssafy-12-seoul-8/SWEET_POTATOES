from collections import deque


def oob(y, x):
    return not (0 <= y < N and 0 <= x < N)


N, M = map(int, input().split())
dy = [0, 0, 1, -1]
dx = [1, -1, 0, 0]
visited = [[0] * N for _ in range(N)]
board = [[[] for _ in range(N)] for _ in range(N)]
bulb = [[0] * N for _ in range(N)]
bulb[0][0] = 1
for _ in range(M):
    x, y, a, b = map(int, input().split())
    board[x - 1][y - 1].append((a - 1, b - 1))

can_go = set()
dq = deque([(0, 0)])
visited[0][0] = 1
cnt = 1
while dq:
    y, x = dq.popleft()
    for ty, tx in board[y][x]:
        if bulb[ty][tx] == 0:
            bulb[ty][tx] = 1
            cnt += 1
        if (ty, tx) in can_go:
            dq.append((ty, tx))
            can_go.remove((ty, tx))
    for k in range(4):
        ny = y + dy[k]
        nx = x + dx[k]
        if not oob(ny, nx) and visited[ny][nx] == 0:
            visited[ny][nx] = 1
            if bulb[ny][nx] == 1:
                dq.append((ny, nx))
            else:
                can_go.add((ny, nx))

print(cnt)
