# 계속해서 왼쪽을 봐야 된다는 것을 고려하지 않았다.
n, m = map(int, input().split())
y, x, d = map(int, input().split())
arr = [list(map(int, input().split())) for _ in range(n)]  # 도로 0, 인도 1

dy = [-1, 0, 1, 0]  # 북,동,남,서(오른쪽회전)
dx = [0, 1, 0, -1]

visited = [[0] * m for _ in range(n)]

visited[y][x] = 1
k = 0
while True:
    if k == 4:
        ny = y - dy[d]
        nx = x - dx[d]
        if arr[ny][nx] == 1:
            break
        y = ny
        x = nx
        visited[y][x] = 1
        k = 0
        continue
    d = (d - 1) % 4
    ny = y + dy[d]
    nx = x + dx[d]
    if arr[ny][nx] == 0 and visited[ny][nx] == 0:
        visited[ny][nx] = 1
        y = ny
        x = nx
        k = 0

        continue

    k = k + 1
sm = 0
for i in range(n):
    for j in range(m):
        if visited[i][j] == 1:
            sm += 1

print(sm)
