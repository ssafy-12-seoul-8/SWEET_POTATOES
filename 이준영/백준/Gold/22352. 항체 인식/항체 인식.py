# 1147~

from collections import deque


def bfs(start_y, start_x):
    global tot_check
    cur1 = arr1[start_y][start_x]
    cur2 = arr2[start_y][start_x]
    dq = deque([(start_y, start_x)])
    while dq:
        y, x = dq.popleft()
        if not visited[y][x]:
            visited[y][x] = True
            for k in range(4):
                ny = y + dy[k]
                nx = x + dx[k]
                if 0 <= ny < N and 0 <= nx < M and not visited[ny][nx]:
                    if arr1[ny][nx] == cur1:
                        if arr2[ny][nx] != cur2:
                            tot_check = False
                        else:
                            dq.append((ny,nx))

dy = [0, 0, 1, -1]
dx = [1, -1, 0, 0]
N, M = map(int, input().split())

arr1 = [list(map(int, input().split())) for _ in range(N)]
arr2 = [list(map(int, input().split())) for _ in range(N)]

visited = [[False] * M for _ in range(N)]
check = True
tot_check = True

for i in range(N):
    for j in range(M):
        if arr1[i][j] != arr2[i][j] and not visited[i][j]:
            if check == False:
                tot_check = False
                break
            else:
                bfs(i, j)
                check = False

if tot_check:
    print("YES")
else:
    print("NO")
