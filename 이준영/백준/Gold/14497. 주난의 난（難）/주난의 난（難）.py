# 이번에 검사할 것들은 dq에서 관리하고 다음에 검사할 것들은 tmp_dq에서 관리하였다,
# 매 시행마다 bfs를 돌며 방문하지 않고 0이면 dq에 넣고 방문하지 않고 1이면 tmp_dq에 넣었다
# 아직 찾지 못했다면 dq = tmp_dq를 한 후 계속 한다.
import sys
from collections import deque

input = sys.stdin.readline

dy = [0, 0, 1, -1]
dx = [1, -1, 0, 0]
N, M = map(int, input().split())

x1, y1, x2, y2 = map(int, input().split())

arr = [list(input().rstrip()) for _ in range(N)]
visited = [[0] * M for _ in range(N)]
for i in range(N):
    for j in range(M):
        if arr[i][j] == "*":
            s_y = i
            s_x = j

visited[s_y][s_x] = 1
dq = deque([(s_y, s_x)])
time = 1
flag = False
while True:
    tmp_dq = deque([])
    while dq:
        y, x = dq.popleft()
        
        for k in range(4):
            ny = y + dy[k]
            nx = x + dx[k]
            if 0 <= ny < N and 0 <= nx < M and visited[ny][nx] == 0:        # 방문하지 않으면  
                if arr[ny][nx] == "#":                                      # 도둑이면 검거하고 끝
                    flag = True
                    break
                elif arr[ny][nx] == "0":                                    # 비었으면 탐색할 dq에 추가한다.
                    visited[ny][nx] = 1
                    dq.append((ny, nx))
                else:
                    visited[ny][nx] = 1                                     # 친구면 다음에 검사할거니까
                    arr[ny][nx] = "0"                                       # tmp_dq에 넣는다
                    tmp_dq.append((ny, nx))
                    
        if flag:
            break
    if flag:
        break
    dq = tmp_dq                                                             # 다음에 검사할 애들을 dq에 넘기고
    time += 1                                                               # 시간 증가


print(time)
