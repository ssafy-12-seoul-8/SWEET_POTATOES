# bfs 함수를 한번만 만들기 위해서 정상인의 눈에서 bfs를 한 번 돌리고
# 적록색약의 시점에서의 arr로 바꾸어 다시 bfs를 돌렸습니다.
import sys
from collections import deque

input = sys.stdin.readline


def bfs(start_y, start_x):
    dq = deque([(start_y, start_x)])
    while dq:
        y, x = dq.popleft()
        if not visited[y][x]:
            visited[y][x] = True
            for k in range(4):
                ny = y + dy[k]
                nx = x + dx[k]
                if 0 <= ny < N and 0 <= nx < N and not visited[ny][nx] and arr[ny][nx] == arr[start_y][start_x]:
                    dq.append((ny, nx))


N = int(input())
arr = [list(input().rstrip()) for _ in range(N)]

dy = [0, 0, 1, -1]
dx = [1, -1, 0, 0]

area1 = 0
visited = [[False] * N for _ in range(N)]

for i in range(N):
    for j in range(N):
        if not visited[i][j]:
            area1 += 1
            bfs(i, j)

# 적록색약용 맵 만들기
for i in range(N):
    for j in range(N):
        if arr[i][j] == "R":        
            arr[i][j] = "G"
            
area2 = 0
visited = [[False] * N for _ in range(N)]
for i in range(N):
    for j in range(N):
        if not visited[i][j]:
            area2 += 1
            bfs(i, j)

print(area1, area2)
