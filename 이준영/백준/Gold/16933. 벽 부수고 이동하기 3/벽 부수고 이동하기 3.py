from collections import deque
import sys

input = sys.stdin.readline
N, M, K = map(int, input().rstrip().split())

visited = [[K + 1] * M for _ in range(N)]
arr = [list(map(int, input().rstrip())) for _ in range(N)]
dy = [0, 0, 1, -1]
dx = [1, -1, 0, 0]

visited[0][0] = 0
dq = deque([(0, 0, 0, 1)])
ans = -1
while dq:
    y, x, cnt, dis = dq.popleft()
    if (y, x) == (N - 1, M - 1):
        ans = dis
        break

    flag = False
    for k in range(4):
        ny = y + dy[k]
        nx = x + dx[k]
        if 0 <= ny < N and 0 <= nx < M:
            if arr[ny][nx] == 0:
                if visited[ny][nx] > cnt:
                    visited[ny][nx] = cnt
                    dq.append((ny, nx, cnt, dis + 1))
            else:
                if dis % 2 == 1:
                    if visited[ny][nx] > cnt + 1:
                        visited[ny][nx] = cnt + 1
                        dq.append((ny, nx, cnt + 1, dis + 1))
                elif visited[ny][nx] > cnt + 1:
                    flag = True

    if flag:
        dq.append((y, x, cnt, dis + 1))

print(ans)
