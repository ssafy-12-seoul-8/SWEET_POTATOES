import sys
from collections import deque

input = sys.stdin.readline


def btk(cur, cnt):
    if cnt == R + G:
        btk2(0, 0)
        return

    for i in range(cur, l):
        tot[cnt] = i
        btk(i + 1, cnt + 1)


def btk2(cur, r_cnt):
    if r_cnt == R:
        check()
        return

    for i in range(cur, R + G):
        R_loc.add(tot[i])
        btk2(i + 1, r_cnt + 1)
        R_loc.remove(tot[i])


def check():
    global mx
    tmp = [[[2501, 2501] for _ in range(M)] for _ in range(N)]  # R이 들어온 시간, G가 들어온 시간
    r_dq = deque([])
    g_dq = deque([])
    for i in range(N):
        for j in range(M):
            if arr[i][j] == 0:
                tmp[i][j] = [-1, -1]

    for i in range(R + G):
        y, x = pos[tot[i]]
        if tot[i] in R_loc:
            tmp[y][x] = [0, -1]
            r_dq.append((y, x, 0))
        else:
            tmp[y][x] = [-1, 0]
            g_dq.append((y, x, 0))
    cnt = 0
    while g_dq and r_dq:
        l1 = len(r_dq)
        l2 = len(g_dq)
        for _ in range(l1):
            y, x, t = r_dq.popleft()
            if tmp[y][x][0] == -1:
                continue
            for k in range(4):
                ny = y + dy[k]
                nx = x + dx[k]
                if 0 <= ny < N and 0 <= nx < M:
                    if tmp[ny][nx][0] <= t + 1 or tmp[ny][nx][1] < t + 1:
                        continue
                    else:
                        tmp[ny][nx][0] = t + 1
                        r_dq.append((ny, nx, t + 1))

        for _ in range(l2):
            y, x, t = g_dq.popleft()
            for k in range(4):
                ny = y + dy[k]
                nx = x + dx[k]
                if 0 <= ny < N and 0 <= nx < M:
                    if tmp[ny][nx][1] <= t + 1 or tmp[ny][nx][0] < t + 1:
                        continue
                    elif tmp[ny][nx][0] == t + 1:
                        cnt += 1
                        tmp[ny][nx] = [-1, -1]
                    else:
                        tmp[ny][nx][1] = t + 1
                        g_dq.append((ny, nx, t + 1))
    mx = max(mx, cnt)


N, M, G, R = map(int, input().split())

arr = [list(map(int, input().split())) for _ in range(N)]

dy = [0, 0, 1, -1]
dx = [1, -1, 0, 0]
pos = []
for i in range(N):
    for j in range(M):
        if arr[i][j] == 2:
            pos.append((i, j))

l = len(pos)
tot = [0] * (R + G)
R_loc = set([])
mx = 0
btk(0, 0)

print(mx)
