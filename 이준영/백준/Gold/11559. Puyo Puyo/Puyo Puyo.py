from collections import deque


def bfs(s_y, s_x):
    global flag
    visited[s_y][s_x] = 1
    lst = [(s_y, s_x)]
    dq = deque([(s_y, s_x)])
    t = arr[s_y][s_x]

    while dq:
        y, x = dq.popleft()
        for k in range(4):
            ny = y + dy[k]
            nx = x + dx[k]
            if 0 <= ny < 12 and 0 <= nx < 6 and visited[ny][nx] == 0 and arr[ny][nx] == t:
                visited[ny][nx] = 1
                lst.append((ny, nx))
                dq.append((ny, nx))

    if len(lst) >= 4:
        for (y, x) in lst:
            arr[y][x] = "."
        flag = True


def down():
    for j in range(6):
        lst = []
        for i in range(12):
            if arr[i][j] != ".":
                lst.append(arr[i][j])
                arr[i][j] = "."

        for i in range(len(lst)):
            arr[i + 12 - len(lst)][j] = lst[i]


arr = [list(input()) for _ in range(12)]
dy = [0, 0, 1, -1]
dx = [1, -1, 0, 0]

time = 0
while True:
    flag = False
    visited = [[0] * 6 for _ in range(12)]
    for i in range(12):
        for j in range(6):
            if visited[i][j] == 0 and arr[i][j] != ".":
                bfs(i, j)

    if not flag:
        break

    down()
    time += 1

print(time)
