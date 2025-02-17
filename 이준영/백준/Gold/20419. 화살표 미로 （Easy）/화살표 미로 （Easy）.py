# 다익스트라를 써보는게 어떨까 l_cnt에 대한
# 그래서 거리 배열을 만들고 거기에 최소 r_cnt를 저장한다. arr[y][x][l_cnt] = 지금까지 나온 최소 r_cnt
# 시간에 도움이 될까 싶어 dy,dx를 크기 12로 만들고 배열의 URDL을 모두 4,5,6,7로 바꾸었다.
# 그 후 오른쪽 회전은 +1, 왼쪽 회전은 -1로 하였다.
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
