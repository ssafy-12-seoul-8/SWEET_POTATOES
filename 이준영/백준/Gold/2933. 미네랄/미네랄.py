# 제출횟수: 1회
# 메모리: 116628KB
# 시간: 256ms
# 일단 왼쪽이나 오른쪽에서 던져서 미네랄을 제거한 후
# 그 미네랄을 기준으로 상하좌우를 보며 bfs를 돌림으로써 분리된 클러스터가 있는지 확인한다.
# 분리된 클러스터가 있다면 떨어트린다.
# 이 때 반복을 막기 위해 상하좌우의 bfs를 돌릴 때 visited배열을 서로 다른 수로 채웠다. (나중에 분리된 클리스터를 구분하기 위함도 있음)

import sys
from collections import deque

input = sys.stdin.readline


def bfs(s_y, s_x, a):                                           # s_y,s_x와 연결된 곳을 찾으며 visited배열을 a로 채움
    visited[s_y][s_x] = a
    dq = deque([(s_y, s_x)])
    flag = False                                                # 땅과 닿아있는가
    while dq:
        y, x = dq.popleft()
        for k in range(4):
            ny = y + dy[k]
            nx = x + dx[k]
            if 0 <= ny < R and 0 <= nx < C and visited[ny][nx] == 0 and arr[ny][nx] == "x":
                visited[ny][nx] = a
                dq.append((ny, nx))
                if ny == R - 1:                                 # 땅과 닿아있으면 True
                    flag = True

    return flag


def drop(a):                                                    # a로 표시된 클러스터를 내리는 작업
    h = 101
    for j in range(C):                                          # j열을 보자
        loc = -1                                                # 가장 아래에 있는 분리된 클러스터
        ground = R                                              # 가장 위에 있는 미네랄(분리된 클러스터에 속하지 않는)
        for i in range(R - 1, -1, -1):                          # 아래에서부터 보자
            if arr[i][j] == "x":
                if visited[i][j] != a:                          # 분리된 클러스터가 아니면 땅 갱신
                    ground = i
                else:                                           # 처음으로 분리된 클러스터가 나오면 loc 갱신 후 break
                    loc = i                                     # 항상 분리된 클러스터에서 밑에 것이 먼저 땅에 닿기 때문에 가능
                    break
        if loc == -1:                                           # 분리된 클러스터가 이 열에 없다.
            continue
        else:
            h = min(h, ground - loc - 1)                        # 떨어지는 높이 갱신

    for j in range(C):
        lst = []                                                # j열에 분리된 클러스터의 좌표 저장
        for i in range(R - 1, -1, -1):
            if arr[i][j] == "x" and visited[i][j] == a:
                lst.append((i, j))

        for y, x in lst:
            arr[y][x] = "."                                     # 먼저 비우고
        for y, x in lst:
            arr[y + h][x] = "x"                                 # 채운다.


dy = [0, 0, 1, -1]
dx = [1, -1, 0, 0]
R, C = map(int, input().split())
arr = [list(input().rstrip()) for _ in range(R)]

N = int(input())
lst = list(map(int, input().split()))

for i in range(N):
    if i % 2 == 0:                                              # 짝수면 왼쪽에서 던진다.
        d = 1
        start_x = 0
    else:                                                       # 홀수면 오른쪽에서 던진다.
        d = -1
        start_x = C - 1

    start_y = R - lst[i]                                        # 높이
    while 0 <= start_x < C and arr[start_y][start_x] == ".":    # 던진다.
        start_x += d

    if not (0 <= start_x < C):                                  # 미네랄 안부시면 지나감
        continue

    else:
        arr[start_y][start_x] = "."                             # 미네랄 부시고

        visited = [[0] * C for _ in range(R)]                   # 방문배열

        for k in range(4):
            ny = start_y + dy[k]
            nx = start_x + dx[k]                                # 인접한 미네랄에 대해 검사하자
            if 0 <= ny < R and 0 <= nx < C and visited[ny][nx] == 0 and arr[ny][nx] == "x":
                check = bfs(ny, nx, k + 1)
                if not check:                                   # 땅과 닿아 있지 않다면
                    drop(k + 1)                                 # 떨어뜨리자
                    break
for i in range(R):
    print(*arr[i], sep="")
