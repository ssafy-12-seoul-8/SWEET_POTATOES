from collections import deque

N, L, R = map(int, input().split())

arr = [list(map(int, input().split())) for _ in range(N)]

time = 0
dy = [-1, 0, 0, 1]
dx = [0, 1, -1, 0]

while True:
    flag = False
    visited = [[0] * N for _ in range(N)]
    new_arr = [row[:] for row in arr]
    for i in range(N):
        for j in range(N):
            if visited[i][j] == 0:
                lst = [(i, j)]
                visited[i][j] = 1
                dq = deque([(i, j)])
                sm = arr[i][j]
                while dq:
                    y, x = dq.popleft()
                    for k in range(4):
                        ny = y + dy[k]
                        nx = x + dx[k]
                        if 0 <= ny < N and 0 <= nx < N and visited[ny][nx] == 0:
                            if L <= abs(arr[ny][nx] - arr[y][x]) <= R:
                                flag = True
                                lst.append((ny, nx))
                                sm += arr[ny][nx]
                                visited[ny][nx] = 1
                                dq.append((ny, nx))
                target = sm // len(lst)
                for y, x in lst:
                    new_arr[y][x] = target
    arr = new_arr

    if flag:
        time += 1
    else:
        break

print(time)
