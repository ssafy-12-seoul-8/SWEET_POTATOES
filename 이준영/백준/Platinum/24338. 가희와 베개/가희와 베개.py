import sys
from collections import deque

input = sys.stdin.readline


def myprint(arr):
    for i in range(N):
        print(*arr[i])
    print("-" * 50)


def oob(y, x):
    return not (0 <= y < N and 0 <= x < M)


def btk(cur):
    global ans, flag
    if flag:
        return

    if cur == l:
        if check():
            flag = True
            ans = lst[:]
        return

    t_flag = False
    for direction, num1, num2 in can_put[cur]:
        if num2 in road[num1]:
            continue

        lst[cur] = direction
        road[num1].add(num2)
        road[num2].add(num1)
        t_flag = True
        btk(cur + 1)
        road[num1].remove(num2)
        road[num2].remove(num1)
    if not t_flag:
        lst[cur] = "S"
        btk(cur + 1)


def check():
    dq = deque([start])
    st = set([start])
    while dq:
        cur = dq.popleft()
        if 1 <= cur <= dest:
            return True
        for num in road[cur]:
            if num not in st:
                dq.append(num)
                st.add(num)

    return False


N, M = map(int, input().split())
board = [list(input().rstrip()) for _ in range(N)]
sy, sx = map(int, input().split())
sy -= 1
sx -= 1
dy = [-1, 0, 1, 0]
dx = [0, 1, 0, -1]

visited = [[0] * M for _ in range(N)]
l = 0
loc = []
tmp_board = [[0] * M for _ in range(N)]
dest_lst = []
for i in range(N):
    for j in range(M):
        if board[i][j] == "?":
            tmp_board[i][j] = -2
            loc.append((i, j))
        elif board[i][j] == "#":
            tmp_board[i][j] = -1
        elif board[i][j] == "1":
            tmp_board[i][j] = 1
        else:
            if board[i][j] == "P" or board[i][j] == "B":
                dest_lst.append((i, j))
            tmp_board[i][j] = 0

l = 0
dq = deque()
for y, x in dest_lst:
    if visited[y][x] == 0:
        l += 1
        visited[y][x] = 1
        dq.append((y, x))
        while dq:
            ty, tx = dq.popleft()
            for k in range(4):
                ny = ty + dy[k]
                nx = tx + dx[k]
                if not oob(ny, nx) and visited[ny][nx] == 0 and tmp_board[ny][nx] == 0:
                    visited[ny][nx] = l
                    dq.append((ny, nx))

dest = l
for i in range(N):
    for j in range(M):
        if visited[i][j] == 0 and tmp_board[i][j] >= 0:
            l += 1
            target = tmp_board[i][j]
            dq.append((i, j))
            visited[i][j] = l
            while dq:
                y, x = dq.popleft()
                for k in range(4):
                    ny = y + dy[k]
                    nx = x + dx[k]

                    if not oob(ny, nx) and visited[ny][nx] == 0 and tmp_board[ny][nx] == target:
                        visited[ny][nx] = l
                        dq.append((ny, nx))

road = [set() for _ in range(l + 1)]
l = len(loc)
lst = [0] * l
ans = []
start = visited[sy][sx]
flag = False
can_put = [[] for _ in range(l)]
for i in range(l):

    y, x = loc[i]
    # 가로
    if 0 < x < M - 1:
        left = tmp_board[y][x - 1]
        right = tmp_board[y][x + 1]
        if left == 0 and right == 1:
            can_put[i].append(["E", visited[y][x - 1], visited[y][x + 1]])
        elif left == 1 and right == 0:
            can_put[i].append(["W", visited[y][x - 1], visited[y][x + 1]])

    # 세로
    if 0 < y < N - 1:
        up = tmp_board[y - 1][x]
        down = tmp_board[y + 1][x]
        if up == 1 and down == 0:
            can_put[i].append(["N", visited[y - 1][x], visited[y + 1][x]])
        elif up == 0 and down == 1:
            can_put[i].append(["S", visited[y - 1][x], visited[y + 1][x]])


btk(0)
if not flag:
    print(-1)
else:
    for i in range(l):
        y, x = loc[i]
        board[y][x] = ans[i]

    for i in range(N):
        print(*board[i], sep="")
