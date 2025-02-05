# 잠기는 높이를 조절함에 따라 영역이 몇개 있는지를 세본다.
# 아무 지역도 안잠기는 경우도 있으니 1을 기본값으로 한다.
# 만약 영역이 0개라는 건 모두 잠겼다는 것이므로 높이를 더 늘리지 않아도 된다.

import sys
from collections import deque

input = sys.stdin.readline


def bfs(start_y, start_x):
    tmp_cnt = 0
    dq = deque([(start_y, start_x)])
    while dq:
        y, x = dq.popleft()
        if not visited[y][x]:
            tmp_cnt += 1
            visited[y][x] = True
            for k in range(4):
                ny = y + dy[k]
                nx = x + dx[k]
                if 0 <= ny < N and 0 <= nx < N and not visited[ny][nx] and arr[ny][nx] > h:
                    dq.append((ny, nx))


N = int(input())
arr = [list(map(int, input().split())) for _ in range(N)]

dy = [0, 0, 1, -1]
dx = [1, -1, 0, 0]
mx = 1
h = 1

while True:
    cnt = 0
    visited = [[False] * N for _ in range(N)]
    
    for i in range(N):
        for j in range(N):
            if not visited[i][j] and arr[i][j] > h:
                bfs(i,j)
                cnt += 1
                
    mx = max(mx, cnt)
    if cnt == 0:
        break
    h = h + 1

print(mx)
