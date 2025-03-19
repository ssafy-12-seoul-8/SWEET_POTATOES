import sys
from collections import deque

input = sys.stdin.readline
N, M = map(int, input().split())
DP = [(0, 1), (1, 0), (0, -1), (-1, 0)]
CC = [(0, -1), (0, 1)]
arr = [list(input().rstrip()) for _ in range(N)]
visited = [[0] * M for _ in range(N)]
dct = {}

l = 1
for i in range(N):
    for j in range(M):
        if arr[i][j] == "X":
            visited[i][j] = -1
        elif visited[i][j] == 0:
            target = arr[i][j]
            lst = [[i, j] for _ in range(8)]
            visited[i][j] = l
            dq = deque([(i, j)])

            while dq:
                y, x = dq.popleft()
                for k in range(4):
                    ny = y + DP[k][0]
                    nx = x + DP[k][1]
                    if 0 <= ny < N and 0 <= nx < M and visited[ny][nx] == 0 and arr[ny][nx] == target:
                        visited[ny][nx] = l
                        dq.append((ny, nx))

                        if lst[6][0] > ny:
                            lst[6] = [ny, nx]
                            lst[7] = [ny, nx]
                        elif lst[6][0] == ny:
                            lst[6] = [ny, min(nx, lst[6][1])]
                            lst[7] = [ny, max(nx, lst[7][1])]

                        if lst[2][0] < ny:
                            lst[2] = [ny, nx]
                            lst[3] = [ny, nx]
                        elif lst[2][0] == ny:
                            lst[2] = [ny, max(nx, lst[2][1])]
                            lst[3] = [ny, min(nx, lst[3][1])]

                        if lst[4][1] > nx:
                            lst[4] = [ny, nx]
                            lst[5] = [ny, nx]
                        elif lst[4][1] == nx:
                            lst[4] = [max(ny, lst[4][0]), nx]
                            lst[5] = [min(ny, lst[5][0]), nx]

                        if lst[0][1] < nx:
                            lst[0] = [ny, nx]
                            lst[1] = [ny, nx]
                        elif lst[0][1] == nx:
                            lst[0] = [min(ny, lst[0][0]), nx]
                            lst[1] = [max(ny, lst[1][0]), nx]

            dct[l] = lst
            l += 1

y, x, dp, cc = 0, 0, 0, 0
ans = []
ans.append(arr[y][x])

while True:
    cur = visited[y][x]
    flag = False
    for t1 in range(4):
        for t2 in range(2):
            ny, nx = dct[cur][dp * 2 + cc]
            ny += DP[dp][0]
            nx += DP[dp][1]
            if 0 <= ny < N and 0 <= nx < M and visited[ny][nx] != -1 and visited[ny][nx] != cur:
                y, x = ny, nx
                ans.append(arr[ny][nx])
                flag = True
                break

            else:
                if t2 == 0:
                    cc = (cc + 1) % 2

        if flag:
            break

        dp = (dp + 1) % 4

    if flag:
        continue

    break


print("".join(ans))
