import sys
from collections import deque

input = sys.stdin.readline

N, M, K = map(int, input().split())
arr = [list(map(int, input().rstrip())) for _ in range(N)]
visited = [[K + 1] * M for _ in range(N)]
dy = [0, 0, 1, -1]
dx = [1, -1, 0, 0]
visited[0][0] = 0
ans = -1
dq = deque([(1, 0, 0, 0)])
flag = False
if N == 1 and M == 1:
    print(1)
else:
    while dq:
        dis, o_cnt, y, x = dq.popleft()
        for k in range(4):
            ny = y + dy[k]
            nx = x + dx[k]
            if 0 <= ny < N and 0 <= nx < M and o_cnt + arr[ny][nx] < visited[ny][nx]:
                if ny == N - 1 and nx == M - 1:
                    flag = True
                    ans = dis + 1
                    break
                visited[ny][nx] = o_cnt + arr[ny][nx]
                dq.append((dis + 1, visited[ny][nx], ny, nx))
        if flag:
            break

    print(ans)
