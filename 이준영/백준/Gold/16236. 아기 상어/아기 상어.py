from collections import deque

n = int(input())
arr = [list(map(int, input().split())) for _ in range(n)]
dy = [0, 0, 1, -1]
dx = [1, -1, 0, 0]
time = 0
r_y = -1
r_x = -1
for i in range(n):
    for j in range(n):
        if arr[i][j] == 9:
            r_y = i
            r_x = j
            arr[i][j] = 0
            break
    if r_y != -1:
        break

r_size = 2
r_exp = 0
time = 0
while True:
    visited = [[0] * n for _ in range(n)]
    lst = []
    visited[r_y][r_x] = 1
    dq = deque([(r_y, r_x)])
    t_time = 1
    while dq:
        l = len(dq)
        for _ in range(l):
            y, x = dq.popleft()
            for k in range(4):
                ny = y + dy[k]
                nx = x + dx[k]
                if 0 <= ny < n and 0 <= nx < n and visited[ny][nx] == 0:
                    visited[ny][nx] = 1
                    if arr[ny][nx] > r_size:
                        continue
                    else:
                        dq.append((ny, nx))
                        if 0 < arr[ny][nx] < r_size:
                            lst.append((ny, nx))
                        else:
                            dq.append((ny, nx))
        if lst:
            break

        t_time += 1
    if not lst:
        break
    time = time + t_time
    lst.sort()
    y, x = lst[0]
    arr[y][x] = 0
    r_y, r_x = y, x
    r_exp += 1
    if r_exp == r_size:
        r_size += 1
        r_exp = 0

print(time)
