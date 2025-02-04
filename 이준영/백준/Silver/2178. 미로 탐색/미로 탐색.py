import sys
from collections import deque

input = sys.stdin.readline

dy = [0, 0, 1, -1]
dx = [1, -1, 0, 0]
N, M = map(int, input().split())
arr = [list(map(int, input().rstrip())) for _ in range(N)]
visited = [[False] * M for _ in range(N)]

dq = deque([(1, 0, 0)])                 # (거리, y, x)를 저장하고 거리에 시작점이 포함하므로 1로 시작
while dq:                               # 항상 갈 수 있는 경우만 입력으로 들어오므로 따로 초기값을 지정하지 않는다.
    dis, y, x = dq.popleft()
    if not visited[y][x]:
        visited[y][x] = True
        if (y, x) == (N - 1, M - 1):
            print(dis)
            break
        for k in range(4):
            ny = y + dy[k]
            nx = x + dx[k]
            if 0 <= ny < N and 0 <= nx < M and not visited[ny][nx] and arr[ny][nx] == 1:
                dq.append((dis + 1, ny, nx))

