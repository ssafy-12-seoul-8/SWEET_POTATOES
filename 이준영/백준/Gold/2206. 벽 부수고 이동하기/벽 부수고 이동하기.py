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

dq = deque([(0, 0, 0, 0)])  # 이동거리, 벽부신 횟수, y좌표, x좌표
ans = -2
while dq:
    dis, cnt, y, x = dq.popleft()
    if not visited[y][x][cnt]:
        visited[y][x][cnt] = True
        if (y, x) == (N - 1, M - 1):
            ans = dis
            break
        for k in range(4):
            ny = y + dy[k]
            nx = x + dx[k]
            if 0 <= ny < N and 0 <= nx < M:
                cur_cnt = cnt + arr[ny][nx]
                if cur_cnt >= 2:
                    continue
                elif not visited[ny][nx][cur_cnt]:
                    dq.append((dis + 1, cur_cnt, ny, nx))

print(ans + 1)
