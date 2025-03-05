from collections import deque


def rotate(d):
    dice[r_d[d][0]], dice[r_d[d][1]], dice[r_d[d][2]], dice[r_d[d][3]] = dice[r_d[d][3]], dice[r_d[d][0]], dice[
        r_d[d][1]], dice[r_d[d][2]]


n, m, K = map(int, input().split())
arr = [list(map(int, input().split())) for _ in range(n)]
dice = [1, 2, 3, 4, 5, 6]
dy = [0, 1, 0, -1]
dx = [1, 0, -1, 0]
d = 0
r_d = [[3, 0, 2, 5],
       [0, 4, 5, 1],
       [0, 3, 5, 2],
       [0, 1, 5, 4]]

score = [[0] * m for _ in range(n)]
visited = [[0] * m for _ in range(n)]

for i in range(n):
    for j in range(m):
        if visited[i][j] == 1:
            continue
        dq = deque([(i, j)])
        lst = [(i, j)]
        visited[i][j] = 1
        num = arr[i][j]
        while dq:
            y, x = dq.popleft()
            for k in range(4):
                ny = y + dy[k]
                nx = x + dx[k]
                if 0 <= ny < n and 0 <= nx < m and visited[ny][nx] == 0 and arr[ny][nx] == num:
                    visited[ny][nx] = 1
                    lst.append((ny, nx))
                    dq.append((ny, nx))

        num = num * len(lst)
        for y, x in lst:
            score[y][x] = num

y = 0
x = 0
fin_score = 0
for _ in range(K):
    ny = y + dy[d]
    nx = x + dx[d]
    if 0 <= ny < n and 0 <= nx < m:
        y = ny
        x = nx
        rotate(d)
        if dice[5] < arr[y][x]:
            d = (d - 1) % 4
        elif dice[5] > arr[y][x]:
            d = (d + 1) % 4

        fin_score += score[y][x]
    else:
        y = y - dy[d]
        x = x - dx[d]
        d = (d + 2) % 4
        rotate(d)
        if dice[5] < arr[y][x]:
            d = (d - 1) % 4
        elif dice[5] > arr[y][x]:
            d = (d + 1) % 4

        fin_score += score[y][x]

print(fin_score)
