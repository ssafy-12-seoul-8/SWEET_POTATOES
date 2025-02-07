from collections import deque


def bfs(start_y, start_x):
    dq = deque([(start_y, start_x)])
    tmp_cnt = 0
    while dq:
        y, x = dq.popleft()
        if not visited[y][x]:
            visited[y][x] = True
            tmp_cnt += 1
            for k in range(4):
                ny = y + dy[k]
                nx = x + dx[k]
                if 0 <= ny < n and 0 <= nx < m and not visited[ny][nx] and arr[ny][nx] == 1:
                    dq.append((ny, nx))

    return tmp_cnt


n, m = map(int, input().split())
arr = [list(map(int, input().split())) for _ in range(n)]
dy = [0, 0, 1, -1]
dx = [1, -1, 0, 0]

mx = 0
cnt = 0
visited = [[False] * m for _ in range(n)]

for i in range(n):
    for j in range(m):
        if not visited[i][j] and arr[i][j] == 1:
            cnt += 1
            res = bfs(i, j)
            mx = max(mx, res)

print(cnt)
print(mx)
