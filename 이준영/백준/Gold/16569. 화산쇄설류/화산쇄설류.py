# 탈출 문제와 유사하나 내가 갈 수 있는 최대 화산의 높이를 계속 갱신해야 한다.
from collections import deque
import sys

input = sys.stdin.readline

dy = [0, 0, 1, -1]
dx = [1, -1, 0, 0]
M, N, V = map(int, input().split())
s_y, s_x = map(int, input().split())
arr = [list(map(int, input().split())) for _ in range(M)]
visited2 = [[0] * N for _ in range(M)]                      # 화산분출됐는지(쇄설물 포함)
visited = [[0] * N for _ in range(M)]                       # 재상이가 지나간 곳(다시 갈 필요가 없음)
s_y -= 1
s_x -= 1
dct = {}
for _ in range(V):
    y, x, t = map(int, input().split())
    y -= 1
    x -= 1
    visited[y][x] = 1
    if t in dct:
        dct[t].append((y, x))
    else:
        dct[t] = [(y, x)]

time = 1
mx = arr[s_y][s_x]
mx_t = 0
visited[s_y][s_x] = 1
v_dq = deque([])
j_dq = deque([(s_y, s_x)])

if 0 in dct:
    for y, x in dct[0]:
        v_dq.append((y, x))
        visited2[y][x] = 1
while j_dq:
    l = len(v_dq)
    for _ in range(l):
        y, x = v_dq.popleft()
        for k in range(4):
            ny = y + dy[k]
            nx = x + dx[k]
            if 0 <= ny < M and 0 <= nx < N and visited2[ny][nx] == 0:
                visited2[ny][nx] = 1
                v_dq.append((ny, nx))

    if time in dct:
        for y, x in dct[time]:
            if visited2[y][x] == 0:
                visited2[y][x] = 1
                v_dq.append((y, x))

    l = len(j_dq)
    for _ in range(l):
        y, x = j_dq.popleft()
        for k in range(4):
            ny = y + dy[k]
            nx = x + dx[k]
            if 0 <= ny < M and 0 <= nx < N and visited2[ny][nx] == 0 and visited[ny][nx] == 0:
                visited[ny][nx] = 1
                j_dq.append((ny, nx))
                if arr[ny][nx] > mx:
                    mx = arr[ny][nx]
                    mx_t = time

    time += 1

print(mx, mx_t)
