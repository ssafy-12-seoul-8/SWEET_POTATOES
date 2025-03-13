import sys
from heapq import heappop, heappush

input = sys.stdin.readline

ans = []
dy = [0, 0, 1, -1]
dx = [1, -1, 0, 0]
while True:
    n, m = map(int, input().split())
    if m == 0:
        break

    arr = [list(input().rstrip()) for _ in range(n)]
    time = [[int(1e9)] * m for _ in range(n)]

    k = 0
    for i in range(n):
        for j in range(m):
            if arr[i][j] == "A":
                s_y, s_x = i, j
                arr[i][j] = "#"
            elif ord('0') <= ord(arr[i][j]) <= ord('9'):
                arr[i][j] = int(arr[i][j])
                k = max(k, arr[i][j] + 1)
            elif arr[i][j] == "B":
                e_y, e_x = i, j
                arr[i][j] = "#"

    info = [0] * k
    for i in range(k):
        a, b, c, d = input().rstrip().split()
        c = int(c)
        d = int(d)
        if b == "-":
            info[i] = [0, c, d]
        else:
            info[i] = [1, c, d]

    time[s_y][s_x] = 0
    pq = []
    heappush(pq, (0, s_y, s_x))

    t_ans = "impossible"

    while pq:
        dis, y, x = heappop(pq)
        if time[y][x] < dis:
            continue

        if (y, x) == (e_y, e_x):
            t_ans = dis
            break

        for k in range(4):
            ny = y + dy[k]
            nx = x + dx[k]
            if 0 <= ny < n and 0 <= nx < m and arr[ny][nx] != ".":
                if arr[ny][nx] == "#":
                    if time[ny][nx] > dis + 1:
                        time[ny][nx] = dis + 1
                        heappush(pq, (dis + 1, ny, nx))
                else:
                    a, b, c = info[arr[ny][nx]]
                    if k <= 1:
                        if a == 0:
                            if dis % (b + c) < b:
                                t = dis + 1
                            else:
                                t = (dis // (b + c) + 1) * (b + c) + 1
                        else:
                            if dis % (b + c) >= c:
                                t = dis + 1
                            else:
                                t = (dis // (b + c)) * (b + c) + c + 1
                    else:
                        if a == 0:
                            if dis % (b + c) >= b:
                                t = dis + 1
                            else:
                                t = (dis // (b + c)) * (b + c) + b + 1
                        else:
                            if (dis % (b + c)) < c:
                                t = dis + 1
                            else:
                                t = (dis // (b + c) + 1) * (b + c) + 1
                    if time[ny][nx] > t:
                        time[ny][nx] = t
                        heappush(pq, (t, ny, nx))

    ans.append(t_ans)
    c = input().rstrip()
print(*ans, sep="\n")
