# 리팩토링 코드 (기능 별 함수 추가 및 함수 내용 수정)
from collections import deque


# y,x 에서 목적지까지 가는 함수
# 운행이 가능하면 (목적지 y좌표, x좌표, 남은 연료량) 반환
# 운행이 불가능하면 (아무 y좌표, x좌표, -1) 반환
def taxi(y, x):
    ey, ex = people[arr[y][x]]  # 목적지 입력
    arr[y][x] = 0  # 좌표를 0으로 바꿔주고 (태웠으니까)
    l = go(y, x, ey, ex)  # 도착점으로 가보자

    if l != -1 and oil >= l:  # 갈 수 있고 oil이 충분하면
        return ey, ex, oil + l

    return ey, ex, -1


# (y,x)에서 출발하여 (ey,ex)로 갈 때 드는 연료 양 (불가능하면 -1리턴)
def go(y, x, ey, ex):
    visited = [[0] * N for _ in range(N)]
    visited[y][x] = 1
    dq = deque([(y, x, 0)])

    while dq:

        ty, tx, d = dq.popleft()

        for k in range(4):
            ny = ty + dy[k]
            nx = tx + dx[k]
            if 0 <= ny < N and 0 <= nx < N and visited[ny][nx] == 0 and arr[ny][nx] != 1:
                if (ny, nx) == (ey, ex):
                    return d + 1  # 도착하면 바로 리턴

                visited[ny][nx] = 1
                dq.append((ny, nx, d + 1))

    return -1  # 도착이 불가능하면 -1 리턴


# 승객을 찾는 함수
# 승객이 있고 운행가능시 (승객의 y좌표, 승객의 x좌표, 남은 연료양) 반환
# 위에 해당하지 않으면 (아무 y좌표, 아무x좌표,-1) 반환
def find_person(s_y, s_x):
    visited = [[0] * N for _ in range(N)]  # 찾으러 가자
    visited[s_y][s_x] = 1  # 현재 방문 처리
    dq = deque([(s_y, s_x)])
    lst = []  # 최단 거리 손님들을 담을 배열
    d = 1  # 거리

    while dq:  # bfs
        l = len(dq)
        for _ in range(l):
            y, x = dq.popleft()

            for k in range(4):
                ny = y + dy[k]
                nx = x + dx[k]
                if 0 <= ny < N and 0 <= nx < N and visited[ny][nx] == 0 and arr[ny][nx] != 1:  # 지날 수 있으면 지난다.
                    visited[ny][nx] = 1

                    if arr[ny][nx] >= 2:  # 근데 손님이면 최단 거리에 있으니 리스트에 추가
                        lst.append((ny, nx))

                    else:  # 길이면 dq에 추가
                        dq.append((ny, nx))
        if lst:  # 손님이 있으면
            lst.sort()

            if oil - d < 0:  # 오일 부족
                return 0, 0, -1

            return lst[0][0], lst[0][1], oil - d

        d += 1  # 아니면 거리 증가

    # 내가 갈 수 있는 곳에 손님이 없네
    return s_y, s_x, -1


N, M, oil = map(int, input().split())
arr = [list(map(int, input().split())) for _ in range(N)]

s_y, s_x = map(int, input().split())  # 출발 위치

dy = [0, 0, 1, -1]
dx = [1, -1, 0, 0]
s_y -= 1
s_x -= 1
people = [0] * (M + 2)  # i번 손님(2<=i<=M+1)의 도착점 저장

for i in range(M):
    sy, sx, ey, ex = map(int, input().split())
    arr[sy - 1][sx - 1] = i + 2  # 시작점은 맵에 바로 표시하고
    people[i + 2] = (ey - 1, ex - 1)  # 도착점은 people에 넣어 관리

flag = True  # 주행 성공 여부
for i in range(M):
    # 지금 출발하는 곳에 손님이 있는 경우
    if arr[s_y][s_x] >= 2:
        s_y, s_x, oil = taxi(s_y, s_x)
        if oil == -1:
            flag = False
            break
        continue

    # 지금 출발하는 곳에 손님이 없는 경우
    s_y, s_x, oil = find_person(s_y, s_x)
    if oil == -1:
        flag = False
        break

    # 하지만 최단거리 손님이 있고 연료도 충분하다면
    # 위에서 했던 작업들을 다시 해준다.
    s_y, s_x, oil = taxi(s_y, s_x)
    if oil == -1:
        flag = False
        break

# 무사히 주행 마치면 현재 연료양 출력
if flag:
    print(oil)
# 아니면 -1출력
else:
    print(-1)
