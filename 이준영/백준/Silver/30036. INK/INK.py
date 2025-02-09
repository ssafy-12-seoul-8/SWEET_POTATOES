I, N, K = map(int, input().split())
ink = list(input())
arr = [list(input()) for _ in range(N)]
com = list(input())

dy = [-1, 1, 0, 0]
dx = [0, 0, -1, 1]

dir = {"U": 0, "D": 1, "L": 2, "R": 3}
j_cnt = 0
i_cnt = 0

for i in range(N):
    for j in range(N):
        if arr[i][j] == "@":
            y = i
            x = j
            arr[i][j] = "."

for i in range(K):
    tmp = com[i]

    if tmp in dir:
        ny = y + dy[dir[tmp]]
        nx = x + dx[dir[tmp]]
        if 0 <= ny < N and 0 <= nx < N and arr[ny][nx] == ".":
            y = ny
            x = nx
    elif tmp == "j":
        i_cnt += 1
    elif tmp == "J":
        c = ink[j_cnt % I]
        j_cnt += 1

        for j in range(y - i_cnt, y + i_cnt + 1):
            for k in range(x - abs(i_cnt - abs(y - j)), x + abs(i_cnt - abs(y - j)) + 1):
                if 0 <= j < N and 0 <= k < N and arr[j][k] != ".":
                    arr[j][k] = c
        i_cnt = 0

arr[y][x] = "@"
for i in range(N):
    print(*arr[i],sep="")
