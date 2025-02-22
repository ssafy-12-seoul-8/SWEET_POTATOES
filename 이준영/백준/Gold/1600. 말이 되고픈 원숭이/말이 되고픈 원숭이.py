import sys
from collections import deque

input = sys.stdin.readline

K = int(input())
W, H = map(int, input().split())
arr = [list(map(int, input().split())) for _ in range(H)]

visited = [[K + 1] * W for _ in range(H)]

dy1 = [0, 0, 1, -1]
dx1 = [1, -1, 0, 0]
dy2 = [-1, -2, -2, -1, 1, 2, 2, 1]
dx2 = [-2, -1, 1, 2, 2, 1, -1, -2]

visited[0][0] = 0
dq = deque([(0, 0, 0, 0)])
if H == 1 and W == 1:
    ans = 0
else:
    ans = -1
    while dq:
        y, x, dis, k_count = dq.popleft()
        for k in range(4):
            ny = y + dy1[k]
            nx = x + dx1[k]
            if 0 <= ny < H and 0 <= nx < W and visited[ny][nx] > k_count and arr[ny][nx] == 0:
                visited[ny][nx] = k_count
                if ny == H - 1 and nx == W - 1:
                    ans = dis + 1
                    break
                dq.append((ny, nx, dis + 1, k_count))

        if ans >= 0:
            break

        if k_count == K:
            continue

        for k in range(8):
            ny = y + dy2[k]
            nx = x + dx2[k]
            if 0 <= ny < H and 0 <= nx < W and (visited[ny][nx] > k_count + 1) and arr[ny][nx] == 0:
                visited[ny][nx] = k_count + 1
                if ny == H - 1 and nx == W - 1:
                    ans = dis + 1
                    break
                dq.append((ny, nx, dis + 1, k_count + 1))

        if ans >= 0:
            break

print(ans)
