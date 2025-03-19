# dq.clear()랑 dq재선언 비교
# 4방향으로 온풍기가 퍼지는 것을 어떻게 구현할 까 하다가 각 방향 별 검사해야 될 좌표들을 넣은 spread를 사용하여 관리하였습니다.
# 0벽과 1벽을 그냥 set으로 관리했습니다. (배열로 하는게 빠르긴 합니다)
# 문제를 잘 못 읽은 것을 푼지 70분만에 깨달아서 오래 걸렸습니다...
# 바람이 퍼져나가는 것을 bfs로 구현하였습니다.
# 온도 조절의 경우 각 좌표에 대해 4방 탐색을 하는 것이 실수를 안할 것이라 생각하여 그렇게 했습니다.

from collections import deque

# (sy,sx),(ny,nx) 사이에 벽이 있다면 False를 아니면 True를 리턴
def check(sy, sx, ny, nx):
    if sy == ny:
        if sx < nx:
            if (sy, sx) in one_wall:
                return False

        elif (ny, nx) in one_wall:
            return False

    if sx == nx:
        if sy < ny:
            if (ny, nx) in zero_wall:
                return False

        elif (sy, sx) in zero_wall:
            return False
    return True


R, C, K = map(int, input().split())
arr = [list(map(int, input().split())) for _ in range(R)]
temp = [[0] * C for _ in range(R)]
W = int(input())
dct = {}
dy = [0, 0, -1, 1]      # 오, 왼, 위, 아래
dx = [1, -1, 0, 0]

# spread[d] : d방향으로 갔을 때 퍼져나가는 방향
spread = [[(0, 1), (-1, 1), (1, 1)], [(0, -1), (-1, -1), (1, -1)], [(-1, 0), (-1, 1), (-1, -1)],
          [(1, 0), (1, 1), (1, -1)]]


zero_wall = set([])
one_wall = set([])

for _ in range(W):
    y, x, t = map(int, input().split())
    if t == 0:
        zero_wall.add((y - 1, x - 1))
    else:
        one_wall.add((y - 1, x - 1))

o_lst = []                                      # 온풍기 리스트
show = []                                       # 봐야 되는 것들

for i in range(R):
    for j in range(C):
        if arr[i][j] == 5:
            show.append((i, j))
        elif arr[i][j] > 0:
            o_lst.append((i, j, arr[i][j] - 1))

cnt = 0                                         # 먹은 초콜릿 개수
dq = deque([])
while True:
    for y, x, d in o_lst:
        dq.clear()
        visited = [[0] * C for _ in range(R)]   # 바람 방문 배열
        ny = y + dy[d]
        nx = x + dx[d]
        temp[ny][nx] += 5                       
        dq.append((ny, nx, 5))

        while dq:
            sy, sx, power = dq.popleft()        # 지금 들어온 위치와 바람의 세기

            ny = sy + spread[d][0][0]
            nx = sx + spread[d][0][1]

            if power == 1:                      # 바람의 세기가 1이면 그 다음은 안봐도 된다.
                break
            
            # 정면으로 갈 때
            if (0 <= ny < R and 0 <= nx < C) and check(sy, sx, ny, nx):
                if visited[ny][nx] == 0:
                    visited[ny][nx] = 1
                    temp[ny][nx] += (power - 1)
                    dq.append((ny, nx, power - 1))
            
            # 대각선으로 갈 때
            for k in range(1, 3):
                ny = sy + spread[d][k][0]
                nx = sx + spread[d][k][1]
                cny = ny - dy[d]
                cnx = nx - dx[d]

                if not (0 <= ny < R and 0 <= nx < C):
                    continue

                if not check(sy, sx, cny, cnx) or not check(cny,cnx,ny,nx):
                    continue

                if visited[ny][nx] == 0:
                    visited[ny][nx] = 1
                    temp[ny][nx] += (power - 1)
                    dq.append((ny, nx, power - 1))

    tmp_temp = [[0] * C for _ in range(R)]          # 임시 온도 변화 저장 배열

    # 각 칸 마다 4방 탐색을 통해 나의 온도 변화량을 계산해서 저장한다.
    for i in range(R):
        for j in range(C):

            for k in range(4):
                ny = i + dy[k]
                nx = j + dx[k]

                if 0 <= ny < R and 0 <= nx < C:
                    if not check(i, j, ny, nx):
                        continue

                    if temp[ny][nx] > temp[i][j]:   # 내가 온도가 더 낮으면 온도를 받아야 한다.
                        tmp_temp[i][j] += ((temp[ny][nx] - temp[i][j]) // 4)
                    else:                           # 내가 온도가 더 높으면 온도를 줘야 한다.
                        tmp_temp[i][j] -= ((temp[i][j] - temp[ny][nx]) // 4)

    # 온도 나눔 반영
    for i in range(R):
        for j in range(C):
            temp[i][j] += tmp_temp[i][j]

    # 가장자리 온도 낮추는 로직
    for i in range(R):
        for j in (0, C - 1):
            if temp[i][j] > 0:
                temp[i][j] -= 1

    for i in (0, R - 1):
        for j in range(1, C - 1):
            if temp[i][j] > 0:
                temp[i][j] -= 1

    # 초콜릿 먹자.
    cnt += 1

    # 101이면 그만 먹어라
    if cnt == 101:
        break

    # 각 칸이 기준이상인지 보자
    flag = True
    for y, x in show:
        if temp[y][x] < K:
            flag = False
            break

    # 모두 기준보다 크면 나가자
    if flag:
        break

print(cnt)
