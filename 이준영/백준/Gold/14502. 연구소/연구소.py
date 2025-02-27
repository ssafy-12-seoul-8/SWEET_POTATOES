# 벽을 먼저 세우고 
# 다 세우면 검사해서 영역의 최대값 갱신
from collections import deque


def btk(cur, cnt):                              # 벽세우기 (현재 검사할 좌표, 세운 벽의 개수)
    if cnt == 3:                                # 벽 다 세우면
        check()                                 # 이 때 불이 없는 영역 계산
        return

    if cur == n * m:                            # 벽 다 안 세웠는데 끝에 도달함
        return

    y = cur // m            
    x = cur % m

    if arr[y][x] != 0:                          # 0이 아니면 설치 불가니까 다음으로 넘어감
        btk(cur + 1, cnt)
        return

    btk(cur + 1, cnt)                           # 여기에 설치하지 않는경우
    arr[y][x] = 1
    btk(cur + 1, cnt + 1)                       # 여기에 설치하는 경우
    arr[y][x] = 0


def check():                                    # 안전한 불의 영역을 계산하자.
    global mx
    visited = [[0] * m for _ in range(n)]
    cnt = 0
    for s_y, s_x in fire:               
        if visited[s_y][s_x] == 1:              # 이미 방문
            continue

        visited[s_y][s_x] = 1                   # 방문 처리
        dq = deque([(s_y, s_x)])

        while dq:
            y, x = dq.popleft()
            for k in range(4):
                ny = y + dy[k]
                nx = x + dx[k]
                if 0 <= ny < n and 0 <= nx < m and arr[ny][nx] == 0 and visited[ny][nx] == 0:
                    cnt += 1
                    visited[ny][nx] = 1
                    dq.append((ny, nx))

    mx = max(mx, tot - cnt)                     # tot는 빈 공간의 수, cntㄴ는 빈 공간 중 불이 붙은 수


n, m = map(int, input().split())
arr = [list(map(int, input().split())) for _ in range(n)]  # 2가 불, 1이 방화벽, 0이 빈칸
dy = [0, 0, 1, -1]
dx = [1, -1, 0, 0]
fire = []
tot = -3                                                    # 벽을 3개 설치할 거니까 미리 빼자
for i in range(n):
    for j in range(m):
        if arr[i][j] == 2:
            fire.append((i, j))
        elif arr[i][j] == 0:
            tot += 1

mx = 0
btk(0, 0)

print(mx)
