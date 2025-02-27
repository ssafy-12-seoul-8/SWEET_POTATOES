from collections import deque


def btk(cur, cnt):
    if cnt == 3:
        check()
        return

    if cur == n * m:
        return

    y = cur // m
    x = cur % m

    if arr[y][x] != 0:
        btk(cur + 1, cnt)
        return

    btk(cur + 1, cnt)
    arr[y][x] = 1
    btk(cur + 1, cnt + 1)
    arr[y][x] = 0


def check():
    global mx
    visited = [[0] * m for _ in range(n)]
    cnt = 0
    for s_y, s_x in fire:
        if visited[s_y][s_x] == 1:
            continue

        visited[s_y][s_x] = 1
        dq = deque([(s_y, s_x)])

        while dq:
            y, x = dq.popleft()
            for k in range(4):
                ny = y + dy[k]
                nx = x + dx[k]
                if 0 <= ny < n and 0 <= nx < m and arr[ny][nx] == 0 and visited[ny][nx] == 0:
                    cnt += 1
                    visited[ny][nx] = 1
                    dq.append((ny, nx))

    mx = max(mx, tot - cnt)


n, m = map(int, input().split())
arr = [list(map(int, input().split())) for _ in range(n)]  # 2가 불, 1이 방화벽, 0이 빈칸
dy = [0, 0, 1, -1]
dx = [1, -1, 0, 0]
fire = []
tot = -3
for i in range(n):
    for j in range(m):
        if arr[i][j] == 2:
            fire.append((i, j))
        elif arr[i][j] == 0:
            tot += 1

mx = 0
btk(0, 0)

print(mx)
