def btk(cur, num):
    if num == 3:
        check()
        return
    if cur == N * M:
        return
    y = cur // M
    x = cur % M
    if arr[y][x] == 0:
        arr[y][x] = 1
        btk(cur + 1, num + 1)
        arr[y][x] = 0
    btk(cur + 1, num)


def check():
    global max_count
    v_count = 0
    visited = [[False] * M for _ in range(N)]
    for start_y, start_x in lst:
        if visited[start_y][start_x]:
            continue
        stk = [(start_y, start_x)]
        while stk:
            y, x = stk.pop()
            if not visited[y][x]:
                visited[y][x] = True
                v_count += 1
                for k in range(4):
                    ny = y + dy[k]
                    nx = x + dx[k]
                    if 0 <= ny < N and 0 <= nx < M and not visited[ny][nx] and arr[ny][nx] != 1:
                        stk.append((ny, nx))
    max_count = max(max_count, cnt - v_count)


N, M = map(int, input().split())
dy = [0, 0, 1, -1]
dx = [1, -1, 0, 0]
arr = [list(map(int, input().split())) for _ in range(N)]
cnt = -3
lst = []
for i in range(N):
    for j in range(M):
        if arr[i][j] == 0:
            cnt += 1
        elif arr[i][j] == 2:
            cnt += 1
            lst.append((i, j))
max_count = 0
btk(0, 0)
print(max_count)
