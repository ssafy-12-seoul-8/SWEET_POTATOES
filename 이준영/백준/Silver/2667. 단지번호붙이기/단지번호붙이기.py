# 1438
import sys

input = sys.stdin.readline

from collections import deque


def bfs(s_y, s_x):
    dq = deque([(s_y, s_x)])
    visited[s_y][s_x] = 1
    cnt = 1

    while dq:
        y, x = dq.popleft()
        for k in range(4):
            ny = y + dy[k]
            nx = x + dx[k]
            if 0 <= ny < N and 0 <= nx < N and not visited[ny][nx] and arr[ny][nx] == 1:
                visited[ny][nx] = 1
                cnt += 1
                dq.append((ny, nx))

    return cnt

N = int(input())

arr = [list(map(int, input().rstrip())) for _ in range(N)]

dy = [0, 0, 1, -1]
dx = [1, -1, 0, 0]
visited = [[0] * N for _ in range(N)]
lst = []

for i in range(N):
    for j in range(N):
        if not visited[i][j] and arr[i][j] == 1:
            cnt = bfs(i, j)
            lst.append(cnt)

lst.sort()
print(len(lst))
for i in range(len(lst)):
    print(lst[i])
