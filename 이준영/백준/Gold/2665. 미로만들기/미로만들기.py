# 0,1-bfs
# 큐에 지금까지 바꾼 검은 방의 개수를 넣어서 관리한다.
# 이렇게 되면 뒤에 나오는 방이 무조건 검은 방을 바꾼 개수가 이전보다 크거나 같다.
# 따라서 방문 배열을 관리하여 예전에 들린 방은 다시 안 들려도 된다.

import sys
from collections import deque

input = sys.stdin.readline
n = int(input())
dy = [0, 0, 1, -1]
dx = [1, -1, 0, 0]

arr = [list(map(int, input().rstrip())) for _ in range(n)]
visited = [[0] * n for _ in range(n)]
visited[0][0] = 1
dq = deque([(0, 0, 0)])

while dq:
    y, x, cnt = dq.popleft()
    if y == n - 1 and x == n - 1:
        ans = cnt
        break

    for k in range(4):
        ny = y + dy[k]
        nx = x + dx[k]
        if 0 <= ny < n and 0 <= nx < n and visited[ny][nx] == 0:    # 아직 안간곳이라면
            visited[ny][nx] = 1
            if arr[ny][nx] == 1:                                    # 흰방이면 앞에 넣는다.
                dq.appendleft((ny, nx, cnt))
            else:                                                   # 검은방이면 뒤에 넣는다.
                dq.append((ny, nx, cnt + 1))

print(ans)
