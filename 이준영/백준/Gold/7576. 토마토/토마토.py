# 각 단계에서 다음에 탐색할 칸을 저장하고 그 칸에 대해서 델타탐색을 하고 일수를 늘리는 방향으로 코드를 짰습니다.
import sys

input = sys.stdin.readline

M, N = map(int, input().split())
arr = [list(map(int, input().split())) for _ in range(N)]
dq = []
tm = 0                                                           # 남은 익지 않은 토마토의 양
dy = [0, 0, 1, -1]
dx = [1, -1, 0, 0]

for i in range(N):
    for j in range(M):
        if arr[i][j] == 0:
            tm += 1
        elif arr[i][j] == 1:
            dq.append((i, j))

day = 0
while dq and tm:                                                  # 토마토가 다 익었거나 dq가 비었다면 멈춘다
    next_q = []
    for y, x in dq:
        for k in range(4):
            ny = y + dy[k]
            nx = x + dx[k]
            if 0 <= ny < N and 0 <= nx < M and arr[ny][nx] == 0:  # 익지 않은 토마토에 도달하면 그게 익은 토마토가 되면서 다시 방문
                arr[ny][nx] = 1                                   # 하지 않는다.
                tm -= 1
                next_q.append((ny, nx))
    day = day + 1
    dq = next_q

if tm == 0:
    print(day)
else:
    print(-1)
