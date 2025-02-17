import sys
from heapq import heappop, heappush

input = sys.stdin.readline
R, C, K = map(int, input().split())

# U R D L
dy = [-1, 0, 1, 0] * 3
dx = [0, 1, 0, -1] * 3

arr = [list(input().rstrip()) for _ in range(R)]

for i in range(R):
    for j in range(C):
        match arr[i][j]:
            case "U":
                arr[i][j] = 4
            case "R":
                arr[i][j] = 5
            case "D":
                arr[i][j] = 6
            case "L":
                arr[i][j] = 7

cnt = [[[K + 1] * (K + 1) for _ in range(C)] for _ in range(R)]

flag = False

cnt[0][0][0] = 0

pq = []

heappush(pq, (0, 0, 0, 0))

while pq:
    l_cnt, r_cnt, y, x = heappop(pq)
    if y == R - 1 and x == C - 1:
        flag = True
        break

    if cnt[y][x][l_cnt] < r_cnt:
        continue

    cur = arr[y][x]
    for k in range(min(K - r_cnt, 3) + 1):
        ny = y + dy[cur + k]
        nx = x + dx[cur + k]
        if 0 <= ny < R and 0 <= nx < C and cnt[ny][nx][l_cnt] > r_cnt + k:
            cnt[ny][nx][l_cnt] = r_cnt + k
            heappush(pq, (l_cnt, r_cnt + k, ny, nx))

    for k in range(1, min(K - l_cnt, 3) + 1):
        ny = y + dy[cur - k]
        nx = x + dx[cur - k]
        if 0 <= ny < R and 0 <= nx < C and cnt[ny][nx][l_cnt + k] > r_cnt:
            cnt[ny][nx][l_cnt + k] = r_cnt
            heappush(pq, (l_cnt + k, r_cnt, ny, nx))

if flag:
    print("Yes")
else:
    print("No")
