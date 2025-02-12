# 일단 7개를 고르고 검사를 연결되어 있는지 검사를 하자
# 7개를 고르는 과정에서 Y가 4개이상이면 칠공주가 될 수 없음
# 나머지를 다 골라도 7이 안되면 리턴
# 마지막으로 True가 되는곳에서 탐색 시작하게 바꿈 (전역변수로 관리)
from collections import deque


def btk(cur, l, s_count):  # 현재위치, 고른 길이, s개수, 시작 y좌표, 시작 x좌표
    global s_y, s_x

    y = cur // 5
    x = cur % 5

    if l - s_count >= 4:
        return

    if l == 7:
        check()
        return

    if 25 - cur + l < 7:
        return

    btk(cur + 1, l, s_count)

    visited[y][x] = True

    s_y = y
    s_x = x

    if arr[y][x] == "S":
        btk(cur + 1, l + 1, s_count + 1)
    else:
        btk(cur + 1, l + 1, s_count)

    visited[y][x] = False


def check():
    global cnt

    st = set([(s_y, s_x)])
    tmp_cnt = 1
    dq = deque([(s_y, s_x)])

    while dq:
        y, x = dq.popleft()
        for k in range(4):
            ny = y + dy[k]
            nx = x + dx[k]
            if 0 <= ny < 5 and 0 <= nx < 5 and visited[ny][nx] and (ny, nx) not in st:
                st.add((ny, nx))
                tmp_cnt += 1
                dq.append((ny, nx))

    if tmp_cnt == 7:
        cnt += 1


arr = [list(input()) for _ in range(5)]
visited = [[False] * 5 for _ in range(5)]
dy = [0, 0, 1, -1]
dx = [1, -1, 0, 0]
s_y = -1
s_x = -1
cnt = 0
btk(0, 0, 0)

print(cnt)
