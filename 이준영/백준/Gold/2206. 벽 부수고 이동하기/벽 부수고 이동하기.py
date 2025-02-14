import sys
from collections import deque

input = sys.stdin.readline
N, M = map(int, input().split())
arr = [list(map(int, input().rstrip())) for _ in range(N)]
visited = [[0] * M for _ in range(N)]
for i in range(N):
    for j in range(M):
        visited[i][j] = [False, False]
dy = [0, 0, 1, -1]
dx = [1, -1, 0, 0]

visited[0][0] = [True, True]
dq = deque([(0, 0, 0, 0)])  # 이동거리, 벽부신 횟수, y좌표, x좌표
ans = -2
if N==1 and M==1:
    ans = 0
else:
    while dq:
        dis, cnt, y, x = dq.popleft()
        for k in range(4):
            ny = y + dy[k]
            nx = x + dx[k]
            if 0 <= ny < N and 0 <= nx < M:
                cur_cnt = cnt + arr[ny][nx]
                if cur_cnt >= 2:
                    continue
                elif not visited[ny][nx][cur_cnt]:
                    visited[ny][nx][cur_cnt] = True
                    dq.append((dis + 1, cur_cnt, ny, nx))
                    if ny == N - 1 and nx == M - 1:
                        ans = dis + 1
                        break

        if ans != -2:
            break

print(ans + 1)
