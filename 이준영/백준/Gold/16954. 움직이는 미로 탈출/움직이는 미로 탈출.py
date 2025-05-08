from collections import deque


def oob(y, x):
    return not (0 <= y < 8 and 0 <= x < 8)


dy = [0, 0, -1, -1, -1, 0, 1, 1, 1]
dx = [0, -1, -1, 0, 1, 1, 1, 0, -1]
board = [list(input()) for _ in range(8)]
visited = [[[0] * 25 for _ in range(8)] for _ in range(8)]
wall = []
for i in range(8):
    for j in range(8):
        if board[i][j] == "#":
            wall.append((i, j))

for t in range(8):
    for y, x in wall:
        if y + t <= 7:
            visited[y + t][x][t] = 1

ans = 0
visited[0][7][0] = 1
dq = deque([(0, 7, 0)])

while dq:
    dis, y, x = dq.popleft()
    for k in range(9):
        ny = y + dy[k]
        nx = x + dx[k]
        if not oob(ny, nx) and visited[ny][nx][dis] == 0:
            if (ny, nx) == (0, 7):
                ans = 1
                break

            if visited[ny][nx][dis + 1] == 0:
                visited[ny][nx][dis] = 1
                dq.append((dis + 1, ny, nx))
    if ans == 1:
        break

print(ans)
